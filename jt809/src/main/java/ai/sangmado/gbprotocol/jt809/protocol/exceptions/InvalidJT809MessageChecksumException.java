package ai.sangmado.gbprotocol.jt809.protocol.exceptions;

/**
 * 无效的消息校验码异常
 */
public class InvalidJT809MessageChecksumException extends RuntimeException {
    static final long serialVersionUID = -1583356138533718648L;

    public InvalidJT809MessageChecksumException() {
        this("无效的消息校验码");
    }

    public InvalidJT809MessageChecksumException(String message) {
        super(message);
    }

    public InvalidJT809MessageChecksumException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidJT809MessageChecksumException(Throwable cause) {
        super(cause);
    }
}