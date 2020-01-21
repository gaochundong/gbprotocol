package ai.sangmado.jt808.protocol;

import ai.sangmado.jt808.protocol.enums.JT808ProtocolVersion;

/**
 * 协议版本规范定义
 */
public interface ISpecificationContext {

    /**
     * 获取协议版本
     *
     * @return 协议版本
     */
    JT808ProtocolVersion getJT808ProtocolVersion();
}
