package ai.sangmado.gbprotocol.jt1078.protocol.message.content;

import ai.sangmado.gbprotocol.jt1078.protocol.enums.JT1078MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import lombok.*;

/**
 * 终端上传音视频属性
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT1078_Message_Content_0x1003 extends JT808MessageContent {
    public static final JT1078MessageId MESSAGE_ID = JT1078MessageId.JT1078_Message_0x1003;

    @Override
    public JT1078MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 输入音频编码方式
     */
    private Integer inputAudioEncoding;
    /**
     * 输入音频声道数
     */
    private Integer inputAudioChannelCount;
    /**
     * 输入音频采样率
     */
    private String inputAudioSampleRate;
    /**
     * 输入音频采样位数
     */
    private String inputAudioSampleBits;
    /**
     * 音频帧长度
     */
    private String audioFrameLength;
    /**
     * 是否支持音频输出
     */
    private Boolean audioOutputSupported;
    /**
     * 视频编码方式
     */
    private String videoEncoding;
    /**
     * 终端支持的最大音频物理通道数量
     */
    private String maxNumberOfAudioPhysicalChannelsSupported;
    /**
     * 终端支持的最大视频物理通道数量
     */
    private String maxNumberOfVideoPhysicalChannelsSupported;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT1078_Message_Content_0x1003 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT1078_Message_Content_0x1003 content = new JT1078_Message_Content_0x1003();
        content.deserialize(ctx, reader);
        return content;
    }
}
