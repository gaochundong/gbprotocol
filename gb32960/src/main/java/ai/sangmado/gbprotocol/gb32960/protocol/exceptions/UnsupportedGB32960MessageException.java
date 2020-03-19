package ai.sangmado.gbprotocol.gb32960.protocol.exceptions;

import ai.sangmado.gbprotocol.gbcommon.enums.IMessageId;

/**
 * 不支持协议消息异常
 */
public class UnsupportedGB32960MessageException extends RuntimeException {
    static final long serialVersionUID = -6373752214056440411L;

    public UnsupportedGB32960MessageException() {
        this("暂不支持该协议消息");
    }

    public UnsupportedGB32960MessageException(IMessageId messageId) {
        this("暂不支持该协议消息: " + messageId.getName());
    }

    public UnsupportedGB32960MessageException(String message) {
        super(message);
    }

    public UnsupportedGB32960MessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedGB32960MessageException(Throwable cause) {
        super(cause);
    }
}