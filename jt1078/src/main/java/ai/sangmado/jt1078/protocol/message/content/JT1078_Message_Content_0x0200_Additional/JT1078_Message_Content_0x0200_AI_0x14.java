package ai.sangmado.jt1078.protocol.message.content.JT1078_Message_Content_0x0200_Additional;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformation;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformationId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 终端􏰉􏱀􏰏􏰙􏱁位置信息汇报 - 位置附加信息 - 视频相关报警标志位
 */
@NoArgsConstructor
public class JT1078_Message_Content_0x0200_AI_0x14 extends JT808_Message_Content_0x0200_AdditionalInformation {
    public static final JT808_Message_Content_0x0200_AdditionalInformationId ADDITIONAL_INFORMATION_ID =
            JT1078_Message_Content_0x0200_AdditionalInformationId.JT1078_0x0200_0x14;

    @Override
    public JT808_Message_Content_0x0200_AdditionalInformationId getAdditionalInformationId() {
        return ADDITIONAL_INFORMATION_ID;
    }

    /**
     * 视频相关报警标志位
     */
    @Getter
    @Setter
    private Integer videoWarningType;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT1078_Message_Content_0x0200_AI_0x14 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT1078_Message_Content_0x0200_AI_0x14 content = new JT1078_Message_Content_0x0200_AI_0x14();
        content.deserialize(ctx, reader);
        return content;
    }
}
