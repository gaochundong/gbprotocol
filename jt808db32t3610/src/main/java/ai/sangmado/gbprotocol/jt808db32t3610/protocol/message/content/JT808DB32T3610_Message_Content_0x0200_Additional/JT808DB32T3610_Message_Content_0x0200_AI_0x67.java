package ai.sangmado.gbprotocol.jt808db32t3610.protocol.message.content.JT808DB32T3610_Message_Content_0x0200_Additional;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformation;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformationId;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808db32t3610.protocol.enums.JT808DB32T3610ExtendedLaneChangingAssistWarningType;
import ai.sangmado.gbprotocol.jt808db32t3610.protocol.enums.JT808DB32T3610ExtendedVehicleStatus;
import ai.sangmado.gbprotocol.jt808db32t3610.protocol.enums.JT808DB32T3610ExtendedWarningSectionFlag;
import ai.sangmado.gbprotocol.jt808db32t3610.protocol.message.content.JT808DB32T3610_WarningIdentity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 终端位置信息汇报 - 位置附加信息 - 变道决策辅助报警信息
 */
@NoArgsConstructor
public class JT808DB32T3610_Message_Content_0x0200_AI_0x67 extends JT808_Message_Content_0x0200_AdditionalInformation {
    public static final JT808_Message_Content_0x0200_AdditionalInformationId ADDITIONAL_INFORMATION_ID =
            JT808DB32T3610_Message_Content_0x0200_AdditionalInformationId.JT808DB32T3610_0x0200_0x67;

    @Override
    public JT808_Message_Content_0x0200_AdditionalInformationId getAdditionalInformationId() {
        return ADDITIONAL_INFORMATION_ID;
    }

    /**
     * 报警ID
     * <p>
     * 按照报警先后，从0开始循环累加，不区分报警类型
     */
    @Getter
    @Setter
    private Long warningId;
    /**
     * 标志状态
     * <p>
     * 该字段仅适用于有开始和结束标志类型的报警和事件
     */
    @Getter
    @Setter
    private JT808DB32T3610ExtendedWarningSectionFlag sectionFlag;
    /**
     * 报警/事件类型
     */
    @Getter
    @Setter
    private JT808DB32T3610ExtendedLaneChangingAssistWarningType warningType;
    /**
     * 车速
     * <p>
     * 单位Km/h 。 范围0~250
     */
    @Getter
    @Setter
    private Integer speed;
    /**
     * 高度
     * <p>
     * 海拔高度，单位为米（m)
     */
    @Getter
    @Setter
    private Integer altitude;
    /**
     * 纬度
     * <p>
     * 以度为单位的纬度值乘以10的6次方，精确到百万分之一度
     */
    @Getter
    @Setter
    private Long latitude;
    /**
     * 经度
     * <p>
     * 以度为单位的纬度值乘以10的6次方，精确到百万分之一度
     */
    @Getter
    @Setter
    private Long longitude;
    /**
     * 日期时间
     * <p>
     * YY-MM-DD-hh-mm-ss (GMT+8 时间)
     */
    @Getter
    @Setter
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime dateTime;
    /**
     * 车辆状态
     */
    @Getter
    @Setter
    private JT808DB32T3610ExtendedVehicleStatus vehicleStatus;
    /**
     * 报警标识号
     */
    @Getter
    @Setter
    private JT808DB32T3610_WarningIdentity warningIdentity;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB32T3610_Message_Content_0x0200_AI_0x67 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB32T3610_Message_Content_0x0200_AI_0x67 content = new JT808DB32T3610_Message_Content_0x0200_AI_0x67();
        content.deserialize(ctx, reader);
        return content;
    }
}
