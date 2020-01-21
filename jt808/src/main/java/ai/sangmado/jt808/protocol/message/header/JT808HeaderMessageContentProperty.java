package ai.sangmado.jt808.protocol.message.header;

import ai.sangmado.jt808.protocol.enums.JT808MessageContentEncryptionMode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * JT808 消息头中消息体属性
 */
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class JT808HeaderMessageContentProperty {

    /**
     * 是否分包
     */
    private boolean isMultiplePackets;

    /**
     * 加密方式
     */
    private JT808MessageContentEncryptionMode encryptionMode;

    /**
     * 消息体长度
     */
    private int contentLength;
}
