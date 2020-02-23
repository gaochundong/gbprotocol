package ai.sangmado.jt809.protocol.message;

import ai.sangmado.gbcommon.memory.PooledByteArray;
import ai.sangmado.jt809.protocol.ISpecificationContext;
import ai.sangmado.jt809.protocol.encoding.IJT809MessageBufferReader;
import ai.sangmado.jt809.protocol.encoding.IJT809MessageBufferWriter;
import ai.sangmado.jt809.protocol.encoding.IJT809MessageFormatter;
import ai.sangmado.jt809.protocol.encoding.impl.JT809MessageByteBufferReader;
import ai.sangmado.jt809.protocol.encoding.impl.JT809MessageByteBufferWriter;
import ai.sangmado.jt809.protocol.exceptions.InvalidJT809MessageChecksumException;
import ai.sangmado.jt809.protocol.exceptions.UnsupportedJT809ProtocolVersionException;
import ai.sangmado.jt809.protocol.message.content.JT809MessageContent;
import ai.sangmado.jt809.protocol.message.header.JT809MessageHeader;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.nio.ByteBuffer;

import static ai.sangmado.jt809.protocol.enums.JT809ProtocolVersion.*;

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
        IJT809MessageBufferWriter bufWriter = new JT809MessageByteBufferWriter(ctx, buf);
        header.serialize(ctx, bufWriter);
        content.serialize(ctx, bufWriter);
        buf.flip();

        // 计算校验码
        this.checksum = checksum(buf);
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
        IJT809MessageBufferWriter bufWriter = new JT809MessageByteBufferWriter(ctx, buf);
        while (reader.isReadable()) {
            readUnescapedByte(reader, bufWriter);
        }
        buf.flip();

        // 记录数组长度
        int bufArrayLength = buf.limit();
        buf.limit(bufArrayLength - 2);

        // 读取头标识
        IJT809MessageBufferReader bufReader = new JT809MessageByteBufferReader(ctx, buf);
        this.beginMarker = bufReader.readByte();

        // 检查协议版本
        verifyMessageProtocolVersion(ctx, bufReader);

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
        buf.flip();
        buf.position(1);
        buf.limit(bufArrayLength - 2);
        int reChecksum = checksum(buf);
        if (this.checksum != reChecksum) {
            throw new InvalidJT809MessageChecksumException();
        }
    }

    private void verifyMessageProtocolVersion(ISpecificationContext ctx, IJT809MessageBufferReader reader) {
        // 预读取消息头中消息ID和消息体属性
        reader.markIndex();
        int messageId = reader.readWord();
        int messageContentProperty = reader.readWord();
        int protocolVersion = reader.readByte() & 0xFF;
        reader.resetIndex();

        // 通过消息体属性格式中第14位版本位尝试判断协议版本
        if ((messageContentProperty >> 14 & 0x01) == 1) {
            // 2019版本，此标记位为1.
            if (ctx.getProtocolVersion().getValue() < V2019.getValue()) {
                throw new UnsupportedJT809ProtocolVersionException(String.format(
                        "协议版本不匹配，终端上传消息版本[%s]，服务端配置版本[%s]，消息ID[%s]，版本位[%s]",
                        V2019, ctx.getProtocolVersion(), messageId, protocolVersion));
            }
        } else {
            // 2013版本与2011版本相同，此标记位为0.
            if (ctx.getProtocolVersion().getValue() > V2013.getValue()) {
                throw new UnsupportedJT809ProtocolVersionException(String.format(
                        "协议版本不匹配，终端上传消息版本[%s|%s]，服务端配置版本[%s]，消息ID[%s]，版本位[%s]",
                        V2013, V2011, ctx.getProtocolVersion(), messageId, protocolVersion));
            }
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
     * 计算CRC校验码
     *
     * @param buf 计算内容
     * @return 校验码
     */
    private static int checksum(ByteBuffer buf) {
        int checksum = 0;
        while (buf.hasRemaining()) {
            checksum = checksum ^ buf.get();
        }
        return checksum;
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
