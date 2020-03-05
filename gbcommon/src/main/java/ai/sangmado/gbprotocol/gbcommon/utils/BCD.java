package ai.sangmado.gbprotocol.gbcommon.utils;

/**
 * BCD Code 工具类
 */
public class BCD {

    public static String bcd2String(byte[] bcd) {
        StringBuilder sb = new StringBuilder();
        for (byte x : bcd) {
            byte high = (byte) (x & 0xf0);
            high >>>= (byte) 4;
            high = (byte) (high & 0x0f);
            byte low = (byte) (x & 0x0f);
            sb.append(high);
            sb.append(low);
        }
        return sb.toString();
    }

    public static byte[] string2BCD(String x) {
        byte[] bcd = new byte[(x.length() + x.length() % 2) / 2];
        for (int pointer = 0, index = 0; pointer < x.length(); pointer++, index++) {
            int left = Character.digit(x.charAt(pointer), 16);
            int right = Character.digit(x.charAt(++pointer), 16);
            bcd[index] = (byte) ((left << 4) | right);
        }
        return bcd;
    }
}
