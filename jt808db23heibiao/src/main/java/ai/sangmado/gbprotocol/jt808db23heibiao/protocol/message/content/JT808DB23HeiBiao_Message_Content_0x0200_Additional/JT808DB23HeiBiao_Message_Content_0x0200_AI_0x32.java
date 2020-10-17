package ai.sangmado.gbprotocol.jt808db23heibiao.protocol.message.content.JT808DB23HeiBiao_Message_Content_0x0200_Additional;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformation;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformationId;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 终端位置信息汇报 - 位置附加信息 - 路网图信息上传
 */
@NoArgsConstructor
public class JT808DB23HeiBiao_Message_Content_0x0200_AI_0x32 extends JT808_Message_Content_0x0200_AdditionalInformation {
    public static final JT808_Message_Content_0x0200_AdditionalInformationId ADDITIONAL_INFORMATION_ID =
            JT808DB23HeiBiao_Message_Content_0x0200_AdditionalInformationId.JT808DB23HeiBiao_0x0200_0x32;

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
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB23HeiBiao_Message_Content_0x0200_AI_0x32 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB23HeiBiao_Message_Content_0x0200_AI_0x32 content = new JT808DB23HeiBiao_Message_Content_0x0200_AI_0x32();
        content.deserialize(ctx, reader);
        return content;
    }
}
