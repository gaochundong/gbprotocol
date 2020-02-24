package ai.sangmado.db32t3610.protocol.message.extension;

import ai.sangmado.db32t3610.protocol.enums.DB32T3610MessageId;
import ai.sangmado.db32t3610.protocol.message.content.DB32T3610_Message_Content_0x0200_Additional.*;
import ai.sangmado.db32t3610.protocol.message.content.*;
import ai.sangmado.db32t3610.protocol.message.content.DB32T3610_Message_Content_0x8103_Parameter.*;
import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.jt808.protocol.message.content.JT808MessageContentRegistration;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformationId;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformationRegistration;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItemId;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItemRegistration;

import java.util.ArrayList;

/**
 * 江苏省地方标准 DB32/T3610 协议扩展
 */
public class DB32T3610MessageExtension {

    /**
     * DB32/T3610 协议扩展
     */
    public static void extend() {
        extend_Message_Content_Definitions();
        extend_Message_Content_0x0200_AdditionalInformation_Definitions();
        extend_Message_Content_0x8103_ParameterItem_Definitions();
    }

    /**
     * DB32/T3610 协议扩展消息体定义
     */
    private static void extend_Message_Content_Definitions() {
        JT808MessageId.putExtensions(new ArrayList<>(DB32T3610MessageId.get_DB32T3610MessageId_List()));

        JT808MessageContentRegistration.registerDecoder(DB32T3610_Message_Content_0x1210.MESSAGE_ID, DB32T3610_Message_Content_0x1210::decode);
        JT808MessageContentRegistration.registerDecoder(DB32T3610_Message_Content_0x1211.MESSAGE_ID, DB32T3610_Message_Content_0x1211::decode);
        JT808MessageContentRegistration.registerDecoder(DB32T3610_Message_Content_0x1212.MESSAGE_ID, DB32T3610_Message_Content_0x1212::decode);
        JT808MessageContentRegistration.registerDecoder(DB32T3610_Message_Content_0x9208.MESSAGE_ID, DB32T3610_Message_Content_0x9208::decode);
        JT808MessageContentRegistration.registerDecoder(DB32T3610_Message_Content_0x9212.MESSAGE_ID, DB32T3610_Message_Content_0x9212::decode);
    }

    /**
     * DB32/T3610 协议扩展0x0200消息体定义
     */
    private static void extend_Message_Content_0x0200_AdditionalInformation_Definitions() {
        JT808_Message_Content_0x0200_AdditionalInformationId.putExtensions(new ArrayList<>(DB32T3610_Message_Content_0x0200_AdditionalInformationId.get_DB32T3610_Message_Content_0x0200_AdditionalInformationId_List()));

        JT808_Message_Content_0x0200_AdditionalInformationRegistration.registerDecoder(DB32T3610_Message_Content_0x0200_AI_0x64.ADDITIONAL_INFORMATION_ID, DB32T3610_Message_Content_0x0200_AI_0x64::decode);
        JT808_Message_Content_0x0200_AdditionalInformationRegistration.registerDecoder(DB32T3610_Message_Content_0x0200_AI_0x65.ADDITIONAL_INFORMATION_ID, DB32T3610_Message_Content_0x0200_AI_0x65::decode);
        JT808_Message_Content_0x0200_AdditionalInformationRegistration.registerDecoder(DB32T3610_Message_Content_0x0200_AI_0x66.ADDITIONAL_INFORMATION_ID, DB32T3610_Message_Content_0x0200_AI_0x66::decode);
        JT808_Message_Content_0x0200_AdditionalInformationRegistration.registerDecoder(DB32T3610_Message_Content_0x0200_AI_0x67.ADDITIONAL_INFORMATION_ID, DB32T3610_Message_Content_0x0200_AI_0x67::decode);
    }

    /**
     * DB32/T3610 协议扩展0x8103消息体定义
     */
    private static void extend_Message_Content_0x8103_ParameterItem_Definitions() {
        JT808_Message_Content_0x8103_ParameterItemId.putExtensions(new ArrayList<>(DB32T3610_Message_Content_0x8103_ParameterItemId.get_DB32T3610_Message_Content_0x8103_ParameterItemId_List()));

        JT808_Message_Content_0x8103_ParameterItemRegistration.registerDecoder(DB32T3610_Message_Content_0x8103_PI_0xF364.PARAMETER_ITEM_ID, DB32T3610_Message_Content_0x8103_PI_0xF364::decode);
        JT808_Message_Content_0x8103_ParameterItemRegistration.registerDecoder(DB32T3610_Message_Content_0x8103_PI_0xF365.PARAMETER_ITEM_ID, DB32T3610_Message_Content_0x8103_PI_0xF365::decode);
        JT808_Message_Content_0x8103_ParameterItemRegistration.registerDecoder(DB32T3610_Message_Content_0x8103_PI_0xF366.PARAMETER_ITEM_ID, DB32T3610_Message_Content_0x8103_PI_0xF366::decode);
        JT808_Message_Content_0x8103_ParameterItemRegistration.registerDecoder(DB32T3610_Message_Content_0x8103_PI_0xF367.PARAMETER_ITEM_ID, DB32T3610_Message_Content_0x8103_PI_0xF367::decode);
    }
}
