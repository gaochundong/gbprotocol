package ai.sangmado.gbstandard.gbcommon.enums;

/**
 * 协议版本接口定义
 */
public interface IProtocolVersion extends Comparable<IProtocolVersion> {

    /**
     * 获取协议版本名称
     */
    String getName();

    /**
     * 获取协议版本整型值
     */
    Integer getValue();

    /**
     * 获取协议版本描述
     */
    String getDescription();
}
