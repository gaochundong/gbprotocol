package ai.sangmado.gbprotocol.jt808.protocol.message;

import ai.sangmado.gbprotocol.gbcommon.memory.PooledByteArray;
import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.InvalidJT808MessageChecksumException;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.message.header.JT808MessageHeader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.impl.JT808MessageByteBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.impl.JT808MessageByteBufferWriter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;

/**
 * JT808 消息
 */
@Slf4j
@NoArgsConstructor
public class JT808Message implements IJT808Message<JT808MessageHeader, JT808MessageContent> {

    /**
     * 头标识
     */
    @Getter
    @Setter
    @JsonProperty(index = 100)
    private byte beginMarker = 0x7e;

    /**
     * 消息头
     */
    @Getter
    @Setter
    @JsonProperty(index = 200)
    private JT808MessageHeader header;

    /**
     * 消息体
     */
    @Getter
    @Setter
    @JsonProperty(index = 300)
    private JT808MessageContent content;

    /**
     * 校验码
     * 从消息头首字节开始，同后一字节进行异或操作，直到消息体末字节结束。校验码占用一个字节。
     */
    @Getter
    @Setter
    @JsonProperty(index = 400)
    private int checksum;

    /**
     * 尾标识
     */
    @Getter
    @Setter
    @JsonProperty(index = 500)
    private byte endMarker = 0x7e;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {
        // 求出消息数据，此处需要申请Header+Content长度的内存
        PooledByteArray pba = ctx.getBufferPool().borrow();
        try {
            serializeWithBuffer(ctx, writer, ByteBuffer.wrap(pba.array()));
        } finally {
            ctx.getBufferPool().recycle(pba);
        }
    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        // 将数据进行反转义，由于反转移需要针对整个Packet，则此处需要申请Packet大小的内存
        PooledByteArray pba = ctx.getBufferPool().borrow();
        try {
            deserializeWithBuffer(ctx, reader, ByteBuffer.wrap(pba.array()));
        } finally {
            ctx.getBufferPool().recycle(pba);
        }
    }

    private void serializeWithBuffer(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer, ByteBuffer buf) {
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

    private void deserializeWithBuffer(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader, ByteBuffer buf) {
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
        this.header = JT808MessageReader.readMessageHeader(ctx, bufReader);

        // 读取消息体
        this.content = JT808MessageReader.readMessageContent(ctx, bufReader, header);

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
