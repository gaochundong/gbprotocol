package ai.sangmado.gbprotocol.jt905.protocol;

import ai.sangmado.gbprotocol.jt905.protocol.enums.JT905ProtocolVersion;

/**
 * 协议版本上下文
 */
public interface IVersionedSpecificationContext extends ISpecificationContext {

    /**
     * 获取协议版本
     *
     * @return 协议版本
     */
    JT905ProtocolVersion getProtocolVersion();
}
