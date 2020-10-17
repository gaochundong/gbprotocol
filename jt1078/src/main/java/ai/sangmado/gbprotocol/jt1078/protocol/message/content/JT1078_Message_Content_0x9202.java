package ai.sangmado.gbprotocol.jt1078.protocol.message.content;

import ai.sangmado.gbprotocol.jt1078.protocol.enums.JT1078MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.*;

/**
 * 平台下发远程录像回放控制
 * <p>
 * 终端设备进行音视频录像回放过程中，平台可下发回放控制指令对回放过程进行控制。
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT1078_Message_Content_0x9202 extends JT808MessageContent {
    public static final JT1078MessageId MESSAGE_ID = JT1078MessageId.JT1078_Message_0x9202;

    @Override
    public JT1078MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 音视频通道号
     */
    private Integer channelNumber;
    /**
     * 回放控制
     * <p>
     * 0：开始回放；
     * 1：暂停回放；
     * 2：结束回放；
     * 3：快进回放；
     * 4：关键帧快退回放；
     * 5：拖动回放；
     * 6：关键帧播放
     */
    private Integer playbackControl;
    /**
     * 快进或快退倍数
     * <p>
     * 回放方式为3和4时，此字段内容有效，否则置0。
     * 0：无效
     * 1：1 倍
     * 2：2 倍
     * 3：4 倍
     * 4：8 倍
     * 5：16 倍
     */
    private Integer playbackSpeedTimes;
    /**
     * 拖动回放位置
     * <p>
     * BCD[6], YY-MM-DD-HH-MM-SS，回放控制为5时，此字段有效
     */
    private String dragPlaybackPosition;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT1078_Message_Content_0x9202 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT1078_Message_Content_0x9202 content = new JT1078_Message_Content_0x9202();
        content.deserialize(ctx, reader);
        return content;
    }
}
