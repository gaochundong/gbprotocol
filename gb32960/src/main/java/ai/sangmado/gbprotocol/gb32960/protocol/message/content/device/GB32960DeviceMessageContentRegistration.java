package ai.sangmado.gbprotocol.gb32960.protocol.message.content.device;

import ai.sangmado.gbprotocol.gb32960.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960DeviceCommandId;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.IGB32960MessageBufferReader;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * GB32960 数据单元注册器 (终端)
 */
public class GB32960DeviceMessageContentRegistration {
    private static final Map<GB32960DeviceCommandId, BiFunction<ISpecificationContext, IGB32960MessageBufferReader, GB32960DeviceMessageContent>> decoders = new HashMap<>(300);

    public static Map<GB32960DeviceCommandId, BiFunction<ISpecificationContext, IGB32960MessageBufferReader, GB32960DeviceMessageContent>> getDecoders() {
        return decoders;
    }

    public static void registerDecoder(GB32960DeviceCommandId commandId, BiFunction<ISpecificationContext, IGB32960MessageBufferReader, GB32960DeviceMessageContent> contentDecoder) {
        decoders.put(commandId, contentDecoder);
    }

    static {
        registerDecoder(GB32960_Device_Message_Content_0x01.COMMAND_ID, GB32960_Device_Message_Content_0x01::decode);
        registerDecoder(GB32960_Device_Message_Content_0x04.COMMAND_ID, GB32960_Device_Message_Content_0x04::decode);
    }
}
