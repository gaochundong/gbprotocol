package ai.sangmado.jt808.protocol.message.content;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.enums.IMessageId;
import ai.sangmado.jt808.protocol.enums.IProtocolVersion;
import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.jt808.protocol.enums.JT808ProtocolVersion;
import ai.sangmado.jt808.protocol.exceptions.UnsupportedJT808MessageException;
import ai.sangmado.jt808.protocol.exceptions.UnsupportedJT808ProtocolVersionException;
import ai.sangmado.jt808.protocol.message.header.JT808MessageHeader;

/**
 * JT808消息体解码器
 */
public final class JT808MessageContentDecoder {

    @SuppressWarnings("unchecked")
    public static <TMessageId extends IMessageId, TProtocolVersion extends IProtocolVersion> JT808MessageContent<TMessageId, TProtocolVersion> decode(
            ISpecificationContext<TProtocolVersion> ctx,
            IJT808MessageBufferReader reader,
            JT808MessageHeader<TMessageId, TProtocolVersion> header) {
        if (!(ctx.getProtocolVersion() instanceof JT808ProtocolVersion)) {
            throw new UnsupportedJT808ProtocolVersionException("协议不匹配: " + ctx.getProtocolVersion());
        }

        JT808MessageContent<JT808MessageId, JT808ProtocolVersion> content;
        if (header.getMessageId().equals(JT808MessageId.JT808_Message_0x0100)) {
            content = new JT808_Message_Content_0x0100();
            content.deserialize((ISpecificationContext<JT808ProtocolVersion>) ctx, reader);
        } else if (header.getMessageId().equals(JT808MessageId.JT808_Message_0x0200)) {
            content = new JT808_Message_Content_0x0200<>();
            content.deserialize((ISpecificationContext<JT808ProtocolVersion>) ctx, reader);
        } else if (header.getMessageId().equals(JT808MessageId.JT808_Message_0x8100)) {
            content = new JT808_Message_Content_0x8100();
            content.deserialize((ISpecificationContext<JT808ProtocolVersion>) ctx, reader);
        } else if (header.getMessageId().equals(JT808MessageId.JT808_Message_0x8103)) {
            content = new JT808_Message_Content_0x8103<>();
            content.deserialize((ISpecificationContext<JT808ProtocolVersion>) ctx, reader);
        } else {
            throw new UnsupportedJT808MessageException(header.getMessageId());
        }
        return (JT808MessageContent<TMessageId, TProtocolVersion>) content;
    }
}
