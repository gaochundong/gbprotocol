package ai.sangmado.gbprotocol.jt808db37lubiao.protocol.message.extension;

import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContentRegistration;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformationId;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformationRegistration;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItemId;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItemRegistration;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_Passthrough_Message.JT808_Message_Content_0x0900_Registration;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_Passthrough_Message.JT808_Message_Content_Passthrough_MessageType;
import ai.sangmado.gbprotocol.jt808db37lubiao.protocol.enums.JT808DB37LuBiaoMessageId;
import ai.sangmado.gbprotocol.jt808db37lubiao.protocol.message.content.JT808DB37LuBiao_Message_Content_0x0200_Additional.*;
import ai.sangmado.gbprotocol.jt808db37lubiao.protocol.message.content.*;
import ai.sangmado.gbprotocol.jt808db37lubiao.protocol.message.content.JT808DB37LuBiao_Message_Content_0x8103_Parameter.*;
import ai.sangmado.gbprotocol.jt808db37lubiao.protocol.message.content.JT808DB37LuBiao_Message_Content_Passthrough_Message.JT808DB37LuBiao_Message_Content_0x0900_Message_0xF7;
import ai.sangmado.gbprotocol.jt808db37lubiao.protocol.message.content.JT808DB37LuBiao_Message_Content_Passthrough_Message.JT808DB37LuBiao_Message_Content_0x0900_Message_0xF8;
import ai.sangmado.gbprotocol.jt808db37lubiao.protocol.message.content.JT808DB37LuBiao_Message_Content_Passthrough_Message.JT808DB37LuBiao_Message_Content_Passthrough_MessageType;

import java.util.ArrayList;

/**
 * 鲁标 协议扩展
 */
public class JT808DB37LuBiaoMessageExtension {

    /**
     * 鲁标 协议扩展
     */
    public static void extend() {
        extend_Message_Content_Definitions();
        extend_Message_Content_0x0200_AdditionalInformation_Definitions();
        extend_Message_Content_0x8103_ParameterItem_Definitions();
        extend_Message_Content_Passthrough_Message_Definitions();
    }

    /**
     * 鲁标 协议扩展消息体定义
     */
    private static void extend_Message_Content_Definitions() {
        JT808MessageId.putExtensions(new ArrayList<>(JT808DB37LuBiaoMessageId.get_JT808DB37LuBiaoMessageId_List()));

        JT808MessageContentRegistration.registerDecoder(JT808DB37LuBiao_Message_Content_0x1210.MESSAGE_ID, JT808DB37LuBiao_Message_Content_0x1210::decode);
        JT808MessageContentRegistration.registerDecoder(JT808DB37LuBiao_Message_Content_0x1211.MESSAGE_ID, JT808DB37LuBiao_Message_Content_0x1211::decode);
        JT808MessageContentRegistration.registerDecoder(JT808DB37LuBiao_Message_Content_0x1212.MESSAGE_ID, JT808DB37LuBiao_Message_Content_0x1212::decode);
        JT808MessageContentRegistration.registerDecoder(JT808DB37LuBiao_Message_Content_0x9208.MESSAGE_ID, JT808DB37LuBiao_Message_Content_0x9208::decode);
        JT808MessageContentRegistration.registerDecoder(JT808DB37LuBiao_Message_Content_0x9212.MESSAGE_ID, JT808DB37LuBiao_Message_Content_0x9212::decode);

        // 鲁标 人脸识别扩展
        JT808MessageContentRegistration.registerDecoder(JT808DB37LuBiao_Message_Content_0x0E10.MESSAGE_ID, JT808DB37LuBiao_Message_Content_0x0E10::decode);
        JT808MessageContentRegistration.registerDecoder(JT808DB37LuBiao_Message_Content_0x0E11.MESSAGE_ID, JT808DB37LuBiao_Message_Content_0x0E11::decode);
        JT808MessageContentRegistration.registerDecoder(JT808DB37LuBiao_Message_Content_0x0E12.MESSAGE_ID, JT808DB37LuBiao_Message_Content_0x0E12::decode);
        JT808MessageContentRegistration.registerDecoder(JT808DB37LuBiao_Message_Content_0x8E10.MESSAGE_ID, JT808DB37LuBiao_Message_Content_0x8E10::decode);
        JT808MessageContentRegistration.registerDecoder(JT808DB37LuBiao_Message_Content_0x8E11.MESSAGE_ID, JT808DB37LuBiao_Message_Content_0x8E11::decode);
        JT808MessageContentRegistration.registerDecoder(JT808DB37LuBiao_Message_Content_0x8E12.MESSAGE_ID, JT808DB37LuBiao_Message_Content_0x8E12::decode);
    }

    /**
     * 鲁标 协议扩展0x0200消息体定义
     */
    private static void extend_Message_Content_0x0200_AdditionalInformation_Definitions() {
        JT808_Message_Content_0x0200_AdditionalInformationId.putExtensions(new ArrayList<>(JT808DB37LuBiao_Message_Content_0x0200_AdditionalInformationId.get_JT808DB37LuBiao_Message_Content_0x0200_AdditionalInformationId_List()));

        JT808_Message_Content_0x0200_AdditionalInformationRegistration.registerDecoder(JT808DB37LuBiao_Message_Content_0x0200_AI_0x64.ADDITIONAL_INFORMATION_ID, JT808DB37LuBiao_Message_Content_0x0200_AI_0x64::decode);
        JT808_Message_Content_0x0200_AdditionalInformationRegistration.registerDecoder(JT808DB37LuBiao_Message_Content_0x0200_AI_0x65.ADDITIONAL_INFORMATION_ID, JT808DB37LuBiao_Message_Content_0x0200_AI_0x65::decode);
        JT808_Message_Content_0x0200_AdditionalInformationRegistration.registerDecoder(JT808DB37LuBiao_Message_Content_0x0200_AI_0x66.ADDITIONAL_INFORMATION_ID, JT808DB37LuBiao_Message_Content_0x0200_AI_0x66::decode);
        JT808_Message_Content_0x0200_AdditionalInformationRegistration.registerDecoder(JT808DB37LuBiao_Message_Content_0x0200_AI_0x67.ADDITIONAL_INFORMATION_ID, JT808DB37LuBiao_Message_Content_0x0200_AI_0x67::decode);
    }

    /**
     * 鲁标 协议扩展0x8103消息体定义
     */
    private static void extend_Message_Content_0x8103_ParameterItem_Definitions() {
        JT808_Message_Content_0x8103_ParameterItemId.putExtensions(new ArrayList<>(JT808DB37LuBiao_Message_Content_0x8103_ParameterItemId.get_JT808DB37LuBiao_Message_Content_0x8103_ParameterItemId_List()));

        JT808_Message_Content_0x8103_ParameterItemRegistration.registerDecoder(JT808DB37LuBiao_Message_Content_0x8103_PI_0xF364.PARAMETER_ITEM_ID, JT808DB37LuBiao_Message_Content_0x8103_PI_0xF364::decode);
        JT808_Message_Content_0x8103_ParameterItemRegistration.registerDecoder(JT808DB37LuBiao_Message_Content_0x8103_PI_0xF365.PARAMETER_ITEM_ID, JT808DB37LuBiao_Message_Content_0x8103_PI_0xF365::decode);
        JT808_Message_Content_0x8103_ParameterItemRegistration.registerDecoder(JT808DB37LuBiao_Message_Content_0x8103_PI_0xF366.PARAMETER_ITEM_ID, JT808DB37LuBiao_Message_Content_0x8103_PI_0xF366::decode);
        JT808_Message_Content_0x8103_ParameterItemRegistration.registerDecoder(JT808DB37LuBiao_Message_Content_0x8103_PI_0xF367.PARAMETER_ITEM_ID, JT808DB37LuBiao_Message_Content_0x8103_PI_0xF367::decode);

        // 鲁标 人脸识别扩展
        JT808_Message_Content_0x8103_ParameterItemRegistration.registerDecoder(JT808DB37LuBiao_Message_Content_0x8103_PI_0xF0E9.PARAMETER_ITEM_ID, JT808DB37LuBiao_Message_Content_0x8103_PI_0xF0E9::decode);
    }

    /**
     * 鲁标 协议扩展0x0900/0x8900透传消息体定义
     */
    private static void extend_Message_Content_Passthrough_Message_Definitions() {
        JT808_Message_Content_Passthrough_MessageType.putExtensions(new ArrayList<>(JT808DB37LuBiao_Message_Content_Passthrough_MessageType.get_JT808DB37LuBiao_Message_Content_Passthrough_MessageType_List()));

        JT808_Message_Content_0x0900_Registration.registerDecoder(JT808DB37LuBiao_Message_Content_0x0900_Message_0xF7.MESSAGE_TYPE, JT808DB37LuBiao_Message_Content_0x0900_Message_0xF7::decode);
        JT808_Message_Content_0x0900_Registration.registerDecoder(JT808DB37LuBiao_Message_Content_0x0900_Message_0xF8.MESSAGE_TYPE, JT808DB37LuBiao_Message_Content_0x0900_Message_0xF8::decode);
    }
}
