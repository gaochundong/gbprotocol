package ai.sangmado.jt809db32t3610.protocol.message.extension;

import ai.sangmado.jt809.protocol.enums.JT809MessageId;
import ai.sangmado.jt809.protocol.message.content.JT809MessageContentRegistration;
import ai.sangmado.jt809db32t3610.protocol.enums.JT809DB32T3610MessageId;
import ai.sangmado.jt809db32t3610.protocol.message.content.JT809DB32T3610_Message_Content_0x1240;

import java.util.ArrayList;

/**
 * 江苏省地方标准 DB32/T3610 协议扩展
 */
public class JT809DB32T3610MessageExtension {

    /**
     * DB32/T3610 协议扩展
     */
    public static void extend() {
        extend_Message_Content_Definitions();
    }

    /**
     * DB32/T3610 协议扩展消息体定义
     */
    private static void extend_Message_Content_Definitions() {
        JT809MessageId.putExtensions(new ArrayList<>(JT809DB32T3610MessageId.get_JT809DB32T3610MessageId_List()));

        JT809MessageContentRegistration.registerDecoder(JT809DB32T3610_Message_Content_0x1240.MESSAGE_ID, JT809DB32T3610_Message_Content_0x1240::decode);
    }
}
