package ai.sangmado.jt808.protocol.message.header;

import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JT808Header2013 extends JT808Header2011 {

    @Builder
    public JT808Header2013(
            JT808MessageId messageId,
            JT808HeaderMessageContentProperty messageContentProperty,
            int serialNumber,
            JT808HeaderMessagePacketProperty messagePacketProperty,
            String phoneNumber) {
        super(messageId, messageContentProperty, serialNumber, messagePacketProperty, phoneNumber);
    }
}
