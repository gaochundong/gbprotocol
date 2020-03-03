package ai.sangmado.gbstandard.jt809.protocol.exceptions;

import ai.sangmado.gbstandard.gbcommon.enums.IProtocolVersion;

/**
 * 不支持协议版本异常
 */
public class UnsupportedJT809ProtocolVersionException extends RuntimeException {
    static final long serialVersionUID = 303547021877163206L;

    public UnsupportedJT809ProtocolVersionException() {
        this("暂不支持该协议版本");
    }

    public UnsupportedJT809ProtocolVersionException(IProtocolVersion protocolVersion) {
        this("暂不支持该协议版本: " + protocolVersion);
    }

    public UnsupportedJT809ProtocolVersionException(String message) {
        super(message);
    }

    public UnsupportedJT809ProtocolVersionException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT809ProtocolVersionException(Throwable cause) {
        super(cause);
    }
}