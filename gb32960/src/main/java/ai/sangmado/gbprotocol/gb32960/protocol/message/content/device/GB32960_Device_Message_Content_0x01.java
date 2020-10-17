package ai.sangmado.gbprotocol.gb32960.protocol.message.content.device;

import ai.sangmado.gbprotocol.gb32960.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960DeviceCommandId;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.IGB32960MessageBufferReader;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.IGB32960MessageBufferWriter;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 车辆登入
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GB32960_Device_Message_Content_0x01 extends GB32960DeviceMessageContent {
    public static final GB32960DeviceCommandId COMMAND_ID = GB32960DeviceCommandId.GB32960_Device_Command_0x01;

    @Override
    public GB32960DeviceCommandId getCommandId() {
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
    public void serialize(IVersionedSpecificationContext ctx, IGB32960MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IGB32960MessageBufferReader reader) {

    }

    public static GB32960_Device_Message_Content_0x01 decode(IVersionedSpecificationContext ctx, IGB32960MessageBufferReader reader) {
        GB32960_Device_Message_Content_0x01 content = new GB32960_Device_Message_Content_0x01();
        content.deserialize(ctx, reader);
        return content;
    }
}
