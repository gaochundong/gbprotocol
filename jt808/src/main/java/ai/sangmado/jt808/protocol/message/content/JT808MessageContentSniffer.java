package ai.sangmado.jt808.protocol.message.content;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.enums.IMessageId;
import ai.sangmado.jt808.protocol.enums.IProtocolVersion;
import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.jt808.protocol.exceptions.UnsupportedJT808MessageException;
import ai.sangmado.jt808.protocol.message.header.JT808MessageHeader;

/**
 * JT808消息体嗅探器
 */
public final class JT808MessageContentSniffer {

    public static <TMessageId extends IMessageId, TProtocolVersion extends IProtocolVersion> JT808MessageContent<TMessageId, TProtocolVersion> sniff(
            ISpecificationContext<TProtocolVersion> ctx,
            IJT808MessageBufferReader reader,
            JT808MessageHeader<TMessageId, TProtocolVersion> header) {
        throw new UnsupportedJT808MessageException();
//        JT808MessageContent<JT808MessageId, TProtocolVersion> content;
//        if (header.getMessageId().equals(JT808MessageId.JT808_Message_0x0100)) {
//            //content = new JT808_Message_Content_0x0100();
//            //content.deserialize(ctx, reader);
//        } else if (header.getMessageId().equals(JT808MessageId.JT808_Message_0x8100)) {
//            //content = new JT808_Message_Content_0x8100();
//            //content.deserialize(ctx, reader);
//        } else {
//            throw new UnsupportedJT808MessageException(header.getMessageId());
//        }
//        return content;
    }
}
