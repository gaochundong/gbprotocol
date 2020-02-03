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
        if (reserved14 != null) this.reserved14 = reserved14;
        if (reserved15 != null) this.reserved15 = reserved15;
    }

    @Override
    public JT808MessageHeaderMessageContentProperty clone() {
        return JT808MessageHeaderMessageContentProperty2011.builder()
                .isMultiplePackets(this.getIsMultiplePackets())
                .encryptionMode(this.getEncryptionMode())
                .contentLength(this.getContentLength())
                .reserved14(this.getReserved14())
                .reserved15(this.getReserved15())
                .build();
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

    /**
     * 将包装整型值解构为当前对象
     *
     * @param value 包装整型值
     */
    @Override
    public void release(Integer value) {
        if ((value >> 13 & 0x01) == 1) {
            setIsMultiplePackets(true);
        } else {
            setIsMultiplePackets(false);
        }

        switch ((value & 0x400) >> 10) {
            case 0:
                setEncryptionMode(JT808MessageContentEncryptionMode.None);
                break;
            case 1:
                setEncryptionMode(JT808MessageContentEncryptionMode.RSA);
                break;
            default:
                throw new UnsupportedJT808OperationException("暂不支持该类型数据加密方式: " + ((value & 0x400) >> 10));
        }

        setContentLength(value & 0x3FF);
    }
}
