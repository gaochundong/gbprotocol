package ai.sangmado.jt1078.protocol.message.extension;

import ai.sangmado.jt1078.protocol.enums.JT1078MessageId;
import ai.sangmado.jt1078.protocol.message.content.JT1078_Message_Content_0x0200_Additional.*;
import ai.sangmado.jt1078.protocol.message.content.*;
import ai.sangmado.jt1078.protocol.message.content.JT1078_Message_Content_0x8103_Parameter.*;
import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.jt808.protocol.message.content.JT808MessageContentRegistration;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformationId;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformationRegistration;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItemId;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItemRegistration;

import java.util.ArrayList;

/**
 * JT1078协议扩展
 */
public class JT1078MessageExtension {

    /**
     * JT1078协议扩展
     */
    public static void extend() {
        extend_Message_Content_Definitions();
        extend_Message_Content_0x0200_AdditionalInformation_Definitions();
        extend_Message_Content_0x8103_ParameterItem_Definitions();
    }

    /**
     * JT1078协议扩展消息体定义
     */
    private static void extend_Message_Content_Definitions() {
        JT808MessageId.putExtensions(new ArrayList<>(JT1078MessageId.get_JT1078MessageId_List()));

        JT808MessageContentRegistration.registerDecoder(JT1078_Message_Content_0x1003.MESSAGE_ID, JT1078_Message_Content_0x1003::decode);
        JT808MessageContentRegistration.registerDecoder(JT1078_Message_Content_0x1005.MESSAGE_ID, JT1078_Message_Content_0x1005::decode);
        JT808MessageContentRegistration.registerDecoder(JT1078_Message_Content_0x9003.MESSAGE_ID, JT1078_Message_Content_0x9003::decode);
        JT808MessageContentRegistration.registerDecoder(JT1078_Message_Content_0x9101.MESSAGE_ID, JT1078_Message_Content_0x9101::decode);
        JT808MessageContentRegistration.registerDecoder(JT1078_Message_Content_0x9102.MESSAGE_ID, JT1078_Message_Content_0x9102::decode);
        JT808MessageContentRegistration.registerDecoder(JT1078_Message_Content_0x9105.MESSAGE_ID, JT1078_Message_Content_0x9105::decode);
        JT808MessageContentRegistration.registerDecoder(JT1078_Message_Content_0x9205.MESSAGE_ID, JT1078_Message_Content_0x9205::decode);
    }

    /**
     * JT1078协议扩展0x0200消息体定义
     */
    private static void extend_Message_Content_0x0200_AdditionalInformation_Definitions() {
        JT808_Message_Content_0x0200_AdditionalInformationId.putExtensions(new ArrayList<>(JT1078_Message_Content_0x0200_AdditionalInformationId.get_JT1078_Message_Content_0x0200_AdditionalInformationId_List()));

        JT808_Message_Content_0x0200_AdditionalInformationRegistration.registerDecoder(JT1078_Message_Content_0x0200_AI_0x14.ADDITIONAL_INFORMATION_ID, JT1078_Message_Content_0x0200_AI_0x14::decode);
        JT808_Message_Content_0x0200_AdditionalInformationRegistration.registerDecoder(JT1078_Message_Content_0x0200_AI_0x15.ADDITIONAL_INFORMATION_ID, JT1078_Message_Content_0x0200_AI_0x15::decode);
        JT808_Message_Content_0x0200_AdditionalInformationRegistration.registerDecoder(JT1078_Message_Content_0x0200_AI_0x16.ADDITIONAL_INFORMATION_ID, JT1078_Message_Content_0x0200_AI_0x16::decode);
        JT808_Message_Content_0x0200_AdditionalInformationRegistration.registerDecoder(JT1078_Message_Content_0x0200_AI_0x17.ADDITIONAL_INFORMATION_ID, JT1078_Message_Content_0x0200_AI_0x17::decode);
        JT808_Message_Content_0x0200_AdditionalInformationRegistration.registerDecoder(JT1078_Message_Content_0x0200_AI_0x18.ADDITIONAL_INFORMATION_ID, JT1078_Message_Content_0x0200_AI_0x18::decode);
    }

    /**
     * JT1078协议扩展0x8103消息体定义
     */
    private static void extend_Message_Content_0x8103_ParameterItem_Definitions() {
        JT808_Message_Content_0x8103_ParameterItemId.putExtensions(new ArrayList<>(JT1078_Message_Content_0x8103_ParameterItemId.get_JT1078_Message_Content_0x8103_ParameterItemId_List()));

        JT808_Message_Content_0x8103_ParameterItemRegistration.registerDecoder(JT1078_Message_Content_0x8103_PI_0x0075.PARAMETER_ITEM_ID, JT1078_Message_Content_0x8103_PI_0x0075::decode);
        JT808_Message_Content_0x8103_ParameterItemRegistration.registerDecoder(JT1078_Message_Content_0x8103_PI_0x0076.PARAMETER_ITEM_ID, JT1078_Message_Content_0x8103_PI_0x0076::decode);
        JT808_Message_Content_0x8103_ParameterItemRegistration.registerDecoder(JT1078_Message_Content_0x8103_PI_0x0077.PARAMETER_ITEM_ID, JT1078_Message_Content_0x8103_PI_0x0077::decode);
        JT808_Message_Content_0x8103_ParameterItemRegistration.registerDecoder(JT1078_Message_Content_0x8103_PI_0x0079.PARAMETER_ITEM_ID, JT1078_Message_Content_0x8103_PI_0x0079::decode);
        JT808_Message_Content_0x8103_ParameterItemRegistration.registerDecoder(JT1078_Message_Content_0x8103_PI_0x007A.PARAMETER_ITEM_ID, JT1078_Message_Content_0x8103_PI_0x007A::decode);
        JT808_Message_Content_0x8103_ParameterItemRegistration.registerDecoder(JT1078_Message_Content_0x8103_PI_0x007B.PARAMETER_ITEM_ID, JT1078_Message_Content_0x8103_PI_0x007B::decode);
        JT808_Message_Content_0x8103_ParameterItemRegistration.registerDecoder(JT1078_Message_Content_0x8103_PI_0x007C.PARAMETER_ITEM_ID, JT1078_Message_Content_0x8103_PI_0x007C::decode);
    }
}
