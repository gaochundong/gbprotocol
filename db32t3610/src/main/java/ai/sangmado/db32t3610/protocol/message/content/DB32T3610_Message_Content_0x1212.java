package ai.sangmado.db32t3610.protocol.message.content;

import ai.sangmado.db32t3610.protocol.enums.DB32T3610MessageId;
import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.message.content.JT808MessageContent;
import lombok.*;

/**
 * 文件上传完成消息
 *
 * 终端向附件服务器完成一个文件数据发送时，向附件服务器发送文件发送完成消息.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DB32T3610_Message_Content_0x1212 extends JT808MessageContent {
    public static final DB32T3610MessageId MESSAGE_ID = DB32T3610MessageId.DB32T3610_Message_0x1212;

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

    public static DB32T3610_Message_Content_0x1212 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        DB32T3610_Message_Content_0x1212 content = new DB32T3610_Message_Content_0x1212();
        content.deserialize(ctx, reader);
        return content;
    }
}
