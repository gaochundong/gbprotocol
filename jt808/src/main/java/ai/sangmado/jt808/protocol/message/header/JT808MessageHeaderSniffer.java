package ai.sangmado.jt808.protocol.message.header;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.enums.IMessageId;
import ai.sangmado.jt808.protocol.enums.IProtocolVersion;
import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.jt808.protocol.enums.JT808ProtocolVersion;
import ai.sangmado.jt808.protocol.exceptions.UnsupportedJT808ProtocolVersionException;

/**
 * JT808消息头嗅探器
 */
public final class JT808MessageHeaderSniffer {

    public static <TMessageId extends IMessageId, TProtocolVersion extends IProtocolVersion> JT808MessageHeader<TMessageId, TProtocolVersion> sniff(
            ISpecificationContext<TProtocolVersion> ctx, IJT808MessageBufferReader reader) {
        JT808MessageHeader<TMessageId, TProtocolVersion> header = null;
//        switch (ctx.getProtocolVersion()) {
//            case V2011: {
//                header = new JT808MessageHeader2011();
//                header.deserialize(ctx, reader);
//                break;
//            }
//            case V2013: {
//                header = new JT808MessageHeader2013();
//                header.deserialize(ctx, reader);
//                break;
//            }
//            case V2019: {
//                header = new JT808MessageHeader2019();
//                header.deserialize(ctx, reader);
//                break;
//            }
//            default:
//                throw new UnsupportedJT808ProtocolVersionException();
//        }
        return header;
    }
}
