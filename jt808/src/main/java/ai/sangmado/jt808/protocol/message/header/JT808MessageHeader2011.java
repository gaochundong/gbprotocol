package ai.sangmado.jt808.protocol.message.header;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.jt808.protocol.enums.JT808ProtocolVersion;
import ai.sangmado.jt808.protocol.exceptions.UnsupportedJT808OperationException;
import ai.sangmado.jt808.protocol.exceptions.UnsupportedJT808ProtocolVersionException;
import com.google.common.base.CharMatcher;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static ai.sangmado.jt808.protocol.enums.JT808ProtocolVersion.V2011;
import static com.google.common.base.Strings.nullToEmpty;
import static com.google.common.base.Strings.padStart;

@Getter
@Setter
@NoArgsConstructor
public class JT808MessageHeader2011 extends JT808MessageHeader {
    public static final JT808ProtocolVersion PROTOCOL_VERSION = V2011;

    @Builder
    public JT808MessageHeader2011(
            JT808MessageId messageId,
            JT808MessageHeaderMessageContentProperty messageContentProperty,
            Integer serialNumber,
            JT808MessageHeaderMessagePacketProperty messagePacketProperty,
            String phoneNumber) {
        super(messageId, messageContentProperty, serialNumber, messagePacketProperty, phoneNumber);
    }

    @Override
    public JT808MessageHeader clone() {
        try {
            return JT808MessageHeader2011.builder()
                    .messageId(this.getMessageId())
                    .messageContentProperty(this.getMessageContentProperty() == null ? null : this.getMessageContentProperty().clone())
                    .serialNumber(this.getSerialNumber())
                    .messagePacketProperty(this.getMessagePacketProperty() == null ? null : this.getMessagePacketProperty().clone())
                    .phoneNumber(this.getPhoneNumber())
                    .build();
        } catch (CloneNotSupportedException ex) {
            throw new UnsupportedJT808OperationException("克隆对象失败", ex);
        }
    }

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {
        writer.writeWord(getMessageId().getValue());

        final char padChar = '0';
        if (ctx.getProtocolVersion().equals(PROTOCOL_VERSION)) {
            writer.writeWord(getMessageContentProperty().marshal());
            writer.writeBCD(padStart(nullToEmpty(getPhoneNumber()), 6 * 2, padChar));
        } else {
            throw new UnsupportedJT808ProtocolVersionException(ctx.getProtocolVersion());
        }

        writer.writeWord(getSerialNumber());

        if (getMessageContentProperty().getIsMultiplePackets()) {
            writer.writeWord(getMessagePacketProperty().getTotalPackets());
            writer.writeWord(getMessagePacketProperty().getPacketSequence());
        }
    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        setMessageId(JT808MessageId.cast(reader.readWord()));

        final String padChar = "0";
        int contentPropertyValue = reader.readWord();
        if (ctx.getProtocolVersion().equals(PROTOCOL_VERSION)) {
            JT808MessageHeaderMessageContentProperty2011 property = new JT808MessageHeaderMessageContentProperty2011();
            property.release(contentPropertyValue);
            setMessageContentProperty(property);
            setPhoneNumber(CharMatcher.anyOf(padChar).trimLeadingFrom(reader.readBCD(6)));
        } else {
            throw new UnsupportedJT808ProtocolVersionException(ctx.getProtocolVersion());
        }

        setSerialNumber(reader.readWord());

        if (getMessageContentProperty().getIsMultiplePackets()) {
            JT808MessageHeaderMessagePacketProperty property = new JT808MessageHeaderMessagePacketProperty();
            property.setTotalPackets(reader.readWord());
            property.setPacketSequence(reader.readWord());
            setMessagePacketProperty(property);
        }
    }

    public static JT808MessageHeader2011 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808MessageHeader2011 header = new JT808MessageHeader2011();
        header.deserialize(ctx, reader);
        return header;
    }
}
