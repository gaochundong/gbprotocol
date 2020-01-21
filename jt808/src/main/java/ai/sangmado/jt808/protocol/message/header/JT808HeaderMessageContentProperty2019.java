package ai.sangmado.jt808.protocol.message.header;

import ai.sangmado.jt808.protocol.enums.JT808MessageContentEncryptionMode;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JT808HeaderMessageContentProperty2019 extends JT808HeaderMessageContentProperty {

    /**
     * 保留位15
     */
    private byte reserved15;

    /**
     * 版本标识
     * 0: 2011版本；
     * 1: 2019起已经引入版本标识功能，并且在终端鉴权报文的鉴权码后跟随着协议版本号，初始版本号为1，后续每次关键性修订版本号都会递增；
     */
    private byte version;

    @Builder
    public JT808HeaderMessageContentProperty2019(
            boolean isMultiplePackets,
            JT808MessageContentEncryptionMode encryptionMode,
            int contentLength,
            byte version,
            byte reserved15) {
        super(isMultiplePackets, encryptionMode, contentLength);
        this.version = version;
        this.reserved15 = reserved15;
    }
}
