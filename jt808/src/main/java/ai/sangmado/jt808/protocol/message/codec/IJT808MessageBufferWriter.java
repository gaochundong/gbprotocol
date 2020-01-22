package ai.sangmado.jt808.protocol.message.codec;

/**
 * JT808 消息Buffer写入器
 */
public interface IJT808MessageBufferWriter {

    /**
     * 写入 BYTE 无符号单字节整型 (字节，8位)
     *
     * @param data 写入数据
     */
    void writeByte(Byte data);

    /**
     * 写入 BYTE 无符号单字节整型 (字节，8位)
     *
     * @param data 写入数据
     */
    void writeByte(Integer data);

    /**
     * 写入 WORD 无符号双字节整型 (字节，16位)
     *
     * @param data 写入数据
     */
    void writeWord(Integer data);

    /**
     * 写入 DWORD 无符号四字节整型 (字节，32位)
     *
     * @param data 写入数据
     */
    void writeDWord(Long data);

    /**
     * 写入 n 字节数据
     *
     * @param data   写入数据
     * @param length 写入长度
     */
    void writeBytes(byte[] data, int length);

    /**
     * 写入 n 字节数据
     *
     * @param data   写入数据
     * @param start  开始位置
     * @param length 写入长度
     */
    void writeBytes(byte[] data, int start, int length);

    /**
     * 写入 8421 码，n 字节
     *
     * @param data 写入数据
     */
    void writeBCD(String data);

    /**
     * 写入 8421 码，n 字节
     *
     * @param data   写入数据
     * @param length 写入长度
     */
    void writeBCD(String data, int length);

    /**
     * 写入 GBK 编码字符串数据，若无数据，置空
     *
     * @param data 写入数据
     */
    void writeString(String data);

    /**
     * 写入 GBK 编码字符串数据，若无数据，置空
     *
     * @param data   写入数据
     * @param length 写入长度
     */
    void writeString(String data, int length);
}
