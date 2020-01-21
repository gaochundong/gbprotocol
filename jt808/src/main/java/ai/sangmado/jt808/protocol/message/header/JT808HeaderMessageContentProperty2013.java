package ai.sangmado.jt808.protocol.message.header;

import ai.sangmado.jt808.protocol.enums.JT808MessageContentEncryptionMode;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JT808HeaderMessageContentProperty2013 extends JT808HeaderMessageContentProperty2011 {

    @Builder
    public JT808HeaderMessageContentProperty2013(
            boolean isMultiplePackets,
            JT808MessageContentEncryptionMode encryptionMode,
            int contentLength,
            byte reserved14,
            byte reserved15) {
        super(isMultiplePackets, encryptionMode, contentLength, reserved14, reserved15);
    }
}
