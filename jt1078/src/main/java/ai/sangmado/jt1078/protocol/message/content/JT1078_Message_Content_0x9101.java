package ai.sangmado.jt1078.protocol.message.content;

import ai.sangmado.jt1078.protocol.enums.JT1078MessageId;
import ai.sangmado.jt1078.protocol.enums.JT1078ProtocolVersion;
import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.message.content.JT808MessageContent;
import lombok.*;

/**
 * 平台下发实时音视频传输状态通知
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT1078_Message_Content_0x9101 extends JT808MessageContent<JT1078MessageId, JT1078ProtocolVersion> {
    public static final JT1078MessageId MESSAGE_ID = JT1078MessageId.JT1078_Message_0x9101;

    @Override
    public JT1078MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 逻辑通道号
     */
    private Integer logicalChannelNumber;
    /**
     * 丢包率
     */
    private Integer packetLossRate;

    @Override
    public void serialize(ISpecificationContext<JT1078ProtocolVersion> ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext<JT1078ProtocolVersion> ctx, IJT808MessageBufferReader reader) {

    }

    public static JT1078_Message_Content_0x9101 decode(ISpecificationContext<JT1078ProtocolVersion> ctx, IJT808MessageBufferReader reader) {
        JT1078_Message_Content_0x9101 content = new JT1078_Message_Content_0x9101();
        content.deserialize(ctx, reader);
        return content;
    }
}
