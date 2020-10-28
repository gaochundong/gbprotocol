package ai.sangmado.gbprotocol.jt808.protocol.utils;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;

import java.nio.ByteBuffer;

/**
 * 字符串转换器
 */
public final class StringsConverter {

    /**
     * 将Byte数组转化为字符串
     *
     * @param x Byte数组
     * @return 字符串
     */
    public static String toString(IVersionedSpecificationContext ctx, byte[] x) {
        if (x == null)
            throw new IllegalArgumentException("Invalid byte array.");
        return ctx.getCharset().decode(ByteBuffer.wrap(x, 0, x.length)).toString();
    }

    /**
     * 将字符串转化为Byte数组
     *
     * @param x 字符串
     * @return Byte数组
     */
    public static byte[] toBytes(IVersionedSpecificationContext ctx, String x) {
        if (x == null)
            throw new IllegalArgumentException("Invalid string.");
        return x.getBytes(ctx.getCharset());
    }
}
