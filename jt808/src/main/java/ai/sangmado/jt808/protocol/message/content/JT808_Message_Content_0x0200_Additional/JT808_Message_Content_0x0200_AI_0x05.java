package ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.enums.JT808ProtocolVersion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 终端􏰉􏱀􏰏􏰙􏱁位置信息汇报 - 位置附加信息 - 胎压
 */
@NoArgsConstructor
public class JT808_Message_Content_0x0200_AI_0x05 extends JT808_Message_Content_0x0200_AdditionalInformation<JT808ProtocolVersion> {

    @Override
    public JT808_Message_Content_0x0200_AdditionalInformationId getAdditionalInformationId() {
        return JT808_Message_Content_0x0200_AdditionalInformationId.JT808_0x0200_0x05;
    }

    /**
     * 胎压
     * <p>
     * 长度 30
     * 单位为Pa，标定轮子的顺序为从车头开始从左到右顺序排列，多于字节为0xFF，表示无效数据
     */
    @Getter
    @Setter
    private byte[] tirePressure;

    @Override
    public void serialize(ISpecificationContext<JT808ProtocolVersion> ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext<JT808ProtocolVersion> ctx, IJT808MessageBufferReader reader) {

    }
}
