package ai.sangmado.gbprotocol.jt808db23heibiao.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808db23heibiao.protocol.enums.JT808DB23HeiBiaoMessageId;
import lombok.*;

/**
 * 人证照片更新通知
 * <p>
 * 平台端驾驶员人脸识别照片更新后，通过此消息指令通知车载设备端进行更新。
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808DB23HeiBiao_Message_Content_0x8C01 extends JT808MessageContent {
    public static final JT808DB23HeiBiaoMessageId MESSAGE_ID = JT808DB23HeiBiaoMessageId.JT808DB23HeiBiao_Message_0x8C01;

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
     */
    private String certificatePhotoVersion;
    /**
     * 人证照片下载地址
     */
    private String certificatePhotoDownloadUrl;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB23HeiBiao_Message_Content_0x8C01 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB23HeiBiao_Message_Content_0x8C01 content = new JT808DB23HeiBiao_Message_Content_0x8C01();
        content.deserialize(ctx, reader);
        return content;
    }
}
