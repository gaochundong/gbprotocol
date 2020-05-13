package ai.sangmado.gbprotocol.gb17691.protocol.exceptions;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;

/**
 * 不支持协议版本异常
 */
public class UnsupportedGB17691ProtocolVersionException extends RuntimeException {
    static final long serialVersionUID = 6807920661590619336L;

    public UnsupportedGB17691ProtocolVersionException() {
        this("暂不支持该协议版本");
    }

    public UnsupportedGB17691ProtocolVersionException(IProtocolVersion protocolVersion) {
        this("暂不支持该协议版本: " + protocolVersion);
    }

    public UnsupportedGB17691ProtocolVersionException(String message) {
        super(message);
    }

    public UnsupportedGB17691ProtocolVersionException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedGB17691ProtocolVersionException(Throwable cause) {
        super(cause);
    }
}