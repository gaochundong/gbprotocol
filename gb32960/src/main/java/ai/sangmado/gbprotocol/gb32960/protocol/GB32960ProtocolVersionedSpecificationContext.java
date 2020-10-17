package ai.sangmado.gbprotocol.gb32960.protocol;

import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960ProtocolVersion;
import ai.sangmado.gbprotocol.gb32960.protocol.exceptions.UnsupportedGB32960OperationException;
import ai.sangmado.gbprotocol.gbcommon.memory.IBufferPool;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.ByteOrder;
import java.nio.charset.Charset;

/**
 * GB32960 协议版本上下文
 */
@NoArgsConstructor
@AllArgsConstructor
public class GB32960ProtocolVersionedSpecificationContext
        extends GB32960ProtocolSpecificationContext
        implements IVersionedSpecificationContext {
    /**
     * 协议版本
     */
    @Getter
    @Setter
    private GB32960ProtocolVersion protocolVersion = GB32960ProtocolVersion.V2016;

    @Override
    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public GB32960ProtocolVersionedSpecificationContext clone() {
        try {
            return GB32960ProtocolVersionedSpecificationContext.newInstance()
                    .withProtocolVersion(this.getProtocolVersion())
                    .withByteOrder(this.getByteOrder())
                    .withCharset(this.getCharset())
                    .withBufferPool(this.getBufferPool());
        } catch (Exception ex) {
            throw new UnsupportedGB32960OperationException("克隆对象失败", ex);
        }
    }

    public static GB32960ProtocolVersionedSpecificationContext buildFrom(GB32960ProtocolVersion protocolVersion, ISpecificationContext ctx) {
        return GB32960ProtocolVersionedSpecificationContext
                .newInstance()
                .withProtocolVersion(protocolVersion)
                .withByteOrder(ctx.getByteOrder())
                .withCharset(ctx.getCharset())
                .withBufferPool(ctx.getBufferPool());
    }

    public static GB32960ProtocolVersionedSpecificationContext newInstance() {
        return new GB32960ProtocolVersionedSpecificationContext();
    }

    public GB32960ProtocolVersionedSpecificationContext withProtocolVersion(GB32960ProtocolVersion protocolVersion) {
        this.setProtocolVersion(protocolVersion);
        return this;
    }

    @Override
    public GB32960ProtocolVersionedSpecificationContext withByteOrder(ByteOrder byteOrder) {
        this.setByteOrder(byteOrder);
        return this;
    }

    @Override
    public GB32960ProtocolVersionedSpecificationContext withCharset(Charset charset) {
        this.setCharset(charset);
        return this;
    }

    @Override
    public GB32960ProtocolVersionedSpecificationContext withBufferPool(IBufferPool bufferPool) {
        this.setBufferPool(bufferPool);
        return this;
    }
}
