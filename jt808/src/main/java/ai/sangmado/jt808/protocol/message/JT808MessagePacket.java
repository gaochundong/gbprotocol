package ai.sangmado.jt808.protocol.message;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageFormatter;
import ai.sangmado.jt808.protocol.encoding.impl.JT808MessageByteBufferReader;
import ai.sangmado.jt808.protocol.encoding.impl.JT808MessageByteBufferWriter;
import ai.sangmado.jt808.protocol.exceptions.InvalidJT808MessageChecksumException;
import ai.sangmado.jt808.protocol.exceptions.UnsupportedJT808ProtocolVersionException;
import ai.sangmado.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.jt808.protocol.message.header.JT808MessageHeader;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.nio.ByteBuffer;

import static ai.sangmado.jt808.protocol.enums.JT808ProtocolVersion.*;

/**
 * JT808 消息包
 */
public class JT808MessagePacket implements IJT808MessageFormatter {

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

    private IJT808MessageDecoder messageDecoder;

    public JT808MessagePacket() {
        this.messageDecoder = JT808MessageDecoder.Default;
    }

    public JT808MessagePacket(@NonNull IJT808MessageDecoder messageDecoder) {
        this.messageDecoder = messageDecoder;
    }

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {
        // 求出消息数据
        final int possibleHeaderLength = 20;
        byte[] bufArray = new byte[possibleHeaderLength + content.getContentLength(ctx)];
        ByteBuffer messageBuf = ByteBuffer.wrap(bufArray);
        IJT808MessageBufferWriter bufWriter = new JT808MessageByteBufferWriter(ctx, messageBuf);
        header.serialize(ctx, bufWriter);
        content.serialize(ctx, bufWriter);
        messageBuf.flip();

        // 计算校验码
        this.checksum = checksum(messageBuf);
        messageBuf.flip();

        // 按顺序写入标识位和数据
        writer.writeByte(beginMarker);
        while (messageBuf.hasRemaining()) {
            writeEscapedByte(messageBuf.get(), writer);
        }
        writeEscapedByte((byte) this.checksum, writer);
        writer.writeByte(endMarker);
    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        // 将数据进行转义
        byte[] bufArray = new byte[reader.readableBytes()];
        ByteBuffer messageBuf = ByteBuffer.wrap(bufArray);
        IJT808MessageBufferWriter bufWriter = new JT808MessageByteBufferWriter(ctx, messageBuf);
        while (reader.isReadable()) {
            readUnescapedByte(reader, bufWriter);
        }
        messageBuf.flip();

        // 记录数组长度
        int bufArrayLength = messageBuf.limit();
        messageBuf.limit(bufArrayLength - 2);

        // 读取头标识
        IJT808MessageBufferReader bufReader = new JT808MessageByteBufferReader(ctx, messageBuf);
        this.beginMarker = bufReader.readByte();

        // 检查协议版本
        checkMessageProtocolVersion(ctx, bufReader);

        // 读取消息头
        this.header = decodeMessageHeader(ctx, bufReader);

        // 读取消息体
        this.content = decodeMessageContent(ctx, bufReader, header);

        // 读取校验码
        messageBuf.limit(bufArrayLength);
        this.checksum = bufReader.readByte();

        // 读取尾标识
        this.endMarker = bufReader.readByte();

        // 验证校验码
        messageBuf.flip();
        messageBuf.position(1);
        messageBuf.limit(bufArrayLength - 2);
        int reChecksum = checksum(messageBuf);
        if (this.checksum != reChecksum) {
            throw new InvalidJT808MessageChecksumException();
        }
    }

    private void checkMessageProtocolVersion(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
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
                throw new UnsupportedJT808ProtocolVersionException(String.format(
                        "协议版本不匹配，终端上传消息版本[%s]，服务端配置版本[%s]，消息ID[%s]，版本位[%s]",
                        V2019, ctx.getProtocolVersion(), messageId, protocolVersion));
            }
        } else {
            // 2013版本与2011版本相同，此标记位为0.
            if (ctx.getProtocolVersion().getValue() > V2013.getValue()) {
                throw new UnsupportedJT808ProtocolVersionException(String.format(
                        "协议版本不匹配，终端上传消息版本[%s|%s]，服务端配置版本[%s]，消息ID[%s]，版本位[%s]",
                        V2013, V2011, ctx.getProtocolVersion(), messageId, protocolVersion));
            }
        }
    }

    private JT808MessageHeader decodeMessageHeader(
            ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        return this.messageDecoder.decodeHeader(ctx, reader);
    }

    private JT808MessageContent decodeMessageContent(
            ISpecificationContext ctx, IJT808MessageBufferReader reader,
            JT808MessageHeader header) {
        return this.messageDecoder.decodeContent(ctx, reader, header);
    }

    private static int checksum(ByteBuffer buf) {
        int checksum = 0;
        while (buf.hasRemaining()) {
            checksum = checksum ^ buf.get();
        }
        return checksum;
    }

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
