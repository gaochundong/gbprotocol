package ai.sangmado.jt1078.protocol.message.content;

import ai.sangmado.jt1078.protocol.enums.JT1078MessageId;
import ai.sangmado.jt1078.protocol.enums.JT1078ProtocolVersion;
import ai.sangmado.jt1078.protocol.exceptions.UnsupportedJT1078ProtocolVersionException;
import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.enums.IMessageId;
import ai.sangmado.jt808.protocol.enums.IProtocolVersion;
import ai.sangmado.jt808.protocol.exceptions.UnsupportedJT808MessageException;
import ai.sangmado.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.jt808.protocol.message.header.JT808MessageHeader;

/**
 * JT808消息体解码器
 */
public final class JT1078MessageContentDecoder {

    @SuppressWarnings("unchecked")
    public static <TMessageId extends IMessageId, TProtocolVersion extends IProtocolVersion> JT808MessageContent<TMessageId, TProtocolVersion> decode(
            ISpecificationContext<TProtocolVersion> ctx,
            IJT808MessageBufferReader reader,
            JT808MessageHeader<TMessageId, TProtocolVersion> header) {
        if (!(ctx.getProtocolVersion() instanceof JT1078ProtocolVersion)) {
            throw new UnsupportedJT1078ProtocolVersionException("协议不匹配: " + ctx.getProtocolVersion());
        }

        JT808MessageContent<JT1078MessageId, JT1078ProtocolVersion> content;
        if (header.getMessageId().equals(JT1078MessageId.JT1078_Message_0x1003)) {
            content = new JT1078_Message_Content_0x1003();
            content.deserialize((ISpecificationContext<JT1078ProtocolVersion>) ctx, reader);
        } else if (header.getMessageId().equals(JT1078MessageId.JT1078_Message_0x1005)) {
            content = new JT1078_Message_Content_0x1005();
            content.deserialize((ISpecificationContext<JT1078ProtocolVersion>) ctx, reader);
        } else if (header.getMessageId().equals(JT1078MessageId.JT1078_Message_0x9003)) {
            content = new JT1078_Message_Content_0x9003();
            content.deserialize((ISpecificationContext<JT1078ProtocolVersion>) ctx, reader);
        } else if (header.getMessageId().equals(JT1078MessageId.JT1078_Message_0x9101)) {
            content = new JT1078_Message_Content_0x9101();
            content.deserialize((ISpecificationContext<JT1078ProtocolVersion>) ctx, reader);
        } else if (header.getMessageId().equals(JT1078MessageId.JT1078_Message_0x9105)) {
            content = new JT1078_Message_Content_0x9105();
            content.deserialize((ISpecificationContext<JT1078ProtocolVersion>) ctx, reader);
        } else {
            throw new UnsupportedJT808MessageException(header.getMessageId());
        }
        return (JT808MessageContent<TMessageId, TProtocolVersion>) content;
    }
}
