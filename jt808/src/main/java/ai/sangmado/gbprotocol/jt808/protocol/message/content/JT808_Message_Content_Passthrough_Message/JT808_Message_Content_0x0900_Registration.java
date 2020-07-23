package ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_Passthrough_Message;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * 透传消息注册器
 */
public class JT808_Message_Content_0x0900_Registration {

    private static final Map<JT808_Message_Content_Passthrough_MessageType, BiFunction<ISpecificationContext, IJT808MessageBufferReader, JT808_Message_Content_0x0900_Base>> decoders = new HashMap<>(300);

    public static Map<JT808_Message_Content_Passthrough_MessageType, BiFunction<ISpecificationContext, IJT808MessageBufferReader, JT808_Message_Content_0x0900_Base>> getDecoders() {
        return decoders;
    }

    public static void registerDecoder(JT808_Message_Content_Passthrough_MessageType messageType, BiFunction<ISpecificationContext, IJT808MessageBufferReader, JT808_Message_Content_0x0900_Base> contentDecoder) {
        decoders.put(messageType, contentDecoder);
    }

    static {
        registerDecoder(JT808_Message_Content_0x0900_Message_0x00.MESSAGE_TYPE, JT808_Message_Content_0x0900_Message_0x00::decode);
        registerDecoder(JT808_Message_Content_0x0900_Message_0x0B.MESSAGE_TYPE, JT808_Message_Content_0x0900_Message_0x0B::decode);
    }
}
