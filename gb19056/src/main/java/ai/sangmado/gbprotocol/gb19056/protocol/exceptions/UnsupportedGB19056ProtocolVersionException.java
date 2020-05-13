package ai.sangmado.gbprotocol.gb19056.protocol.exceptions;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808ProtocolVersionException;

/**
 * 不支持协议版本异常
 */
public class UnsupportedGB19056ProtocolVersionException extends UnsupportedJT808ProtocolVersionException {
    static final long serialVersionUID = 332473492136885947L;

    public UnsupportedGB19056ProtocolVersionException() {
        this("暂不支持该协议版本");
    }

    public UnsupportedGB19056ProtocolVersionException(IProtocolVersion protocolVersion) {
        this("暂不支持该协议版本: " + protocolVersion);
    }

    public UnsupportedGB19056ProtocolVersionException(String message) {
        super(message);
    }

    public UnsupportedGB19056ProtocolVersionException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedGB19056ProtocolVersionException(Throwable cause) {
        super(cause);
    }
}