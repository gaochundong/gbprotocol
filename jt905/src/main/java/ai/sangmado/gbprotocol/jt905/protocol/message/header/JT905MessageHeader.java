package ai.sangmado.gbprotocol.jt905.protocol.message.header;

import ai.sangmado.gbprotocol.jt905.protocol.enums.JT905MessageId;
import ai.sangmado.gbprotocol.jt905.protocol.enums.JT905ProtocolVersion;
import ai.sangmado.gbprotocol.jt905.protocol.serialization.IJT905MessageFormatter;
import lombok.*;

/**
 * JT905 消息头
 */
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class JT905MessageHeader implements IJT905MessageFormatter, Cloneable {

    /**
     * 获取协议版本
     *
     * @return 协议版本
     */
    public abstract JT905ProtocolVersion getProtocolVersion();

    /**
     * 消息ID
     */
    private JT905MessageId messageId;

    /**
     * 消息体长度
     */
    private Integer contentLength;

    /**
     * ISU标识
     */
    private String isu;

    /**
     * 消息流水号
     */
    private Integer serialNumber;

    /**
     * 克隆对象
     *
     * @return 克隆对象
     */
    @Override
    public abstract JT905MessageHeader clone();
}
