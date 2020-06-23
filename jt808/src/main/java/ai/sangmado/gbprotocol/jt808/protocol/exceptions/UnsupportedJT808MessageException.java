package ai.sangmado.gbprotocol.jt808.protocol.exceptions;

import ai.sangmado.gbprotocol.gbcommon.enums.IMessageId;

/**
 * 不支持协议消息异常
 */
public class UnsupportedJT808MessageException extends RuntimeException {
    static final long serialVersionUID = -7212162636270609070L;

    public UnsupportedJT808MessageException() {
        this("暂不支持该协议消息");
    }

    public UnsupportedJT808MessageException(IMessageId messageId) {
        this(String.format("暂不支持该协议消息: %s / %s / %s ",
                messageId.getName(), messageId.getDescription(), messageId.getSince()));
    }

    public UnsupportedJT808MessageException(String message) {
        super(message);
    }

    public UnsupportedJT808MessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT808MessageException(Throwable cause) {
        super(cause);
    }
}