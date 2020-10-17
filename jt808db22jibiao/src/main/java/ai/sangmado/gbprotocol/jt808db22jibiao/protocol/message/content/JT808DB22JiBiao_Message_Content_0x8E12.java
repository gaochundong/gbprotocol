package ai.sangmado.gbprotocol.jt808db22jibiao.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808db22jibiao.protocol.enums.JT808DB22JiBiaoMessageId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 驾驶员身份库信息查询
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
public class JT808DB22JiBiao_Message_Content_0x8E12 extends JT808MessageContent {
    public static final JT808DB22JiBiaoMessageId MESSAGE_ID = JT808DB22JiBiaoMessageId.JT808DB22JiBiao_Message_0x8E12;

    @Override
    public JT808DB22JiBiaoMessageId getMessageId() {
        return MESSAGE_ID;
    }

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {
        // 消息体为空
    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        // 消息体为空
    }

    public static JT808DB22JiBiao_Message_Content_0x8E12 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB22JiBiao_Message_Content_0x8E12 content = new JT808DB22JiBiao_Message_Content_0x8E12();
        content.deserialize(ctx, reader);
        return content;
    }
}
