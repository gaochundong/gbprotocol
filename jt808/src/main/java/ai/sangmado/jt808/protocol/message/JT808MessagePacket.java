package ai.sangmado.jt808.protocol.message;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.message.codec.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.message.codec.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.message.codec.impl.JT808MessageByteBufferWriter;
import ai.sangmado.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.jt808.protocol.message.header.JT808MessageHeader;
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
        ByteBuffer buf = ByteBuffer.wrap(bufArray);
        IJT808MessageBufferWriter bufWriter = new JT808MessageByteBufferWriter(ctx, buf);
        header.serialize(ctx, bufWriter);
        content.serialize(ctx, bufWriter);

        // 计算校验码
        buf.flip();
        byte checksum = checksum(buf);
        buf.flip();

        // 按顺序写入标识位和数据
        writer.writeByte(beginMarker);
        while (buf.hasRemaining()) {
            writeEscapeByte(buf.get(), writer);
        }
        writeEscapeByte(checksum, writer);
        writer.writeByte(endMarker);
    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    private static byte checksum(ByteBuffer buf) {
        int checksum = 0;
        while (buf.hasRemaining()) {
            checksum = checksum ^ buf.get();
        }
        return (byte) checksum;
    }

    private static void writeEscapeByte(byte x, IJT808MessageBufferWriter writer) {
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
}
