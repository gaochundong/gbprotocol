package ai.sangmado.jt809.protocol.message.content;

import ai.sangmado.jt809.protocol.ISpecificationContext;
import ai.sangmado.jt809.protocol.encoding.IJT809MessageBufferReader;
import ai.sangmado.jt809.protocol.encoding.IJT809MessageBufferWriter;
import ai.sangmado.jt809.protocol.enums.JT809MessageId;
import ai.sangmado.jt809.protocol.enums.JT809SubMessageId;
import ai.sangmado.jt809.protocol.exceptions.UnsupportedJT809OperationException;
import ai.sangmado.jt809.protocol.message.content.JT809_Message_Content_0x1400_Sub.JT809_Message_Content_0x1400_SubMessage;
import ai.sangmado.jt809.protocol.message.content.JT809_Message_Content_0x1400_Sub.JT809_Message_Content_0x1400_SubMessageRegistration;
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
        writer.writeUInt16(getMessageId().getValue());
        writer.writeUInt32(subMessage.getContentLength(ctx));
        subMessage.serialize(ctx, writer);
    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT809MessageBufferReader reader) {
        reader.readUInt16();
        reader.readUInt32();

        reader.markIndex();
        JT809SubMessageId subMessageId = JT809SubMessageId.cast(reader.readUInt16() & 0xFFFF);
        reader.resetIndex();

        if (!JT809_Message_Content_0x1400_SubMessageRegistration.getDecoders().containsKey(subMessageId)) {
            throw new UnsupportedJT809OperationException("暂不支持该附加信息ID:" + subMessageId);
        }
        this.subMessage = JT809_Message_Content_0x1400_SubMessageRegistration.getDecoders().get(subMessageId).apply(ctx, reader);
    }

    public static JT809_Message_Content_0x1400 decode(ISpecificationContext ctx, IJT809MessageBufferReader reader) {
        JT809_Message_Content_0x1400 content = new JT809_Message_Content_0x1400();
        content.deserialize(ctx, reader);
        return content;
    }
}
