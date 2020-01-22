package ai.sangmado.jt808.protocol.exceptions;

import ai.sangmado.jt808.protocol.enums.JT808ProtocolVersion;

/**
 * 不支持JT808协议版本异常
 */
public class UnsupportedJT808ProtocolVersionException extends RuntimeException {
    static final long serialVersionUID = 4318942682551505933L;

    public UnsupportedJT808ProtocolVersionException() {
        this("暂不支持该协议版本");
    }

    public UnsupportedJT808ProtocolVersionException(JT808ProtocolVersion protocolVersion) {
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