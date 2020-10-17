package ai.sangmado.gbprotocol.jt1078.protocol.message.content;

import ai.sangmado.gbprotocol.jt1078.protocol.enums.JT1078MessageId;
import ai.sangmado.gbprotocol.jt1078.protocol.enums.LogicalChannelNumber;
import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.*;

/**
 * 平台下发实时音视频传输状态通知
 * <p>
 * 平台在接收终端上传音视频数据的过程中按照设定的时间间隔向终端发送通知包.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT1078_Message_Content_0x9105 extends JT808MessageContent {
    public static final JT1078MessageId MESSAGE_ID = JT1078MessageId.JT1078_Message_0x9105;

    @Override
    public JT1078MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 逻辑通道号
     * <p>
     * 按照JTT1076-2016中的表2：营运车辆车载视频终端音视频通道定义表；
     */
    private LogicalChannelNumber logicalChannelNumber;
    /**
     * 丢包率
     * <p>
     * 当前传输通道的丢包率，数值乘以100之后取整数部分
     */
    private Integer packetLossRate;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {
        writer.writeByte(getLogicalChannelNumber().getValue());
        writer.writeByte(getPacketLossRate());
    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        setLogicalChannelNumber(LogicalChannelNumber.cast(reader.readByte() & 0xFF));
        setPacketLossRate(reader.readByte() & 0xFF);
    }

    public static JT1078_Message_Content_0x9105 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT1078_Message_Content_0x9105 content = new JT1078_Message_Content_0x9105();
        content.deserialize(ctx, reader);
        return content;
    }
}
