package ai.sangmado.gbprotocol.jt905.protocol.message;

import ai.sangmado.gbprotocol.jt905.protocol.enums.JT905MessageId;
import ai.sangmado.gbprotocol.jt905.protocol.enums.JT905ProtocolVersion;
import ai.sangmado.gbprotocol.jt905.protocol.serialization.IJT905MessageFormatter;

/**
 * JT905 消息通用接口
 */
public interface IJT905Message extends IJT905MessageFormatter {
    /**
     * 获取协议版本
     *
     * @return 协议版本
     */
    JT905ProtocolVersion getProtocolVersion();

    /**
     * 获取消息ID
     *
     * @return 消息ID
     */
    JT905MessageId getMessageId();
}
