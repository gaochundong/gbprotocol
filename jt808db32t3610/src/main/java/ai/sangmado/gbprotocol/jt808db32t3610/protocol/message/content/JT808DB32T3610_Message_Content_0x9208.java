package ai.sangmado.gbprotocol.jt808db32t3610.protocol.message.content;

import ai.sangmado.gbprotocol.jt808db32t3610.protocol.enums.JT808DB32T3610MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import lombok.*;

/**
 * 报警附件上传指令
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808DB32T3610_Message_Content_0x9208 extends JT808MessageContent {
    public static final JT808DB32T3610MessageId MESSAGE_ID = JT808DB32T3610MessageId.JT808DB32T3610_Message_0x9208;

    @Override
    public JT808DB32T3610MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * xxx
     */
    private Integer xxx;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB32T3610_Message_Content_0x9208 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB32T3610_Message_Content_0x9208 content = new JT808DB32T3610_Message_Content_0x9208();
        content.deserialize(ctx, reader);
        return content;
    }
}
