package ai.sangmado.jt809.protocol.message;

import ai.sangmado.gbcommon.memory.PooledByteArray;
import ai.sangmado.gbcommon.utils.CRC16;
import ai.sangmado.jt809.protocol.ISpecificationContext;
import ai.sangmado.jt809.protocol.encoding.IJT809MessageBufferReader;
import ai.sangmado.jt809.protocol.encoding.IJT809MessageBufferWriter;
import ai.sangmado.jt809.protocol.encoding.IJT809MessageFormatter;
import ai.sangmado.jt809.protocol.encoding.impl.JT809MessageByteBufferReader;
import ai.sangmado.jt809.protocol.encoding.impl.JT809MessageByteBufferWriter;
import ai.sangmado.jt809.protocol.enums.JT809MessageContentEncryptionMode;
import ai.sangmado.jt809.protocol.exceptions.InvalidJT809MessageChecksumException;
import ai.sangmado.jt809.protocol.message.content.JT809MessageContent;
import ai.sangmado.jt809.protocol.message.header.JT809MessageHeader;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.nio.ByteBuffer;

/**
 * JT809 消息包
 */
public class JT809MessagePacket implements IJT809MessageFormatter {

    /**
     * 头标识
     */
    @Getter
    @Setter
    private byte beginMarker = 0x5b;

    /**
     * 消息头
     */
    @Getter
    @Setter
    private JT809MessageHeader header;

    /**
     * 消息体
     */
    @Getter
    @Setter
    private JT809MessageContent content;

    /**
     * CRC校验码
     * <p>
     * 从数据头到校验码前的 CRC16-CCITT 的校验值，遵循大端排序方式的规定。
     */
    @Getter
    @Setter
    private int checksum;

    /**
     * 尾标识
     */
    @Getter
    @Setter
    private byte endMarker = 0x5d;

    private IJT809MessageDecoder messageDecoder;

    public JT809MessagePacket() {
        this.messageDecoder = JT809MessageDecoder.Default;
    }

    public JT809MessagePacket(@NonNull IJT809MessageDecoder messageDecoder) {
        this.messageDecoder = messageDecoder;
    }

    @Override
    public void serialize(ISpecificationContext ctx, IJT809MessageBufferWriter writer) {
        // 求出消息数据，此处需要申请Header+Content长度的内存
        PooledByteArray pba = ctx.getByteArrayPool().borrow();
        try {
            serializeWithBuffer(ctx, writer, ByteBuffer.wrap(pba.array()));
        } finally {
            ctx.getByteArrayPool().recycle(pba);
        }
    }

    private void serializeWithBuffer(ISpecificationContext ctx, IJT809MessageBufferWriter writer, ByteBuffer buf) {
        // 写入数据
        IJT809MessageBufferWriter bufWriter = new JT809MessageByteBufferWriter(ctx, buf);
        header.serialize(ctx, bufWriter);
        int headerLength = buf.position();
        content.serialize(ctx, bufWriter);
        int contentLength = buf.position() - headerLength;
        buf.flip();

        // 加密消息体
        if (header.getEncryptionMode().equals(JT809MessageContentEncryptionMode.Encrypted)) {
            encrypt(ctx, buf, headerLength, contentLength, header.getEncryptionKey());
        }

        // 计算校验码
        this.checksum = checksum(buf, 0, headerLength + contentLength);
        buf.limit(headerLength + contentLength + 2);
        buf.position(headerLength + contentLength);
        bufWriter.writeUInt16(this.checksum);
        buf.flip();

        // 按顺序写入标识位和数据
        writer.writeByte(beginMarker);
        while (buf.hasRemaining()) {
            writeEscapedByte(buf.get(), writer);
        }
        writer.writeByte(endMarker);
    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT809MessageBufferReader reader) {
        // 将数据进行反转义，由于反转移需要针对整个Packet，则此处需要申请Packet大小的内存
        PooledByteArray pba = ctx.getByteArrayPool().borrow();
        try {
            deserializeWithBuffer(ctx, reader, ByteBuffer.wrap(pba.array()));
        } finally {
            ctx.getByteArrayPool().recycle(pba);
        }
    }

    private void deserializeWithBuffer(ISpecificationContext ctx, IJT809MessageBufferReader reader, ByteBuffer buf) {
        // 反转义
        IJT809MessageBufferWriter bufWriter = new JT809MessageByteBufferWriter(ctx, buf);
        while (reader.isReadable()) {
            readUnescapedByte(reader, bufWriter);
        }
        buf.flip();

        // 记录数组长度
        int bufArrayLength = buf.limit();

        // 计算校验码
        int reChecksum = checksum(buf, 1, bufArrayLength - 4);

        // 读取头标识
        buf.flip();
        buf.limit(bufArrayLength - 3);
        IJT809MessageBufferReader bufReader = new JT809MessageByteBufferReader(ctx, buf);
        this.beginMarker = bufReader.readByte();

        // 读取消息头
        this.header = decodeMessageHeader(ctx, bufReader);
        int headerPosition = buf.position();

        // 解密消息体
        if (header.getEncryptionMode().equals(JT809MessageContentEncryptionMode.Encrypted)) {
            decrypt(ctx, buf, headerPosition, buf.limit() - headerPosition, header.getEncryptionKey());
        }
        buf.position(headerPosition);

        // 读取消息体
        this.content = decodeMessageContent(ctx, bufReader, header);

        // 读取校验码
        buf.limit(bufArrayLength);
        this.checksum = bufReader.readUInt16();

        // 读取尾标识
        this.endMarker = bufReader.readByte();

        // 验证校验码
        if (this.checksum != reChecksum) {
            throw new InvalidJT809MessageChecksumException();
        }
    }

    private JT809MessageHeader decodeMessageHeader(
            ISpecificationContext ctx, IJT809MessageBufferReader reader) {
        return this.messageDecoder.decodeHeader(ctx, reader);
    }

    private JT809MessageContent decodeMessageContent(
            ISpecificationContext ctx, IJT809MessageBufferReader reader,
            JT809MessageHeader header) {
        return this.messageDecoder.decodeContent(ctx, reader, header);
    }

    /**
     * 加密消息体
     *
     * @param ctx           上下文
     * @param buf           消息体数据
     * @param offset        起始位置
     * @param length        处理长度
     * @param encryptionKey 加密Key
     */
    private static void encrypt(ISpecificationContext ctx, ByteBuffer buf, int offset, int length, long encryptionKey) {
        if (0 == encryptionKey) {
            encryptionKey = 1;
        }

        long mkey = ctx.getMessageContentEncryptionOptions().getM1();
        if (0 == mkey) {
            mkey = 1;
        }

        buf.position(offset);
        while (buf.hasRemaining() && (buf.position() < offset + length)) {
            int p = buf.position();
            byte b = buf.get();
            encryptionKey =
                    ctx.getMessageContentEncryptionOptions().getIA1()
                            * (encryptionKey % mkey)
                            + ctx.getMessageContentEncryptionOptions().getIC1();
            buf.put(p, (byte) (b ^ (byte) ((encryptionKey >> 20) & 0xFF)));
        }
    }

    /**
     * 解密消息体
     *
     * @param ctx           上下文
     * @param buf           消息体数据
     * @param offset        起始位置
     * @param length        处理长度
     * @param encryptionKey 加密Key
     */
    private static void decrypt(ISpecificationContext ctx, ByteBuffer buf, int offset, int length, long encryptionKey) {
        // 加密解密为同一算法
        encrypt(ctx, buf, offset, length, encryptionKey);
    }

    /**
     * 计算CRC校验码
     *
     * @param buf    计算内容
     * @param offset 起始位置
     * @param length 处理长度
     * @return 校验码
     */
    private static int checksum(ByteBuffer buf, int offset, int length) {
        return CRC16.CRC16_CCITT(buf, offset, length);
    }

    /**
     * 标识位转义
     * <p>
     * 数据内容进行转义判断，转义规则如下：
     * a) 若数据内容中有出现字符 0x5b 的，需替换为字符0x5a 紧跟字符0x01；
     * b) 若数据内容中有出现字符 0x5a 的，需替换为字符0x5a 紧跟字符0x02；
     * c) 若数据内容中有出现字符 0x5d 的，需替换为字符0x5e 紧跟字符0x01；
     * d) 若数据内容中有出现字符 0x5e 的，需替换为字符0x5e 紧跟字符0x02。
     *
     * @param x      字节
     * @param writer 转义后写入器
     */
    private static void writeEscapedByte(byte x, IJT809MessageBufferWriter writer) {
        if (x == (byte) 0x5b) {
            writer.writeByte(0x5a);
            writer.writeByte(0x01);
        } else if (x == (byte) 0x5a) {
            writer.writeByte(0x5a);
            writer.writeByte(0x02);
        } else if (x == (byte) 0x5d) {
            writer.writeByte(0x5e);
            writer.writeByte(0x01);
        } else if (x == (byte) 0x5e) {
            writer.writeByte(0x5e);
            writer.writeByte(0x02);
        } else {
            writer.writeByte(x);
        }
    }

    /**
     * 反向标识位转义
     *
     * @param reader 数据读取器
     * @param writer 反向转义后数据写入器
     */
    private void readUnescapedByte(IJT809MessageBufferReader reader, IJT809MessageBufferWriter writer) {
        byte x = reader.readByte();
        if (x == (byte) 0x5a) {
            byte x2 = reader.readByte();
            if (x2 == (byte) 0x01) {
                writer.writeByte(0x5b);
            } else if (x2 == (byte) 0x02) {
                writer.writeByte(0x5a);
            } else {
                writer.writeByte(x);
                writer.writeByte(x2);
            }
        } else if (x == (byte) 0x5e) {
            byte x2 = reader.readByte();
            if (x2 == (byte) 0x01) {
                writer.writeByte(0x5d);
            } else if (x2 == (byte) 0x02) {
                writer.writeByte(0x5e);
            } else {
                writer.writeByte(x);
                writer.writeByte(x2);
            }
        } else {
            writer.writeByte(x);
        }
    }
}
