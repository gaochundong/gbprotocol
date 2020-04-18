package ai.sangmado.gbprotocol.jt1078.protocol.message.content;

import ai.sangmado.gbprotocol.jt1078.protocol.enums.JT1078MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.*;

/**
 * 平台下发文件上传控制
 * <p>
 * 平台通知终端暂停、继续或取消正在传输中的所有文件。
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT1078_Message_Content_0x9207 extends JT808MessageContent {
    public static final JT1078MessageId MESSAGE_ID = JT1078MessageId.JT1078_Message_0x9207;

    @Override
    public JT1078MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 应答流水号
     * <p>
     * 对应平台文件上传消息的流水号
     */
    private Integer sequenceNumber;
    /**
     * 上传控制
     * <p>
     * 0：暂停；
     * 1：继续；
     * 2：取消
     */
    private Integer uploadControl;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT1078_Message_Content_0x9207 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT1078_Message_Content_0x9207 content = new JT1078_Message_Content_0x9207();
        content.deserialize(ctx, reader);
        return content;
    }
}
