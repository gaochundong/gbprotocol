package ai.sangmado.gbstandard.jt808.protocol.message.content;

import ai.sangmado.gbstandard.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbstandard.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.gbstandard.jt808.protocol.enums.JT808MessageId;

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
        registerDecoder(JT808_Message_Content_0x0100.MESSAGE_ID, JT808_Message_Content_0x0100::decode);
        registerDecoder(JT808_Message_Content_0x0200.MESSAGE_ID, JT808_Message_Content_0x0200::decode);
        registerDecoder(JT808_Message_Content_0x8100.MESSAGE_ID, JT808_Message_Content_0x8100::decode);
        registerDecoder(JT808_Message_Content_0x8103.MESSAGE_ID, JT808_Message_Content_0x8103::decode);
    }
}
