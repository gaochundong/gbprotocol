package ai.sangmado.jt1078.protocol.message.content;

import ai.sangmado.jt1078.protocol.enums.JT1078MessageId;
import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.message.content.JT808MessageContent;
import lombok.*;

/**
 * 平台下发查询音视频资源列表
 * <p>
 * 平台按照音视频类型、通道号、报警类型和起止时间等组合条件从终端中查询录像文件列表。
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT1078_Message_Content_0x9205 extends JT808MessageContent {
    public static final JT1078MessageId MESSAGE_ID = JT1078MessageId.JT1078_Message_0x9205;

    @Override
    public JT1078MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 逻辑通道号
     * <p>
     * 按照JTT1076-2016中的表2：营运车辆车载视频终端音视频通道定义表；
     */
    private Integer logicalChannelNumber;
    /**
     * 开始时间
     * <p>
     * BCD[6], YY-MM-DD-HH-MM-SS，全 0 表示无起始 时间条件
     */
    private String beginTime;
    /**
     * 结束时间
     * <p>
     * BCD[6], YY-MM-DD-HH-MM-SS，全 0 表示无起始 时间条件
     */
    private String endTime;
    /**
     * 报警标志
     * <p>
     * bit0~bit31见JT/T 808—2011表18报警 标志位定义;
     * bit32 ~ bit63 见表 13;
     * 全 0 表示无报警类型条件
     */
    private Long warningBits;
    /**
     * 音视频资源类型
     * <p>
     * 0:音视频，1:音频，2:视频，3:视频或音视频
     */
    private Integer mediaResourceType;
    /**
     * 码流类型
     * <p>
     * 0:所有码流，1:主码流，2:子码流
     */
    private Integer streamType;
    /**
     * 存储器类型
     * <p>
     * 0:所有存储器，1:主存储器，2:灾备存储器
     */
    private Integer storageType;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT1078_Message_Content_0x9205 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT1078_Message_Content_0x9205 content = new JT1078_Message_Content_0x9205();
        content.deserialize(ctx, reader);
        return content;
    }
}
