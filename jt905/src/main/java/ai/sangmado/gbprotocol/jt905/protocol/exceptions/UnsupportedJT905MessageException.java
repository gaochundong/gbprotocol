package ai.sangmado.gbprotocol.jt905.protocol.exceptions;

import ai.sangmado.gbprotocol.gbcommon.enums.IMessageId;

/**
 * 不支持协议消息异常
 */
public class UnsupportedJT905MessageException extends RuntimeException {
    static final long serialVersionUID = -3208575297084463133L;

    public UnsupportedJT905MessageException() {
        this("暂不支持该协议消息");
    }

    public UnsupportedJT905MessageException(IMessageId messageId) {
        this("暂不支持该协议消息: " + messageId.getName());
    }

    public UnsupportedJT905MessageException(String message) {
        super(message);
    }

    public UnsupportedJT905MessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT905MessageException(Throwable cause) {
        super(cause);
    }
}