package ai.sangmado.gbprotocol.jt808db23heibiao.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808db23heibiao.protocol.enums.JT808DB23HeiBiaoMessageId;
import lombok.*;

/**
 * 驾驶员人证照片更新请求应答
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808DB23HeiBiao_Message_Content_0x8C02 extends JT808MessageContent {
    public static final JT808DB23HeiBiaoMessageId MESSAGE_ID = JT808DB23HeiBiaoMessageId.JT808DB23HeiBiao_Message_0x8C02;

    @Override
    public JT808DB23HeiBiaoMessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 驾驶员从业资格证号
     */
    private String qualificationCertificateNumber;
    /**
     * 版本对比情况
     *
     * 0x00：一致;
     * 0x01：不一致;
     * 当为0x01时以下数据内容有效;
     */
    private String certificatePhotoVersionComparisonResult;
    /**
     * 人证照片版本
     */
    private String certificatePhotoVersion;
    /**
     * 人证照片下载地址
     */
    private String certificatePhotoDownloadUrl;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB23HeiBiao_Message_Content_0x8C02 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB23HeiBiao_Message_Content_0x8C02 content = new JT808DB23HeiBiao_Message_Content_0x8C02();
        content.deserialize(ctx, reader);
        return content;
    }
}
