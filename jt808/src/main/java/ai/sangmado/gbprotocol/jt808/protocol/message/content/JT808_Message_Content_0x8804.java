package ai.sangmado.gbprotocol.jt808.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.*;

/**
 * 平台下发录音开始命令
 *
 * @since V2011
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808_Message_Content_0x8804 extends JT808MessageContent {
    public static final JT808MessageId MESSAGE_ID = JT808MessageId.JT808_Message_0x8804;

    @Override
    public JT808MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 录音命令
     * <p>
     * 0x00：停止录音；
     * 0x01：开始录音；
     */
    private Integer recordingCommand;
    /**
     * 录音时长
     * <p>
     * 单位为秒（s），0 表示一直录音；
     */
    private Integer recordingInterval;
    /**
     * 保存标志
     * <p>
     * 0：实时上传；
     * 1：保存；
     */
    private Integer saveFlag;
    /**
     * 音频采样率
     * <p>
     * 0：8K；
     * 1：11K；
     * 2：23K；
     * 3：32K；
     */
    private Integer audioSampleRate;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808_Message_Content_0x8804 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x8804 content = new JT808_Message_Content_0x8804();
        content.deserialize(ctx, reader);
        return content;
    }
}
