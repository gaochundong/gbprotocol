package ai.sangmado.gbprotocol.jt808.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * JT808 消息体注册器
 */
public class JT808MessageContentRegistration {
    private static final Map<JT808MessageId, BiFunction<IVersionedSpecificationContext, IJT808MessageBufferReader, JT808MessageContent>> decoders = new HashMap<>(300);

    public static Map<JT808MessageId, BiFunction<IVersionedSpecificationContext, IJT808MessageBufferReader, JT808MessageContent>> getDecoders() {
        return decoders;
    }

    public static void registerDecoder(JT808MessageId messageId, BiFunction<IVersionedSpecificationContext, IJT808MessageBufferReader, JT808MessageContent> contentDecoder) {
        decoders.put(messageId, contentDecoder);
    }

    static {
        registerDecoder(JT808_Message_Content_0x0001.MESSAGE_ID, JT808_Message_Content_0x0001::decode);
        registerDecoder(JT808_Message_Content_0x0002.MESSAGE_ID, JT808_Message_Content_0x0002::decode);
        registerDecoder(JT808_Message_Content_0x0003.MESSAGE_ID, JT808_Message_Content_0x0003::decode);
        registerDecoder(JT808_Message_Content_0x0004.MESSAGE_ID, JT808_Message_Content_0x0004::decode);
        registerDecoder(JT808_Message_Content_0x0100.MESSAGE_ID, JT808_Message_Content_0x0100::decode);
        registerDecoder(JT808_Message_Content_0x0102.MESSAGE_ID, JT808_Message_Content_0x0102::decode);
        registerDecoder(JT808_Message_Content_0x0104.MESSAGE_ID, JT808_Message_Content_0x0104::decode);
        registerDecoder(JT808_Message_Content_0x0107.MESSAGE_ID, JT808_Message_Content_0x0107::decode);
        registerDecoder(JT808_Message_Content_0x0108.MESSAGE_ID, JT808_Message_Content_0x0108::decode);
        registerDecoder(JT808_Message_Content_0x0200.MESSAGE_ID, JT808_Message_Content_0x0200::decode);
        registerDecoder(JT808_Message_Content_0x0702.MESSAGE_ID, JT808_Message_Content_0x0702::decode);
        registerDecoder(JT808_Message_Content_0x0800.MESSAGE_ID, JT808_Message_Content_0x0800::decode);
        registerDecoder(JT808_Message_Content_0x0801.MESSAGE_ID, JT808_Message_Content_0x0801::decode);
        registerDecoder(JT808_Message_Content_0x0802.MESSAGE_ID, JT808_Message_Content_0x0802::decode);
        registerDecoder(JT808_Message_Content_0x0805.MESSAGE_ID, JT808_Message_Content_0x0805::decode);
        registerDecoder(JT808_Message_Content_0x0900.MESSAGE_ID, JT808_Message_Content_0x0900::decode);
        registerDecoder(JT808_Message_Content_0x0901.MESSAGE_ID, JT808_Message_Content_0x0901::decode);
        registerDecoder(JT808_Message_Content_0x0A00.MESSAGE_ID, JT808_Message_Content_0x0A00::decode);

        registerDecoder(JT808_Message_Content_0x8001.MESSAGE_ID, JT808_Message_Content_0x8001::decode);
        registerDecoder(JT808_Message_Content_0x8004.MESSAGE_ID, JT808_Message_Content_0x8004::decode);
        registerDecoder(JT808_Message_Content_0x8100.MESSAGE_ID, JT808_Message_Content_0x8100::decode);
        registerDecoder(JT808_Message_Content_0x8103.MESSAGE_ID, JT808_Message_Content_0x8103::decode);
        registerDecoder(JT808_Message_Content_0x8104.MESSAGE_ID, JT808_Message_Content_0x8104::decode);
        registerDecoder(JT808_Message_Content_0x8105.MESSAGE_ID, JT808_Message_Content_0x8105::decode);
        registerDecoder(JT808_Message_Content_0x8106.MESSAGE_ID, JT808_Message_Content_0x8106::decode);
        registerDecoder(JT808_Message_Content_0x8107.MESSAGE_ID, JT808_Message_Content_0x8107::decode);
        registerDecoder(JT808_Message_Content_0x8108.MESSAGE_ID, JT808_Message_Content_0x8108::decode);
        registerDecoder(JT808_Message_Content_0x8201.MESSAGE_ID, JT808_Message_Content_0x8201::decode);
        registerDecoder(JT808_Message_Content_0x8204.MESSAGE_ID, JT808_Message_Content_0x8204::decode);
        registerDecoder(JT808_Message_Content_0x8300.MESSAGE_ID, JT808_Message_Content_0x8300::decode);
        registerDecoder(JT808_Message_Content_0x8702.MESSAGE_ID, JT808_Message_Content_0x8702::decode);
        registerDecoder(JT808_Message_Content_0x8800.MESSAGE_ID, JT808_Message_Content_0x8800::decode);
        registerDecoder(JT808_Message_Content_0x8801.MESSAGE_ID, JT808_Message_Content_0x8801::decode);
        registerDecoder(JT808_Message_Content_0x8802.MESSAGE_ID, JT808_Message_Content_0x8802::decode);
        registerDecoder(JT808_Message_Content_0x8803.MESSAGE_ID, JT808_Message_Content_0x8803::decode);
        registerDecoder(JT808_Message_Content_0x8804.MESSAGE_ID, JT808_Message_Content_0x8804::decode);
        registerDecoder(JT808_Message_Content_0x8805.MESSAGE_ID, JT808_Message_Content_0x8805::decode);
        registerDecoder(JT808_Message_Content_0x8900.MESSAGE_ID, JT808_Message_Content_0x8900::decode);
        registerDecoder(JT808_Message_Content_0x8A00.MESSAGE_ID, JT808_Message_Content_0x8A00::decode);
    }
}
