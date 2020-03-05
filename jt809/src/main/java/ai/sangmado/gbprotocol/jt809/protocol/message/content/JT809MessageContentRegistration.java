package ai.sangmado.gbprotocol.jt809.protocol.message.content;

import ai.sangmado.gbprotocol.jt809.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt809.protocol.serialization.IJT809MessageBufferReader;
import ai.sangmado.gbprotocol.jt809.protocol.enums.JT809MessageId;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * JT809 消息体注册器
 */
public class JT809MessageContentRegistration {
    private static final Map<JT809MessageId, BiFunction<ISpecificationContext, IJT809MessageBufferReader, JT809MessageContent>> decoders = new HashMap<>(300);

    public static Map<JT809MessageId, BiFunction<ISpecificationContext, IJT809MessageBufferReader, JT809MessageContent>> getDecoders() {
        return decoders;
    }

    public static void registerDecoder(JT809MessageId messageId, BiFunction<ISpecificationContext, IJT809MessageBufferReader, JT809MessageContent> contentDecoder) {
        decoders.put(messageId, contentDecoder);
    }

    static {
        registerDecoder(JT809_Message_Content_0x1400.MESSAGE_ID, JT809_Message_Content_0x1400::decode);
    }
}
