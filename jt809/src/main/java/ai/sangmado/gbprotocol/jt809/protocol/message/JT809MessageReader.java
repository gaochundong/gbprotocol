package ai.sangmado.gbprotocol.jt809.protocol.message;

import ai.sangmado.gbprotocol.gbcommon.memory.PooledByteArray;
import ai.sangmado.gbprotocol.jt809.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt809.protocol.exceptions.UnsupportedJT809MessageException;
import ai.sangmado.gbprotocol.jt809.protocol.exceptions.UnsupportedJT809ProtocolVersionException;
import ai.sangmado.gbprotocol.jt809.protocol.message.content.JT809MessageContent;
import ai.sangmado.gbprotocol.jt809.protocol.message.content.JT809MessageContentRegistration;
import ai.sangmado.gbprotocol.jt809.protocol.message.header.JT809MessageHeader;
import ai.sangmado.gbprotocol.jt809.protocol.message.header.JT809MessageHeaderRegistration;
import ai.sangmado.gbprotocol.jt809.protocol.serialization.IJT809MessageBufferReader;
import ai.sangmado.gbprotocol.jt809.protocol.serialization.IJT809MessageBufferWriter;
import ai.sangmado.gbprotocol.jt809.protocol.serialization.impl.JT809MessageByteBufferReader;
import ai.sangmado.gbprotocol.jt809.protocol.serialization.impl.JT809MessageByteBufferWriter;

import java.nio.ByteBuffer;

/**
 * JT809 消息读取器
 */
public final class JT809MessageReader {

    /**
     * 读取消息头
     *
     * @param ctx    上下文
     * @param reader 数据源
     * @return 消息头
     */
    public static JT809MessageHeader readMessageHeader(
            ISpecificationContext ctx, IJT809MessageBufferReader reader) {
        if (!JT809MessageHeaderRegistration.getDecoders().containsKey(ctx.getProtocolVersion())) {
            throw new UnsupportedJT809ProtocolVersionException(ctx.getProtocolVersion());
        }
        return JT809MessageHeaderRegistration
                .getDecoders()
                .get(ctx.getProtocolVersion())
                .apply(ctx, reader);
    }

    /**
     * 读取消息体
     *
     * @param ctx    上下文
     * @param reader 数据源
     * @param header 消息头
     * @return 消息体
     */
    public static JT809MessageContent readMessageContent(
            ISpecificationContext ctx, IJT809MessageBufferReader reader, JT809MessageHeader header) {
        if (!JT809MessageContentRegistration.getDecoders().containsKey(header.getMessageId())) {
            throw new UnsupportedJT809MessageException(header.getMessageId());
        }
        PooledByteArray pba = ctx.getBufferPool().borrow();
        try {
            ByteBuffer buf = ByteBuffer.wrap(pba.array());
            IJT809MessageBufferWriter bufWriter = new JT809MessageByteBufferWriter(ctx, buf);

            // 拷贝与消息体长度相等的数据
            long contentLength = header.getMessageLength() - header.getMessageLengthWithoutContent();
            while (contentLength > 0) {
                bufWriter.writeByte(reader.readByte());
                contentLength--;
            }
            buf.flip();

            IJT809MessageBufferReader bufReader = new JT809MessageByteBufferReader(ctx, buf);
            return JT809MessageContentRegistration
                    .getDecoders()
                    .get(header.getMessageId())
                    .apply(ctx, bufReader);
        } finally {
            ctx.getBufferPool().recycle(pba);
        }
    }
}
