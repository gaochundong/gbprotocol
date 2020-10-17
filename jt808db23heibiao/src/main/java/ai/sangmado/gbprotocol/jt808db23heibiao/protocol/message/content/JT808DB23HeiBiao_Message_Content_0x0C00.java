package ai.sangmado.gbprotocol.jt808db23heibiao.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808db23heibiao.protocol.enums.JT808DB23HeiBiaoMessageId;
import lombok.*;

import java.math.BigDecimal;

/**
 * 驾驶员身份识别上报
 * <p>
 * 终端根据配置自动进行人证匹配，通过该消息通知平台驾驶员身份识别结果。
 * 如配置抓拍照片上传，人脸抓拍标识有效，上传此消息后立刻上传抓拍照片，并通过0x0803消息通知平台上传状态。
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808DB23HeiBiao_Message_Content_0x0C00 extends JT808MessageContent {
    public static final JT808DB23HeiBiaoMessageId MESSAGE_ID = JT808DB23HeiBiaoMessageId.JT808DB23HeiBiao_Message_0x0C00;

    @Override
    public JT808DB23HeiBiaoMessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 位置基本信息
     * <p>
     * 位置信息汇报(0x0200)消息体基本信息
     */
    private String locationInfo;
    /**
     * 驾驶员从业资格证号
     */
    private String qualificationCertificateNumber;
    /**
     * 比对类型
     * <p>
     * 0-插卡比对；
     * 1-巡检比对；
     * 2-点火比对；
     * 3-离开返回比对
     */
    private Integer comparisonType;
    /**
     * 比对结果
     * <p>
     * 0：匹配成功；
     * 1：匹配失败；
     * 2：超时；
     * 3：没有启用该功能；
     * 4：连接异常；
     * 5：无指定人脸图片
     * 6：无人脸库
     */
    private Integer comparisonResult;
    /**
     * 照片匹配率
     * <p>
     * 百分比；范围0%~100%。单位是1%；
     */
    private BigDecimal photoMatchingRatio;
    /**
     * 人脸抓怕照片标识
     * <p>
     * 比对结果为0或者1时，应上传图片数据（为抓拍的图片，上传到参数指定的文件服务器）
     * 业务类型_车牌号_通道号_拍照原因（比对类型）_驾驶员从业资格证号_拍照时间YYYYMMDDHHNNSS_序号.jpg
     * 其中 业务类型为01(人脸比对)
     */
    private String facePhotoCaptureFlag;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB23HeiBiao_Message_Content_0x0C00 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB23HeiBiao_Message_Content_0x0C00 content = new JT808DB23HeiBiao_Message_Content_0x0C00();
        content.deserialize(ctx, reader);
        return content;
    }
}
