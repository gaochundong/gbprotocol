package ai.sangmado.jt808.protocol.message.codec;

import ai.sangmado.jt808.protocol.ISpecificationContext;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static ai.sangmado.jt808.protocol.message.codec.Bits.*;

public class JT808MessageByteArrayWritableBuffer extends JT808MessageWritableBuffer {
    private ISpecificationContext ctx;
    private ByteBuffer buf;

    public JT808MessageByteArrayWritableBuffer(ISpecificationContext ctx) {
        this.ctx = ctx;
        this.buf = ByteBuffer.allocate(2048);
        this.buf.order(this.ctx.getByteOrder());
    }

    private boolean isBigEndian() {
        return this.ctx.getByteOrder() == ByteOrder.BIG_ENDIAN;
    }

    @Override
    public void writeByte(byte x) {
        buf.put(x);
    }

    @Override
    public void writeByte(int x) {
        writeByte(int0(x));
    }

    @Override
    public void writeWord(int x) {
        if (isBigEndian()) {
            buf.put(int1(x));
            buf.put(int0(x));
        } else {
            buf.put(int0(x));
            buf.put(int1(x));
        }
    }

    @Override
    public void writeDWord(long x) {
        if (isBigEndian()) {
            buf.put(long3(x));
            buf.put(long2(x));
            buf.put(long1(x));
            buf.put(long0(x));
        } else {
            buf.put(long0(x));
            buf.put(long1(x));
            buf.put(long2(x));
            buf.put(long3(x));
        }
    }

    @Override
    public void writeBytes(byte[] x) {
        writeBytes(x, 0, x.length);
    }

    @Override
    public void writeBytes(byte[] x, int offset, int length) {
        buf.put(x, offset, length);
    }

    @Override
    public void writeBytes(ByteBuffer x) {
        buf.put(x);
    }

    @Override
    public void writeBCD(String x) {

    }

    @Override
    public void writeString(String x) {
        writeBytes(x.getBytes(ctx.getCharset()));
    }
}
