package ai.sangmado.gbprotocol.gb19056.protocol.message.content;

import ai.sangmado.gbprotocol.gbcommon.enums.IMessageId;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageFormatter;

/**
 * GB19056 消息体 - 数据块
 */
public abstract class GB19056MessageBlock<T extends IMessageId> implements IJT808MessageFormatter {

    /**
     * 获取消息体定义的消息ID
     *
     * @return 消息ID
     */
    public abstract T getMessageId();
}
