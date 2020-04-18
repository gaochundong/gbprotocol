package ai.sangmado.gbprotocol.jt1078.protocol.message.content;

import ai.sangmado.gbprotocol.jt1078.protocol.enums.JT1078MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.*;

/**
 * 终端文件上传完成通知
 * <p>
 * 当全部文件通过FTP上传完成后，终端上报此指令通知平台。
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT1078_Message_Content_0x1206 extends JT808MessageContent {
    public static final JT1078MessageId MESSAGE_ID = JT1078MessageId.JT1078_Message_0x1206;

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
     * 结果
     * <p>
     * 0：成功；
     * 1：失败
     */
    private Integer result;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT1078_Message_Content_0x1206 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT1078_Message_Content_0x1206 content = new JT1078_Message_Content_0x1206();
        content.deserialize(ctx, reader);
        return content;
    }
}
