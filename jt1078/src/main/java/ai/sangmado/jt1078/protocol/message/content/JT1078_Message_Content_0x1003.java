package ai.sangmado.jt1078.protocol.message.content;

import ai.sangmado.jt1078.protocol.enums.JT1078MessageId;
import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.message.content.JT808MessageContent;
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

    @Override
    public JT1078MessageId getMessageId() {
        return JT1078MessageId.JT1078_Message_0x1003;
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
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }
}
