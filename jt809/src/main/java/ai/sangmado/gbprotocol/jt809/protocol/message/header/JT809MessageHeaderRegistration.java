package ai.sangmado.gbprotocol.jt809.protocol.message.header;

import ai.sangmado.gbprotocol.jt809.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt809.protocol.serialization.IJT809MessageBufferReader;
import ai.sangmado.gbprotocol.jt809.protocol.enums.JT809ProtocolVersion;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * JT809 消息头注册器
 */
public class JT809MessageHeaderRegistration {
    private static final Map<JT809ProtocolVersion, BiFunction<IVersionedSpecificationContext, IJT809MessageBufferReader, JT809MessageHeader>> decoders = new HashMap<>(3);

    public static Map<JT809ProtocolVersion, BiFunction<IVersionedSpecificationContext, IJT809MessageBufferReader, JT809MessageHeader>> getDecoders() {
        return decoders;
    }

    public static void register(JT809ProtocolVersion protocolVersion, BiFunction<IVersionedSpecificationContext, IJT809MessageBufferReader, JT809MessageHeader> headerDecoder) {
        decoders.put(protocolVersion, headerDecoder);
    }

    static {
        register(JT809MessageHeader2011.PROTOCOL_VERSION, JT809MessageHeader2011::decode);
        register(JT809MessageHeader2019.PROTOCOL_VERSION, JT809MessageHeader2019::decode);
    }
}
