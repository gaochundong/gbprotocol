package ai.sangmado.gbprotocol.jt808.protocol.message;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.message.header.JT808MessageHeader;

/**
 * JT808 消息包解码器
 */
public interface IJT808MessageDecoder {

    /**
     * 解析消息头
     *
     * @param ctx    协议上下文
     * @param reader Buffer读取器
     * @return 消息头
     */
    JT808MessageHeader decodeHeader(ISpecificationContext ctx, IJT808MessageBufferReader reader);

    /**
     * 解析消息体
     *
     * @param ctx    协议上下文
     * @param reader Buffer读取器
     * @param header 消息头
     * @return 消息体
     */
    JT808MessageContent decodeContent(ISpecificationContext ctx, IJT808MessageBufferReader reader, JT808MessageHeader header);
}