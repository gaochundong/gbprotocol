package ai.sangmado.gbprotocol.jt1078.protocol.message.content;

import ai.sangmado.gbprotocol.jt1078.protocol.enums.JT1078MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 终端上传乘客流量
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT1078_Message_Content_0x1005 extends JT808MessageContent {
    public static final JT1078MessageId MESSAGE_ID = JT1078MessageId.JT1078_Message_0x1005;

    private static final String TIMESTAMP_PATTERN = "yyMMddHHmmss";
    private static final DateTimeFormatter TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern(TIMESTAMP_PATTERN);

    @Override
    public JT1078MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 起始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime beginTime;
    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime endTime;
    /**
     * 上车人数
     */
    private Integer numberOfPeopleGettingOn;
    /**
     * 下车人数
     */
    private Integer numberOfPeopleGettingOff;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {
        writer.writeBCD(TIMESTAMP_FORMATTER.format(getBeginTime()));
        writer.writeBCD(TIMESTAMP_FORMATTER.format(getEndTime()));
        writer.writeWord(getNumberOfPeopleGettingOn());
        writer.writeWord(getNumberOfPeopleGettingOff());
    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        setBeginTime(LocalDateTime.parse(reader.readBCD(6), TIMESTAMP_FORMATTER));
        setEndTime(LocalDateTime.parse(reader.readBCD(6), TIMESTAMP_FORMATTER));
        setNumberOfPeopleGettingOn(reader.readWord());
        setNumberOfPeopleGettingOff(reader.readWord());
    }

    public static JT1078_Message_Content_0x1005 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT1078_Message_Content_0x1005 content = new JT1078_Message_Content_0x1005();
        content.deserialize(ctx, reader);
        return content;
    }
}
