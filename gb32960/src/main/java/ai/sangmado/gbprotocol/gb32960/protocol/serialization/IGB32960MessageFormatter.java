package ai.sangmado.gbprotocol.gb32960.protocol.serialization;

import ai.sangmado.gbprotocol.gb32960.protocol.ISpecificationContext;

/**
 * GB32960 消息序列化器
 */
public interface IGB32960MessageFormatter {

    /**
     * 将GB32960消息对象序列化后写入Buffer
     *
     * @param ctx    协议规范上下文
     * @param writer Buffer写入器
     */
    void serialize(ISpecificationContext ctx, IGB32960MessageBufferWriter writer);

    /**
     * 从Buffer读取数据并反序列化后构建GB32960消息对象
     *
     * @param ctx    协议规范上下文
     * @param reader Buffer读取器
     */
    void deserialize(ISpecificationContext ctx, IGB32960MessageBufferReader reader);
}