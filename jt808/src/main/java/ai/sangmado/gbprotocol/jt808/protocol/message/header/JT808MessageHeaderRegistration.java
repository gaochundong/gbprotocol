package ai.sangmado.gbprotocol.jt808.protocol.message.header;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808ProtocolVersion;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * JT808 消息头注册器
 */
public class JT808MessageHeaderRegistration {
    private static final Map<JT808ProtocolVersion, BiFunction<IVersionedSpecificationContext, IJT808MessageBufferReader, JT808MessageHeader>> decoders = new HashMap<>(3);

    public static Map<JT808ProtocolVersion, BiFunction<IVersionedSpecificationContext, IJT808MessageBufferReader, JT808MessageHeader>> getDecoders() {
        return decoders;
    }

    public static void register(JT808ProtocolVersion protocolVersion, BiFunction<IVersionedSpecificationContext, IJT808MessageBufferReader, JT808MessageHeader> headerDecoder) {
        decoders.put(protocolVersion, headerDecoder);
    }

    static {
        register(JT808MessageHeader2011.PROTOCOL_VERSION, JT808MessageHeader2011::decode);
        register(JT808MessageHeader2013.PROTOCOL_VERSION, JT808MessageHeader2013::decode);
        register(JT808MessageHeader2019.PROTOCOL_VERSION, JT808MessageHeader2019::decode);
    }
}
