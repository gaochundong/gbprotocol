package ai.sangmado.gbprotocol.gb32960.protocol.message.content.platform;

import ai.sangmado.gbprotocol.gb32960.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960PlatformCommandId;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.IGB32960MessageBufferWriter;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.IGB32960MessageFormatter;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.impl.GB32960MessageByteBufferWriter;
import ai.sangmado.gbprotocol.gbcommon.memory.PooledByteArray;

import java.nio.ByteBuffer;

/**
 * GB32960 数据单元 (平台)
 */
public abstract class GB32960PlatformMessageContent implements IGB32960MessageFormatter {

    /**
     * 获取命令ID
     *
     * @return 命令ID
     */
    public abstract GB32960PlatformCommandId getCommandId();

    /**
     * 获取数据单元长度
     *
     * @param ctx 协议规范上下文
     * @return 数据单元长度
     */
    public int getContentLength(ISpecificationContext ctx) {
        PooledByteArray pba = ctx.getBufferPool().borrow();
        try {
            ByteBuffer buf = ByteBuffer.wrap(pba.array());
            IGB32960MessageBufferWriter bufWriter = new GB32960MessageByteBufferWriter(ctx, buf);
            this.serialize(ctx, bufWriter);
            buf.flip();
            return buf.remaining();
        } finally {
            ctx.getBufferPool().recycle(pba);
        }
    }
}
