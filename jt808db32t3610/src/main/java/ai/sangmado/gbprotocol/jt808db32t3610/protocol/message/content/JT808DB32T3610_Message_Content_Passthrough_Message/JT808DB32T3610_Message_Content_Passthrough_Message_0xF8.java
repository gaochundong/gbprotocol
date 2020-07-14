package ai.sangmado.gbprotocol.jt808db32t3610.protocol.message.content.JT808DB32T3610_Message_Content_Passthrough_Message;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_Passthrough_Message.JT808_Message_Content_Passthrough_Base;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 透传消息 - 信息查询
 */
@NoArgsConstructor
public class JT808DB32T3610_Message_Content_Passthrough_Message_0xF8 extends JT808_Message_Content_Passthrough_Base {
    public static final JT808DB32T3610_Message_Content_Passthrough_MessageType MESSAGE_TYPE =
            JT808DB32T3610_Message_Content_Passthrough_MessageType.JT808DB32T3610_Passthrough_Message_0xF8;

    @Override
    public JT808DB32T3610_Message_Content_Passthrough_MessageType getPassthroughMessageType() {
        return MESSAGE_TYPE;
    }

    /**
     * xxx
     */
    @Getter
    @Setter
    private Integer xxx;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB32T3610_Message_Content_Passthrough_Message_0xF8 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB32T3610_Message_Content_Passthrough_Message_0xF8 content = new JT808DB32T3610_Message_Content_Passthrough_Message_0xF8();
        content.deserialize(ctx, reader);
        return content;
    }
}
