package ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 终端位置信息汇报 - 位置附加信息 - 进出区域/路线报警附加信息
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
     * 位置类型
     * <p>
     * 1：圆型区域；
     * 2：矩形区域；
     * 3：多边形区域；
     * 4：路线
     */
    @Getter
    @Setter
    private Integer positionType;
    /**
     * 区域或路段ID
     * <p>
     * 若位置类型为0，无该字段
     */
    @Getter
    @Setter
    private Long segmentId;
    /**
     * 方向
     * <p>
     * 0：进；
     * 1：出
     */
    @Getter
    @Setter
    private Integer direction;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808_Message_Content_0x0200_AI_0x12 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x0200_AI_0x12 content = new JT808_Message_Content_0x0200_AI_0x12();
        content.deserialize(ctx, reader);
        return content;
    }
}
