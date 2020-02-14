package ai.sangmado.jt1078.protocol.exceptions;

/**
 * 无效的消息校验码异常
 */
public class InvalidJT1078MessageChecksumException extends RuntimeException {
    static final long serialVersionUID = 6771333437594439922L;

    public InvalidJT1078MessageChecksumException() {
        this("无效的消息校验码");
    }

    public InvalidJT1078MessageChecksumException(String message) {
        super(message);
    }

    public InvalidJT1078MessageChecksumException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidJT1078MessageChecksumException(Throwable cause) {
        super(cause);
    }
}