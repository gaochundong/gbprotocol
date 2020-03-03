package ai.sangmado.gbstandard.jt809.protocol.message.content.JT809_Message_Content_0x1400_Sub;

import ai.sangmado.gbstandard.gbcommon.memory.PooledByteArray;
import ai.sangmado.gbstandard.jt809.protocol.ISpecificationContext;
import ai.sangmado.gbstandard.jt809.protocol.encoding.IJT809MessageBufferWriter;
import ai.sangmado.gbstandard.jt809.protocol.encoding.IJT809MessageFormatter;
import ai.sangmado.gbstandard.jt809.protocol.encoding.impl.JT809MessageByteBufferWriter;
import ai.sangmado.gbstandard.jt809.protocol.enums.JT809SubMessageId;
import lombok.NoArgsConstructor;

import java.nio.ByteBuffer;

/**
 * 主链路报警信息交互消息 UP_WARN_MSG - 子消息
 */
@NoArgsConstructor
public abstract class JT809_Message_Content_0x1400_SubMessage implements IJT809MessageFormatter {

    /**
     * 获取子消息ID
     *
     * @return 子消息ID
     */
    public abstract JT809SubMessageId getSubMessageId();

    /**
     * 获取子消息体长度
     *
     * @param ctx 协议规范上下文
     * @return 子消息体长度
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
