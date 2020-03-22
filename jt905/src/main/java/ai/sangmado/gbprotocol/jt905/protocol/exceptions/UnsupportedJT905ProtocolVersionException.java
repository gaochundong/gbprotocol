package ai.sangmado.gbprotocol.jt905.protocol.exceptions;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;

/**
 * 不支持协议版本异常
 */
public class UnsupportedJT905ProtocolVersionException extends RuntimeException {
    static final long serialVersionUID = 8691477310068804322L;

    public UnsupportedJT905ProtocolVersionException() {
        this("暂不支持该协议版本");
    }

    public UnsupportedJT905ProtocolVersionException(IProtocolVersion protocolVersion) {
        this("暂不支持该协议版本: " + protocolVersion);
    }

    public UnsupportedJT905ProtocolVersionException(String message) {
        super(message);
    }

    public UnsupportedJT905ProtocolVersionException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT905ProtocolVersionException(Throwable cause) {
        super(cause);
    }
}