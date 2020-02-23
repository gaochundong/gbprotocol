package ai.sangmado.jt809.protocol.message.content;

import ai.sangmado.jt809.protocol.ISpecificationContext;
import ai.sangmado.jt809.protocol.encoding.IJT809MessageBufferReader;
import ai.sangmado.jt809.protocol.encoding.IJT809MessageBufferWriter;
import ai.sangmado.jt809.protocol.enums.JT809MessageId;
import ai.sangmado.jt809.protocol.message.content.JT809_Message_Content_0x1400_Sub.JT809_Message_Content_0x1400_SubMessage;
import lombok.*;

/**
 * 主链路报警信息交互消息 UP_WARN_MSG
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT809_Message_Content_0x1400 extends JT809MessageContent {
    public static final JT809MessageId MESSAGE_ID = JT809MessageId.JT809_Message_0x1400;

    @Override
    public JT809MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 子消息
     */
    private JT809_Message_Content_0x1400_SubMessage subMessage;

    @Override
    public void serialize(ISpecificationContext ctx, IJT809MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT809MessageBufferReader reader) {

    }

    public static JT809_Message_Content_0x1400 decode(ISpecificationContext ctx, IJT809MessageBufferReader reader) {
        JT809_Message_Content_0x1400 content = new JT809_Message_Content_0x1400();
        content.deserialize(ctx, reader);
        return content;
    }
}
