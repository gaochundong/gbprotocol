package ai.sangmado.gbcommon.utils;

import java.nio.ByteBuffer;

/**
 * CRC16校验类
 */
public class CRC16 {

    public static int CRC16_CCITT(byte[] buffer) {
        return CRC16_CCITT(buffer, 0, buffer.length);
    }

    public static int CRC16_CCITT(byte[] buffer, int offset, int length) {
        int crc = 0xFFFF;          // initial value
        int polynomial = 0x1021;   // 0001 0000 0010 0001  (0, 5, 12)

        for (int j = 0; j < length; ++j) {
            for (int i = 0; i < 8; i++) {
                boolean bit = ((buffer[offset + j] >> (7 - i) & 1) == 1);
                boolean c15 = ((crc >> 15 & 1) == 1);
                crc <<= 1;
                if (c15 ^ bit) crc ^= polynomial;
            }
        }

        crc &= 0xFFFF;
        return crc;
    }

    public static int CRC16_CCITT(ByteBuffer buf) {
        int crc = 0xFFFF;          // initial value
        int polynomial = 0x1021;   // 0001 0000 0010 0001  (0, 5, 12)

        while (buf.hasRemaining()) {
            for (int i = 0; i < 8; i++) {
                boolean bit = ((buf.get() >> (7 - i) & 1) == 1);
                boolean c15 = ((crc >> 15 & 1) == 1);
                crc <<= 1;
                if (c15 ^ bit) crc ^= polynomial;
            }
        }

        crc &= 0xFFFF;
        return crc;
    }
}
