package ai.sangmado.gbprotocol.gbcommon.enums;

/**
 * 消息ID接口定义
 */
public interface IMessageId extends Comparable<IMessageId>, IExtension<IMessageId> {

    /**
     * 获取消息名称
     */
    String getName();

    /**
     * 获取消息ID
     */
    Integer getValue();

    /**
     * 获取消息协议版本
     */
    IProtocolVersion getSince();

    /**
     * 获取消息描述
     */
    String getDescription();
}
