package ai.sangmado.jt808.protocol.message.header;

import ai.sangmado.jt808.protocol.enums.JT808MessageContentEncryptionMode;
import lombok.*;

/**
 * JT808 消息头中消息体属性
 */
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class JT808MessageHeaderMessageContentProperty {

    /**
     * 是否分包
     */
    private Boolean isMultiplePackets;

    /**
     * 加密方式
     */
    private JT808MessageContentEncryptionMode encryptionMode;

    /**
     * 消息体长度
     */
    private Integer contentLength;

    /**
     * 将当前对象序列化至包装整型值
     *
     * @return 包装整型值
     */
    public abstract Integer marshal();

    /**
     * 将包装整型值解构为当前对象
     *
     * @param value 包装整型值
     */
    public abstract void release(Integer value);
}
