package ai.sangmado.gbprotocol.gb32960.protocol.exceptions;

/**
 * 无效的消息校验码异常
 */
public class InvalidGB32960MessageChecksumException extends RuntimeException {
    static final long serialVersionUID = -1571494177605459617L;

    public InvalidGB32960MessageChecksumException() {
        this("无效的消息校验码");
    }

    public InvalidGB32960MessageChecksumException(String message) {
        super(message);
    }

    public InvalidGB32960MessageChecksumException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidGB32960MessageChecksumException(Throwable cause) {
        super(cause);
    }
}