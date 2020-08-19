package ai.sangmado.gbprotocol.jt808db23heibiao.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808db23heibiao.protocol.enums.JT808DB23HeiBiaoMessageId;
import lombok.*;

/**
 * 驾驶员人证照片更新请求
 * <p>
 * 终端主动发起的人证照片更新请求，可在签到后或定期进行请求。通过此消息指令车载设备获取指定驾驶员照片信息。
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808DB23HeiBiao_Message_Content_0x0C02 extends JT808MessageContent {
    public static final JT808DB23HeiBiaoMessageId MESSAGE_ID = JT808DB23HeiBiaoMessageId.JT808DB23HeiBiao_Message_0x0C02;

    @Override
    public JT808DB23HeiBiaoMessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 驾驶员从业资格证号
     */
    private String qualificationCertificateNumber;
    /**
     * 人证照片版本
     * <p>
     * 格式为YYYYMMDDHHNNSS，终端本地存储的驾驶员人证照片版本。未知或没有照片时，以00000000000000填充。
     */
    private String certificatePhotoVersion;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB23HeiBiao_Message_Content_0x0C02 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB23HeiBiao_Message_Content_0x0C02 content = new JT808DB23HeiBiao_Message_Content_0x0C02();
        content.deserialize(ctx, reader);
        return content;
    }
}
