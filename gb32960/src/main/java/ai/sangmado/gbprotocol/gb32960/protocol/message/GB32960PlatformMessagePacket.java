package ai.sangmado.gbprotocol.gb32960.protocol.message;

import ai.sangmado.gbprotocol.gb32960.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960PlatformCommandId;
import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960ProtocolVersion;
import ai.sangmado.gbprotocol.gb32960.protocol.message.content.platform.GB32960PlatformMessageContent;
import ai.sangmado.gbprotocol.gb32960.protocol.message.header.platform.GB32960PlatformMessageHeader;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.IGB32960MessageBufferReader;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.IGB32960MessageBufferWriter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * GB32960 消息包 (平台)
 */
@Slf4j
@NoArgsConstructor
public class GB32960PlatformMessagePacket implements IGB32960PlatformMessage {

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
    private GB32960PlatformMessageHeader header;

    /**
     * 消息体
     */
    @Getter
    @Setter
    private GB32960PlatformMessageContent content;

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
    public GB32960PlatformCommandId getCommandId() {
        return this.header.getCommandId();
    }

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IGB32960MessageBufferWriter writer) {
        // 这个协议很流氓，平台和终端的消息ID是一样的
    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IGB32960MessageBufferReader reader) {
        // 这个协议很流氓，平台和终端的消息ID是一样的
    }
}
