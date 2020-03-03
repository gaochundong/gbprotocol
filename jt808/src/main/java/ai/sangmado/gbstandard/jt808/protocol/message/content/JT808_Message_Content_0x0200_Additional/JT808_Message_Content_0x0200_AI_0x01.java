package ai.sangmado.gbstandard.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional;

import ai.sangmado.gbstandard.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbstandard.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.gbstandard.jt808.protocol.encoding.IJT808MessageBufferWriter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 终端位置信息汇报 - 位置附加信息 - 里程
 */
@NoArgsConstructor
public class JT808_Message_Content_0x0200_AI_0x01 extends JT808_Message_Content_0x0200_AdditionalInformation {
    public static final JT808_Message_Content_0x0200_AdditionalInformationId ADDITIONAL_INFORMATION_ID =
            JT808_Message_Content_0x0200_AdditionalInformationId.JT808_0x0200_0x01;

    @Override
    public JT808_Message_Content_0x0200_AdditionalInformationId getAdditionalInformationId() {
        return ADDITIONAL_INFORMATION_ID;
    }

    /**
     * 里程表读数
     */
    @Getter
    @Setter
    private Integer milometer;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808_Message_Content_0x0200_AI_0x01 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x0200_AI_0x01 content = new JT808_Message_Content_0x0200_AI_0x01();
        content.deserialize(ctx, reader);
        return content;
    }
}
