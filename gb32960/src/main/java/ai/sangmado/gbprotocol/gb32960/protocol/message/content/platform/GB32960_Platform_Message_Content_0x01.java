package ai.sangmado.gbprotocol.gb32960.protocol.message.content.platform;

import ai.sangmado.gbprotocol.gb32960.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960PlatformCommandId;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.IGB32960MessageBufferReader;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.IGB32960MessageBufferWriter;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 车辆登入
 * <p>
 * 可充电储能子系统指当车辆存在多套可充电储能系统混合使用时，每套可充电储能系统为一个可充电储能子系统。
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GB32960_Platform_Message_Content_0x01 extends GB32960PlatformMessageContent {
    public static final GB32960PlatformCommandId COMMAND_ID = GB32960PlatformCommandId.GB32960_Platform_Command_0x01;

    @Override
    public GB32960PlatformCommandId getCommandId() {
        return COMMAND_ID;
    }

    /**
     * 数据采集时间(北京时间)
     */
    private LocalDateTime dataCollectionTime;

    /**
     * 登入流水号
     */
    private Integer serialNumber;

    /**
     * SIM卡ICCID
     */
    private String iccid;

    /**
     * 可充电储能子系统数
     */
    private Integer energySubSystemCount;

    /**
     * 可充电储能系统编码长度
     */
    private Integer energySystemEncodingLength;

    /**
     * 可充电储能系统编码
     */
    private List<String> energySystemEncodingCode;

    @Override
    public void serialize(ISpecificationContext ctx, IGB32960MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IGB32960MessageBufferReader reader) {

    }

    public static GB32960_Platform_Message_Content_0x01 decode(ISpecificationContext ctx, IGB32960MessageBufferReader reader) {
        GB32960_Platform_Message_Content_0x01 content = new GB32960_Platform_Message_Content_0x01();
        content.deserialize(ctx, reader);
        return content;
    }
}
