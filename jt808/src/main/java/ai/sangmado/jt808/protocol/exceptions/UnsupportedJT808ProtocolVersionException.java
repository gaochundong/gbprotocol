package ai.sangmado.jt808.protocol.exceptions;

import ai.sangmado.gbcommon.enums.IProtocolVersion;

/**
 * 不支持协议版本异常
 */
public class UnsupportedJT808ProtocolVersionException extends RuntimeException {
    static final long serialVersionUID = 4318942682551505933L;

    public UnsupportedJT808ProtocolVersionException() {
        this("暂不支持该协议版本");
    }

    public UnsupportedJT808ProtocolVersionException(IProtocolVersion protocolVersion) {
        this("暂不支持该协议版本: " + protocolVersion);
    }

    public UnsupportedJT808ProtocolVersionException(String message) {
        super(message);
    }

    public UnsupportedJT808ProtocolVersionException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT808ProtocolVersionException(Throwable cause) {
        super(cause);
    }
}