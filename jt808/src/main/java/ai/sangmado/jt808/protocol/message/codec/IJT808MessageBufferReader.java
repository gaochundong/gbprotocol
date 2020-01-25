package ai.sangmado.jt808.protocol.message.codec;

/**
 * JT808 消息Buffer读取器
 */
public interface IJT808MessageBufferReader {

    /**
     * 读取 BYTE 无符号单字节整型 (字节，8位)
     */
    byte readByte();

    /**
     * 读取 WORD 无符号双字节整型 (字节，16位)
     */
    int readWord();

    /**
     * 读取 DWORD 无符号四字节整型 (字节，32位)
     */
    long readDWord();

    /**
     * 读取 n 字节数据
     *
     * @param length 读取长度
     */
    byte[] readBytes(int length);

    /**
     * 读取 n 字节为 8421 码
     *
     * @param length 读取长度
     */
    String readBCD(int length);

    /**
     * 读取 n 字节为字符串，GBK 编码
     *
     * @param length 读取长度
     */
    String readString(int length);

    /**
     * 读取剩余字节为字符串，GBK 编码
     */
    String readStringRemaining();
}
