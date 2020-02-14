package ai.sangmado.jt1078.protocol.exceptions;

import ai.sangmado.jt1078.protocol.enums.JT1078MessageId;

/**
 * 不支持JT808协议消息异常
 */
public class UnsupportedJT1078MessageException extends RuntimeException {
    static final long serialVersionUID = -8734858167378108984L;

    public UnsupportedJT1078MessageException() {
        this("暂不支持该协议消息");
    }

    public UnsupportedJT1078MessageException(JT1078MessageId messageId) {
        this("暂不支持该协议消息: " + messageId.getName());
    }

    public UnsupportedJT1078MessageException(String message) {
        super(message);
    }

    public UnsupportedJT1078MessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT1078MessageException(Throwable cause) {
        super(cause);
    }
}