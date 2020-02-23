package ai.sangmado.jt809.protocol.encoding.impl;

import ai.sangmado.gbcommon.utils.BCD;
import ai.sangmado.jt809.protocol.ISpecificationContext;
import ai.sangmado.jt809.protocol.encoding.IJT809MessageBufferWriter;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static ai.sangmado.gbcommon.utils.Bits.*;

/**
 * 基于 ByteBuffer 的写入层实现
 */
public class JT809MessageByteBufferWriter implements IJT809MessageBufferWriter {
    private ISpecificationContext ctx;
    private ByteBuffer buf;

    public JT809MessageByteBufferWriter(ISpecificationContext ctx, ByteBuffer buf) {
        this.ctx = ctx;
        this.buf = buf;
    }

    private boolean isBigEndian() {
        return this.buf.order() == ByteOrder.BIG_ENDIAN;
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
    public void writeUInt16(int x) {
        if (isBigEndian()) {
            buf.put(int1(x));
            buf.put(int0(x));
        } else {
            buf.put(int0(x));
            buf.put(int1(x));
        }
    }

    @Override
    public void writeUInt32(long x) {
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
    public void writeUInt64(long x) {
        if (isBigEndian()) {
            buf.put(long7(x));
            buf.put(long6(x));
            buf.put(long5(x));
            buf.put(long4(x));
            buf.put(long3(x));
            buf.put(long2(x));
            buf.put(long1(x));
            buf.put(long0(x));
        } else {
            buf.put(long0(x));
            buf.put(long1(x));
            buf.put(long2(x));
            buf.put(long3(x));
            buf.put(long4(x));
            buf.put(long5(x));
            buf.put(long6(x));
            buf.put(long7(x));
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
