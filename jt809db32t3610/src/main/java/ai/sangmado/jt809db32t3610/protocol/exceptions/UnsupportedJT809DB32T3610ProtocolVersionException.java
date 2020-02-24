package ai.sangmado.jt809db32t3610.protocol.exceptions;

import ai.sangmado.gbcommon.enums.IProtocolVersion;
import ai.sangmado.jt809.protocol.exceptions.UnsupportedJT809ProtocolVersionException;

/**
 * 不支持协议版本异常
 */
public class UnsupportedJT809DB32T3610ProtocolVersionException extends UnsupportedJT809ProtocolVersionException {
    static final long serialVersionUID = 8538689346582680149L;

    public UnsupportedJT809DB32T3610ProtocolVersionException() {
        this("暂不支持该协议版本");
    }

    public UnsupportedJT809DB32T3610ProtocolVersionException(IProtocolVersion protocolVersion) {
        this("暂不支持该协议版本: " + protocolVersion);
    }

    public UnsupportedJT809DB32T3610ProtocolVersionException(String message) {
        super(message);
    }

    public UnsupportedJT809DB32T3610ProtocolVersionException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT809DB32T3610ProtocolVersionException(Throwable cause) {
        super(cause);
    }
}