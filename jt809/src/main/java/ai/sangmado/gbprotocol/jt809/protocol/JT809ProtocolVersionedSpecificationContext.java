package ai.sangmado.gbprotocol.jt809.protocol;

import ai.sangmado.gbprotocol.gbcommon.memory.IBufferPool;
import ai.sangmado.gbprotocol.jt809.protocol.enums.JT809MessageContentEncryptionOptions;
import ai.sangmado.gbprotocol.jt809.protocol.enums.JT809ProtocolVersion;
import ai.sangmado.gbprotocol.jt809.protocol.exceptions.UnsupportedJT809OperationException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.ByteOrder;
import java.nio.charset.Charset;

/**
 * JT809 协议版本上下文
 */
@NoArgsConstructor
@AllArgsConstructor
public class JT809ProtocolVersionedSpecificationContext
        extends JT809ProtocolSpecificationContext
        implements IVersionedSpecificationContext {

    /**
     * 获取协议版本
     */
    @Getter
    @Setter
    private JT809ProtocolVersion protocolVersion = JT809ProtocolVersion.V2011;

    @Override
    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public JT809ProtocolVersionedSpecificationContext clone() {
        try {
            return JT809ProtocolVersionedSpecificationContext.newInstance()
                    .withProtocolVersion(this.getProtocolVersion())
                    .withByteOrder(this.getByteOrder())
                    .withCharset(this.getCharset())
                    .withMessageContentEncryptionOptions(this.getMessageContentEncryptionOptions())
                    .withBufferPool(this.getBufferPool());
        } catch (Exception ex) {
            throw new UnsupportedJT809OperationException("克隆对象失败", ex);
        }
    }

    public static JT809ProtocolVersionedSpecificationContext buildFrom(JT809ProtocolVersion protocolVersion, ISpecificationContext ctx) {
        return JT809ProtocolVersionedSpecificationContext
                .newInstance()
                .withProtocolVersion(protocolVersion)
                .withByteOrder(ctx.getByteOrder())
                .withCharset(ctx.getCharset())
                .withMessageContentEncryptionOptions(ctx.getMessageContentEncryptionOptions())
                .withBufferPool(ctx.getBufferPool());
    }

    public static JT809ProtocolVersionedSpecificationContext newInstance() {
        return new JT809ProtocolVersionedSpecificationContext();
    }

    public JT809ProtocolVersionedSpecificationContext withProtocolVersion(JT809ProtocolVersion protocolVersion) {
        this.setProtocolVersion(protocolVersion);
        return this;
    }

    @Override
    public JT809ProtocolVersionedSpecificationContext withByteOrder(ByteOrder byteOrder) {
        this.setByteOrder(byteOrder);
        return this;
    }

    @Override
    public JT809ProtocolVersionedSpecificationContext withCharset(Charset charset) {
        this.setCharset(charset);
        return this;
    }

    @Override
    public JT809ProtocolVersionedSpecificationContext withMessageContentEncryptionOptions(JT809MessageContentEncryptionOptions messageContentEncryptionOptions) {
        this.setMessageContentEncryptionOptions(messageContentEncryptionOptions);
        return this;
    }

    @Override
    public JT809ProtocolVersionedSpecificationContext withBufferPool(IBufferPool bufferPool) {
        this.setBufferPool(bufferPool);
        return this;
    }
}
