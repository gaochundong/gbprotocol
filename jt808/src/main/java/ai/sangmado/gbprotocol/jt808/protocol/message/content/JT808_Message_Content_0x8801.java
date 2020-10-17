package ai.sangmado.gbprotocol.jt808.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.*;

/**
 * 平台摄像头立即拍摄命令
 *
 * @since V2011 未定义如何响应
 * @since V2013 平台向终端下发0x8801立即拍照指令，终端使用0x0805回应平台
 * @since 苏标 苏标对通道ID做了特定要求，但并未修改消息格式
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808_Message_Content_0x8801 extends JT808MessageContent {
    public static final JT808MessageId MESSAGE_ID = JT808MessageId.JT808_Message_0x8801;

    @Override
    public JT808MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 通道ID
     */
    private Integer channelId;
    /**
     * 拍摄命令
     */
    private Integer snapshotCommand;
    /**
     * 拍照间隔/录像时间
     */
    private Integer snapshotInterval;
    /**
     * 保存标志
     */
    private Integer saveFlag;
    /**
     * 分辨率
     */
    private Integer resolution;
    /**
     * 图像/视频质量
     */
    private Integer quality;
    /**
     * 亮度
     */
    private Integer brightness;
    /**
     * 对比度
     */
    private Integer contrast;
    /**
     * 饱和度
     */
    private Integer saturation;
    /**
     * 色度
     */
    private Integer chroma;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808_Message_Content_0x8801 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x8801 content = new JT808_Message_Content_0x8801();
        content.deserialize(ctx, reader);
        return content;
    }
}
