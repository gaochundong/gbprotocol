package ai.sangmado.gbprotocol.jt905.protocol.message.content;

import ai.sangmado.gbprotocol.jt905.protocol.enums.JT905MessageId;
import ai.sangmado.gbprotocol.jt905.protocol.serialization.IJT905MessageFormatter;

/**
 * JT905 消息体
 */
public abstract class JT905MessageContent implements IJT905MessageFormatter {

    /**
     * 获取消息体定义的消息ID
     *
     * @return 消息ID
     */
    public abstract JT905MessageId getMessageId();
}
