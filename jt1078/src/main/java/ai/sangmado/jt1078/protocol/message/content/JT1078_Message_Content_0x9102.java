package ai.sangmado.jt1078.protocol.message.content;

import ai.sangmado.jt1078.protocol.enums.JT1078MessageId;
import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.message.content.JT808MessageContent;
import lombok.*;

/**
 * 平台下发音视频实时传输控制
 * <p>
 * 平台发送音视频实时传输控制指令，用于切换码流、暂停码流传输、关闭音视频传输通道等.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT1078_Message_Content_0x9102 extends JT808MessageContent {
    public static final JT1078MessageId MESSAGE_ID = JT1078MessageId.JT1078_Message_0x9102;

    @Override
    public JT1078MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 逻辑通道号
     */
    private Integer logicalChannelNumber;
    /**
     * 控制指令
     * <p>
     * 平台可以通过该指令对设备的实时音视频进行控制：
     * 0:关闭音视频传输指令
     * 1:切换码流（增加暂停和继续）
     * 2:暂停该通道所有流的发送
     * 3:恢复暂停前流的发送,与暂停前的流类型一致
     * 4:关闭双向对讲
     */
    private Integer controlCommand;
    /**
     * 关闭音视频类型
     * <p>
     * 0:关闭该通道有关的音视频数据
     * 1:只关闭该通道有关的音频，保留该通道有关的视频
     * 2:只关闭该通道有关的视频，保留该通道有关的音频
     */
    private Integer disableMediaData;
    /**
     * 切换码流类型
     * <p>
     * 将之前申请的码流切换为新申请的码流，音频与切换前保持一致。新申请的码流为：
     * 0:主码流
     * 1:子码流
     */
    private Integer switchToStreamType;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT1078_Message_Content_0x9102 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT1078_Message_Content_0x9102 content = new JT1078_Message_Content_0x9102();
        content.deserialize(ctx, reader);
        return content;
    }
}
