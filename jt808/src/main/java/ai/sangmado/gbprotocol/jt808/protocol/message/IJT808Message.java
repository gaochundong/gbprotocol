package ai.sangmado.gbprotocol.jt808.protocol.message;

import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808ProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.message.header.JT808MessageHeader;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * JT808 消息通用接口
 *
 * @param <H> 消息头类型
 * @param <C> 消息体类型
 */
public interface IJT808Message<H extends JT808MessageHeader, C extends JT808MessageContent> extends IJT808VersioningMessage {
    /**
     * 获取协议版本
     *
     * @return 协议版本
     */
    @Override
    @JsonIgnore
    default JT808ProtocolVersion getProtocolVersion() {
        return this.getHeader().getProtocolVersion();
    }

    /**
     * 获取消息ID
     *
     * @return 消息ID
     */
    @Override
    @JsonIgnore
    default JT808MessageId getMessageId() {
        return this.getHeader().getMessageId();
    }

    /**
     * 获取消息头
     *
     * @return 消息头
     */
    H getHeader();

    /**
     * 获取消息体
     *
     * @return 消息体
     */
    C getContent();
}
