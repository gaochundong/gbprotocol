package ai.sangmado.gbprotocol.gb32960.protocol.message;

import ai.sangmado.gbprotocol.gb32960.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960DeviceCommandId;
import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960ProtocolVersion;
import ai.sangmado.gbprotocol.gb32960.protocol.message.content.device.GB32960DeviceMessageContent;
import ai.sangmado.gbprotocol.gb32960.protocol.message.header.device.GB32960DeviceMessageHeader;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.IGB32960MessageBufferReader;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.IGB32960MessageBufferWriter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * GB32960 消息包 (终端)
 */
@Slf4j
@NoArgsConstructor
public class GB32960DeviceMessagePacket implements IGB32960DeviceMessage {

    /**
     * 起始符1
     */
    @Getter
    @Setter
    private byte beginMarker1 = 0x23;

    /**
     * 起始符2
     */
    @Getter
    @Setter
    private byte beginMarker2 = 0x23;

    /**
     * 消息头
     */
    @Getter
    @Setter
    private GB32960DeviceMessageHeader header;

    /**
     * 消息体
     */
    @Getter
    @Setter
    private GB32960DeviceMessageContent content;

    /**
     * BCC异或校验码
     */
    @Getter
    @Setter
    private int checksum;

    /**
     * 获取协议版本
     *
     * @return 协议版本
     */
    @Override
    public GB32960ProtocolVersion getProtocolVersion() {
        return this.header.getProtocolVersion();
    }

    /**
     * 获取命令ID
     *
     * @return 命令ID
     */
    @Override
    public GB32960DeviceCommandId getCommandId() {
        return this.header.getCommandId();
    }

    @Override
    public void serialize(ISpecificationContext ctx, IGB32960MessageBufferWriter writer) {
        // 这个协议很流氓，平台和终端的消息ID是一样的
    }

    @Override
    public void deserialize(ISpecificationContext ctx, IGB32960MessageBufferReader reader) {
        // 这个协议很流氓，平台和终端的消息ID是一样的
    }
}
