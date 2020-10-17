package ai.sangmado.gbprotocol.jt1078.protocol.message.content;

import ai.sangmado.gbprotocol.jt1078.protocol.enums.JT1078MessageId;
import ai.sangmado.gbprotocol.jt1078.protocol.enums.LogicalChannelNumber;
import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.*;

/**
 * 平台下发云台控制指令 - 云台旋转
 * <p>
 * 平台向终端请求旋转镜头。
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT1078_Message_Content_0x9301 extends JT808MessageContent {
    public static final JT1078MessageId MESSAGE_ID = JT1078MessageId.JT1078_Message_0x9301;

    @Override
    public JT1078MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 逻辑通道号
     */
    private LogicalChannelNumber logicalChannelNumber;
    /**
     * 方向
     * <p>
     * 0：停止；
     * 1：上；
     * 2：下；
     * 3：左；
     * 4：右；
     */
    private Integer direction;
    /**
     * 速度
     * <p>
     * 0-255
     */
    private Integer speed;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT1078_Message_Content_0x9301 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT1078_Message_Content_0x9301 content = new JT1078_Message_Content_0x9301();
        content.deserialize(ctx, reader);
        return content;
    }
}
