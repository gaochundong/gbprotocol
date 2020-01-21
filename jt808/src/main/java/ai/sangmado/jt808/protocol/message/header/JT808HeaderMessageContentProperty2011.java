package ai.sangmado.jt808.protocol.message.header;

import ai.sangmado.jt808.protocol.enums.JT808MessageContentEncryptionMode;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JT808HeaderMessageContentProperty2011 extends JT808HeaderMessageContentProperty {

    /**
     * 保留位15
     */
    private byte reserved15;

    /**
     * 保留位14
     */
    private byte reserved14;

    @Builder
    public JT808HeaderMessageContentProperty2011(
            boolean isMultiplePackets,
            JT808MessageContentEncryptionMode encryptionMode,
            int contentLength,
            byte reserved14,
            byte reserved15) {
        super(isMultiplePackets, encryptionMode, contentLength);
        this.reserved14 = reserved14;
        this.reserved15 = reserved15;
    }
}
