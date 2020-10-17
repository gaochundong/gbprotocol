package ai.sangmado.gbprotocol.jt808.protocol;

import ai.sangmado.gbprotocol.gbcommon.memory.IBufferPool;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808OperationException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.ByteOrder;
import java.nio.charset.Charset;

/**
 * JT808 协议上下文
 */
@NoArgsConstructor
@AllArgsConstructor
public class JT808ProtocolSpecificationContext implements ISpecificationContext {
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
    public JT808ProtocolSpecificationContext clone() {
        try {
            return JT808ProtocolSpecificationContext
                    .newInstance()
                    .withByteOrder(this.getByteOrder())
                    .withCharset(this.getCharset())
                    .withBufferPool(this.getBufferPool());
        } catch (Exception ex) {
            throw new UnsupportedJT808OperationException("克隆对象失败", ex);
        }
    }

    public static JT808ProtocolSpecificationContext newInstance() {
        return new JT808ProtocolSpecificationContext();
    }

    public JT808ProtocolSpecificationContext withByteOrder(ByteOrder byteOrder) {
        this.setByteOrder(byteOrder);
        return this;
    }

    public JT808ProtocolSpecificationContext withCharset(Charset charset) {
        this.setCharset(charset);
        return this;
    }

    public JT808ProtocolSpecificationContext withBufferPool(IBufferPool bufferPool) {
        this.setBufferPool(bufferPool);
        return this;
    }
}
