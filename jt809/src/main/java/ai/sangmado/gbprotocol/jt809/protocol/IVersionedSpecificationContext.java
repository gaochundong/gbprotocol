package ai.sangmado.gbprotocol.jt809.protocol;

import ai.sangmado.gbprotocol.jt809.protocol.enums.JT809ProtocolVersion;

/**
 * 协议版本上下文
 */
public interface IVersionedSpecificationContext extends ISpecificationContext {

    /**
     * 获取协议版本
     *
     * @return 协议版本
     */
    JT809ProtocolVersion getProtocolVersion();
}
