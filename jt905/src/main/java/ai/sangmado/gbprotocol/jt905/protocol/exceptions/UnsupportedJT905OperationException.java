package ai.sangmado.gbprotocol.jt905.protocol.exceptions;

/**
 * 不支持协议操作异常
 */
public class UnsupportedJT905OperationException extends RuntimeException {
    static final long serialVersionUID = 7190837226015908943L;

    public UnsupportedJT905OperationException() {
        this("暂不支持该协议操作");
    }

    public UnsupportedJT905OperationException(String message) {
        super(message);
    }

    public UnsupportedJT905OperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT905OperationException(Throwable cause) {
        super(cause);
    }
}