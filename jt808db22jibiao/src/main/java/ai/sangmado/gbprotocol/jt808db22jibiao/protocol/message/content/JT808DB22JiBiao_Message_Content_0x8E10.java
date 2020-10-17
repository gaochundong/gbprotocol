package ai.sangmado.gbprotocol.jt808db22jibiao.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808db22jibiao.protocol.enums.JT808DB22JiBiaoMessageId;
import lombok.*;

import java.util.List;

/**
 * 驾驶员身份识别上报应答
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808DB22JiBiao_Message_Content_0x8E10 extends JT808MessageContent {
    public static final JT808DB22JiBiaoMessageId MESSAGE_ID = JT808DB22JiBiaoMessageId.JT808DB22JiBiao_Message_0x8E10;

    @Override
    public JT808DB22JiBiaoMessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 应答流水号
     * <p>
     * 对应人脸比对上报的流水号
     */
    private Integer ackSerialNumber;
    /**
     * 重传包总数
     */
    private Integer retransmitPacketCount;
    /**
     * 重传包ID
     * <p>
     * 重传包序号顺序排列，如“包ID1 包ID2......包IDn”。
     */
    private List<String> retransmitPacketIdList;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB22JiBiao_Message_Content_0x8E10 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB22JiBiao_Message_Content_0x8E10 content = new JT808DB22JiBiao_Message_Content_0x8E10();
        content.deserialize(ctx, reader);
        return content;
    }
}
