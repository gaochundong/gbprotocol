package ai.sangmado.jt1078.protocol.message.content.JT1078_Message_Content_0x0200_Additional;

import ai.sangmado.jt1078.protocol.enums.JT1078ProtocolVersion;
import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformation;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformationId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 终端􏰉􏱀􏰏􏰙􏱁位置信息汇报 - 位置附加信息 - 视频信号遮挡报警状态
 */
@NoArgsConstructor
public class JT1078_Message_Content_0x0200_AI_0x16 extends JT808_Message_Content_0x0200_AdditionalInformation<JT1078ProtocolVersion> {

    @Override
    public JT808_Message_Content_0x0200_AdditionalInformationId getAdditionalInformationId() {
        return JT1078_Message_Content_0x0200_AdditionalInformationId.JT1078_0x0200_0x16;
    }

    /**
     * 视频信号遮挡报警状态
     */
    @Getter
    @Setter
    private Integer videoSignalBlock;

    @Override
    public void serialize(ISpecificationContext<JT1078ProtocolVersion> ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext<JT1078ProtocolVersion> ctx, IJT808MessageBufferReader reader) {

    }
}
