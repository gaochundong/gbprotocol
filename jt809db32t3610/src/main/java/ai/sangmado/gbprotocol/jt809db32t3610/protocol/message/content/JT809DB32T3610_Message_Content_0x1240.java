package ai.sangmado.gbprotocol.jt809db32t3610.protocol.message.content;

import ai.sangmado.gbprotocol.jt809.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt809.protocol.serialization.IJT809MessageBufferReader;
import ai.sangmado.gbprotocol.jt809.protocol.serialization.IJT809MessageBufferWriter;
import ai.sangmado.gbprotocol.jt809.protocol.message.content.JT809MessageContent;
import ai.sangmado.gbprotocol.jt809db32t3610.protocol.enums.JT809DB32T3610MessageId;
import lombok.*;

/**
 * 主动上传车辆主动安全智能防控终端安装信息消息
 * <p>
 * 主动安全智能防控平台收到车辆安全智能防控终端安装信息，并确认符合要求后，向上级平台上传该车辆安全智能防控终端安装信息。
 * 本条消息服务端无需应答。
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT809DB32T3610_Message_Content_0x1240 extends JT809MessageContent {
    public static final JT809DB32T3610MessageId MESSAGE_ID = JT809DB32T3610MessageId.JT809DB32T3610_Message_0x1240;

    @Override
    public JT809DB32T3610MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * xxx
     */
    private Integer xxx;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT809MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT809MessageBufferReader reader) {

    }

    public static JT809DB32T3610_Message_Content_0x1240 decode(IVersionedSpecificationContext ctx, IJT809MessageBufferReader reader) {
        JT809DB32T3610_Message_Content_0x1240 content = new JT809DB32T3610_Message_Content_0x1240();
        content.deserialize(ctx, reader);
        return content;
    }
}
