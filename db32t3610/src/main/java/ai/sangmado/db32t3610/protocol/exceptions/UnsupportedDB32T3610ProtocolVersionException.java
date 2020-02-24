package ai.sangmado.db32t3610.protocol.exceptions;

import ai.sangmado.gbcommon.enums.IProtocolVersion;

/**
 * 不支持协议版本异常
 */
public class UnsupportedDB32T3610ProtocolVersionException extends RuntimeException {
    static final long serialVersionUID = 562928058618468335L;

    public UnsupportedDB32T3610ProtocolVersionException() {
        this("暂不支持该协议版本");
    }

    public UnsupportedDB32T3610ProtocolVersionException(IProtocolVersion protocolVersion) {
        this("暂不支持该协议版本: " + protocolVersion);
    }

    public UnsupportedDB32T3610ProtocolVersionException(String message) {
        super(message);
    }

    public UnsupportedDB32T3610ProtocolVersionException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedDB32T3610ProtocolVersionException(Throwable cause) {
        super(cause);
    }
}