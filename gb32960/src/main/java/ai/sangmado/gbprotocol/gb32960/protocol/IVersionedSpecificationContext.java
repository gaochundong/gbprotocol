package ai.sangmado.gbprotocol.gb32960.protocol;

import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960ProtocolVersion;

/**
 * 协议版本上下文
 */
public interface IVersionedSpecificationContext extends ISpecificationContext {

    /**
     * 获取协议版本
     *
     * @return 协议版本
     */
    GB32960ProtocolVersion getProtocolVersion();
}
