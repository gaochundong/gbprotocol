package ai.sangmado.gbprotocol.jt808.protocol.message.header;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808ProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808OperationException;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808ProtocolVersionException;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.CharMatcher;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.google.common.base.Strings.nullToEmpty;
import static com.google.common.base.Strings.padStart;

/**
 * JT808 V2013版本 消息头
 */
@Getter
@Setter
@NoArgsConstructor
public class JT808MessageHeader2013 extends JT808MessageHeader {
    public static final JT808ProtocolVersion PROTOCOL_VERSION = JT808ProtocolVersion.V2013;

    @Builder
    public JT808MessageHeader2013(
            JT808MessageId messageId,
            JT808MessageHeaderMessageContentProperty messageContentProperty,
            Integer serialNumber,
            JT808MessageHeaderMessagePacketProperty messagePacketProperty,
            String phoneNumber) {
        super(messageId, messageContentProperty, serialNumber, messagePacketProperty, phoneNumber);
    }

    @Override
    @JsonProperty(index = 100)
    public JT808ProtocolVersion getProtocolVersion() {
        return PROTOCOL_VERSION;
    }

    @Override
    public JT808MessageHeader clone() {
        try {
            return JT808MessageHeader2013.builder()
                    .messageId(this.getMessageId())
                    .messageContentProperty(this.getMessageContentProperty() == null ? null : this.getMessageContentProperty().clone())
                    .serialNumber(this.getSerialNumber())
                    .messagePacketProperty(this.getMessagePacketProperty() == null ? null : this.getMessagePacketProperty().clone())
                    .phoneNumber(this.getPhoneNumber())
                    .build();
        } catch (Exception ex) {
            throw new UnsupportedJT808OperationException("克隆对象失败", ex);
        }
    }

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {
        // 消息ID
        writer.writeWord(getMessageId().getValue());

        final char padChar = '0'; // 补数字0
        if (ctx.getProtocolVersion().equals(PROTOCOL_VERSION)) {
            // 消息体属性
            writer.writeWord(getMessageContentProperty().marshal());
            // 终端手机号 BCD[6]
            writer.writeBCD(padStart(nullToEmpty(getPhoneNumber()), 6 * 2, padChar));
        } else {
            throw new UnsupportedJT808ProtocolVersionException(ctx.getProtocolVersion());
        }

        // 消息流水号
        writer.writeWord(getSerialNumber());

        // 消息包封装项
        if (getMessageContentProperty().getIsMultiplePackets()) {
            writer.writeWord(getMessagePacketProperty().getTotalPackets());
            writer.writeWord(getMessagePacketProperty().getPacketSequence());
        }
    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        // 消息ID
        setMessageId(JT808MessageId.cast(reader.readWord()));

        final String padChar = "0"; // 补数字0
        int contentPropertyValue = reader.readWord();
        if (ctx.getProtocolVersion().equals(PROTOCOL_VERSION)) {
            JT808MessageHeaderMessageContentProperty2013 property = new JT808MessageHeaderMessageContentProperty2013();
            property.release(contentPropertyValue);
            // 消息体属性
            setMessageContentProperty(property);
            // 终端手机号 BCD[6]
            setPhoneNumber(CharMatcher.anyOf(padChar).trimLeadingFrom(reader.readBCD(6)));
        } else {
            throw new UnsupportedJT808ProtocolVersionException(ctx.getProtocolVersion());
        }

        // 消息流水号
        setSerialNumber(reader.readWord());

        // 消息包封装项
        if (getMessageContentProperty().getIsMultiplePackets()) {
            JT808MessageHeaderMessagePacketProperty property = new JT808MessageHeaderMessagePacketProperty();
            property.setTotalPackets(reader.readWord());
            property.setPacketSequence(reader.readWord());
            setMessagePacketProperty(property);
        }
    }

    public static JT808MessageHeader2013 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808MessageHeader2013 header = new JT808MessageHeader2013();
        header.deserialize(ctx, reader);
        return header;
    }
}
