package ai.sangmado.db32t3610.protocol.message.content;

import ai.sangmado.db32t3610.protocol.enums.DB32T3610MessageId;
import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.message.content.JT808MessageContent;
import lombok.*;

/**
 * 报警附件信息消息
 * <p>
 * 终端根据附件上传指令连接附件服务器，并向服务器发送报警附件信息消息
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DB32T3610_Message_Content_0x1210 extends JT808MessageContent {
    public static final DB32T3610MessageId MESSAGE_ID = DB32T3610MessageId.DB32T3610_Message_0x1210;

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

    public static DB32T3610_Message_Content_0x1210 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        DB32T3610_Message_Content_0x1210 content = new DB32T3610_Message_Content_0x1210();
        content.deserialize(ctx, reader);
        return content;
    }
}
