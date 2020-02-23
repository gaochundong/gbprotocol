package ai.sangmado.jt809.protocol.message.content.JT809_Message_Content_0x1400_Sub;

import ai.sangmado.jt809.protocol.ISpecificationContext;
import ai.sangmado.jt809.protocol.encoding.IJT809MessageBufferReader;
import ai.sangmado.jt809.protocol.encoding.IJT809MessageBufferWriter;
import ai.sangmado.jt809.protocol.enums.JT809SubMessageId;
import ai.sangmado.jt809.protocol.enums.JT809WarningSource;
import ai.sangmado.jt809.protocol.enums.JT809WarningType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 主链路报警信息交互消息 UP_WARN_MSG - 子消息 - 上报报警信息 UP_WARN_MSG_ADPT_INFO
 * <p>
 * 下级平台向上级平台上报某车辆的报警信息;
 * 本条消息上级平台无需应答;
 */
@NoArgsConstructor
public class JT809_Message_Content_0x1400_Sub_0x1402 extends JT809_Message_Content_0x1400_SubMessage {
    public static final JT809SubMessageId SUB_MESSAGE_ID = JT809SubMessageId.JT809_Sub_Message_0x1402;

    @Override
    public JT809SubMessageId getSubMessageId() {
        return SUB_MESSAGE_ID;
    }

    /**
     * 发起报警平台唯一编码，由平台所在地行政区域代码和平台编号组成
     */
    @Getter
    @Setter
    private String fromPlatformId;

    /**
     * 报警类型
     */
    @Getter
    @Setter
    private JT809WarningType warningType;

    /**
     * 报警时间，UTC时间格式
     */
    @Getter
    @Setter
    private Long warningTime;

    /**
     * 报警信息来源
     */
    @Getter
    @Setter
    private JT809WarningSource warningSource;

    /**
     * 事件开始时间，UTC时间格式
     */
    @Getter
    @Setter
    private Long beginTime;

    /**
     * 事件结束时间，UTC时间格式
     */
    @Getter
    @Setter
    private Long endTime;

    /**
     * 车牌号，非车辆相关报警全填0
     */
    @Getter
    @Setter
    private String plateNumber;

    /**
     * 车牌颜色
     * <p>
     * 2011:按照 JT/T 415-2006中5.4.12的规定
     * 2019:按照 JT/T 697.7-2014的规定，非车辆相关报警全填0
     */
    @Getter
    @Setter
    private Integer plateColor;

    /**
     * 被报警平台唯一编码，由平台所在地行政区划大码和平台编号组成。非平台相关报警全填0
     */
    @Getter
    @Setter
    private String toPlatformId;

    /**
     * 线路ID
     * <p>
     * JT/T808-2019中0x8606规定的报文中的线路
     */
    @Getter
    @Setter
    private Long drivingLineId;

    /**
     * 上报报警信息ID
     */
    @Getter
    @Setter
    private Long warningInfoId;

    /**
     * 上报报警信息长度，最长1024字节
     */
    @Getter
    @Setter
    private Long warningInfoLength;

    /**
     * 上报报警信息内容
     */
    @Getter
    @Setter
    private String warningInfoContent;

    @Override
    public void serialize(ISpecificationContext ctx, IJT809MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT809MessageBufferReader reader) {

    }

    public static JT809_Message_Content_0x1400_Sub_0x1402 decode(ISpecificationContext ctx, IJT809MessageBufferReader reader) {
        JT809_Message_Content_0x1400_Sub_0x1402 content = new JT809_Message_Content_0x1400_Sub_0x1402();
        content.deserialize(ctx, reader);
        return content;
    }
}
