package ai.sangmado.jt808.protocol.codec;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.utils.BCD;
import io.netty.buffer.ByteBuf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static ai.sangmado.jt808.protocol.utils.Bits.*;

/**
 * 基于 Netty ByteBuf 的写入层实现
 */
public class JT808MessageNettyByteBufWriter implements IJT808MessageBufferWriter {
    private ISpecificationContext ctx;
    private ByteBuf buf;

    public JT808MessageNettyByteBufWriter(ISpecificationContext ctx, ByteBuf buf) {
        this.ctx = ctx;
        this.buf = buf;
    }

    private boolean isBigEndian() {
        return ctx.getByteOrder() == ByteOrder.BIG_ENDIAN;
    }

    @Override
    public void writeByte(byte x) {
        buf.writeByte(x);
    }

    @Override
    public void writeByte(int x) {
        writeByte(int0(x));
    }

    @Override
    public void writeWord(int x) {
        if (isBigEndian()) {
            buf.writeByte(int1(x));
            buf.writeByte(int0(x));
        } else {
            buf.writeByte(int0(x));
            buf.writeByte(int1(x));
        }
    }

    @Override
    public void writeDWord(long x) {
        if (isBigEndian()) {
            buf.writeByte(long3(x));
            buf.writeByte(long2(x));
            buf.writeByte(long1(x));
            buf.writeByte(long0(x));
        } else {
            buf.writeByte(long0(x));
            buf.writeByte(long1(x));
            buf.writeByte(long2(x));
            buf.writeByte(long3(x));
        }
    }

    @Override
    public void writeBytes(byte[] x) {
        writeBytes(x, 0, x.length);
    }

    @Override
    public void writeBytes(byte[] x, int offset, int length) {
        buf.writeBytes(x, offset, length);
    }

    @Override
    public void writeBytes(ByteBuffer x) {
        buf.writeBytes(x);
    }

    @Override
    public void writeBCD(String x) {
        if (x == null)
            throw new IllegalArgumentException("input string cannot be null.");
        writeBytes(BCD.string2BCD(x));
    }

    @Override
    public void writeString(String x) {
        if (x == null)
            throw new IllegalArgumentException("input string cannot be null.");
        writeBytes(x.getBytes(ctx.getCharset()));
    }
}
