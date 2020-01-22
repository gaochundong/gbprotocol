package ai.sangmado.jt808.protocol.message.header;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.enums.JT808MessageId;
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
public class JT808MessageHeader2019 extends JT808MessageHeader {

    /**
     * 协议版本号
     * 每次关键修订递增，初始版本为1。
     */
    private Byte protocolVersion;

    /**
     * 终端手机号
     * 2019：根据安装后终端自身的手机号转换。手机号不足位的，则在前补充数字 0。
     */
    private String phoneNumber;

    @Builder
    public JT808MessageHeader2019(
            JT808MessageId messageId,
            JT808MessageHeaderMessageContentProperty messageContentProperty,
            Integer serialNumber,
            JT808MessageHeaderMessagePacketProperty messagePacketProperty,
            String phoneNumber,
            Byte protocolVersion) {
        super(messageId, messageContentProperty, serialNumber, messagePacketProperty);
        this.protocolVersion = protocolVersion;
        this.phoneNumber = phoneNumber;
    }

    @SuppressWarnings("SwitchStatementWithTooFewBranches")
    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {
        writer.writeWord(getMessageId().getValue());

        switch (ctx.getJT808ProtocolVersion()) {
            case V2019: {
                writer.writeWord(getMessageContentProperty().marshal());
                writer.writeByte(getProtocolVersion());
                writer.writeBCD(padStart(nullToEmpty(getPhoneNumber()), 10, '0'), 10);
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
            case V2019: {
                JT808MessageHeaderMessageContentProperty2019 property = new JT808MessageHeaderMessageContentProperty2019();
                property.release(contentPropertyValue);
                setMessageContentProperty(property);
                setProtocolVersion(reader.readByte());
                setPhoneNumber(reader.readBCD(10));
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
