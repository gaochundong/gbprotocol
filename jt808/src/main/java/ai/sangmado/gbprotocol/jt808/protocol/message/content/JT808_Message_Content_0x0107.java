package ai.sangmado.gbprotocol.jt808.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.*;

/**
 * 终端平台查询终端属性应答
 *
 * @since V2013
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808_Message_Content_0x0107 extends JT808MessageContent {
    public static final JT808MessageId MESSAGE_ID = JT808MessageId.JT808_Message_0x0107;

    @Override
    public JT808MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 终端类型
     * <p>
     * bit0，0：不适用客运车辆，1：适用客运车辆；
     * bit1，0：不适用危险品车辆，1：适用危险品车辆；
     * bit2，0：不适用普通货运车辆，1：适用普通货运车辆；
     * bit3，0：不适用出租车辆，1：适用出租车辆；
     * bit6，0：不支持硬盘录像，1：支持硬盘录像；
     * bit7，0：一体机，1：分体机。
     */
    private Integer deviceType;
    /**
     * 制造商ID
     * <p>
     * 5个字节，终端制造商编码。
     */
    private String manufactureId;
    /**
     * 终端型号
     * <p>
     * 20个字节，此终端型号由制造商自行定义，位数不足时，后补“0X00”。
     */
    private String deviceModel;
    /**
     * 终端ID
     * <p>
     * 7个字节，由大写字母和数字组成，此终端ID由制造商自行定义，位数不足时，后补“0X00”。
     */
    private String deviceId;
    /**
     * 终端SIM卡ICCID
     */
    private String iccid;
    /**
     * 终端硬件版本号长度
     */
    private Integer hardwareVersionLength;
    /**
     * 终端硬件版本号
     */
    private String hardwareVersion;
    /**
     * 终端固件版本号长度
     */
    private Integer firmwareVersionLength;
    /**
     * 终端固件版本号
     */
    private String firmwareVersion;
    /**
     * GNSS模块属性
     * <p>
     * bit0，0：不支持GPS 定位，1：支持GPS 定位；
     * bit1，0：不支持北斗定位，1：支持北斗定位；
     * bit2，0：不支持GLONASS 定位，1：支持GLONASS 定位；
     * bit3，0：不支持Galileo 定位，1：支持Galileo 定位。
     */
    private Integer gnssModuleProperty;
    /**
     * 通信模块属性
     * <p>
     * bit0，0：不支持GPRS通信，1：支持GPRS通信；
     * bit1，0：不支持CDMA通信，1：支持CDMA通信；
     * bit2，0：不支持TD-SCDMA通信，1：支持TD-SCDMA通信；
     * bit3，0：不支持WCDMA通信，1：支持WCDMA通信；
     * bit4，0：不支持CDMA2000通信，1：支持CDMA2000通信。
     * bit5，0：不支持TD-LTE通信，1：支持TD-LTE通信；
     * bit7，0：不支持其他通信方式，1：支持其他通信方式。
     */
    private Integer communicationModuleProperty;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808_Message_Content_0x0107 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x0107 content = new JT808_Message_Content_0x0107();
        content.deserialize(ctx, reader);
        return content;
    }
}
