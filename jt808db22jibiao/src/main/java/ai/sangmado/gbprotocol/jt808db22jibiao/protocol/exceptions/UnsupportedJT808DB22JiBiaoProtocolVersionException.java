package ai.sangmado.gbprotocol.jt808db22jibiao.protocol.exceptions;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808ProtocolVersionException;

/**
 * 不支持协议版本异常
 */
public class UnsupportedJT808DB22JiBiaoProtocolVersionException extends UnsupportedJT808ProtocolVersionException {
    static final long serialVersionUID = -4831769289167241634L;

    public UnsupportedJT808DB22JiBiaoProtocolVersionException() {
        this("暂不支持该协议版本");
    }

    public UnsupportedJT808DB22JiBiaoProtocolVersionException(IProtocolVersion protocolVersion) {
        this("暂不支持该协议版本: " + protocolVersion);
    }

    public UnsupportedJT808DB22JiBiaoProtocolVersionException(String message) {
        super(message);
    }

    public UnsupportedJT808DB22JiBiaoProtocolVersionException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT808DB22JiBiaoProtocolVersionException(Throwable cause) {
        super(cause);
    }
}