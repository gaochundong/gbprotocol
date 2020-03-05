package ai.sangmado.gbprotocol.jt808db32t3610.protocol.message.content;

import ai.sangmado.gbprotocol.jt808db32t3610.protocol.enums.JT808DB32T3610MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import lombok.*;

/**
 * 文件信息上传
 * <p>
 * 终端向附件服务器发送报警附件信息指令并得到应答后，向附件服务器发送附件文件信息消息
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808DB32T3610_Message_Content_0x1211 extends JT808MessageContent {
    public static final JT808DB32T3610MessageId MESSAGE_ID = JT808DB32T3610MessageId.JT808DB32T3610_Message_0x1211;

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

    public static JT808DB32T3610_Message_Content_0x1211 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB32T3610_Message_Content_0x1211 content = new JT808DB32T3610_Message_Content_0x1211();
        content.deserialize(ctx, reader);
        return content;
    }
}
