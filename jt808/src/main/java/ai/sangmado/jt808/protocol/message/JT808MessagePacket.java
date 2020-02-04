package ai.sangmado.jt808.protocol.message;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.exceptions.InvalidJT808MessageChecksumException;
import ai.sangmado.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.jt808.protocol.message.content.JT808MessageContentFactory;
import ai.sangmado.jt808.protocol.message.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.message.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.message.encoding.impl.JT808MessageByteBufferReader;
import ai.sangmado.jt808.protocol.message.encoding.impl.JT808MessageByteBufferWriter;
import ai.sangmado.jt808.protocol.message.header.JT808MessageHeader;
import ai.sangmado.jt808.protocol.message.header.JT808MessageHeaderFactory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.ByteBuffer;

/**
 * JT808 消息包
 */
@Getter
@Setter
@NoArgsConstructor
public class JT808MessagePacket implements IJT808MessageFormatter {

    /**
     * 头标识
     */
    private Byte beginMarker = 0x7e;

    /**
     * 消息头
     */
    private JT808MessageHeader header;

    /**
     * 消息体
     */
    private JT808MessageContent content;

    /**
     * 校验码
     * 从消息头首字节开始，同后一字节进行异或操作，直到消息体末字节结束。校验码占用一个字节。
     */
    private Byte checksum;

    /**
     * 尾标识
     */
    private Byte endMarker = 0x7e;

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
        byte checksum = checksum(messageBuf);
        messageBuf.flip();

        // 按顺序写入标识位和数据
        writer.writeByte(beginMarker);
        while (messageBuf.hasRemaining()) {
            writeEscapedByte(messageBuf.get(), writer);
        }
        writeEscapedByte(checksum, writer);
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

        // 读取消息头
        this.header = JT808MessageHeaderFactory.deserialize(ctx, bufReader);

        // 读取消息体
        this.content = JT808MessageContentFactory.deserialize(ctx, bufReader, header);

        // 读取校验码
        messageBuf.limit(bufArrayLength);
        this.checksum = bufReader.readByte();

        // 读取尾标识
        this.endMarker = bufReader.readByte();

        // 验证校验码
        messageBuf.flip();
        messageBuf.position(1);
        messageBuf.limit(bufArrayLength - 2);
        byte reChecksum = checksum(messageBuf);
        if (this.checksum != reChecksum) {
            throw new InvalidJT808MessageChecksumException();
        }
    }

    private static byte checksum(ByteBuffer buf) {
        int checksum = 0;
        while (buf.hasRemaining()) {
            checksum = checksum ^ buf.get();
        }
        return (byte) checksum;
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
