package ai.sangmado.gbprotocol.jt808db37lubiao.protocol.exceptions;

import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808OperationException;

/**
 * 不支持协议操作异常
 */
public class UnsupportedJT808DB37LuBiaoOperationException extends UnsupportedJT808OperationException {
    static final long serialVersionUID = -1888033475037040646L;

    public UnsupportedJT808DB37LuBiaoOperationException() {
        this("暂不支持该协议操作");
    }

    public UnsupportedJT808DB37LuBiaoOperationException(String message) {
        super(message);
    }

    public UnsupportedJT808DB37LuBiaoOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT808DB37LuBiaoOperationException(Throwable cause) {
        super(cause);
    }
}