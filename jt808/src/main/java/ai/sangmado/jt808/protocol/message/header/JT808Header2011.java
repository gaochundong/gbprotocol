package ai.sangmado.jt808.protocol.message.header;

import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JT808Header2011 extends JT808Header {

    /**
     * 终端手机号
     * 2011：根据安装后终端自身的手机号转换。手机号不足12位，则在前补充数字，大陆手机号补充数字0，港澳台则根据其区号进行位数补充。
     */
    private String phoneNumber;

    @Builder
    public JT808Header2011(
            JT808MessageId messageId,
            JT808HeaderMessageContentProperty messageContentProperty,
            int serialNumber,
            JT808HeaderMessagePacketProperty messagePacketProperty,
            String phoneNumber) {
        super(messageId, messageContentProperty, serialNumber, messagePacketProperty);
        this.phoneNumber = phoneNumber;
    }
}
