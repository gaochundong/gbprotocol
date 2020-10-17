package ai.sangmado.gbprotocol.gb19056.protocol.message.content;

import ai.sangmado.gbprotocol.gb19056.protocol.enums.GB19056ReplyMessageId;
import ai.sangmado.gbprotocol.gb19056.protocol.message.content.reply.*;
import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * GB19056 应答帧 消息体 数据块 注册器
 */
public class GB19056ReplyMessageBlockRegistration {
    private static final Map<GB19056ReplyMessageId, BiFunction<IVersionedSpecificationContext, IJT808MessageBufferReader, GB19056MessageBlock<GB19056ReplyMessageId>>> decoders = new HashMap<>(300);

    public static Map<GB19056ReplyMessageId, BiFunction<IVersionedSpecificationContext, IJT808MessageBufferReader, GB19056MessageBlock<GB19056ReplyMessageId>>> getDecoders() {
        return decoders;
    }

    public static void registerDecoder(GB19056ReplyMessageId messageId, BiFunction<IVersionedSpecificationContext, IJT808MessageBufferReader, GB19056MessageBlock<GB19056ReplyMessageId>> contentDecoder) {
        decoders.put(messageId, contentDecoder);
    }

    static {
        registerDecoder(GB19056_Reply_Message_Block_0x00.MESSAGE_ID, GB19056_Reply_Message_Block_0x00::decode);
        registerDecoder(GB19056_Reply_Message_Block_0x01.MESSAGE_ID, GB19056_Reply_Message_Block_0x01::decode);
        registerDecoder(GB19056_Reply_Message_Block_0x02.MESSAGE_ID, GB19056_Reply_Message_Block_0x02::decode);
        registerDecoder(GB19056_Reply_Message_Block_0x03.MESSAGE_ID, GB19056_Reply_Message_Block_0x03::decode);
        registerDecoder(GB19056_Reply_Message_Block_0x04.MESSAGE_ID, GB19056_Reply_Message_Block_0x04::decode);
    }
}
