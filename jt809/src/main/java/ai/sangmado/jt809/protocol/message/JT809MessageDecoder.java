package ai.sangmado.jt809.protocol.message;

import ai.sangmado.gbcommon.memory.PooledByteArray;
import ai.sangmado.jt809.protocol.ISpecificationContext;
import ai.sangmado.jt809.protocol.encoding.IJT809MessageBufferReader;
import ai.sangmado.jt809.protocol.encoding.IJT809MessageBufferWriter;
import ai.sangmado.jt809.protocol.encoding.impl.JT809MessageByteBufferReader;
import ai.sangmado.jt809.protocol.encoding.impl.JT809MessageByteBufferWriter;
import ai.sangmado.jt809.protocol.exceptions.UnsupportedJT809MessageException;
import ai.sangmado.jt809.protocol.exceptions.UnsupportedJT809ProtocolVersionException;
import ai.sangmado.jt809.protocol.message.content.JT809MessageContent;
import ai.sangmado.jt809.protocol.message.content.JT809MessageContentRegistration;
import ai.sangmado.jt809.protocol.message.header.JT809MessageHeader;
import ai.sangmado.jt809.protocol.message.header.JT809MessageHeaderRegistration;

import java.nio.ByteBuffer;

/**
 * JT809 消息包解码器
 */
public class JT809MessageDecoder implements IJT809MessageDecoder {

    public static final JT809MessageDecoder Default = new JT809MessageDecoder();

    @Override
    public JT809MessageHeader decodeHeader(
            ISpecificationContext ctx, IJT809MessageBufferReader reader) {
        if (!JT809MessageHeaderRegistration.getDecoders().containsKey(ctx.getProtocolVersion())) {
            throw new UnsupportedJT809ProtocolVersionException(ctx.getProtocolVersion());
        }
        return JT809MessageHeaderRegistration.getDecoders().get(ctx.getProtocolVersion()).apply(ctx, reader);
    }

    @Override
    public JT809MessageContent decodeContent(
            ISpecificationContext ctx, IJT809MessageBufferReader reader, JT809MessageHeader header) {
        if (!JT809MessageContentRegistration.getDecoders().containsKey(header.getMessageId())) {
            throw new UnsupportedJT809MessageException(header.getMessageId());
        }
        PooledByteArray pba = ctx.getByteArrayPool().borrow();
        try {
            ByteBuffer buf = ByteBuffer.wrap(pba.array());
            IJT809MessageBufferWriter bufWriter = new JT809MessageByteBufferWriter(ctx, buf);

            // 拷贝与消息体长度相等的数据
            long contentLength = header.getMessageLength();
            while (contentLength > 0) {
                bufWriter.writeByte(reader.readByte());
                contentLength--;
            }
            buf.flip();

            IJT809MessageBufferReader bufReader = new JT809MessageByteBufferReader(ctx, buf);
            return JT809MessageContentRegistration.getDecoders().get(header.getMessageId()).apply(ctx, bufReader);
        } finally {
            ctx.getByteArrayPool().recycle(pba);
        }
    }
}
