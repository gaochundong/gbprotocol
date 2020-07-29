package ai.sangmado.gbprotocol.jt808db37lubiao.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808db37lubiao.protocol.enums.JT808DB37LuBiaoMessageId;
import lombok.*;

/**
 * 驾驶员信息查询
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808DB37LuBiao_Message_Content_0x8E12 extends JT808MessageContent {
    public static final JT808DB37LuBiaoMessageId MESSAGE_ID = JT808DB37LuBiaoMessageId.JT808DB37LuBiao_Message_0x8E12;

    @Override
    public JT808DB37LuBiaoMessageId getMessageId() {
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

    public static JT808DB37LuBiao_Message_Content_0x8E12 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB37LuBiao_Message_Content_0x8E12 content = new JT808DB37LuBiao_Message_Content_0x8E12();
        content.deserialize(ctx, reader);
        return content;
    }
}
