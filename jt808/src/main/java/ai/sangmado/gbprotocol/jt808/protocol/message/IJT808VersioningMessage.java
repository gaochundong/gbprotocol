package ai.sangmado.gbprotocol.jt808.protocol.message;

import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808ProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageFormatter;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * JT808 版本化消息
 */
public interface IJT808VersioningMessage extends IJT808MessageFormatter {
    /**
     * 获取协议版本
     *
     * @return 协议版本
     */
    @JsonIgnore
    JT808ProtocolVersion getProtocolVersion();

    /**
     * 获取消息ID
     *
     * @return 消息ID
     */
    @JsonIgnore
    JT808MessageId getMessageId();
}
