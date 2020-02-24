package ai.sangmado.db32t3610.protocol.exceptions;

import ai.sangmado.gbcommon.enums.IMessageId;

/**
 * 不支持协议消息异常
 */
public class UnsupportedDB32T3610MessageException extends RuntimeException {
    static final long serialVersionUID = 4035581577857292065L;

    public UnsupportedDB32T3610MessageException() {
        this("暂不支持该协议消息");
    }

    public UnsupportedDB32T3610MessageException(IMessageId messageId) {
        this("暂不支持该协议消息: " + messageId.getName());
    }

    public UnsupportedDB32T3610MessageException(String message) {
        super(message);
    }

    public UnsupportedDB32T3610MessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedDB32T3610MessageException(Throwable cause) {
        super(cause);
    }
}