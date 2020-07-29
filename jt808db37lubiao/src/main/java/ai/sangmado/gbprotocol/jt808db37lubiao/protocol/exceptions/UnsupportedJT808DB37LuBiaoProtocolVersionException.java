package ai.sangmado.gbprotocol.jt808db37lubiao.protocol.exceptions;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808ProtocolVersionException;

/**
 * 不支持协议版本异常
 */
public class UnsupportedJT808DB37LuBiaoProtocolVersionException extends UnsupportedJT808ProtocolVersionException {
    static final long serialVersionUID = -3762866559506311257L;

    public UnsupportedJT808DB37LuBiaoProtocolVersionException() {
        this("暂不支持该协议版本");
    }

    public UnsupportedJT808DB37LuBiaoProtocolVersionException(IProtocolVersion protocolVersion) {
        this("暂不支持该协议版本: " + protocolVersion);
    }

    public UnsupportedJT808DB37LuBiaoProtocolVersionException(String message) {
        super(message);
    }

    public UnsupportedJT808DB37LuBiaoProtocolVersionException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT808DB37LuBiaoProtocolVersionException(Throwable cause) {
        super(cause);
    }
}