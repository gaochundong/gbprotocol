package ai.sangmado.gbprotocol.jt808db23heibiao.protocol.exceptions;

import ai.sangmado.gbprotocol.gbcommon.enums.IMessageId;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808MessageException;

/**
 * 不支持协议消息异常
 */
public class UnsupportedJT808DB23HeiBiaoMessageException extends UnsupportedJT808MessageException {
    static final long serialVersionUID = -3780609898848634088L;

    public UnsupportedJT808DB23HeiBiaoMessageException() {
        this("暂不支持该协议消息");
    }

    public UnsupportedJT808DB23HeiBiaoMessageException(IMessageId messageId) {
        this("暂不支持该协议消息: " + messageId.getName());
    }

    public UnsupportedJT808DB23HeiBiaoMessageException(String message) {
        super(message);
    }

    public UnsupportedJT808DB23HeiBiaoMessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT808DB23HeiBiaoMessageException(Throwable cause) {
        super(cause);
    }
}