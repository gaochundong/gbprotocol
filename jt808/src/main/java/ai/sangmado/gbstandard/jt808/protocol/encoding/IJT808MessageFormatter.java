package ai.sangmado.gbstandard.jt808.protocol.encoding;

import ai.sangmado.gbstandard.jt808.protocol.ISpecificationContext;

/**
 * JT808 消息序列化器
 */
public interface IJT808MessageFormatter {

    /**
     * 将JT808消息对象序列化后写入Buffer
     *
     * @param ctx    协议规范上下文
     * @param writer Buffer写入器
     */
    void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer);

    /**
     * 从Buffer读取数据并反序列化后构建JT808消息对象
     *
     * @param ctx    协议规范上下文
     * @param reader Buffer读取器
     */
    void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader);
}