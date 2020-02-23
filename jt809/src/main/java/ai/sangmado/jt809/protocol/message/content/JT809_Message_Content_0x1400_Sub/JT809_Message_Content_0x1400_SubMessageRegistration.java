package ai.sangmado.jt809.protocol.message.content.JT809_Message_Content_0x1400_Sub;

import ai.sangmado.jt809.protocol.ISpecificationContext;
import ai.sangmado.jt809.protocol.encoding.IJT809MessageBufferReader;
import ai.sangmado.jt809.protocol.enums.JT809SubMessageId;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * 主链路报警信息交互消息 UP_WARN_MSG - 子消息 - 注册器
 */
public class JT809_Message_Content_0x1400_SubMessageRegistration {

    private static final Map<JT809SubMessageId, BiFunction<ISpecificationContext, IJT809MessageBufferReader, JT809_Message_Content_0x1400_SubMessage>> decoders = new HashMap<>(300);

    public static Map<JT809SubMessageId, BiFunction<ISpecificationContext, IJT809MessageBufferReader, JT809_Message_Content_0x1400_SubMessage>> getDecoders() {
        return decoders;
    }

    public static void registerDecoder(JT809SubMessageId messageId, BiFunction<ISpecificationContext, IJT809MessageBufferReader, JT809_Message_Content_0x1400_SubMessage> contentDecoder) {
        decoders.put(messageId, contentDecoder);
    }

    static {
        registerDecoder(JT809_Message_Content_0x1400_Sub_0x1402.SUB_MESSAGE_ID, JT809_Message_Content_0x1400_Sub_0x1402::decode);
    }
}
