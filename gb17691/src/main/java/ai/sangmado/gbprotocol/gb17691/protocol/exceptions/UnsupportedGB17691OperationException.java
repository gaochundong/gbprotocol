package ai.sangmado.gbprotocol.gb17691.protocol.exceptions;

/**
 * 不支持协议操作异常
 */
public class UnsupportedGB17691OperationException extends RuntimeException {
    static final long serialVersionUID = 6389610690309860958L;

    public UnsupportedGB17691OperationException() {
        this("暂不支持该协议操作");
    }

    public UnsupportedGB17691OperationException(String message) {
        super(message);
    }

    public UnsupportedGB17691OperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedGB17691OperationException(Throwable cause) {
        super(cause);
    }
}