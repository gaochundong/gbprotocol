package ai.sangmado.gbprotocol.jt808db51chuanbiao.protocol.exceptions;

import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808OperationException;

/**
 * 不支持协议操作异常
 */
public class UnsupportedJT808DB51ChuanBiaoOperationException extends UnsupportedJT808OperationException {
    static final long serialVersionUID = -1888033475037040646L;

    public UnsupportedJT808DB51ChuanBiaoOperationException() {
        this("暂不支持该协议操作");
    }

    public UnsupportedJT808DB51ChuanBiaoOperationException(String message) {
        super(message);
    }

    public UnsupportedJT808DB51ChuanBiaoOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT808DB51ChuanBiaoOperationException(Throwable cause) {
        super(cause);
    }
}