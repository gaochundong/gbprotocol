package ai.sangmado.gbprotocol.jt1078.protocol.message.content;

import ai.sangmado.gbprotocol.jt1078.protocol.enums.JT1078MessageId;
import ai.sangmado.gbprotocol.jt1078.protocol.enums.LogicalChannelNumber;
import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.*;

/**
 * 平台下发远程录像回放请求
 * <p>
 * 平台向终端设备请求音视频录像回放，终端应采用0x1205(终端上传录像文件列表)指令应答，
 * 然后传输录像数据采用表18 实时音视频流数据传输RTP 协议负载包格式所定义的封包格式。
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT1078_Message_Content_0x9201 extends JT808MessageContent {
    public static final JT1078MessageId MESSAGE_ID = JT1078MessageId.JT1078_Message_0x9201;

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
    private LogicalChannelNumber logicalChannelNumber;
    /**
     * 音视频类型
     * <p>
     * 0:音视频，1:音频，2:视频，3:视频或音视频
     */
    private Integer mediaResourceType;
    /**
     * 码流类型
     * <p>
     * 0:所有码流，1:主码流，2:子码流；如果此通道只传输音频，此字段置0；
     */
    private Integer streamType;
    /**
     * 存储器类型
     * <p>
     * 0:所有存储器，1:主存储器，2:灾备存储器
     */
    private Integer storageType;
    /**
     * 回放方式
     * <p>
     * 0：正常回放；
     * 1：快进回放；
     * 2：关键帧快退回放；
     * 3：关键帧播放；
     * 4：单帧上传
     */
    private Integer playbackType;
    /**
     * 快进或快退倍数
     * <p>
     * 回放方式为1和2时，此字段内容有效，否则置0。
     * 0：无效
     * 1：1 倍
     * 2：2 倍
     */
    private Integer playbackSpeedTimes1;
    /**
     * 快进或快退倍数
     * <p>
     * 3：4 倍
     * 4：8 倍
     * 5：16 倍
     */
    private Integer playbackSpeedTimes2;
    /**
     * 开始时间
     * <p>
     * BCD[6], YY-MM-DD-HH-MM-SS，回放方式为4时，该字段表示单帧上传时间
     */
    private String beginTime;
    /**
     * 结束时间
     * <p>
     * BCD[6], YY-MM-DD-HH-MM-SS，为0表示一直回放，回放方式为4时，该字段无效
     */
    private String endTime;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT1078_Message_Content_0x9201 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT1078_Message_Content_0x9201 content = new JT1078_Message_Content_0x9201();
        content.deserialize(ctx, reader);
        return content;
    }
}
