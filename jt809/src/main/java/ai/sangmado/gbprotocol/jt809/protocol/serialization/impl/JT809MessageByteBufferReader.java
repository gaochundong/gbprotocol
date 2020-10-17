package ai.sangmado.gbprotocol.jt809.protocol.serialization.impl;

import ai.sangmado.gbprotocol.gbcommon.utils.BCD;
import ai.sangmado.gbprotocol.gbcommon.utils.Bits;
import ai.sangmado.gbprotocol.jt809.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt809.protocol.serialization.IJT809MessageBufferReader;
import com.google.common.primitives.UnsignedLong;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 基于 ByteBuffer 的 JT809 读取层实现
 */
public class JT809MessageByteBufferReader implements IJT809MessageBufferReader {
    private final IVersionedSpecificationContext ctx;
    private final ByteBuffer buf;
    private int markedIndex = 0;

    public JT809MessageByteBufferReader(IVersionedSpecificationContext ctx, ByteBuffer buf) {
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
    public int readUInt16() {
        if (isBigEndian()) {
            return (((buf.get() & 0xFF) << 8) | ((buf.get() & 0xFF))) & 0xFFFF;
        } else {
            return (((buf.get() & 0xFF)) | ((buf.get() & 0xFF) << 8)) & 0xFFFF;
        }
    }

    @Override
    public long readUInt32() {
        if (isBigEndian()) {
            return (((buf.get() & 0xFF) << 24) | ((buf.get() & 0xFF) << 16) | ((buf.get() & 0xFF) << 8) | ((buf.get() & 0xFF))) & 0xFFFFFFFFL;
        } else {
            return (((buf.get() & 0xFF)) | ((buf.get() & 0xFF) << 8) | ((buf.get() & 0xFF) << 16) | ((buf.get() & 0xFF) << 24)) & 0xFFFFFFFFL;
        }
    }

    @Override
    public UnsignedLong readUInt64() {
        byte b0 = buf.get();
        byte b1 = buf.get();
        byte b2 = buf.get();
        byte b3 = buf.get();
        byte b4 = buf.get();
        byte b5 = buf.get();
        byte b6 = buf.get();
        byte b7 = buf.get();
        if (isBigEndian()) {
            return UnsignedLong.fromLongBits(Bits.makeLong(b0, b1, b2, b3, b4, b5, b6, b7));
        } else {
            return UnsignedLong.fromLongBits(Bits.makeLong(b7, b6, b5, b4, b3, b2, b1, b0));
        }
    }

    @Override
    public byte[] readBytes(int length) {
        byte[] x = new byte[length];
        buf.get(x, 0, x.length);
        return x;
    }

    @Override
    public String readBCD(int length) {
        byte[] x = readBytes(length);
        return BCD.bcd2String(x);
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
