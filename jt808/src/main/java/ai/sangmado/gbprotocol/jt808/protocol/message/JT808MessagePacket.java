package ai.sangmado.gbprotocol.jt808.protocol.message;

import ai.sangmado.gbprotocol.gbcommon.memory.PooledByteArray;
import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808ProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.InvalidJT808MessageChecksumException;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808MessageException;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808ProtocolVersionException;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContentRegistration;
import ai.sangmado.gbprotocol.jt808.protocol.message.header.JT808MessageHeader;
import ai.sangmado.gbprotocol.jt808.protocol.message.header.JT808MessageHeaderRegistration;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.impl.JT808MessageByteBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.impl.JT808MessageByteBufferWriter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.ByteBuffer;

/**
 * JT808 消息包
 */
@NoArgsConstructor
public class JT808MessagePacket implements IJT808Message {

    /**
     * 头标识
     */
    @Getter
    @Setter
    private byte beginMarker = 0x7e;

    /**
     * 消息头
     */
    @Getter
    @Setter
    private JT808MessageHeader header;

    /**
     * 消息体
     */
    @Getter
    @Setter
    private JT808MessageContent content;

    /**
     * 校验码
     * 从消息头首字节开始，同后一字节进行异或操作，直到消息体末字节结束。校验码占用一个字节。
     */
    @Getter
    @Setter
    private int checksum;

    /**
     * 尾标识
     */
    @Getter
    @Setter
    private byte endMarker = 0x7e;

    /**
     * 获取协议版本
     *
     * @return 协议版本
     */
    @Override
    public JT808ProtocolVersion getProtocolVersion() {
        return this.header.getProtocolVersion();
    }

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {
        // 求出消息数据，此处需要申请Header+Content长度的内存
        PooledByteArray pba = ctx.getBufferPool().borrow();
        try {
            serializeWithBuffer(ctx, writer, ByteBuffer.wrap(pba.array()));
        } finally {
            ctx.getBufferPool().recycle(pba);
        }
    }

    private void serializeWithBuffer(ISpecificationContext ctx, IJT808MessageBufferWriter writer, ByteBuffer buf) {
        // 写入数据
        IJT808MessageBufferWriter bufWriter = new JT808MessageByteBufferWriter(ctx, buf);
        header.serialize(ctx, bufWriter);
        content.serialize(ctx, bufWriter);
        buf.flip();

        // 计算校验码
        this.checksum = checksum(buf, 0, buf.limit());
        buf.flip();

        // 按顺序写入标识位和数据
        writer.writeByte(beginMarker);
        while (buf.hasRemaining()) {
            writeEscapedByte(buf.get(), writer);
        }
        writeEscapedByte((byte) this.checksum, writer);
        writer.writeByte(endMarker);
    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        // 将数据进行反转义，由于反转移需要针对整个Packet，则此处需要申请Packet大小的内存
        PooledByteArray pba = ctx.getBufferPool().borrow();
        try {
            deserializeWithBuffer(ctx, reader, ByteBuffer.wrap(pba.array()));
        } finally {
            ctx.getBufferPool().recycle(pba);
        }
    }

    private void deserializeWithBuffer(ISpecificationContext ctx, IJT808MessageBufferReader reader, ByteBuffer buf) {
        // 反转义
        IJT808MessageBufferWriter bufWriter = new JT808MessageByteBufferWriter(ctx, buf);
        while (reader.isReadable()) {
            readUnescapedByte(reader, bufWriter);
        }
        buf.flip();

        // 记录数组长度
        int bufArrayLength = buf.limit();

        // 计算校验码
        int reChecksum = checksum(buf, 1, bufArrayLength - 3);

        // 读取头标识
        buf.flip();
        buf.limit(bufArrayLength - 2);
        IJT808MessageBufferReader bufReader = new JT808MessageByteBufferReader(ctx, buf);
        this.beginMarker = bufReader.readByte();

        // 读取消息头
        this.header = decodeMessageHeader(ctx, bufReader);

        // 读取消息体
        this.content = decodeMessageContent(ctx, bufReader, header);

        // 读取校验码
        buf.limit(bufArrayLength);
        this.checksum = bufReader.readByte();

        // 读取尾标识
        this.endMarker = bufReader.readByte();

        // 验证校验码
        if (this.checksum != reChecksum) {
            throw new InvalidJT808MessageChecksumException();
        }
    }

    private JT808MessageHeader decodeMessageHeader(
            ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        if (!JT808MessageHeaderRegistration.getDecoders().containsKey(ctx.getProtocolVersion())) {
            throw new UnsupportedJT808ProtocolVersionException(ctx.getProtocolVersion());
        }
        return JT808MessageHeaderRegistration.getDecoders().get(ctx.getProtocolVersion()).apply(ctx, reader);
    }

    private JT808MessageContent decodeMessageContent(
            ISpecificationContext ctx, IJT808MessageBufferReader reader,
            JT808MessageHeader header) {
        if (!JT808MessageContentRegistration.getDecoders().containsKey(header.getMessageId())) {
            throw new UnsupportedJT808MessageException(header.getMessageId());
        }
        PooledByteArray pba = ctx.getBufferPool().borrow();
        try {
            ByteBuffer buf = ByteBuffer.wrap(pba.array());
            IJT808MessageBufferWriter bufWriter = new JT808MessageByteBufferWriter(ctx, buf);

            // 拷贝与消息体长度相等的数据
            int contentLength = header.getMessageContentProperty().getContentLength();
            while (contentLength > 0) {
                bufWriter.writeByte(reader.readByte());
                contentLength--;
            }
            buf.flip();

            IJT808MessageBufferReader bufReader = new JT808MessageByteBufferReader(ctx, buf);
            return JT808MessageContentRegistration.getDecoders().get(header.getMessageId()).apply(ctx, bufReader);
        } finally {
            ctx.getBufferPool().recycle(pba);
        }
    }

    /**
     * 计算校验码
     * <p>
     * 校验码的计算规则应从消息头首字节开始，同后一字节进行异或操作，直到消息体末字节结束；
     * 校验码长度为一字节；
     *
     * @param buf    计算内容
     * @param offset 起始位置
     * @param length 处理长度
     * @return 校验码
     */
    private static int checksum(ByteBuffer buf, int offset, int length) {
        int checksum = 0;
        buf.position(offset);
        while (buf.hasRemaining() && (buf.position() < offset + length)) {
            checksum = checksum ^ buf.get();
        }
        return checksum;
    }

    /**
     * 标识位转义
     * <p>
     * 先对0x7d进行转义，转换为固定两字节数据 0x7d 0x01；
     * 在对0x7e进行转义，转换为固定两字节数据 0x7d 0x02；
     *
     * @param x      字节
     * @param writer 转义后写入器
     */
    private static void writeEscapedByte(byte x, IJT808MessageBufferWriter writer) {
        if (x == (byte) 0x7d) {
            writer.writeByte(0x7d);
            writer.writeByte(0x01);
        } else if (x == (byte) 0x7e) {
            writer.writeByte(0x7d);
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
    private void readUnescapedByte(IJT808MessageBufferReader reader, IJT808MessageBufferWriter writer) {
        byte x = reader.readByte();
        if (x == (byte) 0x7d) {
            byte x2 = reader.readByte();
            if (x2 == (byte) 0x01) {
                writer.writeByte(0x7d);
            } else if (x2 == (byte) 0x02) {
                writer.writeByte(0x7e);
            } else {
                writer.writeByte(x);
                writer.writeByte(x2);
            }
        } else {
            writer.writeByte(x);
        }
    }
}
