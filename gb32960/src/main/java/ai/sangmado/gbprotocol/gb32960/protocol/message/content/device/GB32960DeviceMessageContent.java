package ai.sangmado.gbprotocol.gb32960.protocol.message.content.device;

import ai.sangmado.gbprotocol.gb32960.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960DeviceCommandId;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.IGB32960MessageBufferWriter;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.IGB32960MessageFormatter;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.impl.GB32960MessageByteBufferWriter;
import ai.sangmado.gbprotocol.gbcommon.memory.PooledByteArray;

import java.nio.ByteBuffer;

/**
 * GB32960 数据单元 (终端)
 */
public abstract class GB32960DeviceMessageContent implements IGB32960MessageFormatter {

    /**
     * 获取命令ID
     *
     * @return 命令ID
     */
    public abstract GB32960DeviceCommandId getCommandId();

    /**
     * 获取数据单元长度
     *
     * @param ctx 协议规范上下文
     * @return 数据单元长度
     */
    public int getContentLength(IVersionedSpecificationContext ctx) {
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
