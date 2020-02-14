package ai.sangmado.gbcommon.utils;

/**
 * Bit位工具类
 */
public class Bits {

    public static byte char1(char x) { return (byte)(x >> 8); }
    public static byte char0(char x) { return (byte)(x     ); }

    public static byte short1(short x) { return (byte)(x >> 8); }
    public static byte short0(short x) { return (byte)(x     ); }

    public static byte int3(int x) { return (byte)(x >> 24); }
    public static byte int2(int x) { return (byte)(x >> 16); }
    public static byte int1(int x) { return (byte)(x >>  8); }
    public static byte int0(int x) { return (byte)(x      ); }

    public static byte long7(long x) { return (byte)(x >> 56); }
    public static byte long6(long x) { return (byte)(x >> 48); }
    public static byte long5(long x) { return (byte)(x >> 40); }
    public static byte long4(long x) { return (byte)(x >> 32); }
    public static byte long3(long x) { return (byte)(x >> 24); }
    public static byte long2(long x) { return (byte)(x >> 16); }
    public static byte long1(long x) { return (byte)(x >>  8); }
    public static byte long0(long x) { return (byte)(x      ); }
}
