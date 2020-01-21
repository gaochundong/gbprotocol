package ai.sangmado.jt808.protocol.message.header;

import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JT808Header2019 extends JT808Header {

    /**
     * 协议版本号
     * 每次关键修订递增，初始版本为1。
     */
    private byte protocolVersion;

    /**
     * 终端手机号
     * 2019：根据安装后终端自身的手机号转换。手机号不足位的，则在前补充数字 0。
     */
    private String phoneNumber;

    @Builder
    public JT808Header2019(
            JT808MessageId messageId,
            JT808HeaderMessageContentProperty messageContentProperty,
            int serialNumber,
            JT808HeaderMessagePacketProperty messagePacketProperty,
            String phoneNumber,
            byte protocolVersion) {
        super(messageId, messageContentProperty, serialNumber, messagePacketProperty);
        this.protocolVersion = protocolVersion;
        this.phoneNumber = phoneNumber;
    }
}
