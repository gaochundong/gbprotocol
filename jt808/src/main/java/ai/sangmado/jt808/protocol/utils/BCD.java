package ai.sangmado.jt808.protocol.utils;

/**
 * BCD Code 工具类
 */
public class BCD {

    public static String bcd2BCDString(byte bcd) {
        StringBuilder sb = new StringBuilder();

        byte high = (byte) (bcd & 0xf0);
        high >>>= (byte) 4;
        high = (byte) (high & 0x0f);
        byte low = (byte) (bcd & 0x0f);

        sb.append(high);
        sb.append(low);

        return sb.toString();
    }

    public static String bcd2BCDString(byte[] bcd) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bcd) {
            sb.append(bcd2BCDString(b));
        }
        return sb.toString();
    }

    public static byte[] bcdString2BCD(String bcdString) {
        int l = bcdString.length();
        byte[] bcd = new byte[l / 2];
        for (int i = 0; i < bcd.length; i++) {
            String ch = bcdString.substring(i * 2, i * 2 + 2);
            bcd[i] = Byte.parseByte(ch);
        }
        return bcd;
    }
}
