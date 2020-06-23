package ai.sangmado.gbprotocol.jt808.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * JT808 消息体注册器
 */
public class JT808MessageContentRegistration {
    private static final Map<JT808MessageId, BiFunction<ISpecificationContext, IJT808MessageBufferReader, JT808MessageContent>> decoders = new HashMap<>(300);

    public static Map<JT808MessageId, BiFunction<ISpecificationContext, IJT808MessageBufferReader, JT808MessageContent>> getDecoders() {
        return decoders;
    }

    public static void registerDecoder(JT808MessageId messageId, BiFunction<ISpecificationContext, IJT808MessageBufferReader, JT808MessageContent> contentDecoder) {
        decoders.put(messageId, contentDecoder);
    }

    static {
        registerDecoder(JT808_Message_Content_0x0001.MESSAGE_ID, JT808_Message_Content_0x0001::decode);
        registerDecoder(JT808_Message_Content_0x0002.MESSAGE_ID, JT808_Message_Content_0x0002::decode);
        registerDecoder(JT808_Message_Content_0x0003.MESSAGE_ID, JT808_Message_Content_0x0003::decode);
        registerDecoder(JT808_Message_Content_0x0004.MESSAGE_ID, JT808_Message_Content_0x0004::decode);
        registerDecoder(JT808_Message_Content_0x0100.MESSAGE_ID, JT808_Message_Content_0x0100::decode);
        registerDecoder(JT808_Message_Content_0x0102.MESSAGE_ID, JT808_Message_Content_0x0102::decode);
        registerDecoder(JT808_Message_Content_0x0200.MESSAGE_ID, JT808_Message_Content_0x0200::decode);
        registerDecoder(JT808_Message_Content_0x8001.MESSAGE_ID, JT808_Message_Content_0x8001::decode);
        registerDecoder(JT808_Message_Content_0x8004.MESSAGE_ID, JT808_Message_Content_0x8004::decode);
        registerDecoder(JT808_Message_Content_0x8100.MESSAGE_ID, JT808_Message_Content_0x8100::decode);
        registerDecoder(JT808_Message_Content_0x8103.MESSAGE_ID, JT808_Message_Content_0x8103::decode);
    }
}
