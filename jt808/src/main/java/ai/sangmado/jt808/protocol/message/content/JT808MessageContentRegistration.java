package ai.sangmado.jt808.protocol.message.content;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.jt808.protocol.enums.JT808ProtocolVersion;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * JT808 消息体注册器
 */
public class JT808MessageContentRegistration {
    private static final Map<JT808MessageId, BiFunction<ISpecificationContext<JT808ProtocolVersion>, IJT808MessageBufferReader, JT808MessageContent<JT808MessageId, JT808ProtocolVersion>>> decoders = new HashMap<>(300);

    public static Map<JT808MessageId, BiFunction<ISpecificationContext<JT808ProtocolVersion>, IJT808MessageBufferReader, JT808MessageContent<JT808MessageId, JT808ProtocolVersion>>> getDecoders() {
        return decoders;
    }

    public static void register(JT808MessageId messageId, BiFunction<ISpecificationContext<JT808ProtocolVersion>, IJT808MessageBufferReader, JT808MessageContent<JT808MessageId, JT808ProtocolVersion>> contentDecoder) {
        decoders.put(messageId, contentDecoder);
    }

    static {
        register(JT808_Message_Content_0x0100.MESSAGE_ID, JT808_Message_Content_0x0100::decode);
        register(JT808_Message_Content_0x0200.MESSAGE_ID, JT808_Message_Content_0x0200::decode);
        register(JT808_Message_Content_0x8100.MESSAGE_ID, JT808_Message_Content_0x8100::decode);
        register(JT808_Message_Content_0x8103.MESSAGE_ID, JT808_Message_Content_0x8103::decode);
    }
}
