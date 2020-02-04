package ai.sangmado.jt808.protocol.memory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 池化数组
 */
public class PooledByteArray {
    private byte[] bytes;

    public PooledByteArray(byte[] bytes) {
        this.bytes = bytes;
    }

    public byte[] array() {
        return bytes;
    }

    public int length() {
        return bytes.length;
    }

    public byte get(int index) {
        return bytes[index];
    }

    public void set(int index, byte b) {
        bytes[index] = b;
    }

    public void copyTo(byte[] dst, int dstPos, int offset, int len) {
        System.arraycopy(bytes, offset, dst, dstPos, len);
    }

    public void copyFrom(byte[] src, int srcPos, int offset, int len) {
        System.arraycopy(src, srcPos, bytes, offset, len);
    }

    public void writeTo(OutputStream out, int offset, int len) throws IOException {
        out.write(bytes, offset, len);
    }

    public int readFrom(InputStream in, int offset, int len) throws IOException {
        return in.read(bytes, offset, len);
    }
}
