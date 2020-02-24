package ai.sangmado.db32t3610.protocol.message.content;

import ai.sangmado.db32t3610.protocol.enums.DB32T3610MessageId;
import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.message.content.JT808MessageContent;
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
public class DB32T3610_Message_Content_0x1211 extends JT808MessageContent {
    public static final DB32T3610MessageId MESSAGE_ID = DB32T3610MessageId.DB32T3610_Message_0x1211;

    @Override
    public DB32T3610MessageId getMessageId() {
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

    public static DB32T3610_Message_Content_0x1211 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        DB32T3610_Message_Content_0x1211 content = new DB32T3610_Message_Content_0x1211();
        content.deserialize(ctx, reader);
        return content;
    }
}
