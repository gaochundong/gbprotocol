package ai.sangmado.jt809.protocol.message;

import ai.sangmado.jt809.protocol.ISpecificationContext;
import ai.sangmado.jt809.protocol.encoding.IJT809MessageBufferReader;
import ai.sangmado.jt809.protocol.message.content.JT809MessageContent;
import ai.sangmado.jt809.protocol.message.header.JT809MessageHeader;

/**
 * JT809 消息包解码器
 */
public interface IJT809MessageDecoder {

    /**
     * 解析消息头
     *
     * @param ctx    协议上下文
     * @param reader Buffer读取器
     * @return 消息头
     */
    JT809MessageHeader decodeHeader(ISpecificationContext ctx, IJT809MessageBufferReader reader);

    /**
     * 解析消息体
     *
     * @param ctx    协议上下文
     * @param reader Buffer读取器
     * @param header 消息头
     * @return 消息体
     */
    JT809MessageContent decodeContent(ISpecificationContext ctx, IJT809MessageBufferReader reader, JT809MessageHeader header);
}