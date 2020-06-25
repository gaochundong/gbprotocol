package ai.sangmado.gbprotocol.gb32960.protocol.message.content.device;

import ai.sangmado.gbprotocol.gb32960.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960DeviceCommandId;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.IGB32960MessageBufferReader;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.IGB32960MessageBufferWriter;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 车辆登出
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GB32960_Device_Message_Content_0x04 extends GB32960DeviceMessageContent {
    public static final GB32960DeviceCommandId COMMAND_ID = GB32960DeviceCommandId.GB32960_Device_Command_0x04;

    @Override
    public GB32960DeviceCommandId getCommandId() {
        return COMMAND_ID;
    }

    /**
     * 登出时间
     */
    private LocalDateTime dataCollectionTime;

    /**
     * 登出流水号
     */
    private Integer serialNumber;

    @Override
    public void serialize(ISpecificationContext ctx, IGB32960MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IGB32960MessageBufferReader reader) {

    }

    public static GB32960_Device_Message_Content_0x04 decode(ISpecificationContext ctx, IGB32960MessageBufferReader reader) {
        GB32960_Device_Message_Content_0x04 content = new GB32960_Device_Message_Content_0x04();
        content.deserialize(ctx, reader);
        return content;
    }
}
