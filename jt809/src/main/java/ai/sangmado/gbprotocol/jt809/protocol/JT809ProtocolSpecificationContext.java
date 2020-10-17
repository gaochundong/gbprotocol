package ai.sangmado.gbprotocol.jt809.protocol;

import ai.sangmado.gbprotocol.gbcommon.memory.IBufferPool;
import ai.sangmado.gbprotocol.jt809.protocol.enums.JT809MessageContentEncryptionOptions;
import ai.sangmado.gbprotocol.jt809.protocol.exceptions.UnsupportedJT809OperationException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.ByteOrder;
import java.nio.charset.Charset;

/**
 * JT809 协议上下文
 */
@NoArgsConstructor
@AllArgsConstructor
public class JT809ProtocolSpecificationContext implements ISpecificationContext {

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
     * 消息体加密参数
     */
    @Getter
    @Setter
    private JT809MessageContentEncryptionOptions messageContentEncryptionOptions = null;
    /**
     * 数组池
     */
    @Getter
    @Setter
    private IBufferPool bufferPool = null;

    @Override
    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public JT809ProtocolSpecificationContext clone() {
        try {
            return JT809ProtocolSpecificationContext
                    .newInstance()
                    .withByteOrder(this.getByteOrder())
                    .withCharset(this.getCharset())
                    .withMessageContentEncryptionOptions(this.getMessageContentEncryptionOptions())
                    .withBufferPool(this.getBufferPool());
        } catch (Exception ex) {
            throw new UnsupportedJT809OperationException("克隆对象失败", ex);
        }
    }

    public static JT809ProtocolSpecificationContext newInstance() {
        return new JT809ProtocolSpecificationContext();
    }

    public JT809ProtocolSpecificationContext withByteOrder(ByteOrder byteOrder) {
        this.setByteOrder(byteOrder);
        return this;
    }

    public JT809ProtocolSpecificationContext withCharset(Charset charset) {
        this.setCharset(charset);
        return this;
    }

    public JT809ProtocolSpecificationContext withMessageContentEncryptionOptions(JT809MessageContentEncryptionOptions messageContentEncryptionOptions) {
        this.setMessageContentEncryptionOptions(messageContentEncryptionOptions);
        return this;
    }

    public JT809ProtocolSpecificationContext withBufferPool(IBufferPool bufferPool) {
        this.setBufferPool(bufferPool);
        return this;
    }
}
