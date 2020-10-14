package ai.sangmado.gbprotocol.jt808.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.*;

import java.util.List;

/**
 * 平台多媒体数据上传应答
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808_Message_Content_0x8800 extends JT808MessageContent {
    public static final JT808MessageId MESSAGE_ID = JT808MessageId.JT808_Message_0x8800;

    @Override
    public JT808MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 多媒体数据ID
     */
    private Long mediaDataId;
    /**
     * 重传包总数
     */
    private Integer retransmitPacketCount;
    /**
     * 重传包ID列表
     * <p>
     * 重传包序号顺序排列，如“包ID1 包ID2......包IDn”。
     * <p>
     * 不超过125项，无该字段则表明已收到全部数据包
     */
    private List<Integer> retransmitPacketIdList;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808_Message_Content_0x8800 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x8800 content = new JT808_Message_Content_0x8800();
        content.deserialize(ctx, reader);
        return content;
    }
}
