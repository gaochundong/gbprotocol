package ai.sangmado.jt1078.protocol.message.content;

import ai.sangmado.jt1078.protocol.enums.JT1078MessageId;
import ai.sangmado.gbstandard.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbstandard.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.gbstandard.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.gbstandard.jt808.protocol.message.content.JT808MessageContent;
import lombok.*;

/**
 * 平台下发实时音视频传输请求
 * <p>
 * 平台向终端设备请求实时音视频传输，包括实时视频传输、主动发起双向语音对讲、单向监听、向所有终端广播语音和特定透传等。
 * 终端在收到此消息后回复视频终端通用应答，然后通过对应的服务器IP地址和端口号建立传输链路，然后按照音视频流传输协议传输相应的音视频流数据。
 * <p>
 * 平台收到视频终端的特殊报警后，应无须等待人工确认即主动下发本条指令，启动实时音视频传输。
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT1078_Message_Content_0x9101 extends JT808MessageContent {
    public static final JT1078MessageId MESSAGE_ID = JT1078MessageId.JT1078_Message_0x9101;

    @Override
    public JT1078MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 服务器IP地址长度
     */
    private Integer serverIPAddressLength;
    /**
     * 服务器IP地址
     */
    private String serverIPAddress;
    /**
     * 服务器视频通道监听端口号(TCP)
     */
    private Integer serverVideoChannelTcpPort;
    /**
     * 服务器视频通道监听端口号（UDP）
     */
    private Integer serverVideoChannelUdpPort;
    /**
     * 逻辑通道号
     */
    private Integer logicalChannelNumber;
    /**
     * 数据类型
     * 0:音视频 1:视频 2:双向对讲 3:监听 4:中心广播 5:透传
     */
    private Integer dataType;
    /**
     * 码流类型
     * 0:主码流 1:子码流
     */
    private Integer streamType;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT1078_Message_Content_0x9101 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT1078_Message_Content_0x9101 content = new JT1078_Message_Content_0x9101();
        content.deserialize(ctx, reader);
        return content;
    }
}
