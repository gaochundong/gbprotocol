package ai.sangmado.gbprotocol.gb32960.protocol;

import ai.sangmado.gbprotocol.gb32960.protocol.exceptions.UnsupportedGB32960OperationException;
import ai.sangmado.gbprotocol.gbcommon.memory.IBufferPool;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.ByteOrder;
import java.nio.charset.Charset;

/**
 * GB32960 协议上下文
 */
@NoArgsConstructor
@AllArgsConstructor
public class GB32960ProtocolSpecificationContext implements ISpecificationContext {
    /**
     * 字节序
     */
    @Getter
    @Setter
    private ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
    /**
     * 字符集
     */
    @Getter
    @Setter
    private Charset charset = Charset.forName("GBK");
    /**
     * 数组池
     */
    @Getter
    @Setter
    private IBufferPool bufferPool = null;

    @Override
    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public GB32960ProtocolSpecificationContext clone() {
        try {
            return GB32960ProtocolSpecificationContext.newInstance()
                    .withByteOrder(this.getByteOrder())
                    .withCharset(this.getCharset())
                    .withBufferPool(this.getBufferPool());
        } catch (Exception ex) {
            throw new UnsupportedGB32960OperationException("克隆对象失败", ex);
        }
    }

    public static GB32960ProtocolSpecificationContext newInstance() {
        return new GB32960ProtocolSpecificationContext();
    }

    public GB32960ProtocolSpecificationContext withByteOrder(ByteOrder byteOrder) {
        this.setByteOrder(byteOrder);
        return this;
    }

    public GB32960ProtocolSpecificationContext withCharset(Charset charset) {
        this.setCharset(charset);
        return this;
    }

    public GB32960ProtocolSpecificationContext withBufferPool(IBufferPool bufferPool) {
        this.setBufferPool(bufferPool);
        return this;
    }
}
