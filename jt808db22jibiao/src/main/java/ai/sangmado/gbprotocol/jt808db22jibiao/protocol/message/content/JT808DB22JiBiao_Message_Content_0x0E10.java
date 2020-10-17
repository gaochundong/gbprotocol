package ai.sangmado.gbprotocol.jt808db22jibiao.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x0200;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808db22jibiao.protocol.enums.JT808DB22JiBiaoMessageId;
import lombok.*;

/**
 * 驾驶员身份识别上报
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808DB22JiBiao_Message_Content_0x0E10 extends JT808MessageContent {
    public static final JT808DB22JiBiaoMessageId MESSAGE_ID = JT808DB22JiBiaoMessageId.JT808DB22JiBiao_Message_0x0E10;

    @Override
    public JT808DB22JiBiaoMessageId getMessageId() {
        return MESSAGE_ID;
    }

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
    private Integer comparedResult;
    /**
     * 比对相似度阈值
     * <p>
     * 百分比；范围0%~100%。 单位是1%；
     */
    private Integer similarityThreshold;
    /**
     * 比对相似度
     * <p>
     * 百分比；范围0.00%~100.00%。单位是0.01%；比如5432 表示54.32%
     */
    private Integer similarity;
    /**
     * 比对类型
     * <p>
     * 0-插卡比对；
     * 1-巡检比对；
     * 2-点火比对；
     * 3-离开返回比对
     */
    private Integer comparisonCategory;
    /**
     * 比对人脸ID长度
     */
    private Integer comparedFaceIdLength;
    /**
     * 比对人脸ID
     */
    private String comparedFaceId;
    /**
     * 位置信息汇报(0x0200)消息体
     * <p>
     * 表示人脸比对时刻的位置基本信息数据
     */
    private JT808_Message_Content_0x0200 gpsData;
    /**
     * 图片格式
     * <p>
     * 0：JPEG
     */
    private String photoFormat;
    /**
     * 图片数据包
     * <p>
     * 比对结果为0 或者1 时，应上传图片数据（为抓拍的图片）
     */
    private String photoData;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB22JiBiao_Message_Content_0x0E10 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB22JiBiao_Message_Content_0x0E10 content = new JT808DB22JiBiao_Message_Content_0x0E10();
        content.deserialize(ctx, reader);
        return content;
    }
}
