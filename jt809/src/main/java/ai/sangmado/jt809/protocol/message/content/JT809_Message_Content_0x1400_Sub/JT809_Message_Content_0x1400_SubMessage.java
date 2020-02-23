package ai.sangmado.jt809.protocol.message.content.JT809_Message_Content_0x1400_Sub;

import ai.sangmado.jt809.protocol.encoding.IJT809MessageFormatter;
import ai.sangmado.jt809.protocol.enums.JT809SubMessageId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 主链路报警信息交互消息 UP_WARN_MSG - 子消息
 */
@NoArgsConstructor
public abstract class JT809_Message_Content_0x1400_SubMessage implements IJT809MessageFormatter {

    /**
     * 获取子消息ID
     *
     * @return 子消息ID
     */
    public abstract JT809SubMessageId getSubMessageId();

    /**
     * 子消息体长度
     */
    @Getter
    @Setter
    private Integer subMessageContentLength;
}
