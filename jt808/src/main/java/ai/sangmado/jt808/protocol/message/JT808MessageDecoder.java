package ai.sangmado.jt808.protocol.message;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.exceptions.UnsupportedJT808MessageException;
import ai.sangmado.jt808.protocol.exceptions.UnsupportedJT808ProtocolVersionException;
import ai.sangmado.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.jt808.protocol.message.content.JT808MessageContentRegistration;
import ai.sangmado.jt808.protocol.message.header.JT808MessageHeader;
import ai.sangmado.jt808.protocol.message.header.JT808MessageHeaderRegistration;

/**
 * JT808 消息包解码器
 */
public class JT808MessageDecoder implements IJT808MessageDecoder {

    public static final JT808MessageDecoder Default = new JT808MessageDecoder();

    @Override
    public JT808MessageHeader decodeHeader(
            ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        if (!JT808MessageHeaderRegistration.getDecoders().containsKey(ctx.getProtocolVersion())) {
            throw new UnsupportedJT808ProtocolVersionException(ctx.getProtocolVersion());
        }
        return JT808MessageHeaderRegistration.getDecoders().get(ctx.getProtocolVersion()).apply(ctx, reader);
    }

    @Override
    public JT808MessageContent decodeContent(
            ISpecificationContext ctx, IJT808MessageBufferReader reader, JT808MessageHeader header) {
        if (!JT808MessageContentRegistration.getDecoders().containsKey(header.getMessageId())) {
            throw new UnsupportedJT808MessageException(header.getMessageId());
        }
        return JT808MessageContentRegistration.getDecoders().get(header.getMessageId()).apply(ctx, reader);
    }
}
