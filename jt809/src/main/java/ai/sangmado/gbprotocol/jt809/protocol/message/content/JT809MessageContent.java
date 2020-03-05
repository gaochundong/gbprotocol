package ai.sangmado.gbprotocol.jt809.protocol.message.content;

import ai.sangmado.gbprotocol.gbcommon.memory.PooledByteArray;
import ai.sangmado.gbprotocol.jt809.protocol.serialization.IJT809MessageBufferWriter;
import ai.sangmado.gbprotocol.jt809.protocol.serialization.IJT809MessageFormatter;
import ai.sangmado.gbprotocol.jt809.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt809.protocol.serialization.impl.JT809MessageByteBufferWriter;
import ai.sangmado.gbprotocol.jt809.protocol.enums.JT809MessageId;

import java.nio.ByteBuffer;

/**
 * JT809 消息体
 */
public abstract class JT809MessageContent implements IJT809MessageFormatter {

    /**
     * 获取消息体定义的消息ID
     *
     * @return 消息ID
     */
    public abstract JT809MessageId getMessageId();

    /**
     * 获取消息体长度
     *
     * @param ctx 协议规范上下文
     * @return 消息体长度
     */
    public int getContentLength(ISpecificationContext ctx) {
        PooledByteArray pba = ctx.getByteArrayPool().borrow();
        try {
            ByteBuffer buf = ByteBuffer.wrap(pba.array());
            IJT809MessageBufferWriter bufWriter = new JT809MessageByteBufferWriter(ctx, buf);
            this.serialize(ctx, bufWriter);
            buf.flip();
            return buf.remaining();
        } finally {
            ctx.getByteArrayPool().recycle(pba);
        }
    }
}
