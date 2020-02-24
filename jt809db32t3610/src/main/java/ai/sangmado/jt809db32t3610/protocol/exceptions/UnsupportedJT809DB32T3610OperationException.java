package ai.sangmado.jt809db32t3610.protocol.exceptions;

import ai.sangmado.jt809.protocol.exceptions.UnsupportedJT809OperationException;

/**
 * 不支持协议操作异常
 */
public class UnsupportedJT809DB32T3610OperationException extends UnsupportedJT809OperationException {
    static final long serialVersionUID = 6410882341427901991L;

    public UnsupportedJT809DB32T3610OperationException() {
        this("暂不支持该协议操作");
    }

    public UnsupportedJT809DB32T3610OperationException(String message) {
        super(message);
    }

    public UnsupportedJT809DB32T3610OperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT809DB32T3610OperationException(Throwable cause) {
        super(cause);
    }
}