package ai.sangmado.gbprotocol.jt808.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MediaDataActionCode;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MediaDataType;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 平台下发存储多媒体数据上传
 *
 * @since V2011
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808_Message_Content_0x8803 extends JT808MessageContent {
    public static final JT808MessageId MESSAGE_ID = JT808MessageId.JT808_Message_0x8803;

    @Override
    public JT808MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 多媒体类型
     */
    private JT808MediaDataType mediaDataType;
    /**
     * 通道ID
     * <p>
     * 0:表示检索该媒体类型的所有通道；
     */
    private Integer channelId;
    /**
     * 事件项编码
     * <p>
     * 0：平台下发指令；
     * 1：定时动作；
     * 2：抢劫报警触发；
     * 3：碰撞侧翻报警触发；
     */
    private JT808MediaDataActionCode mediaDataActionCode;
    /**
     * 起始时间
     * <p>
     * BCD[6] YY-MM-DD-hh-mm-ss
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime beginTime;
    /**
     * 结束时间
     * <p>
     * BCD[6] YY-MM-DD-hh-mm-ss
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime endTime;
    /**
     * 删除标志
     * <p>
     * 0：保留；1：删除;
     */
    private Boolean deletedFlag;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808_Message_Content_0x8803 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x8803 content = new JT808_Message_Content_0x8803();
        content.deserialize(ctx, reader);
        return content;
    }
}
