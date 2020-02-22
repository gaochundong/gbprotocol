package ai.sangmado.jt1078.protocol.exceptions;

/**
 * 不支持协议操作异常
 */
public class UnsupportedJT1078OperationException extends RuntimeException {
    static final long serialVersionUID = 6857103519680790348L;

    public UnsupportedJT1078OperationException() {
        this("暂不支持该协议操作");
    }

    public UnsupportedJT1078OperationException(String message) {
        super(message);
    }

    public UnsupportedJT1078OperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT1078OperationException(Throwable cause) {
        super(cause);
    }
}