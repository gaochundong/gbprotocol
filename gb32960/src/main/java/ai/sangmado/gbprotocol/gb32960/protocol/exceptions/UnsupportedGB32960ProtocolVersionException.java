package ai.sangmado.gbprotocol.gb32960.protocol.exceptions;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;

/**
 * 不支持协议版本异常
 */
public class UnsupportedGB32960ProtocolVersionException extends RuntimeException {
    static final long serialVersionUID = -4999454353039597741L;

    public UnsupportedGB32960ProtocolVersionException() {
        this("暂不支持该协议版本");
    }

    public UnsupportedGB32960ProtocolVersionException(IProtocolVersion protocolVersion) {
        this("暂不支持该协议版本: " + protocolVersion);
    }

    public UnsupportedGB32960ProtocolVersionException(String message) {
        super(message);
    }

    public UnsupportedGB32960ProtocolVersionException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedGB32960ProtocolVersionException(Throwable cause) {
        super(cause);
    }
}