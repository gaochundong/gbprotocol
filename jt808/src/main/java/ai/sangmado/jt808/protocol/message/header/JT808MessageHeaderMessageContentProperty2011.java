package ai.sangmado.jt808.protocol.message.header;

import ai.sangmado.jt808.protocol.enums.JT808MessageContentEncryptionMode;
import ai.sangmado.jt808.protocol.exceptions.UnsupportedJT808OperationException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JT808MessageHeaderMessageContentProperty2011 extends JT808MessageHeaderMessageContentProperty {

    /**
     * 保留位15
     */
    private Byte reserved15;

    /**
     * 保留位14
     */
    private Byte reserved14;

    @Builder
    public JT808MessageHeaderMessageContentProperty2011(
            Boolean isMultiplePackets,
            JT808MessageContentEncryptionMode encryptionMode,
            Integer contentLength,
            Byte reserved14,
            Byte reserved15) {
        super(isMultiplePackets, encryptionMode, contentLength);
        this.reserved14 = reserved14;
        this.reserved15 = reserved15;
    }

    /**
     * 将当前对象序列化至包装整型值
     *
     * @return 包装整型值
     */
    @Override
    public Integer marshal() {
        int packetSplitting = 0;
        if (getIsMultiplePackets()) {
            packetSplitting = 1 << 13;
        }

        int encryption = 0;
        switch (getEncryptionMode()) {
            case None:
                break;
            case RSA:
                encryption = 1 << 10;
                break;
            default:
                throw new UnsupportedJT808OperationException("暂不支持该类型数据加密方式: " + getEncryptionMode());
        }

        if (getContentLength() == null || getContentLength() <= 0) {
            setContentLength(0);
        }

        return packetSplitting | encryption | getContentLength();
    }
}
