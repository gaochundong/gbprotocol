package ai.sangmado.gbprotocol.jt808db37t6666.protocol.exceptions;

import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808OperationException;

/**
 * 不支持协议操作异常
 */
public class UnsupportedJT808DB37T6666OperationException extends UnsupportedJT808OperationException {
    static final long serialVersionUID = -1888033475037040646L;

    public UnsupportedJT808DB37T6666OperationException() {
        this("暂不支持该协议操作");
    }

    public UnsupportedJT808DB37T6666OperationException(String message) {
        super(message);
    }

    public UnsupportedJT808DB37T6666OperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT808DB37T6666OperationException(Throwable cause) {
        super(cause);
    }
}