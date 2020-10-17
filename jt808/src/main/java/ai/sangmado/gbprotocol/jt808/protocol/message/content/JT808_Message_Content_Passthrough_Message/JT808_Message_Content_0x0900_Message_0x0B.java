package ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_Passthrough_Message;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 透传消息 - 道路运输证IC卡信息
 */
@NoArgsConstructor
public class JT808_Message_Content_0x0900_Message_0x0B extends JT808_Message_Content_0x0900_Base {
    public static final JT808_Message_Content_Passthrough_MessageType MESSAGE_TYPE =
            JT808_Message_Content_Passthrough_MessageType.JT808_Passthrough_Message_0x0B;

    @Override
    public JT808_Message_Content_Passthrough_MessageType getPassthroughMessageType() {
        return MESSAGE_TYPE;
    }

    /**
     * xxx
     */
    @Getter
    @Setter
    private Integer xxx;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808_Message_Content_0x0900_Message_0x0B decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x0900_Message_0x0B content = new JT808_Message_Content_0x0900_Message_0x0B();
        content.deserialize(ctx, reader);
        return content;
    }
}
