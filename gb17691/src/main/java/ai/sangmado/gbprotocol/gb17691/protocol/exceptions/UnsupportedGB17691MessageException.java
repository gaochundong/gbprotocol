package ai.sangmado.gbprotocol.gb17691.protocol.exceptions;

import ai.sangmado.gbprotocol.gbcommon.enums.IMessageId;

/**
 * 不支持协议消息异常
 */
public class UnsupportedGB17691MessageException extends RuntimeException {
    static final long serialVersionUID = 1631125493187729352L;

    public UnsupportedGB17691MessageException() {
        this("暂不支持该协议消息");
    }

    public UnsupportedGB17691MessageException(IMessageId messageId) {
        this("暂不支持该协议消息: " + messageId.getName());
    }

    public UnsupportedGB17691MessageException(String message) {
        super(message);
    }

    public UnsupportedGB17691MessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedGB17691MessageException(Throwable cause) {
        super(cause);
    }
}