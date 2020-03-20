package ai.sangmado.gbprotocol.gb32960.protocol.message.header.device;

import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960DeviceCommandId;
import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960MessageContentEncryptionMode;
import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960ProtocolVersion;
import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960ReplyId;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.IGB32960MessageFormatter;
import lombok.*;

/**
 * GB32960 消息头 (终端)
 */
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class GB32960DeviceMessageHeader implements IGB32960MessageFormatter, Cloneable {

    /**
     * 获取协议版本
     *
     * @return 协议版本
     */
    public abstract GB32960ProtocolVersion getProtocolVersion();

    /**
     * 命令单元 - 命令标识
     * <p>
     * Since {@link GB32960ProtocolVersion#V2016}
     */
    private GB32960DeviceCommandId commandId;

    /**
     * 命令单元 - 应答标志
     * <p>
     * Since {@link GB32960ProtocolVersion#V2016}
     */
    private GB32960ReplyId replyId;

    /**
     * 唯一识别码
     * <p>
     * Since {@link GB32960ProtocolVersion#V2016}
     */
    private String vin;

    /**
     * 数据单元加密方式
     * <p>
     * Since {@link GB32960ProtocolVersion#V2016}
     */
    private GB32960MessageContentEncryptionMode encryptionMode;

    /**
     * 数据单元长度
     * <p>
     * Since {@link GB32960ProtocolVersion#V2016}
     */
    private Integer contentLength;

    /**
     * 克隆对象
     *
     * @return 克隆对象
     */
    @Override
    public abstract GB32960DeviceMessageHeader clone();
}
