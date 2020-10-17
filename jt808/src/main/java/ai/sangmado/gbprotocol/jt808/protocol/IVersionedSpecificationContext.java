package ai.sangmado.gbprotocol.jt808.protocol;

import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808ProtocolVersion;

/**
 * 协议版本上下文
 */
public interface IVersionedSpecificationContext extends ISpecificationContext {

    /**
     * 获取协议版本
     *
     * @return 协议版本
     */
    JT808ProtocolVersion getProtocolVersion();
}
