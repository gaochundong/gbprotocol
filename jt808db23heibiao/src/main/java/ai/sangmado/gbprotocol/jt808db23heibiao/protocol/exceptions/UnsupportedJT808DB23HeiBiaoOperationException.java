package ai.sangmado.gbprotocol.jt808db23heibiao.protocol.exceptions;

import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808OperationException;

/**
 * 不支持协议操作异常
 */
public class UnsupportedJT808DB23HeiBiaoOperationException extends UnsupportedJT808OperationException {
    static final long serialVersionUID = -1888033475037040646L;

    public UnsupportedJT808DB23HeiBiaoOperationException() {
        this("暂不支持该协议操作");
    }

    public UnsupportedJT808DB23HeiBiaoOperationException(String message) {
        super(message);
    }

    public UnsupportedJT808DB23HeiBiaoOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT808DB23HeiBiaoOperationException(Throwable cause) {
        super(cause);
    }
}