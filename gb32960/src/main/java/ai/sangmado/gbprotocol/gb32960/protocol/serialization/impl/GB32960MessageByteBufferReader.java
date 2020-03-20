package ai.sangmado.gbprotocol.gb32960.protocol.serialization.impl;

import ai.sangmado.gbprotocol.gb32960.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.IGB32960MessageBufferReader;
import ai.sangmado.gbprotocol.gbcommon.utils.Bits;
import com.google.common.primitives.UnsignedLong;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 基于 ByteBuffer 的 GB32960 读取层实现
 */
public class GB32960MessageByteBufferReader implements IGB32960MessageBufferReader {
    private ISpecificationContext ctx;
    private ByteBuffer buf;
    private int markedIndex = 0;

    public GB32960MessageByteBufferReader(ISpecificationContext ctx, ByteBuffer buf) {
        this.ctx = ctx;
        this.buf = buf;
    }

    private boolean isBigEndian() {
        return this.buf.order() == ByteOrder.BIG_ENDIAN;
    }

    @Override
    public void markIndex() {
        this.markedIndex = buf.position();
    }

    @Override
    public void resetIndex() {
        buf.position(this.markedIndex);
    }

    @Override
    public boolean isReadable() {
        return buf.hasRemaining();
    }

    @Override
    public boolean isReadable(int size) {
        return buf.remaining() >= size;
    }

    @Override
    public int readableBytes() {
        return buf.remaining();
    }

    @Override
    public byte readByte() {
        return buf.get();
    }

    @SuppressWarnings("IfStatementWithIdenticalBranches")
    @Override
    public int readWord() {
        if (isBigEndian()) {
            return (((buf.get() & 0xFF) << 8) | ((buf.get() & 0xFF))) & 0xFFFF;
        } else {
            return (((buf.get() & 0xFF)) | ((buf.get() & 0xFF) << 8)) & 0xFFFF;
        }
    }

    @Override
    public long readDWord() {
        if (isBigEndian()) {
            return (((buf.get() & 0xFF) << 24) | ((buf.get() & 0xFF) << 16) | ((buf.get() & 0xFF) << 8) | ((buf.get() & 0xFF))) & 0xFFFFFFFFL;
        } else {
            return (((buf.get() & 0xFF)) | ((buf.get() & 0xFF) << 8) | ((buf.get() & 0xFF) << 16) | ((buf.get() & 0xFF) << 24)) & 0xFFFFFFFFL;
        }
    }

    @Override
    public byte[] readBytes(int length) {
        byte[] x = new byte[length];
        buf.get(x, 0, x.length);
        return x;
    }

    @Override
    public String readString(int length) {
        byte[] x = readBytes(length);
        return ctx.getCharset().decode(ByteBuffer.wrap(x, 0, x.length)).toString();
    }

    @Override
    public String readStringRemaining() {
        return readString(buf.remaining());
    }
}
