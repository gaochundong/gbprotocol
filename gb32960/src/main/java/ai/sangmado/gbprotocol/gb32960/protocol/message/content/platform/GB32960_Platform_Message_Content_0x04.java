package ai.sangmado.gbprotocol.gb32960.protocol.message.content.platform;

import ai.sangmado.gbprotocol.gb32960.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960PlatformCommandId;
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
public class GB32960_Platform_Message_Content_0x04 extends GB32960PlatformMessageContent {
    public static final GB32960PlatformCommandId COMMAND_ID = GB32960PlatformCommandId.GB32960_Platform_Command_0x04;

    @Override
    public GB32960PlatformCommandId getCommandId() {
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

    public static GB32960_Platform_Message_Content_0x04 decode(ISpecificationContext ctx, IGB32960MessageBufferReader reader) {
        GB32960_Platform_Message_Content_0x04 content = new GB32960_Platform_Message_Content_0x04();
        content.deserialize(ctx, reader);
        return content;
    }
}
