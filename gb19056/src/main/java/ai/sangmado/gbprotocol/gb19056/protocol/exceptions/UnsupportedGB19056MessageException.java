package ai.sangmado.gbprotocol.gb19056.protocol.exceptions;

import ai.sangmado.gbprotocol.gbcommon.enums.IMessageId;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808MessageException;

/**
 * 不支持协议消息异常
 */
public class UnsupportedGB19056MessageException extends UnsupportedJT808MessageException {
    static final long serialVersionUID = 4160539288662834222L;

    public UnsupportedGB19056MessageException() {
        this("暂不支持该协议消息");
    }

    public UnsupportedGB19056MessageException(IMessageId messageId) {
        this("暂不支持该协议消息: " + messageId.getName());
    }

    public UnsupportedGB19056MessageException(String message) {
        super(message);
    }

    public UnsupportedGB19056MessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedGB19056MessageException(Throwable cause) {
        super(cause);
    }
}