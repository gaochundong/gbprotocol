package ai.sangmado.gbstandard.jt808.protocol.exceptions;

/**
 * 无效的消息校验码异常
 */
public class InvalidJT808MessageChecksumException extends RuntimeException {
    static final long serialVersionUID = -8292016349079936925L;

    public InvalidJT808MessageChecksumException() {
        this("无效的消息校验码");
    }

    public InvalidJT808MessageChecksumException(String message) {
        super(message);
    }

    public InvalidJT808MessageChecksumException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidJT808MessageChecksumException(Throwable cause) {
        super(cause);
    }
}