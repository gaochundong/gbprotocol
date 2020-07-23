package ai.sangmado.gbprotocol.jt808.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_Passthrough_Message.JT808_Message_Content_Passthrough_MessageType;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_Passthrough_Message.JT808_Message_Content_0x0900_Base;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_Passthrough_Message.JT808_Message_Content_0x0900_Registration;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.*;

/**
 * 终端数据上行透传
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
public class JT808_Message_Content_0x0900 extends JT808MessageContent {
    public static final JT808MessageId MESSAGE_ID = JT808MessageId.JT808_Message_0x0900;

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
    private JT808_Message_Content_0x0900_Base passthroughMessageContent;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {
        writer.writeByte(passthroughMessageType.getValue());
        passthroughMessageContent.serialize(ctx, writer);
    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        setPassthroughMessageType(JT808_Message_Content_Passthrough_MessageType.cast(reader.readByte() & 0xFF));

        JT808_Message_Content_0x0900_Base passthroughMessageContent =
                JT808_Message_Content_0x0900_Registration.getDecoders()
                        .get(getPassthroughMessageType()).apply(ctx, reader);
        setPassthroughMessageContent(passthroughMessageContent);
    }

    public static JT808_Message_Content_0x0900 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x0900 content = new JT808_Message_Content_0x0900();
        content.deserialize(ctx, reader);
        return content;
    }
}
