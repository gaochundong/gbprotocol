package ai.sangmado.jt1078.protocol.exceptions;

import ai.sangmado.jt808.protocol.enums.IProtocolVersion;

/**
 * 不支持JT1078协议版本异常
 */
public class UnsupportedJT1078ProtocolVersionException extends RuntimeException {
    static final long serialVersionUID = -8186572467563833501L;

    public UnsupportedJT1078ProtocolVersionException() {
        this("暂不支持该协议版本");
    }

    public UnsupportedJT1078ProtocolVersionException(IProtocolVersion protocolVersion) {
        this("暂不支持该协议版本: " + protocolVersion);
    }

    public UnsupportedJT1078ProtocolVersionException(String message) {
        super(message);
    }

    public UnsupportedJT1078ProtocolVersionException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT1078ProtocolVersionException(Throwable cause) {
        super(cause);
    }
}