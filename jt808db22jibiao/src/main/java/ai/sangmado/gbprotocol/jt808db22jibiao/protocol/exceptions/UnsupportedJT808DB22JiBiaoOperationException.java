package ai.sangmado.gbprotocol.jt808db22jibiao.protocol.exceptions;

import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808OperationException;

/**
 * 不支持协议操作异常
 */
public class UnsupportedJT808DB22JiBiaoOperationException extends UnsupportedJT808OperationException {
    static final long serialVersionUID = 4362796032044740723L;

    public UnsupportedJT808DB22JiBiaoOperationException() {
        this("暂不支持该协议操作");
    }

    public UnsupportedJT808DB22JiBiaoOperationException(String message) {
        super(message);
    }

    public UnsupportedJT808DB22JiBiaoOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT808DB22JiBiaoOperationException(Throwable cause) {
        super(cause);
    }
}