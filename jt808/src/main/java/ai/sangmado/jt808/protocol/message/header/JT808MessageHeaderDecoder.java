package ai.sangmado.jt808.protocol.message.header;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.enums.IMessageId;
import ai.sangmado.jt808.protocol.enums.IProtocolVersion;
import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.jt808.protocol.enums.JT808ProtocolVersion;
import ai.sangmado.jt808.protocol.exceptions.UnsupportedJT808ProtocolVersionException;

import static ai.sangmado.jt808.protocol.enums.JT808ProtocolVersion.*;

/**
 * JT808消息头解码器
 */
public final class JT808MessageHeaderDecoder {

    @SuppressWarnings("unchecked")
    public static <TMessageId extends IMessageId, TProtocolVersion extends IProtocolVersion> JT808MessageHeader<TMessageId, TProtocolVersion> decode(
            ISpecificationContext<TProtocolVersion> ctx, IJT808MessageBufferReader reader) {
        if (!(ctx.getProtocolVersion() instanceof JT808ProtocolVersion)) {
            throw new UnsupportedJT808ProtocolVersionException("协议不匹配: " + ctx.getProtocolVersion());
        }

        JT808MessageHeader<JT808MessageId, JT808ProtocolVersion> header;
        if (ctx.getProtocolVersion().equals(V2011)) {
            header = new JT808MessageHeader2011();
            header.deserialize((ISpecificationContext<JT808ProtocolVersion>) ctx, reader);
        } else if (ctx.getProtocolVersion().equals(V2013)) {
            header = new JT808MessageHeader2013();
            header.deserialize((ISpecificationContext<JT808ProtocolVersion>) ctx, reader);
        } else if (ctx.getProtocolVersion().equals(V2019)) {
            header = new JT808MessageHeader2019();
            header.deserialize((ISpecificationContext<JT808ProtocolVersion>) ctx, reader);
        } else {
            throw new UnsupportedJT808ProtocolVersionException();
        }
        return (JT808MessageHeader<TMessageId, TProtocolVersion>) header;
    }
}
