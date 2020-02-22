package ai.sangmado.jt808.protocol.exceptions;

/**
 * 不支持协议操作异常
 */
public class UnsupportedJT808OperationException extends RuntimeException {
    static final long serialVersionUID = 8796577638288634770L;

    public UnsupportedJT808OperationException() {
        this("暂不支持该协议操作");
    }

    public UnsupportedJT808OperationException(String message) {
        super(message);
    }

    public UnsupportedJT808OperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT808OperationException(Throwable cause) {
        super(cause);
    }
}