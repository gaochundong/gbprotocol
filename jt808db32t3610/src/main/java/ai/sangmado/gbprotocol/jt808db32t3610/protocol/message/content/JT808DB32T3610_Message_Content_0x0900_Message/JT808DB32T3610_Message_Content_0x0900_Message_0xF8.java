package ai.sangmado.gbprotocol.jt808db32t3610.protocol.message.content.JT808DB32T3610_Message_Content_0x0900_Message;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_Passthrough_Message.JT808_Message_Content_0x0900_Base;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 透传消息 - 信息查询
 */
@NoArgsConstructor
public class JT808DB32T3610_Message_Content_0x0900_Message_0xF8 extends JT808_Message_Content_0x0900_Base {
    public static final JT808DB32T3610_Message_Content_Passthrough_MessageType MESSAGE_TYPE =
            JT808DB32T3610_Message_Content_Passthrough_MessageType.JT808DB32T3610_Passthrough_Message_0xF8;

    @Override
    public JT808DB32T3610_Message_Content_Passthrough_MessageType getPassthroughMessageType() {
        return MESSAGE_TYPE;
    }

    /**
     * 外设ID
     */
    @Getter
    @Setter
    private JT808DB32T3610_Message_Content_Passthrough_PeripheralId peripheralId;
    /**
     * 消息长度
     */
    @Getter
    @Setter
    private Integer messageLength;
    /**
     * 公司名称长度
     */
    @Getter
    @Setter
    private Integer companyNameLength;
    /**
     * 公司名称
     */
    @Getter
    @Setter
    private String companyName;
    /**
     * 产品型号长度
     */
    @Getter
    @Setter
    private Integer productModelLength;
    /**
     * 产品型号
     */
    @Getter
    @Setter
    private String productModel;
    /**
     * 硬件版本号长度
     */
    @Getter
    @Setter
    private Integer hardwareVersionLength;
    /**
     * 硬件版本号
     */
    @Getter
    @Setter
    private String hardwareVersion;
    /**
     * 软件版本号长度
     */
    @Getter
    @Setter
    private Integer softwareVersionLength;
    /**
     * 软件版本号
     */
    @Getter
    @Setter
    private String softwareVersion;
    /**
     * 设备ID长度
     */
    @Getter
    @Setter
    private Integer deviceIdLength;
    /**
     * 设备ID
     */
    @Getter
    @Setter
    private String deviceId;
    /**
     * 客户代码长度
     */
    @Getter
    @Setter
    private Integer customerCodeLength;
    /**
     * 客户代码
     */
    @Getter
    @Setter
    private String customerCode;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB32T3610_Message_Content_0x0900_Message_0xF8 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB32T3610_Message_Content_0x0900_Message_0xF8 content = new JT808DB32T3610_Message_Content_0x0900_Message_0xF8();
        content.deserialize(ctx, reader);
        return content;
    }
}
