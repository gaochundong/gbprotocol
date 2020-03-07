package ai.sangmado.gbprotocol.jt808.protocol.message;

import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808ProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageFormatter;

/**
 * JT808 消息通用接口
 */
public interface IJT808Message extends IJT808MessageFormatter {
    /**
     * 获取协议版本
     *
     * @return 协议版本
     */
    JT808ProtocolVersion getProtocolVersion();
}
