package ai.sangmado.gbprotocol.jt808.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_Passthrough_Message.JT808_Message_Content_0x8900_Base;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_Passthrough_Message.JT808_Message_Content_Passthrough_MessageType;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.*;

/**
 * 平台数据下行透传
 *
 * @since V2011 消息定义
 * @since V2013 定义透传消息类型
 * @since V2019 无变更
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808_Message_Content_0x8900 extends JT808MessageContent {
    public static final JT808MessageId MESSAGE_ID = JT808MessageId.JT808_Message_0x8900;

    @Override
    public JT808MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 透传消息类型
     */
    private JT808_Message_Content_Passthrough_MessageType passthroughMessageType;

    /**
     * 透传消息内容
     */
    private JT808_Message_Content_0x8900_Base passthroughMessageContent;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {
        writer.writeByte(passthroughMessageType.getValue());
        passthroughMessageContent.serialize(ctx, writer);
    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        setPassthroughMessageType(JT808_Message_Content_Passthrough_MessageType.cast(reader.readByte() & 0xFF));
    }

    public static JT808_Message_Content_0x8900 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x8900 content = new JT808_Message_Content_0x8900();
        content.deserialize(ctx, reader);
        return content;
    }
}
