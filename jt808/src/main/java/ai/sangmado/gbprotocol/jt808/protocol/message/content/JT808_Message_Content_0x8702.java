package ai.sangmado.gbprotocol.jt808.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.*;

/**
 * 平台上报驾驶员身份信息请求
 *
 * @since V2013
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808_Message_Content_0x8702 extends JT808MessageContent {
    public static final JT808MessageId MESSAGE_ID = JT808MessageId.JT808_Message_0x8702;

    @Override
    public JT808MessageId getMessageId() {
        return MESSAGE_ID;
    }

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {
        // 上报驾驶员身份信息请求消息体为空。
    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        // 上报驾驶员身份信息请求消息体为空。
    }

    public static JT808_Message_Content_0x8702 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x8702 content = new JT808_Message_Content_0x8702();
        content.deserialize(ctx, reader);
        return content;
    }
}
