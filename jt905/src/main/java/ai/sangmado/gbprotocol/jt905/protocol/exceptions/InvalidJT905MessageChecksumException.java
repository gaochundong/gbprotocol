package ai.sangmado.gbprotocol.jt905.protocol.exceptions;

/**
 * 无效的消息校验码异常
 */
public class InvalidJT905MessageChecksumException extends RuntimeException {
    static final long serialVersionUID = 4117039868431199537L;

    public InvalidJT905MessageChecksumException() {
        this("无效的消息校验码");
    }

    public InvalidJT905MessageChecksumException(String message) {
        super(message);
    }

    public InvalidJT905MessageChecksumException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidJT905MessageChecksumException(Throwable cause) {
        super(cause);
    }
}