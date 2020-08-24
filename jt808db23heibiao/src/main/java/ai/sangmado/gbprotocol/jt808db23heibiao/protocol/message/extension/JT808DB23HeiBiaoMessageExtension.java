package ai.sangmado.gbprotocol.jt808db23heibiao.protocol.message.extension;

import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContentRegistration;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformationId;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformationRegistration;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItemId;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItemRegistration;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_Passthrough_Message.JT808_Message_Content_0x0900_Registration;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_Passthrough_Message.JT808_Message_Content_Passthrough_MessageType;
import ai.sangmado.gbprotocol.jt808db23heibiao.protocol.enums.JT808DB23HeiBiaoMessageId;
import ai.sangmado.gbprotocol.jt808db23heibiao.protocol.message.content.JT808DB23HeiBiao_Message_Content_0x0200_Additional.*;
import ai.sangmado.gbprotocol.jt808db23heibiao.protocol.message.content.*;
import ai.sangmado.gbprotocol.jt808db23heibiao.protocol.message.content.JT808DB23HeiBiao_Message_Content_0x8103_Parameter.*;
import ai.sangmado.gbprotocol.jt808db23heibiao.protocol.message.content.JT808DB23HeiBiao_Message_Content_0x0900_Message.JT808DB23HeiBiao_Message_Content_0x0900_Message_0xF7;
import ai.sangmado.gbprotocol.jt808db23heibiao.protocol.message.content.JT808DB23HeiBiao_Message_Content_0x0900_Message.JT808DB23HeiBiao_Message_Content_0x0900_Message_0xF8;
import ai.sangmado.gbprotocol.jt808db23heibiao.protocol.message.content.JT808DB23HeiBiao_Message_Content_0x0900_Message.JT808DB23HeiBiao_Message_Content_Passthrough_MessageType;

import java.util.ArrayList;

/**
 * 黑标 协议扩展
 */
public class JT808DB23HeiBiaoMessageExtension {

    /**
     * 黑标 协议扩展
     */
    public static void extend() {
        extend_Message_Content_Definitions();
        extend_Message_Content_0x0200_AdditionalInformation_Definitions();
        extend_Message_Content_0x8103_ParameterItem_Definitions();
        extend_Message_Content_0x0900_Message_Definitions();
    }

    /**
     * 黑标 协议扩展消息体定义
     */
    private static void extend_Message_Content_Definitions() {
        JT808MessageId.putExtensions(new ArrayList<>(JT808DB23HeiBiaoMessageId.get_JT808DB23HeiBiaoMessageId_List()));

        JT808MessageContentRegistration.registerDecoder(JT808DB23HeiBiao_Message_Content_0x1210.MESSAGE_ID, JT808DB23HeiBiao_Message_Content_0x1210::decode);
        JT808MessageContentRegistration.registerDecoder(JT808DB23HeiBiao_Message_Content_0x1211.MESSAGE_ID, JT808DB23HeiBiao_Message_Content_0x1211::decode);
        JT808MessageContentRegistration.registerDecoder(JT808DB23HeiBiao_Message_Content_0x1212.MESSAGE_ID, JT808DB23HeiBiao_Message_Content_0x1212::decode);
        JT808MessageContentRegistration.registerDecoder(JT808DB23HeiBiao_Message_Content_0x9208.MESSAGE_ID, JT808DB23HeiBiao_Message_Content_0x9208::decode);
        JT808MessageContentRegistration.registerDecoder(JT808DB23HeiBiao_Message_Content_0x9212.MESSAGE_ID, JT808DB23HeiBiao_Message_Content_0x9212::decode);

        // 黑标 身份认证
        JT808MessageContentRegistration.registerDecoder(JT808DB23HeiBiao_Message_Content_0x8C01.MESSAGE_ID, JT808DB23HeiBiao_Message_Content_0x8C01::decode);
        JT808MessageContentRegistration.registerDecoder(JT808DB23HeiBiao_Message_Content_0x0C02.MESSAGE_ID, JT808DB23HeiBiao_Message_Content_0x0C02::decode);
        JT808MessageContentRegistration.registerDecoder(JT808DB23HeiBiao_Message_Content_0x8C02.MESSAGE_ID, JT808DB23HeiBiao_Message_Content_0x8C02::decode);
        JT808MessageContentRegistration.registerDecoder(JT808DB23HeiBiao_Message_Content_0x0C00.MESSAGE_ID, JT808DB23HeiBiao_Message_Content_0x0C00::decode);

        // 黑标 设备状态汇总上报日报
        JT808MessageContentRegistration.registerDecoder(JT808DB23HeiBiao_Message_Content_0x0F01.MESSAGE_ID, JT808DB23HeiBiao_Message_Content_0x0F01::decode);
    }

    /**
     * 黑标 协议扩展0x0200消息体定义
     */
    private static void extend_Message_Content_0x0200_AdditionalInformation_Definitions() {
        JT808_Message_Content_0x0200_AdditionalInformationId.putExtensions(new ArrayList<>(JT808DB23HeiBiao_Message_Content_0x0200_AdditionalInformationId.get_JT808DB23HeiBiao_Message_Content_0x0200_AdditionalInformationId_List()));

        JT808_Message_Content_0x0200_AdditionalInformationRegistration.registerDecoder(JT808DB23HeiBiao_Message_Content_0x0200_AI_0x64.ADDITIONAL_INFORMATION_ID, JT808DB23HeiBiao_Message_Content_0x0200_AI_0x64::decode);
        JT808_Message_Content_0x0200_AdditionalInformationRegistration.registerDecoder(JT808DB23HeiBiao_Message_Content_0x0200_AI_0x65.ADDITIONAL_INFORMATION_ID, JT808DB23HeiBiao_Message_Content_0x0200_AI_0x65::decode);
        JT808_Message_Content_0x0200_AdditionalInformationRegistration.registerDecoder(JT808DB23HeiBiao_Message_Content_0x0200_AI_0x71.ADDITIONAL_INFORMATION_ID, JT808DB23HeiBiao_Message_Content_0x0200_AI_0x71::decode);
        JT808_Message_Content_0x0200_AdditionalInformationRegistration.registerDecoder(JT808DB23HeiBiao_Message_Content_0x0200_AI_0x32.ADDITIONAL_INFORMATION_ID, JT808DB23HeiBiao_Message_Content_0x0200_AI_0x32::decode);
    }

    /**
     * 黑标 协议扩展0x8103消息体定义
     */
    private static void extend_Message_Content_0x8103_ParameterItem_Definitions() {
        JT808_Message_Content_0x8103_ParameterItemId.putExtensions(new ArrayList<>(JT808DB23HeiBiao_Message_Content_0x8103_ParameterItemId.get_JT808DB23HeiBiao_Message_Content_0x8103_ParameterItemId_List()));

        JT808_Message_Content_0x8103_ParameterItemRegistration.registerDecoder(JT808DB23HeiBiao_Message_Content_0x8103_PI_0xF364.PARAMETER_ITEM_ID, JT808DB23HeiBiao_Message_Content_0x8103_PI_0xF364::decode);
        JT808_Message_Content_0x8103_ParameterItemRegistration.registerDecoder(JT808DB23HeiBiao_Message_Content_0x8103_PI_0xF365.PARAMETER_ITEM_ID, JT808DB23HeiBiao_Message_Content_0x8103_PI_0xF365::decode);

        // 黑标 主备服务器地址
        JT808_Message_Content_0x8103_ParameterItemRegistration.registerDecoder(JT808DB23HeiBiao_Message_Content_0x8103_PI_0xFF01.PARAMETER_ITEM_ID, JT808DB23HeiBiao_Message_Content_0x8103_PI_0xFF01::decode);
        JT808_Message_Content_0x8103_ParameterItemRegistration.registerDecoder(JT808DB23HeiBiao_Message_Content_0x8103_PI_0xFF02.PARAMETER_ITEM_ID, JT808DB23HeiBiao_Message_Content_0x8103_PI_0xFF02::decode);
    }

    /**
     * 黑标 协议扩展0x0900/0x8900透传消息体定义
     */
    private static void extend_Message_Content_0x0900_Message_Definitions() {
        JT808_Message_Content_Passthrough_MessageType.putExtensions(new ArrayList<>(JT808DB23HeiBiao_Message_Content_Passthrough_MessageType.get_JT808DB23HeiBiao_Message_Content_Passthrough_MessageType_List()));

        JT808_Message_Content_0x0900_Registration.registerDecoder(JT808DB23HeiBiao_Message_Content_0x0900_Message_0xF7.MESSAGE_TYPE, JT808DB23HeiBiao_Message_Content_0x0900_Message_0xF7::decode);
        JT808_Message_Content_0x0900_Registration.registerDecoder(JT808DB23HeiBiao_Message_Content_0x0900_Message_0xF8.MESSAGE_TYPE, JT808DB23HeiBiao_Message_Content_0x0900_Message_0xF8::decode);
    }
}
