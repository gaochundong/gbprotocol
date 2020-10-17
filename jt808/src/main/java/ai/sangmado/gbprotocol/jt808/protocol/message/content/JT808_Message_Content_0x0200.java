package ai.sangmado.gbprotocol.jt808.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808VehicleState;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808WarningType;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808OperationException;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformation;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformationId;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformationRegistration;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    private static final String TIMESTAMP_PATTERN = "yyMMddHHmmss";
    private static final DateTimeFormatter TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern(TIMESTAMP_PATTERN);

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
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime timestamp;
    /**
     * 位置附加信息列表
     */
    private List<JT808_Message_Content_0x0200_AdditionalInformation> additionalInformationList;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {
        writer.writeDWord(getWarningType().getValue());
        writer.writeDWord(getState().getValue());
        writer.writeDWord(getLatitude());
        writer.writeDWord(getLongitude());
        writer.writeWord(getAltitude());
        writer.writeWord(getSpeed());
        writer.writeWord(getDirection());
        writer.writeBCD(TIMESTAMP_FORMATTER.format(getTimestamp()));

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
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        setWarningType(JT808WarningType.cast(reader.readDWord()));
        setState(JT808VehicleState.cast(reader.readDWord()));
        setLatitude(reader.readDWord());
        setLongitude(reader.readDWord());
        setAltitude(reader.readWord());
        setSpeed(reader.readWord());
        setDirection(reader.readWord());
        setTimestamp(LocalDateTime.parse(reader.readBCD(6), TIMESTAMP_FORMATTER));

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

    public static JT808_Message_Content_0x0200 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x0200 content = new JT808_Message_Content_0x0200();
        content.deserialize(ctx, reader);
        return content;
    }
}
