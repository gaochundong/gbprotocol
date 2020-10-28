package ai.sangmado.gbprotocol.jt808.protocol.utils;

/**
 * Byte数组填充器
 */
public final class BytesPadder {

    /**
     * 为Byte数组左补位
     *
     * @param src       Byte数组
     * @param minLength 最小长度
     * @param padChar   补位字符
     * @return 补位后数组
     */
    public static byte[] padLeft(byte[] src, int minLength, byte padChar) {
        if (src == null)
            throw new IllegalArgumentException("Invalid byte array.");

        if (src.length > minLength) {
            throw new IllegalArgumentException("Bytes length exceeded.");
        } else if (src.length == minLength) {
            return src;
        } else {
            byte[] dest = new byte[minLength];
            for (int i = 0; i < minLength - src.length; i++) {
                dest[i] = padChar;
            }
            System.arraycopy(src, 0, dest, minLength - src.length, src.length);
            return dest;
        }
    }

    /**
     * 为Byte数组右补位
     *
     * @param src       Byte数组
     * @param minLength 最小长度
     * @param padChar   补位字符
     * @return 补位后数组
     */
    public static byte[] padRight(byte[] src, int minLength, byte padChar) {
        if (src == null)
            throw new IllegalArgumentException("Invalid byte array.");

        if (src.length > minLength) {
            throw new IllegalArgumentException("Bytes length exceeded.");
        } else if (src.length == minLength) {
            return src;
        } else {
            byte[] dest = new byte[minLength];
            System.arraycopy(src, 0, dest, 0, src.length);
            for (int i = src.length; i < minLength; i++) {
                dest[i] = padChar;
            }
            return dest;
        }
    }

    /**
     * Byte数组去除左侧指定字符
     *
     * @param src      Byte数组
     * @param trimChar 去除字符
     * @return 去除后数组
     */
    public static byte[] trimLeft(byte[] src, byte trimChar) {
        if (src == null)
            throw new IllegalArgumentException("Invalid byte array.");

        final int NO_TRIM = -1;
        int pos = NO_TRIM;
        for (int i = 0; i < src.length; i++) {
            if (src[i] != trimChar) {
                pos = i;
                break;
            }
        }
        if (pos != NO_TRIM) {
            byte[] dest = new byte[src.length - pos];
            System.arraycopy(src, pos, dest, 0, src.length - pos);
            return dest;
        }

        return src;
    }

    /**
     * Byte数组去除右侧指定字符
     *
     * @param src      Byte数组
     * @param trimChar 去除字符
     * @return 去除后数组
     */
    public static byte[] trimRight(byte[] src, byte trimChar) {
        if (src == null)
            throw new IllegalArgumentException("Invalid byte array.");

        final int NO_TRIM = -1;
        int pos = NO_TRIM;
        for (int i = src.length - 1; i >= 0; i--) {
            if (src[i] != trimChar) {
                pos = i;
                break;
            }
        }
        if (pos != NO_TRIM) {
            byte[] dest = new byte[pos + 1];
            System.arraycopy(src, 0, dest, 0, pos + 1);
            return dest;
        }

        return src;
    }
}
