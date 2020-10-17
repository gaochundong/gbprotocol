package ai.sangmado.gbprotocol.jt808.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MediaDataActionCode;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MediaDataType;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.*;

import java.util.List;

/**
 * 终端存储多媒体数据检索应答
 *
 * @since V2011
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808_Message_Content_0x0802 extends JT808MessageContent {
    public static final JT808MessageId MESSAGE_ID = JT808MessageId.JT808_Message_0x0802;

    @Override
    public JT808MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 应答流水号
     * <p>
     * 对应的多媒体数据检索消息的流水号
     */
    private Integer ackSerialNumber;
    /**
     * 多媒体数据总项数
     * <p>
     * 满足检索条件的多媒体数据总项数
     */
    private Integer mediaDataItemCount;
    /**
     * 多媒体检索项数据
     */
    private List<MediaDataItem> mediaDataItems;

    /**
     * 多媒体检索项
     */
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class MediaDataItem {
        /**
         * 多媒体数据ID
         *
         * @since V2013 新增字段
         */
        private Long mediaDataId;
        /**
         * 多媒体类型
         */
        private JT808MediaDataType mediaDataType;
        /**
         * 通道ID
         */
        private Integer channelId;
        /**
         * 事件项编码
         */
        private JT808MediaDataActionCode mediaDataActionCode;
        /**
         * 位置信息汇报(0x0200消息体)
         * <p>
         * 表示拍摄或录制的起始时刻的位置基本信息数据
         */
        private JT808_Message_Content_0x0200 gpsData;
    }

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808_Message_Content_0x0802 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x0802 content = new JT808_Message_Content_0x0802();
        content.deserialize(ctx, reader);
        return content;
    }
}
