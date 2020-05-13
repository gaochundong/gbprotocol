package ai.sangmado.gbprotocol.gb19056.protocol.exceptions;

import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808OperationException;

/**
 * 不支持协议操作异常
 */
public class UnsupportedGB19056OperationException extends UnsupportedJT808OperationException {
    static final long serialVersionUID = -7008748926473349560L;

    public UnsupportedGB19056OperationException() {
        this("暂不支持该协议操作");
    }

    public UnsupportedGB19056OperationException(String message) {
        super(message);
    }

    public UnsupportedGB19056OperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedGB19056OperationException(Throwable cause) {
        super(cause);
    }
}