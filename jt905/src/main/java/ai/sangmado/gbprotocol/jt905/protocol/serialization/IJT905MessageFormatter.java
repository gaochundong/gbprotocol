package ai.sangmado.gbprotocol.jt905.protocol.serialization;

import ai.sangmado.gbprotocol.jt905.protocol.IVersionedSpecificationContext;

/**
 * JT905 消息序列化器
 */
public interface IJT905MessageFormatter {

    /**
     * 将JT905消息对象序列化后写入Buffer
     *
     * @param ctx    协议规范上下文
     * @param writer Buffer写入器
     */
    void serialize(IVersionedSpecificationContext ctx, IJT905MessageBufferWriter writer);

    /**
     * 从Buffer读取数据并反序列化后构建JT905消息对象
     *
     * @param ctx    协议规范上下文
     * @param reader Buffer读取器
     */
    void deserialize(IVersionedSpecificationContext ctx, IJT905MessageBufferReader reader);
}