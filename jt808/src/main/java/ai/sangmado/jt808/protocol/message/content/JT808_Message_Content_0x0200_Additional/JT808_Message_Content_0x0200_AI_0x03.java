package ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 终端􏰉􏱀􏰏􏰙􏱁位置信息汇报 - 位置附加信息 - 行驶记录功能获取的速度
 */
@NoArgsConstructor
public class JT808_Message_Content_0x0200_AI_0x03 extends JT808_Message_Content_0x0200_AdditionalInformation {

    @Override
    public JT808_Message_Content_0x0200_AdditionalInformationId getAdditionalInformationId() {
        return JT808_Message_Content_0x0200_AdditionalInformationId.JT808_0x0200_0x03;
    }

    /**
     * 行驶记录功能获取的速度
     */
    @Getter
    @Setter
    private Integer speed;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }
}
