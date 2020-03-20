package ai.sangmado.gbprotocol.gb32960.protocol.message;

import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960PlatformCommandId;
import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960ProtocolVersion;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.IGB32960MessageFormatter;

/**
 * GB32960 消息通用接口 (平台)
 */
public interface IGB32960PlatformMessage extends IGB32960MessageFormatter {
    /**
     * 获取协议版本
     *
     * @return 协议版本
     */
    GB32960ProtocolVersion getProtocolVersion();

    /**
     * 获取命令ID
     *
     * @return 命令ID
     */
    GB32960PlatformCommandId getCommandId();
}
