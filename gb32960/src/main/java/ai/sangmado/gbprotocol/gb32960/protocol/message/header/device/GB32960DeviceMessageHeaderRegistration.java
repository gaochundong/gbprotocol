package ai.sangmado.gbprotocol.gb32960.protocol.message.header.device;

import ai.sangmado.gbprotocol.gb32960.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960ProtocolVersion;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.IGB32960MessageBufferReader;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * GB32960 消息头注册器 (终端)
 */
public class GB32960DeviceMessageHeaderRegistration {
    private static final Map<GB32960ProtocolVersion, BiFunction<IVersionedSpecificationContext, IGB32960MessageBufferReader, GB32960DeviceMessageHeader>> decoders = new HashMap<>(3);

    public static Map<GB32960ProtocolVersion, BiFunction<IVersionedSpecificationContext, IGB32960MessageBufferReader, GB32960DeviceMessageHeader>> getDecoders() {
        return decoders;
    }

    public static void register(GB32960ProtocolVersion protocolVersion, BiFunction<IVersionedSpecificationContext, IGB32960MessageBufferReader, GB32960DeviceMessageHeader> headerDecoder) {
        decoders.put(protocolVersion, headerDecoder);
    }

    static {
        register(GB32960DeviceMessageHeader2016.PROTOCOL_VERSION, GB32960DeviceMessageHeader2016::decode);
    }
}
