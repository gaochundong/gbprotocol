package ai.sangmado.gbprotocol.gb32960.protocol.exceptions;

/**
 * 不支持协议操作异常
 */
public class UnsupportedGB32960OperationException extends RuntimeException {
    static final long serialVersionUID = 1608244261368497438L;

    public UnsupportedGB32960OperationException() {
        this("暂不支持该协议操作");
    }

    public UnsupportedGB32960OperationException(String message) {
        super(message);
    }

    public UnsupportedGB32960OperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedGB32960OperationException(Throwable cause) {
        super(cause);
    }
}