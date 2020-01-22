package ai.sangmado.jt808.protocol.message.header;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.jt808.protocol.exceptions.UnsupportedJT808OperationException;
import ai.sangmado.jt808.protocol.exceptions.UnsupportedJT808ProtocolVersionException;
import ai.sangmado.jt808.protocol.message.codec.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.message.codec.IJT808MessageBufferWriter;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import static com.google.common.base.Strings.nullToEmpty;
import static com.google.common.base.Strings.padStart;

@Getter
@Setter
public class JT808MessageHeader2011 extends JT808MessageHeader {

    /**
     * 终端手机号
     * 2011：根据安装后终端自身的手机号转换。手机号不足12位，则在前补充数字，大陆手机号补充数字0，港澳台则根据其区号进行位数补充。
     */
    private String phoneNumber;

    @Builder
    public JT808MessageHeader2011(
            JT808MessageId messageId,
            JT808MessageHeaderMessageContentProperty messageContentProperty,
            Integer serialNumber,
            JT808MessageHeaderMessagePacketProperty messagePacketProperty,
            String phoneNumber) {
        super(messageId, messageContentProperty, serialNumber, messagePacketProperty);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public JT808MessageHeader clone() {
        try {
            return JT808MessageHeader2011.builder()
                    .messageId(this.getMessageId())
                    .messageContentProperty(this.getMessageContentProperty().clone())
                    .serialNumber(this.getSerialNumber())
                    .messagePacketProperty(this.getMessagePacketProperty().clone())
                    .phoneNumber(this.getPhoneNumber())
                    .build();
        } catch (CloneNotSupportedException ex) {
            throw new UnsupportedJT808OperationException("克隆对象失败", ex);
        }
    }

    @SuppressWarnings("SwitchStatementWithTooFewBranches")
    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {
        writer.writeWord(getMessageId().getValue());

        switch (ctx.getJT808ProtocolVersion()) {
            case V2011: {
                writer.writeWord(getMessageContentProperty().marshal());
                writer.writeBCD(padStart(nullToEmpty(getPhoneNumber()), 6, '0'), 6);
                break;
            }
            default:
                throw new UnsupportedJT808ProtocolVersionException(ctx.getJT808ProtocolVersion());
        }

        writer.writeWord(getSerialNumber());

        if (getMessageContentProperty().getIsMultiplePackets()) {
            writer.writeWord(getMessagePacketProperty().getTotalPackets());
            writer.writeWord(getMessagePacketProperty().getPacketSequence());
        }
    }

    @SuppressWarnings("SwitchStatementWithTooFewBranches")
    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        setMessageId(JT808MessageId.cast(reader.readWord()));

        int contentPropertyValue = reader.readWord();
        switch (ctx.getJT808ProtocolVersion()) {
            case V2011: {
                JT808MessageHeaderMessageContentProperty2011 property = new JT808MessageHeaderMessageContentProperty2011();
                property.release(contentPropertyValue);
                setMessageContentProperty(property);
                setPhoneNumber(reader.readBCD(6));
                break;
            }
            default:
                throw new UnsupportedJT808ProtocolVersionException(ctx.getJT808ProtocolVersion());
        }

        setSerialNumber(reader.readWord());

        if (getMessageContentProperty().getIsMultiplePackets()) {
            JT808MessageHeaderMessagePacketProperty property = new JT808MessageHeaderMessagePacketProperty();
            property.setTotalPackets(reader.readWord());
            property.setPacketSequence(reader.readWord());
            setMessagePacketProperty(property);
        }
    }
}
