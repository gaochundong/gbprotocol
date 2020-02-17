package ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 终端􏰉􏱀􏰏􏰙􏱁位置信息汇报 - 位置附加信息 - 进出区域/路线报警附加信息
 */
@NoArgsConstructor
public class JT808_Message_Content_0x0200_AI_0x12 extends JT808_Message_Content_0x0200_AdditionalInformation {
    public static final JT808_Message_Content_0x0200_AdditionalInformationId ADDITIONAL_INFORMATION_ID =
            JT808_Message_Content_0x0200_AdditionalInformationId.JT808_0x0200_0x12;

    @Override
    public JT808_Message_Content_0x0200_AdditionalInformationId getAdditionalInformationId() {
        return ADDITIONAL_INFORMATION_ID;
    }

    /**
     * 进出区域/路线报警附加信息
     * <p>
     * 长度 6
     */
    @Getter
    @Setter
    private byte[] entryAreaAdditionalInformation;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808_Message_Content_0x0200_AI_0x12 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x0200_AI_0x12 content = new JT808_Message_Content_0x0200_AI_0x12();
        content.deserialize(ctx, reader);
        return content;
    }
}
