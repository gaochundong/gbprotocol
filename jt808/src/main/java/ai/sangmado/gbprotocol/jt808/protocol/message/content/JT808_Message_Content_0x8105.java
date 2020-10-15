package ai.sangmado.gbprotocol.jt808.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808DeviceControlCommandId;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.*;

/**
 * 平台下发终端控制指令
 *
 * @since V2011
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808_Message_Content_0x8105 extends JT808MessageContent {
    public static final JT808MessageId MESSAGE_ID = JT808MessageId.JT808_Message_0x8105;

    @Override
    public JT808MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 命令字
     */
    private JT808DeviceControlCommandId controlCommandId;
    /**
     * 命令参数
     * <p>
     * 命令参数格式具体见后面描述，每个字段之间采用半角”;”分隔，每个STRING字段先按GBK编码处理后再组成消息
     */
    private String controlCommandArguments;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808_Message_Content_0x8105 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x8105 content = new JT808_Message_Content_0x8105();
        content.deserialize(ctx, reader);
        return content;
    }
}
