package ai.sangmado.gbprotocol.jt808db23heibiao.protocol.exceptions;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808ProtocolVersionException;

/**
 * 不支持协议版本异常
 */
public class UnsupportedJT808DB23HeiBiaoProtocolVersionException extends UnsupportedJT808ProtocolVersionException {
    static final long serialVersionUID = -3762866559506311257L;

    public UnsupportedJT808DB23HeiBiaoProtocolVersionException() {
        this("暂不支持该协议版本");
    }

    public UnsupportedJT808DB23HeiBiaoProtocolVersionException(IProtocolVersion protocolVersion) {
        this("暂不支持该协议版本: " + protocolVersion);
    }

    public UnsupportedJT808DB23HeiBiaoProtocolVersionException(String message) {
        super(message);
    }

    public UnsupportedJT808DB23HeiBiaoProtocolVersionException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT808DB23HeiBiaoProtocolVersionException(Throwable cause) {
        super(cause);
    }
}