package ai.sangmado.gbprotocol.gb19056.protocol.message.content;

import ai.sangmado.gbprotocol.gb19056.protocol.enums.GB19056CommandMessageId;
import ai.sangmado.gbprotocol.gb19056.protocol.message.content.command.*;
import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * GB19056 命令帧 消息体 数据块 注册器
 */
public class GB19056CommandMessageBlockRegistration {
    private static final Map<GB19056CommandMessageId, BiFunction<IVersionedSpecificationContext, IJT808MessageBufferReader, GB19056MessageBlock<GB19056CommandMessageId>>> decoders = new HashMap<>(300);

    public static Map<GB19056CommandMessageId, BiFunction<IVersionedSpecificationContext, IJT808MessageBufferReader, GB19056MessageBlock<GB19056CommandMessageId>>> getDecoders() {
        return decoders;
    }

    public static void registerDecoder(GB19056CommandMessageId messageId, BiFunction<IVersionedSpecificationContext, IJT808MessageBufferReader, GB19056MessageBlock<GB19056CommandMessageId>> contentDecoder) {
        decoders.put(messageId, contentDecoder);
    }

    static {
        registerDecoder(GB19056_Command_Message_Block_0x00.MESSAGE_ID, GB19056_Command_Message_Block_0x00::decode);
        registerDecoder(GB19056_Command_Message_Block_0x01.MESSAGE_ID, GB19056_Command_Message_Block_0x01::decode);
        registerDecoder(GB19056_Command_Message_Block_0x02.MESSAGE_ID, GB19056_Command_Message_Block_0x02::decode);
        registerDecoder(GB19056_Command_Message_Block_0x03.MESSAGE_ID, GB19056_Command_Message_Block_0x03::decode);
        registerDecoder(GB19056_Command_Message_Block_0x04.MESSAGE_ID, GB19056_Command_Message_Block_0x04::decode);
    }
}
