package ai.sangmado.gbprotocol.gb19056.protocol.exceptions;

/**
 * 不支持协议操作异常
 */
public class UnsupportedGB19056OperationException extends RuntimeException {
    static final long serialVersionUID = -8189267007359958827L;

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