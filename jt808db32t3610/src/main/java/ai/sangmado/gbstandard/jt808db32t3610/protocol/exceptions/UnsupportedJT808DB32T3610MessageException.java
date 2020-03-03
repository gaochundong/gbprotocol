package ai.sangmado.jt808db32t3610.protocol.exceptions;

import ai.sangmado.gbstandard.gbcommon.enums.IMessageId;
import ai.sangmado.gbstandard.jt808.protocol.exceptions.UnsupportedJT808MessageException;

/**
 * 不支持协议消息异常
 */
public class UnsupportedJT808DB32T3610MessageException extends UnsupportedJT808MessageException {
    static final long serialVersionUID = 4035581577857292065L;

    public UnsupportedJT808DB32T3610MessageException() {
        this("暂不支持该协议消息");
    }

    public UnsupportedJT808DB32T3610MessageException(IMessageId messageId) {
        this("暂不支持该协议消息: " + messageId.getName());
    }

    public UnsupportedJT808DB32T3610MessageException(String message) {
        super(message);
    }

    public UnsupportedJT808DB32T3610MessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT808DB32T3610MessageException(Throwable cause) {
        super(cause);
    }
}