package ai.sangmado.gbprotocol.jt1078.protocol.exceptions;

import ai.sangmado.gbprotocol.gbcommon.enums.IMessageId;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808MessageException;

/**
 * 不支持协议消息异常
 */
public class UnsupportedJT1078MessageException extends UnsupportedJT808MessageException {
    static final long serialVersionUID = -8734858167378108984L;

    public UnsupportedJT1078MessageException() {
        this("暂不支持该协议消息");
    }

    public UnsupportedJT1078MessageException(IMessageId messageId) {
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