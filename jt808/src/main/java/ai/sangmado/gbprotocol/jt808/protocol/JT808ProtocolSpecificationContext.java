package ai.sangmado.gbprotocol.jt808.protocol;

import ai.sangmado.gbprotocol.gbcommon.memory.IBufferPool;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808ProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808OperationException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.ByteOrder;
import java.nio.charset.Charset;

/**
 * JT808 协议上下文
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808ProtocolSpecificationContext implements ISpecificationContext {
    @Setter
    @Builder.Default
    private JT808ProtocolVersion protocolVersion = JT808ProtocolVersion.V2019;
    @Setter
    @Builder.Default
    private ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
    @Setter
    @Builder.Default
    private Charset charset = Charset.forName("GBK");
    @Setter
    @Builder.Default
    private IBufferPool bufferPool = null;

    /**
     * 获取协议版本
     *
     * @return 协议版本
     */
    @Override
    public JT808ProtocolVersion getProtocolVersion() {
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
    public JT808ProtocolSpecificationContext clone() {
        try {
            return JT808ProtocolSpecificationContext.builder()
                    .protocolVersion(this.getProtocolVersion())
                    .byteOrder(this.getByteOrder())
                    .charset(this.getCharset())
                    .bufferPool(this.getBufferPool())
                    .build();
        } catch (Exception ex) {
            throw new UnsupportedJT808OperationException("克隆对象失败", ex);
        }
    }

    public static JT808ProtocolSpecificationContext newInstance() {
        return new JT808ProtocolSpecificationContext();
    }

    public JT808ProtocolSpecificationContext withProtocolVersion(JT808ProtocolVersion protocolVersion) {
        this.setProtocolVersion(protocolVersion);
        return this;
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
