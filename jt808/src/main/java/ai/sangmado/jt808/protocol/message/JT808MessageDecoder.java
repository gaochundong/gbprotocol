package ai.sangmado.jt808.protocol.message;

import ai.sangmado.gbcommon.memory.PooledByteArray;
import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.encoding.impl.JT808MessageByteBufferReader;
import ai.sangmado.jt808.protocol.encoding.impl.JT808MessageByteBufferWriter;
import ai.sangmado.jt808.protocol.exceptions.UnsupportedJT808MessageException;
import ai.sangmado.jt808.protocol.exceptions.UnsupportedJT808ProtocolVersionException;
import ai.sangmado.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.jt808.protocol.message.content.JT808MessageContentRegistration;
import ai.sangmado.jt808.protocol.message.header.JT808MessageHeader;
import ai.sangmado.jt808.protocol.message.header.JT808MessageHeaderRegistration;

import java.nio.ByteBuffer;

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
        PooledByteArray pba = ctx.getByteArrayPool().borrow();
        try {
            ByteBuffer buf = ByteBuffer.wrap(pba.array());
            IJT808MessageBufferWriter bufWriter = new JT808MessageByteBufferWriter(ctx, buf);

            int contentLength = header.getMessageContentProperty().getContentLength();
            while (contentLength > 0) {
                bufWriter.writeByte(reader.readByte());
                contentLength--;
            }
            buf.flip();

            IJT808MessageBufferReader bufReader = new JT808MessageByteBufferReader(ctx, buf);
            return JT808MessageContentRegistration.getDecoders().get(header.getMessageId()).apply(ctx, bufReader);
        } finally {
            ctx.getByteArrayPool().recycle(pba);
        }
    }
}
