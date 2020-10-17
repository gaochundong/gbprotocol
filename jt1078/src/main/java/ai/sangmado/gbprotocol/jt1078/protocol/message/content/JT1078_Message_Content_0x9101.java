package ai.sangmado.gbprotocol.jt1078.protocol.message.content;

import ai.sangmado.gbprotocol.jt1078.protocol.enums.ChannelStreamType;
import ai.sangmado.gbprotocol.jt1078.protocol.enums.JT1078MessageId;
import ai.sangmado.gbprotocol.jt1078.protocol.enums.LogicalChannelNumber;
import ai.sangmado.gbprotocol.jt1078.protocol.enums.StreamingDataType;
import ai.sangmado.gbprotocol.jt1078.protocol.exceptions.UnsupportedJT1078ProtocolVersionException;
import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808ProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
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
    private Integer streamingServerIPAddressLength;
    /**
     * 服务器IP地址
     */
    private String streamingServerIPAddress;
    /**
     * 服务器视频通道监听端口号(TCP)
     */
    private Integer streamingServerTcpPort;
    /**
     * 服务器视频通道监听端口号（UDP）
     */
    private Integer streamingServerUdpPort;
    /**
     * 逻辑通道号
     */
    private LogicalChannelNumber logicalChannelNumber;
    /**
     * 数据类型
     * 0:音视频 1:视频 2:双向对讲 3:监听 4:中心广播 5:透传
     */
    private StreamingDataType streamingDataType;
    /**
     * 码流类型
     * 0:主码流 1:子码流
     * <p>
     * 通常主码流分辨率高用于设备本地录像，子码流分辨率低用于远程直播节省流量费
     */
    private ChannelStreamType channelStreamType;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {
        if (ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2011) || ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2013)) {
            writer.writeByte(getStreamingServerIPAddressLength());
            writer.writeString(getStreamingServerIPAddress());
            writer.writeWord(getStreamingServerTcpPort());
            writer.writeWord(getStreamingServerUdpPort());
            writer.writeByte(getLogicalChannelNumber().getValue());
            writer.writeByte(getStreamingDataType().getValue());
            writer.writeByte(getChannelStreamType().getValue());
        } else if (ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2019)) {
            // 目前 JT1078 是基于 JT808 V2011 版本进行扩展，暂不支持
            throw new UnsupportedJT1078ProtocolVersionException(ctx.getProtocolVersion());
        } else {
            throw new UnsupportedJT1078ProtocolVersionException(ctx.getProtocolVersion());
        }
    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        if (ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2011) || ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2013)) {
            setStreamingServerIPAddressLength(reader.readByte() & 0xFF);
            setStreamingServerIPAddress(reader.readString(getStreamingServerIPAddressLength()));
            setStreamingServerTcpPort(reader.readWord());
            setStreamingServerUdpPort(reader.readWord());
            setLogicalChannelNumber(LogicalChannelNumber.cast(reader.readByte() & 0xFF));
            setStreamingDataType(StreamingDataType.cast(reader.readByte() & 0xFF));
            setChannelStreamType(ChannelStreamType.cast(reader.readByte() & 0xFF));
        } else if (ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2019)) {
            // 目前 JT1078 是基于 JT808 V2011 版本进行扩展，暂不支持
            throw new UnsupportedJT1078ProtocolVersionException(ctx.getProtocolVersion());
        } else {
            throw new UnsupportedJT1078ProtocolVersionException(ctx.getProtocolVersion());
        }
    }

    public static JT1078_Message_Content_0x9101 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT1078_Message_Content_0x9101 content = new JT1078_Message_Content_0x9101();
        content.deserialize(ctx, reader);
        return content;
    }
}
