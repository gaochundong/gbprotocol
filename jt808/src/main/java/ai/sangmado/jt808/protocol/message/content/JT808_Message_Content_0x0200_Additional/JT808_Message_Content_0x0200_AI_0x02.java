package ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.enums.JT808ProtocolVersion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 终端􏰉􏱀􏰏􏰙􏱁位置信息汇报 - 位置附加信息 - 油量
 */
@NoArgsConstructor
public class JT808_Message_Content_0x0200_AI_0x02 extends JT808_Message_Content_0x0200_AdditionalInformation<JT808ProtocolVersion> {

    @Override
    public JT808_Message_Content_0x0200_AdditionalInformationId getAdditionalInformationId() {
        return JT808_Message_Content_0x0200_AdditionalInformationId.JT808_0x0200_0x02;
    }

    /**
     * 油量表读数
     */
    @Getter
    @Setter
    private Integer fuelMeter;

    @Override
    public void serialize(ISpecificationContext<JT808ProtocolVersion> ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext<JT808ProtocolVersion> ctx, IJT808MessageBufferReader reader) {

    }
}
