package ai.sangmado.gbprotocol.jt809db32t3610.protocol.exceptions;

import ai.sangmado.gbprotocol.gbcommon.enums.IMessageId;
import ai.sangmado.gbprotocol.jt809.protocol.exceptions.UnsupportedJT809MessageException;

/**
 * 不支持协议消息异常
 */
public class UnsupportedJT809DB32T3610MessageException extends UnsupportedJT809MessageException {
    static final long serialVersionUID = 9021922586133290705L;

    public UnsupportedJT809DB32T3610MessageException() {
        this("暂不支持该协议消息");
    }

    public UnsupportedJT809DB32T3610MessageException(IMessageId messageId) {
        this("暂不支持该协议消息: " + messageId.getName());
    }

    public UnsupportedJT809DB32T3610MessageException(String message) {
        super(message);
    }

    public UnsupportedJT809DB32T3610MessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT809DB32T3610MessageException(Throwable cause) {
        super(cause);
    }
}