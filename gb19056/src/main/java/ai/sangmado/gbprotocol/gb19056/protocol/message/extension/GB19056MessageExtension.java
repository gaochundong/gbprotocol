package ai.sangmado.gbprotocol.gb19056.protocol.message.extension;

import ai.sangmado.gbprotocol.gb19056.protocol.message.jt808.JT808_Message_Content_0x0700;
import ai.sangmado.gbprotocol.gb19056.protocol.message.jt808.JT808_Message_Content_0x8700;
import ai.sangmado.gbprotocol.gb19056.protocol.message.jt808.JT808_Message_Content_0x8701;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContentRegistration;

/**
 * GB19056 协议扩展
 */
public class GB19056MessageExtension {

    /**
     * GB19056 协议扩展
     */
    public static void extend() {
        extend_JT808_Message_Definitions();
    }

    /**
     * JT808 消息定义
     */
    private static void extend_JT808_Message_Definitions() {
        JT808MessageContentRegistration.registerDecoder(JT808_Message_Content_0x8700.MESSAGE_ID, JT808_Message_Content_0x8700::decode);
        JT808MessageContentRegistration.registerDecoder(JT808_Message_Content_0x8701.MESSAGE_ID, JT808_Message_Content_0x8701::decode);
        JT808MessageContentRegistration.registerDecoder(JT808_Message_Content_0x0700.MESSAGE_ID, JT808_Message_Content_0x0700::decode);
    }
}
