package ai.sangmado.jt808.protocol.message.content;

import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import lombok.Getter;
import lombok.Setter;

/**
 * JT808 消息体
 */
@Getter
@Setter
public abstract class JT808MessageContent {

    /**
     * 获取消息体定义的消息ID
     *
     * @return 消息ID
     */
    public abstract JT808MessageId getMessageId();
}
