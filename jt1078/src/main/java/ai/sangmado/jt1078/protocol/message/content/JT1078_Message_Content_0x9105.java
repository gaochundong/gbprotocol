package ai.sangmado.jt1078.protocol.message.content;

import ai.sangmado.jt1078.protocol.enums.JT1078MessageId;
import ai.sangmado.jt1078.protocol.enums.JT1078ProtocolVersion;
import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.message.content.JT808MessageContent;
import lombok.*;

/**
 * 平台下发实时音视频传输请求
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT1078_Message_Content_0x9105 extends JT808MessageContent<JT1078MessageId, JT1078ProtocolVersion> {

    @Override
    public JT1078MessageId getMessageId() {
        return JT1078MessageId.JT1078_Message_0x9105;
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
    public void serialize(ISpecificationContext<JT1078ProtocolVersion> ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext<JT1078ProtocolVersion> ctx, IJT808MessageBufferReader reader) {

    }
}
