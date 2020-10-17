package ai.sangmado.gbprotocol.gb32960.protocol.message.header.platform;

import ai.sangmado.gbprotocol.gb32960.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960ProtocolVersion;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.IGB32960MessageBufferReader;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * GB32960 消息头注册器 (平台)
 */
public class GB32960PlatformMessageHeaderRegistration {
    private static final Map<GB32960ProtocolVersion, BiFunction<IVersionedSpecificationContext, IGB32960MessageBufferReader, GB32960PlatformMessageHeader>> decoders = new HashMap<>(3);

    public static Map<GB32960ProtocolVersion, BiFunction<IVersionedSpecificationContext, IGB32960MessageBufferReader, GB32960PlatformMessageHeader>> getDecoders() {
        return decoders;
    }

    public static void register(GB32960ProtocolVersion protocolVersion, BiFunction<IVersionedSpecificationContext, IGB32960MessageBufferReader, GB32960PlatformMessageHeader> headerDecoder) {
        decoders.put(protocolVersion, headerDecoder);
    }

    static {
        register(GB32960PlatformMessageHeader2016.PROTOCOL_VERSION, GB32960PlatformMessageHeader2016::decode);
    }
}
