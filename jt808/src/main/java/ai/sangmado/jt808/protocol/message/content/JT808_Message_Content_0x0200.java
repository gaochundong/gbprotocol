package ai.sangmado.jt808.protocol.message.content;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.jt808.protocol.enums.JT808VehicleState;
import ai.sangmado.jt808.protocol.enums.JT808WarningType;
import ai.sangmado.jt808.protocol.exceptions.UnsupportedJT808OperationException;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformation;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformationId;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformationRegistration;
import com.google.common.base.CharMatcher;
import lombok.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Strings.nullToEmpty;
import static com.google.common.base.Strings.padStart;

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
public class JT808_Message_Content_0x0200 extends JT808MessageContent {
    public static final JT808MessageId MESSAGE_ID = JT808MessageId.JT808_Message_0x0200;

    @Override
    public JT808MessageId getMessageId() {
        return MESSAGE_ID;
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
    private Long latitude;
    /**
     * 经度
     * 以度为单位的经度值乘以10的6次方，精确到百万分之一度
     */
    private Long longitude;
    /**
     * 高程
     * 海拔高度，单位为米(m)
     */
    private Long altitude;
    /**
     * 速度
     * 单位为1/10公里每小时(1/10km/h)
     */
    private Long speed;
    /**
     * 方向
     * 0~359，正北为0，顺时针
     */
    private Long direction;
    /**
     * 时间
     * BCD[6]，YYMMDDhhmmss(GMT+8时间，本标准中之后涉及的时间均采用此时区)
     */
    private String timestamp;
    /**
     * 位置附加信息列表
     */
    private List<JT808_Message_Content_0x0200_AdditionalInformation> additionalInformationList;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {
        writer.writeDWord(getWarningType().getValue());
        writer.writeDWord(getState().getValue());
        writer.writeDWord(getLatitude());
        writer.writeDWord(getLongitude());
        writer.writeDWord(getAltitude());
        writer.writeDWord(getSpeed());
        writer.writeDWord(getDirection());

        final char padChar = '0';
        writer.writeBCD(padStart(nullToEmpty(getTimestamp()), 6 * 2, padChar));

        // 针对附加信息排序后再写入
        if (getAdditionalInformationList() != null && getAdditionalInformationList().size() > 0) {
            for (JT808_Message_Content_0x0200_AdditionalInformation ai :
                    getAdditionalInformationList().stream()
                            .sorted(Comparator.comparing(JT808_Message_Content_0x0200_AdditionalInformation::getAdditionalInformationId))
                            .collect(Collectors.toList())) {
                ai.serialize(ctx, writer);
            }
        }
    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        setWarningType(JT808WarningType.cast(reader.readDWord()));
        setState(JT808VehicleState.cast(reader.readDWord()));
        setLatitude(reader.readDWord());
        setLongitude(reader.readDWord());
        setAltitude(reader.readDWord());
        setSpeed(reader.readDWord());
        setDirection(reader.readDWord());

        final String padChar = "0";
        setTimestamp(CharMatcher.anyOf(padChar).trimLeadingFrom(reader.readBCD(6)));

        // 通过读取附加信息ID进行判断
        // 格式：附加信息ID+附加信息长度+附加信息
        setAdditionalInformationList(new ArrayList<>());
        while (reader.readableBytes() > 0) {
            reader.markIndex();
            int aiId = reader.readByte() & 0xFF;
            reader.resetIndex();

            JT808_Message_Content_0x0200_AdditionalInformationId additionalInformationId = JT808_Message_Content_0x0200_AdditionalInformationId.cast(aiId);
            if (!JT808_Message_Content_0x0200_AdditionalInformationRegistration.getDecoders().containsKey(additionalInformationId)) {
                throw new UnsupportedJT808OperationException("暂不支持该附加信息ID:" + additionalInformationId);
            }
            JT808_Message_Content_0x0200_AdditionalInformation ai =
                    JT808_Message_Content_0x0200_AdditionalInformationRegistration.getDecoders()
                            .get(additionalInformationId).apply(ctx, reader);
            getAdditionalInformationList().add(ai);
        }
    }

    public static JT808_Message_Content_0x0200 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x0200 content = new JT808_Message_Content_0x0200();
        content.deserialize(ctx, reader);
        return content;
    }
}
