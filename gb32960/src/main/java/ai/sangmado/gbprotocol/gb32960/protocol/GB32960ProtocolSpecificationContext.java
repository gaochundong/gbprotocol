package ai.sangmado.gbprotocol.gb32960.protocol;

import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960ProtocolVersion;
import ai.sangmado.gbprotocol.gb32960.protocol.exceptions.UnsupportedGB32960OperationException;
import ai.sangmado.gbprotocol.gbcommon.memory.IBufferPool;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.ByteOrder;
import java.nio.charset.Charset;

/**
 * GB32960 协议上下文
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GB32960ProtocolSpecificationContext implements ISpecificationContext {
    @Setter
    @Builder.Default
    private GB32960ProtocolVersion protocolVersion = GB32960ProtocolVersion.V2016;
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
    public GB32960ProtocolVersion getProtocolVersion() {
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
    public GB32960ProtocolSpecificationContext clone() {
        try {
            return GB32960ProtocolSpecificationContext.builder()
                    .protocolVersion(this.getProtocolVersion())
                    .byteOrder(this.getByteOrder())
                    .charset(this.getCharset())
                    .bufferPool(this.getBufferPool())
                    .build();
        } catch (Exception ex) {
            throw new UnsupportedGB32960OperationException("克隆对象失败", ex);
        }
    }

    public static GB32960ProtocolSpecificationContext newInstance() {
        return new GB32960ProtocolSpecificationContext();
    }

    public GB32960ProtocolSpecificationContext withProtocolVersion(GB32960ProtocolVersion protocolVersion) {
        this.setProtocolVersion(protocolVersion);
        return this;
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
