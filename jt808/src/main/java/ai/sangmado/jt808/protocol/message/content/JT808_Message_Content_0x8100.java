package ai.sangmado.jt808.protocol.message.content;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.enums.JT808DeviceRegistrationResult;
import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.jt808.protocol.enums.JT808ProtocolVersion;
import lombok.*;

/**
 * 平台终端注册应答
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808_Message_Content_0x8100 extends JT808MessageContent<JT808MessageId, JT808ProtocolVersion> {
    public static final JT808MessageId MESSAGE_ID = JT808MessageId.JT808_Message_0x8100;

    @Override
    public JT808MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 应答流水号
     * 对应终端注册消息的流水号
     */
    private Integer ackSerialNumber;
    /**
     * 注册结果
     */
    private JT808DeviceRegistrationResult registrationResult;
    /**
     * 鉴权码
     * 注册结果为成功是，才有该字段。
     */
    private String authCode;

    @Override
    public void serialize(ISpecificationContext<JT808ProtocolVersion> ctx, IJT808MessageBufferWriter writer) {
        writer.writeWord(getAckSerialNumber());
        writer.writeByte(getRegistrationResult().getValue());

        // 终端注册成功后才有鉴权码字段
        if (getRegistrationResult() == JT808DeviceRegistrationResult.Success) {
            writer.writeString(getAuthCode());
        }
    }

    @Override
    public void deserialize(ISpecificationContext<JT808ProtocolVersion> ctx, IJT808MessageBufferReader reader) {
        setAckSerialNumber(reader.readWord());

        JT808DeviceRegistrationResult registrationResult = JT808DeviceRegistrationResult.cast(reader.readByte());
        setRegistrationResult(registrationResult);

        // 终端注册成功后才有鉴权码字段
        if (registrationResult == JT808DeviceRegistrationResult.Success) {
            setAuthCode(reader.readStringRemaining());
        }
    }

    public static JT808_Message_Content_0x8100 decode(ISpecificationContext<JT808ProtocolVersion> ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x8100 content = new JT808_Message_Content_0x8100();
        content.deserialize(ctx, reader);
        return content;
    }
}
