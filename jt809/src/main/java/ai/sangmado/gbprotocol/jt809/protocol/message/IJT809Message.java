package ai.sangmado.gbprotocol.jt809.protocol.message;

import ai.sangmado.gbprotocol.jt809.protocol.enums.JT809ProtocolVersion;
import ai.sangmado.gbprotocol.jt809.protocol.serialization.IJT809MessageFormatter;

/**
 * JT809 消息通用接口
 */
public interface IJT809Message extends IJT809MessageFormatter {
    /**
     * 获取协议版本
     *
     * @return 协议版本
     */
    JT809ProtocolVersion getProtocolVersion();
}
