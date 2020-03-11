package ai.sangmado.gbprotocol.jt809.protocol;

import ai.sangmado.gbprotocol.gbcommon.memory.IBufferPool;
import ai.sangmado.gbprotocol.jt809.protocol.enums.JT809MessageContentEncryptionOptions;
import ai.sangmado.gbprotocol.jt809.protocol.enums.JT809ProtocolVersion;
import ai.sangmado.gbprotocol.jt809.protocol.exceptions.UnsupportedJT809OperationException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.ByteOrder;
import java.nio.charset.Charset;

/**
 * JT809 协议上下文
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT809ProtocolSpecificationContext implements ISpecificationContext {
    @Setter
    @Builder.Default
    private JT809ProtocolVersion protocolVersion = JT809ProtocolVersion.V2011;
    @Setter
    @Builder.Default
    private ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
    @Setter
    @Builder.Default
    private Charset charset = Charset.forName("GBK");
    @Setter
    @Builder.Default
    private JT809MessageContentEncryptionOptions messageContentEncryptionOptions = null;
    @Setter
    @Builder.Default
    private IBufferPool bufferPool = null;

    /**
     * 获取协议版本
     *
     * @return 协议版本
     */
    @Override
    public JT809ProtocolVersion getProtocolVersion() {
        return this.protocolVersion;
    }

    /**
     * 获取字节序
     * <p>
     * 大端（Big-Endian）字节序：高字节存于内存低地址，低字节存于内存高地址。
     * 小端（Little-Endian）字节序：低字节存于内存低地址，高字节存于内存高地址。
     *
     * @return 字节序
     */
    @Override
    public ByteOrder getByteOrder() {
        return byteOrder;
    }

    /**
     * 获取字符集
     *
     * @return 字符集
     */
    @Override
    public Charset getCharset() {
        return charset;
    }

    /**
     * 获取消息体加密参数
     *
     * @return 消息体加密参数
     */
    @Override
    public JT809MessageContentEncryptionOptions getMessageContentEncryptionOptions() {
        return messageContentEncryptionOptions;
    }

    /**
     * 获取数组池
     *
     * @return 数组池
     */
    @Override
    public IBufferPool getBufferPool() {
        return bufferPool;
    }

    @Override
    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public JT809ProtocolSpecificationContext clone() {
        try {
            return JT809ProtocolSpecificationContext.builder()
                    .protocolVersion(this.getProtocolVersion())
                    .byteOrder(this.getByteOrder())
                    .charset(this.getCharset())
                    .messageContentEncryptionOptions(this.getMessageContentEncryptionOptions())
                    .bufferPool(this.getBufferPool())
                    .build();
        } catch (Exception ex) {
            throw new UnsupportedJT809OperationException("克隆对象失败", ex);
        }
    }

    public static JT809ProtocolSpecificationContext newInstance() {
        return new JT809ProtocolSpecificationContext();
    }

    public JT809ProtocolSpecificationContext withProtocolVersion(JT809ProtocolVersion protocolVersion) {
        this.setProtocolVersion(protocolVersion);
        return this;
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
