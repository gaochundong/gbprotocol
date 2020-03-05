package ai.sangmado.gbprotocol.jt1078.protocol.message.content.JT1078_Message_Content_0x0200_Additional;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformation;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformationId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 终端位置信息汇报 - 位置附加信息 - 视频信号丢失报警状态
 */
@NoArgsConstructor
public class JT1078_Message_Content_0x0200_AI_0x15 extends JT808_Message_Content_0x0200_AdditionalInformation {
    public static final JT808_Message_Content_0x0200_AdditionalInformationId ADDITIONAL_INFORMATION_ID =
            JT1078_Message_Content_0x0200_AdditionalInformationId.JT1078_0x0200_0x15;

    @Override
    public JT808_Message_Content_0x0200_AdditionalInformationId getAdditionalInformationId() {
        return ADDITIONAL_INFORMATION_ID;
    }

    /**
     * 视频信号丢失报警状态
     */
    @Getter
    @Setter
    private Integer videoSignalLoss;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT1078_Message_Content_0x0200_AI_0x15 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT1078_Message_Content_0x0200_AI_0x15 content = new JT1078_Message_Content_0x0200_AI_0x15();
        content.deserialize(ctx, reader);
        return content;
    }
}
