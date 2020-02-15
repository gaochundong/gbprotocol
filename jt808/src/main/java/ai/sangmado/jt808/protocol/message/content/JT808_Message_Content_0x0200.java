package ai.sangmado.jt808.protocol.message.content;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.enums.IProtocolVersion;
import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.jt808.protocol.enums.JT808VehicleState;
import ai.sangmado.jt808.protocol.enums.JT808WarningType;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformation;
import lombok.*;

import java.util.List;

/**
 * 终端􏰉􏱀􏰏􏰙􏱁位置信息汇报
 * <p>
 * 􏰢􏰣车辆在发生报警时应立即上报一条位置信息，并在位置信息中附加报警状态。
 * 位置信息汇报消息体由位置基本信息和位置附加信息项列表组成。
 * 位置附件信息项列表由各位置附件信息项组合，也可没有，根据消息头中的长度字段确定。
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808_Message_Content_0x0200<TProtocolVersion extends IProtocolVersion> extends JT808MessageContent<JT808MessageId, TProtocolVersion> {

    @Override
    public JT808MessageId getMessageId() {
        return JT808MessageId.JT808_Message_0x0200;
    }

    /**
     * 报警标志
     */
    private JT808WarningType warningType;
    /**
     * 状态
     */
    private JT808VehicleState state;
    /**
     * 纬度
     * 以度为单位的纬度值乘以10的6次方，精确到百万分之一度
     */
    private Integer latitude;
    /**
     * 经度
     * 以度为单位的经度值乘以10的6次方，精确到百万分之一度
     */
    private Integer longitude;
    /**
     * 高程
     * 海拔高度，单位为米(m)
     */
    private Integer altitude;
    /**
     * 速度
     * 单位为1/10公里每小时(1/10km/h)
     */
    private Integer speed;
    /**
     * 方向
     * 0~359，正北为0，顺时针
     */
    private Integer direction;
    /**
     * 时间
     * BCD[6]，YY-MM-DD-hh-mm-ss(GMT+8时间，本标准中之后涉及的时间均采用此时区)
     */
    private String timestamp;
    /**
     * 位置附加信息列表
     */
    private List<JT808_Message_Content_0x0200_AdditionalInformation<TProtocolVersion>> additionalInformationList;

    @Override
    public void serialize(ISpecificationContext<TProtocolVersion> ctx, IJT808MessageBufferWriter writer) {
    }

    @Override
    public void deserialize(ISpecificationContext<TProtocolVersion> ctx, IJT808MessageBufferReader reader) {
    }
}
