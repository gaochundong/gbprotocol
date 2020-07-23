package ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_Passthrough_Message;

import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageFormatter;
import lombok.NoArgsConstructor;

/**
 * 透传消息抽象类 - 0x8900
 */
@NoArgsConstructor
public abstract class JT808_Message_Content_0x8900_Base implements IJT808MessageFormatter {

    /**
     * 获取透传消息类型
     *
     * @return 透传消息类型
     */
    public abstract JT808_Message_Content_Passthrough_MessageType getPassthroughMessageType();
}
