package ai.sangmado.gbprotocol.jt808db22jibiao.protocol.exceptions;

import ai.sangmado.gbprotocol.gbcommon.enums.IMessageId;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808MessageException;

/**
 * 不支持协议消息异常
 */
public class UnsupportedJT808DB22JiBiaoMessageException extends UnsupportedJT808MessageException {
    static final long serialVersionUID = 80737643803696666L;

    public UnsupportedJT808DB22JiBiaoMessageException() {
        this("暂不支持该协议消息");
    }

    public UnsupportedJT808DB22JiBiaoMessageException(IMessageId messageId) {
        this("暂不支持该协议消息: " + messageId.getName());
    }

    public UnsupportedJT808DB22JiBiaoMessageException(String message) {
        super(message);
    }

    public UnsupportedJT808DB22JiBiaoMessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT808DB22JiBiaoMessageException(Throwable cause) {
        super(cause);
    }
}