package ai.sangmado.gbprotocol.jt808db22jibiao.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808db22jibiao.protocol.enums.JT808DB22JiBiaoMessageId;
import lombok.*;

import java.util.List;

/**
 * 驾驶员身份库查询应答
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808DB22JiBiao_Message_Content_0x0E12 extends JT808MessageContent {
    public static final JT808DB22JiBiaoMessageId MESSAGE_ID = JT808DB22JiBiaoMessageId.JT808DB22JiBiao_Message_0x0E12;

    @Override
    public JT808DB22JiBiaoMessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 人脸库列表个数
     */
    private Integer driverFaceRepositoryItemCount;
    /**
     * 人脸库信息列表
     */
    private List<String> driverFaceRepositoryItems;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB22JiBiao_Message_Content_0x0E12 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB22JiBiao_Message_Content_0x0E12 content = new JT808DB22JiBiao_Message_Content_0x0E12();
        content.deserialize(ctx, reader);
        return content;
    }
}
