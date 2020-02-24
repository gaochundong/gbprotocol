package ai.sangmado.db32t3610.protocol.exceptions;

/**
 * 不支持协议操作异常
 */
public class UnsupportedDB32T3610OperationException extends RuntimeException {
    static final long serialVersionUID = 3884063173042415016L;

    public UnsupportedDB32T3610OperationException() {
        this("暂不支持该协议操作");
    }

    public UnsupportedDB32T3610OperationException(String message) {
        super(message);
    }

    public UnsupportedDB32T3610OperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedDB32T3610OperationException(Throwable cause) {
        super(cause);
    }
}