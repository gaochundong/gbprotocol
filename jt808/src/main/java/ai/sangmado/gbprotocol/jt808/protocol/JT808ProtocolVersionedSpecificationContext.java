package ai.sangmado.gbprotocol.jt808.protocol;

import ai.sangmado.gbprotocol.gbcommon.memory.IBufferPool;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808ProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808OperationException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.ByteOrder;
import java.nio.charset.Charset;

/**
 * JT808 协议版本上下文
 */
@NoArgsConstructor
@AllArgsConstructor
public class JT808ProtocolVersionedSpecificationContext
        extends JT808ProtocolSpecificationContext
        implements IVersionedSpecificationContext {

    /**
     * 协议版本
     */
    @Getter
    @Setter
    private JT808ProtocolVersion protocolVersion = JT808ProtocolVersion.V2019;

    @Override
    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public JT808ProtocolVersionedSpecificationContext clone() {
        try {
            return JT808ProtocolVersionedSpecificationContext
                    .newInstance()
                    .withProtocolVersion(this.getProtocolVersion())
                    .withByteOrder(this.getByteOrder())
                    .withCharset(this.getCharset())
                    .withBufferPool(this.getBufferPool());
        } catch (Exception ex) {
            throw new UnsupportedJT808OperationException("克隆对象失败", ex);
        }
    }

    public static JT808ProtocolVersionedSpecificationContext buildFrom(JT808ProtocolVersion protocolVersion, ISpecificationContext ctx) {
        return JT808ProtocolVersionedSpecificationContext
                .newInstance()
                .withProtocolVersion(protocolVersion)
                .withByteOrder(ctx.getByteOrder())
                .withCharset(ctx.getCharset())
                .withBufferPool(ctx.getBufferPool());
    }

    public static JT808ProtocolVersionedSpecificationContext newInstance() {
        return new JT808ProtocolVersionedSpecificationContext();
    }

    public JT808ProtocolVersionedSpecificationContext withProtocolVersion(JT808ProtocolVersion protocolVersion) {
        this.setProtocolVersion(protocolVersion);
        return this;
    }

    @Override
    public JT808ProtocolVersionedSpecificationContext withByteOrder(ByteOrder byteOrder) {
        this.setByteOrder(byteOrder);
        return this;
    }

    @Override
    public JT808ProtocolVersionedSpecificationContext withCharset(Charset charset) {
        this.setCharset(charset);
        return this;
    }

    @Override
    public JT808ProtocolVersionedSpecificationContext withBufferPool(IBufferPool bufferPool) {
        this.setBufferPool(bufferPool);
        return this;
    }
}
