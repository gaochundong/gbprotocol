package ai.sangmado.gbprotocol.jt905.protocol.serialization;

/**
 * JT905 消息Buffer读取器
 */
public interface IJT905MessageBufferReader {

    /**
     * 标记当前读取位置
     */
    void markIndex();

    /**
     * 重置至已标记的读取位置
     */
    void resetIndex();

    /**
     * 是否还有可读数据
     *
     * @return 是否还有可读数据
     */
    boolean isReadable();

    /**
     * 是否还有可读数据
     *
     * @param size 可读数据最低长度
     * @return 是否还有可读数据
     */
    boolean isReadable(int size);

    /**
     * 可读数据长度
     *
     * @return 可读数据长度
     */
    int readableBytes();

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
