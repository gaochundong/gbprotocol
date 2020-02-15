package ai.sangmado.jt808.protocol.enums;

/**
 * 消息ID接口定义
 */
public interface IMessageId {

    /**
     * 消息ID来自版本
     */
    IProtocolVersion getSince();
}
