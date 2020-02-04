package ai.sangmado.jt808.protocol.message.header;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.exceptions.UnsupportedJT808ProtocolVersionException;
import ai.sangmado.jt808.protocol.message.encoding.IJT808MessageBufferReader;

/**
 * JT808消息头工厂
 */
public final class JT808MessageHeaderFactory {

    public static JT808MessageHeader buildWith(ISpecificationContext ctx) {
        switch (ctx.getJT808ProtocolVersion()) {
            case V2011: {
                JT808MessageHeaderMessageContentProperty2011 messageContentProperty =
                        JT808MessageHeaderMessageContentProperty2011.builder()
                                .isMultiplePackets(true)
                                .encryptionMode(ctx.getMessageContentEncryptionMode())
                                .build();
                return JT808MessageHeader2011.builder()
                        .messageContentProperty(messageContentProperty)
                        .messagePacketProperty(new JT808MessageHeaderMessagePacketProperty())
                        .build();
            }
            case V2013: {
                JT808MessageHeaderMessageContentProperty2013 messageContentProperty =
                        JT808MessageHeaderMessageContentProperty2013.builder()
                                .isMultiplePackets(true)
                                .encryptionMode(ctx.getMessageContentEncryptionMode())
                                .build();
                return JT808MessageHeader2013.builder()
                        .messageContentProperty(messageContentProperty)
                        .messagePacketProperty(new JT808MessageHeaderMessagePacketProperty())
                        .build();
            }
            case V2019: {
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
            }
            default:
                throw new UnsupportedJT808ProtocolVersionException();
        }
    }

    public static JT808MessageHeader deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808MessageHeader header;
        switch (ctx.getJT808ProtocolVersion()) {
            case V2011: {
                header = new JT808MessageHeader2011();
                header.deserialize(ctx, reader);
                break;
            }
            case V2013: {
                header = new JT808MessageHeader2013();
                header.deserialize(ctx, reader);
                break;
            }
            case V2019: {
                header = new JT808MessageHeader2019();
                header.deserialize(ctx, reader);
                break;
            }
            default:
                throw new UnsupportedJT808ProtocolVersionException();
        }
        return header;
    }
}
