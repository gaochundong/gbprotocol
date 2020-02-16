package ai.sangmado.jt1078.protocol.message.extension;

import ai.sangmado.jt1078.protocol.enums.JT1078MessageId;
import ai.sangmado.jt1078.protocol.message.content.*;
import ai.sangmado.jt808.protocol.enums.JT808MessageId;

import java.util.ArrayList;

import static ai.sangmado.jt808.protocol.message.content.JT808MessageContentRegistration.register;

/**
 * JT1078 协议扩展
 */
public class JT1078MessageExtension {

    /**
     * JT1078 协议扩展消息ID
     */
    public void extendMessageIdDefinitions() {
        JT808MessageId.putExtensions(new ArrayList<>(JT1078MessageId.getJT1078MessageIdList()));
    }

    /**
     * JT1078 协议扩展消息体定义
     */
    public void extendMessageContentDefinitions() {
        register(JT1078_Message_Content_0x1003.MESSAGE_ID, JT1078_Message_Content_0x1003::decode);
        register(JT1078_Message_Content_0x1005.MESSAGE_ID, JT1078_Message_Content_0x1005::decode);
        register(JT1078_Message_Content_0x9003.MESSAGE_ID, JT1078_Message_Content_0x9003::decode);
        register(JT1078_Message_Content_0x9101.MESSAGE_ID, JT1078_Message_Content_0x9101::decode);
        register(JT1078_Message_Content_0x9105.MESSAGE_ID, JT1078_Message_Content_0x9105::decode);
    }
}
