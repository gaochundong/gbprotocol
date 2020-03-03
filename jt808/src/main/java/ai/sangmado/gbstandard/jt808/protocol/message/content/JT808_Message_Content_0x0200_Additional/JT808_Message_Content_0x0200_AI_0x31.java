package ai.sangmado.gbstandard.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional;

import ai.sangmado.gbstandard.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.gbstandard.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.gbstandard.jt808.protocol.ISpecificationContext;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 终端位置信息汇报 - 位置附加信息 - GNSS定位卫星数
 */
@NoArgsConstructor
public class JT808_Message_Content_0x0200_AI_0x31 extends JT808_Message_Content_0x0200_AdditionalInformation {
    public static final JT808_Message_Content_0x0200_AdditionalInformationId ADDITIONAL_INFORMATION_ID =
            JT808_Message_Content_0x0200_AdditionalInformationId.JT808_0x0200_0x31;

    @Override
    public JT808_Message_Content_0x0200_AdditionalInformationId getAdditionalInformationId() {
        return ADDITIONAL_INFORMATION_ID;
    }

    /**
     * GNSS定位卫星数
     */
    @Getter
    @Setter
    private Integer numberOfSatellites;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808_Message_Content_0x0200_AI_0x31 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x0200_AI_0x31 content = new JT808_Message_Content_0x0200_AI_0x31();
        content.deserialize(ctx, reader);
        return content;
    }
}
