package ai.sangmado.gbstandard.jt808.protocol.message.header;

import ai.sangmado.gbstandard.jt808.protocol.enums.JT808ProtocolVersion;
import ai.sangmado.gbstandard.jt808.protocol.exceptions.UnsupportedJT808ProtocolVersionException;
import ai.sangmado.gbstandard.jt808.protocol.ISpecificationContext;

/**
 * JT808消息头工厂
 */
public final class JT808MessageHeaderFactory {

    public static JT808MessageHeader buildWith(ISpecificationContext ctx) {
        if (ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2011)) {
            JT808MessageHeaderMessageContentProperty2011 messageContentProperty =
                    JT808MessageHeaderMessageContentProperty2011.builder()
                            .isMultiplePackets(true)
                            .encryptionMode(ctx.getMessageContentEncryptionMode())
                            .build();
            return JT808MessageHeader2011.builder()
                    .messageContentProperty(messageContentProperty)
                    .messagePacketProperty(new JT808MessageHeaderMessagePacketProperty())
                    .build();
        } else if (ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2013)) {
            JT808MessageHeaderMessageContentProperty2013 messageContentProperty =
                    JT808MessageHeaderMessageContentProperty2013.builder()
                            .isMultiplePackets(true)
                            .encryptionMode(ctx.getMessageContentEncryptionMode())
                            .build();
            return JT808MessageHeader2013.builder()
                    .messageContentProperty(messageContentProperty)
                    .messagePacketProperty(new JT808MessageHeaderMessagePacketProperty())
                    .build();
        } else if (ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2019)) {
            JT808MessageHeaderMessageContentProperty2019 messageContentProperty =
                    JT808MessageHeaderMessageContentProperty2019.builder()
                            .isMultiplePackets(true)
                            .encryptionMode(ctx.getMessageContentEncryptionMode())
                            .build();
            return JT808MessageHeader2019.builder()
                    .protocolVersion((byte) 1)
                    .messageContentProperty(messageContentProperty)
                    .messagePacketProperty(new JT808MessageHeaderMessagePacketProperty())
                    .build();
        } else {
            throw new UnsupportedJT808ProtocolVersionException();
        }
    }
}
