package ai.sangmado.gbprotocol.jt808.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808TextMessageSendFlag;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808TextMessageTextType;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.*;

/**
 * 平台文本信息下发
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808_Message_Content_0x8300 extends JT808MessageContent {
    public static final JT808MessageId MESSAGE_ID = JT808MessageId.JT808_Message_0x8300;

    @Override
    public JT808MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 文本信息标志位
     */
    private JT808TextMessageSendFlag textFlag;
    /**
     * 文本类型
     *
     * @since V2019 新增字段
     */
    private JT808TextMessageTextType textType;
    /**
     * 文本信息
     * <p>
     * 最长为1024 字节，经GBK 编码
     */
    private String textContent;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808_Message_Content_0x8300 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x8300 content = new JT808_Message_Content_0x8300();
        content.deserialize(ctx, reader);
        return content;
    }
}
