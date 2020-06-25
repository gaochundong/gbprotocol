package ai.sangmado.gbprotocol.jt1078.protocol.message.content;

import ai.sangmado.gbprotocol.jt1078.protocol.enums.JT1078MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageFormatter;
import lombok.*;

import java.util.List;

/**
 * 终端上传音视频资源列表
 * <p>
 * 终端响应平台的查询音视频资源列表指令，采用终端上传音视频资源列表消息应答。
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT1078_Message_Content_0x1205 extends JT808MessageContent {
    public static final JT1078MessageId MESSAGE_ID = JT1078MessageId.JT1078_Message_0x1205;

    @Override
    public JT1078MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 流水号
     */
    private Integer serialNumber;
    /**
     * 音视频资源总数
     */
    private Integer mediaResourceCount;
    /**
     * 音视频资源列表
     */
    private List<MediaResource> mediaResourceList;

    /**
     * 终端上传音视频资源列表格式
     */
    @Getter
    @Setter
    @NoArgsConstructor
    public static class MediaResource implements IJT808MessageFormatter {

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
        /**
         * 文件大小
         * <p>
         * 单位字节(Byte)
         */
        private Long fileSize;

        @Override
        public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

        }

        @Override
        public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

        }
    }

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT1078_Message_Content_0x1205 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT1078_Message_Content_0x1205 content = new JT1078_Message_Content_0x1205();
        content.deserialize(ctx, reader);
        return content;
    }
}
