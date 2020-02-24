package ai.sangmado.jt808db32t3610.protocol.exceptions;

/**
 * 不支持协议操作异常
 */
public class UnsupportedJT808DB32T3610OperationException extends RuntimeException {
    static final long serialVersionUID = 3884063173042415016L;

    public UnsupportedJT808DB32T3610OperationException() {
        this("暂不支持该协议操作");
    }

    public UnsupportedJT808DB32T3610OperationException(String message) {
        super(message);
    }

    public UnsupportedJT808DB32T3610OperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT808DB32T3610OperationException(Throwable cause) {
        super(cause);
    }
}