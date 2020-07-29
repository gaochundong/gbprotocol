package ai.sangmado.gbprotocol.jt809.protocol.message;

import ai.sangmado.gbprotocol.jt809.protocol.enums.JT809MessageId;
import ai.sangmado.gbprotocol.jt809.protocol.enums.JT809ProtocolVersion;
import ai.sangmado.gbprotocol.jt809.protocol.message.content.JT809MessageContent;
import ai.sangmado.gbprotocol.jt809.protocol.message.header.JT809MessageHeader;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * JT809 消息通用接口
 *
 * @param <H> 消息头类型
 * @param <C> 消息体类型
 */
public interface IJT809Message<H extends JT809MessageHeader, C extends JT809MessageContent> extends IJT809VersioningMessage {
    /**
     * 获取协议版本
     *
     * @return 协议版本
     */
    @Override
    @JsonIgnore
    default JT809ProtocolVersion getProtocolVersion() {
        return this.getHeader().getProtocolVersion();
    }

    /**
     * 获取消息ID
     *
     * @return 消息ID
     */
    @Override
    @JsonIgnore
    default JT809MessageId getMessageId() {
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
