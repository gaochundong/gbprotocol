package ai.sangmado.jt809.protocol.exceptions;

/**
 * 不支持协议操作异常
 */
public class UnsupportedJT809OperationException extends RuntimeException {
    static final long serialVersionUID = -7900740943722150014L;

    public UnsupportedJT809OperationException() {
        this("暂不支持该协议操作");
    }

    public UnsupportedJT809OperationException(String message) {
        super(message);
    }

    public UnsupportedJT809OperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT809OperationException(Throwable cause) {
        super(cause);
    }
}