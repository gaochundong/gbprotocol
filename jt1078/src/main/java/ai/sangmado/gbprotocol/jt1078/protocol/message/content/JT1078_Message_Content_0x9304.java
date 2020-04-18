package ai.sangmado.gbprotocol.jt1078.protocol.message.content;

import ai.sangmado.gbprotocol.jt1078.protocol.enums.JT1078MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.*;

/**
 * 平台下发云台控制指令 - 云台雨刷控制
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT1078_Message_Content_0x9304 extends JT808MessageContent {
    public static final JT1078MessageId MESSAGE_ID = JT1078MessageId.JT1078_Message_0x9304;

    @Override
    public JT1078MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 逻辑通道号
     */
    private Integer logicalChannelNumber;
    /**
     * 启停标识
     * <p>
     * 0：停止；
     * 1：启动；
     */
    private Integer actionMode;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT1078_Message_Content_0x9304 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT1078_Message_Content_0x9304 content = new JT1078_Message_Content_0x9304();
        content.deserialize(ctx, reader);
        return content;
    }
}
