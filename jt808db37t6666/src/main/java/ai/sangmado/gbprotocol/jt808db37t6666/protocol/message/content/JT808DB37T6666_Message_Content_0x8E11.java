package ai.sangmado.gbprotocol.jt808db37t6666.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808db37t6666.protocol.enums.JT808DB37T6666MessageId;
import lombok.*;

/**
 * 驾驶员图片信息设置
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808DB37T6666_Message_Content_0x8E11 extends JT808MessageContent {
    public static final JT808DB37T6666MessageId MESSAGE_ID = JT808DB37T6666MessageId.JT808DB37T6666_Message_0x8E11;

    @Override
    public JT808DB37T6666MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * xxx
     */
    private String xxx;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB37T6666_Message_Content_0x8E11 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB37T6666_Message_Content_0x8E11 content = new JT808DB37T6666_Message_Content_0x8E11();
        content.deserialize(ctx, reader);
        return content;
    }
}
