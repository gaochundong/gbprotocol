package ai.sangmado.jt809.protocol.message.header;

import ai.sangmado.jt809.protocol.encoding.IJT809MessageFormatter;
import ai.sangmado.jt809.protocol.enums.JT809MessageContentEncryptionMode;
import ai.sangmado.jt809.protocol.enums.JT809MessageId;
import ai.sangmado.jt809.protocol.enums.JT809ProtocolVersion;
import lombok.*;

/**
 * JT809 消息头
 */
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class JT809MessageHeader implements IJT809MessageFormatter, Cloneable {

    /**
     * 数据长度
     * <p>
     * Since {@link JT809ProtocolVersion#V2011}
     * <p>
     * V2011:
     * 头标识 + 数据头 + 数据体 + 尾标识
     * 1 + 22 + n + 1
     * <p>
     * V2019:
     * 头标识 + 数据头 + 数据体 + CRC校验码 + 尾标识
     * 1 + 22 + n + 1 + 1
     */
    private Long messageLength;

    /**
     * 报文序列号
     * <p>
     * Since {@link JT809ProtocolVersion#V2011}
     * <p>
     * 占用四个字节，为发送信息的序列号，用于接收方检测是否有信息的丢失。
     * 上级平台和下级平台按自己发送数据包的个数计数，互不影响。
     * 程序开始运行时等于零，发送第一帧数据时开始计数，到最大数后自动归零。
     */
    private Long messageSequenceNumber;

    /**
     * 业务数据类型，即消息ID
     * <p>
     * Since {@link JT809ProtocolVersion#V2011}
     */
    private JT809MessageId messageId;

    /**
     * 下级平台接入码，上级平台给下级平台分配唯一标识码
     * <p>
     * Since {@link JT809ProtocolVersion#V2011}
     */
    private Long gnssCenterId;

    /**
     * 协议版本号标识，上下级平台之间采用的标准协议版编号；
     * <p>
     * Since {@link JT809ProtocolVersion#V2011}
     * <p>
     * 长度为3个字节来表示，0x01 0x02 0x0F 标识的版本号是 v1.2.15，以此类推。
     */
    private JT809ProtocolVersion protocolVersion;

    /**
     * 报文加密标识位
     * 0表示报文不加密，1表示报文加密。
     * <p>
     * Since {@link JT809ProtocolVersion#V2011}
     * <p>
     * 用来区分报文是否进行加密，
     * 如果标识为1，则说明对后续相应业务的数据体采用ENCRYPT_KEY对应的密钥进行加密处理。
     * 如果标识为0，则说明不进行加密处理。
     */
    private JT809MessageContentEncryptionMode encryptionMode;

    /**
     * 数据加密的密匙，长度为4个字节
     * <p>
     * Since {@link JT809ProtocolVersion#V2011}
     */
    private Long encryptionKey;

    /**
     * 克隆对象
     *
     * @return 克隆对象
     */
    @Override
    public abstract JT809MessageHeader clone();
}
