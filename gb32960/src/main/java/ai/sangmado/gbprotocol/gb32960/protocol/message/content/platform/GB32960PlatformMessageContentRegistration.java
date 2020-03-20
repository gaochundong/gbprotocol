package ai.sangmado.gbprotocol.gb32960.protocol.message.content.platform;

import ai.sangmado.gbprotocol.gb32960.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960PlatformCommandId;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.IGB32960MessageBufferReader;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * GB32960 数据单元注册器 (平台)
 */
public class GB32960PlatformMessageContentRegistration {
    private static final Map<GB32960PlatformCommandId, BiFunction<ISpecificationContext, IGB32960MessageBufferReader, GB32960PlatformMessageContent>> decoders = new HashMap<>(300);

    public static Map<GB32960PlatformCommandId, BiFunction<ISpecificationContext, IGB32960MessageBufferReader, GB32960PlatformMessageContent>> getDecoders() {
        return decoders;
    }

    public static void registerDecoder(GB32960PlatformCommandId commandId, BiFunction<ISpecificationContext, IGB32960MessageBufferReader, GB32960PlatformMessageContent> contentDecoder) {
        decoders.put(commandId, contentDecoder);
    }

    static {
        registerDecoder(GB32960_Platform_Message_Content_0x01.COMMAND_ID, GB32960_Platform_Message_Content_0x01::decode);
        registerDecoder(GB32960_Platform_Message_Content_0x04.COMMAND_ID, GB32960_Platform_Message_Content_0x04::decode);
    }
}
