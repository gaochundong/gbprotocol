package ai.sangmado.gbprotocol.jt808.protocol.message;

import ai.sangmado.gbprotocol.gbcommon.memory.PooledByteArray;
import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808MessageException;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808ProtocolVersionException;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContentRegistration;
import ai.sangmado.gbprotocol.jt808.protocol.message.header.JT808MessageHeader;
import ai.sangmado.gbprotocol.jt808.protocol.message.header.JT808MessageHeaderRegistration;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.impl.JT808MessageByteBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.impl.JT808MessageByteBufferWriter;

import java.nio.ByteBuffer;

/**
 * JT808 消息读取器
 */
@SuppressWarnings("unchecked")
public final class JT808MessageReader {

    /**
     * 读取消息头
     *
     * @param ctx    上下文
     * @param reader 数据源
     * @return 消息头
     */
    public static JT808MessageHeader readMessageHeader(
            ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        if (!JT808MessageHeaderRegistration.getDecoders().containsKey(ctx.getProtocolVersion())) {
            throw new UnsupportedJT808ProtocolVersionException(ctx.getProtocolVersion());
        }

        return JT808MessageHeaderRegistration
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
    public static JT808MessageContent readMessageContent(
            ISpecificationContext ctx, IJT808MessageBufferReader reader, JT808MessageHeader header) {
        if (!JT808MessageContentRegistration.getDecoders().containsKey(header.getMessageId())) {
            throw new UnsupportedJT808MessageException(header.getMessageId());
        }
        PooledByteArray pba = ctx.getBufferPool().borrow();
        try {
            ByteBuffer buf = ByteBuffer.wrap(pba.array());
            IJT808MessageBufferWriter bufWriter = new JT808MessageByteBufferWriter(ctx, buf);

            // 拷贝与消息体长度相等的数据
            int contentLength = header.getMessageContentProperty().getContentLength();
            while (contentLength > 0) {
                bufWriter.writeByte(reader.readByte());
                contentLength--;
            }
            buf.flip();

            IJT808MessageBufferReader bufReader = new JT808MessageByteBufferReader(ctx, buf);
            return JT808MessageContentRegistration
                    .getDecoders()
                    .get(header.getMessageId())
                    .apply(ctx, bufReader);
        } finally {
            ctx.getBufferPool().recycle(pba);
        }
    }
}
