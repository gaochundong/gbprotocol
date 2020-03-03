package ai.sangmado.gbstandard.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional;

import ai.sangmado.gbstandard.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbstandard.jt808.protocol.encoding.IJT808MessageBufferReader;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * 终端位置信息汇报 - 位置附加信息 - 注册器
 */
public class JT808_Message_Content_0x0200_AdditionalInformationRegistration {

    private static final Map<JT808_Message_Content_0x0200_AdditionalInformationId, BiFunction<ISpecificationContext, IJT808MessageBufferReader, JT808_Message_Content_0x0200_AdditionalInformation>> decoders = new HashMap<>(300);

    public static Map<JT808_Message_Content_0x0200_AdditionalInformationId, BiFunction<ISpecificationContext, IJT808MessageBufferReader, JT808_Message_Content_0x0200_AdditionalInformation>> getDecoders() {
        return decoders;
    }

    public static void registerDecoder(JT808_Message_Content_0x0200_AdditionalInformationId messageId, BiFunction<ISpecificationContext, IJT808MessageBufferReader, JT808_Message_Content_0x0200_AdditionalInformation> contentDecoder) {
        decoders.put(messageId, contentDecoder);
    }

    static {
        registerDecoder(JT808_Message_Content_0x0200_AI_0x01.ADDITIONAL_INFORMATION_ID, JT808_Message_Content_0x0200_AI_0x01::decode);
        registerDecoder(JT808_Message_Content_0x0200_AI_0x02.ADDITIONAL_INFORMATION_ID, JT808_Message_Content_0x0200_AI_0x02::decode);
        registerDecoder(JT808_Message_Content_0x0200_AI_0x03.ADDITIONAL_INFORMATION_ID, JT808_Message_Content_0x0200_AI_0x03::decode);
        registerDecoder(JT808_Message_Content_0x0200_AI_0x04.ADDITIONAL_INFORMATION_ID, JT808_Message_Content_0x0200_AI_0x04::decode);
        registerDecoder(JT808_Message_Content_0x0200_AI_0x05.ADDITIONAL_INFORMATION_ID, JT808_Message_Content_0x0200_AI_0x05::decode);
        registerDecoder(JT808_Message_Content_0x0200_AI_0x06.ADDITIONAL_INFORMATION_ID, JT808_Message_Content_0x0200_AI_0x06::decode);

        registerDecoder(JT808_Message_Content_0x0200_AI_0x11.ADDITIONAL_INFORMATION_ID, JT808_Message_Content_0x0200_AI_0x11::decode);
        registerDecoder(JT808_Message_Content_0x0200_AI_0x12.ADDITIONAL_INFORMATION_ID, JT808_Message_Content_0x0200_AI_0x12::decode);
        registerDecoder(JT808_Message_Content_0x0200_AI_0x13.ADDITIONAL_INFORMATION_ID, JT808_Message_Content_0x0200_AI_0x13::decode);

        registerDecoder(JT808_Message_Content_0x0200_AI_0x25.ADDITIONAL_INFORMATION_ID, JT808_Message_Content_0x0200_AI_0x25::decode);
        registerDecoder(JT808_Message_Content_0x0200_AI_0x2A.ADDITIONAL_INFORMATION_ID, JT808_Message_Content_0x0200_AI_0x2A::decode);
        registerDecoder(JT808_Message_Content_0x0200_AI_0x2B.ADDITIONAL_INFORMATION_ID, JT808_Message_Content_0x0200_AI_0x2B::decode);

        registerDecoder(JT808_Message_Content_0x0200_AI_0x30.ADDITIONAL_INFORMATION_ID, JT808_Message_Content_0x0200_AI_0x30::decode);
        registerDecoder(JT808_Message_Content_0x0200_AI_0x31.ADDITIONAL_INFORMATION_ID, JT808_Message_Content_0x0200_AI_0x31::decode);
    }
}
