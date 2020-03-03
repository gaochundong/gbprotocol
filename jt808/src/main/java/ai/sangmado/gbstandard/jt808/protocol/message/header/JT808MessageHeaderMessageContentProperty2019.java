package ai.sangmado.gbstandard.jt808.protocol.message.header;

import ai.sangmado.gbstandard.jt808.protocol.enums.JT808MessageContentEncryptionMode;
import ai.sangmado.gbstandard.jt808.protocol.exceptions.UnsupportedJT808OperationException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static ai.sangmado.gbstandard.jt808.protocol.enums.JT808MessageContentEncryptionMode.*;

@Getter
@Setter
@NoArgsConstructor
public class JT808MessageHeaderMessageContentProperty2019 extends JT808MessageHeaderMessageContentProperty {

    /**
     * 保留位15
     */
    private Byte reserved15;

    /**
     * 版本标识
     * 0: 2011版本；
     * 1: 2019起已经引入版本标识功能，并且在终端鉴权报文的鉴权码后跟随着协议版本号，初始版本号为1，后续每次关键性修订版本号都会递增；
     */
    private Byte versionIdentifier = 1;

    @Builder
    public JT808MessageHeaderMessageContentProperty2019(
            Boolean isMultiplePackets,
            JT808MessageContentEncryptionMode encryptionMode,
            Integer contentLength,
            Byte versionIdentifier,
            Byte reserved15) {
        super(isMultiplePackets, encryptionMode, contentLength);
        if (versionIdentifier != null) this.versionIdentifier = versionIdentifier;
        if (reserved15 != null) this.reserved15 = reserved15;
    }

    @Override
    public JT808MessageHeaderMessageContentProperty clone() {
        return JT808MessageHeaderMessageContentProperty2019.builder()
                .isMultiplePackets(this.getIsMultiplePackets())
                .encryptionMode(this.getEncryptionMode())
                .contentLength(this.getContentLength())
                .versionIdentifier(this.getVersionIdentifier())
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
        int versioning = 0;
        if (getVersionIdentifier() == 1) {
            versioning = 1 << 14;
        }

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

        return versioning | packetSplitting | encryption | getContentLength();
    }

    /**
     * 将包装整型值解构为当前对象
     *
     * @param value 包装整型值
     */
    @Override
    public void release(Integer value) {
        if ((value >> 14 & 0x01) == 1) {
            setVersionIdentifier((byte) 1);
        } else {
            setVersionIdentifier((byte) 0);
        }

        if ((value >> 13 & 0x01) == 1) {
            setIsMultiplePackets(true);
        } else {
            setIsMultiplePackets(false);
        }

        switch ((value & 0x400) >> 10) {
            case 0:
                setEncryptionMode(None);
                break;
            case 1:
                setEncryptionMode(RSA);
                break;
            default:
                throw new UnsupportedJT808OperationException("暂不支持该类型数据加密方式: " + ((value & 0x400) >> 10));
        }

        setContentLength(value & 0x3FF);
    }
}
