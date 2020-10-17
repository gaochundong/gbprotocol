package ai.sangmado.gbprotocol.gb32960.protocol.serialization.impl;

import ai.sangmado.gbprotocol.gb32960.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.IGB32960MessageBufferWriter;
import com.google.common.primitives.UnsignedLong;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static ai.sangmado.gbprotocol.gbcommon.utils.Bits.*;

/**
 * 基于 ByteBuffer 的 GB32960 写入层实现
 */
public class GB32960MessageByteBufferWriter implements IGB32960MessageBufferWriter {
    private final IVersionedSpecificationContext ctx;
    private final ByteBuffer buf;

    public GB32960MessageByteBufferWriter(IVersionedSpecificationContext ctx, ByteBuffer buf) {
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
    public void writeString(String x) {
        if (x == null)
            throw new IllegalArgumentException("input string cannot be null.");
        writeBytes(x.getBytes(ctx.getCharset()));
    }
}
