package ai.sangmado.gbprotocol.jt1078.protocol.message.content;

import ai.sangmado.gbprotocol.jt1078.protocol.enums.JT1078MessageId;
import ai.sangmado.gbprotocol.jt1078.protocol.enums.OperationResult;
import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
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
    private Integer ackSerialNumber;
    /**
     * 结果
     * <p>
     * 0：成功；
     * 1：失败
     */
    private OperationResult result;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {
        writer.writeWord(getAckSerialNumber());
        writer.writeByte(getResult().getValue());
    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        setAckSerialNumber(reader.readWord());
        OperationResult result = OperationResult.cast(reader.readByte() & 0xFF);
        setResult(result);
    }

    public static JT1078_Message_Content_0x1206 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT1078_Message_Content_0x1206 content = new JT1078_Message_Content_0x1206();
        content.deserialize(ctx, reader);
        return content;
    }
}
