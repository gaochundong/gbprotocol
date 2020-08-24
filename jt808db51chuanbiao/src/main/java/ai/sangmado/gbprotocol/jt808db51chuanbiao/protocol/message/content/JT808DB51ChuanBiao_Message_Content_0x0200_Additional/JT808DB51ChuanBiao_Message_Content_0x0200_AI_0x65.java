package ai.sangmado.gbprotocol.jt808db51chuanbiao.protocol.message.content.JT808DB51ChuanBiao_Message_Content_0x0200_Additional;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformation;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformationId;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 终端位置信息汇报 - 位置附加信息 - 驾驶员行为监测功能报警信息
 */
@NoArgsConstructor
public class JT808DB51ChuanBiao_Message_Content_0x0200_AI_0x65 extends JT808_Message_Content_0x0200_AdditionalInformation {
    public static final JT808_Message_Content_0x0200_AdditionalInformationId ADDITIONAL_INFORMATION_ID =
            JT808DB51ChuanBiao_Message_Content_0x0200_AdditionalInformationId.JT808DB51ChuanBiao_0x0200_0x65;

    @Override
    public JT808_Message_Content_0x0200_AdditionalInformationId getAdditionalInformationId() {
        return ADDITIONAL_INFORMATION_ID;
    }

    /**
     * xxx
     */
    @Getter
    @Setter
    private Integer xxx;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB51ChuanBiao_Message_Content_0x0200_AI_0x65 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB51ChuanBiao_Message_Content_0x0200_AI_0x65 content = new JT808DB51ChuanBiao_Message_Content_0x0200_AI_0x65();
        content.deserialize(ctx, reader);
        return content;
    }
}
