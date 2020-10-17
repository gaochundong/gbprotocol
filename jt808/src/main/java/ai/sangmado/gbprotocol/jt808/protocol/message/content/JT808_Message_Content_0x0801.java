package ai.sangmado.gbprotocol.jt808.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MediaDataActionCode;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MediaDataCodingFormat;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MediaDataType;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.*;

/**
 * 终端多媒体数据上传
 *
 * @since V2011
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808_Message_Content_0x0801 extends JT808MessageContent {
    public static final JT808MessageId MESSAGE_ID = JT808MessageId.JT808_Message_0x0801;

    @Override
    public JT808MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 多媒体数据ID
     */
    private Long mediaDataId;
    /**
     * 多媒体类型
     */
    private JT808MediaDataType mediaDataType;
    /**
     * 多媒体格式编码
     */
    private JT808MediaDataCodingFormat mediaDataCodingFormat;
    /**
     * 事件项编码
     */
    private JT808MediaDataActionCode mediaDataActionCode;
    /**
     * 通道ID
     */
    private Integer channelId;
    /**
     * 位置信息汇报(0x0200消息体)
     * 表示多媒体数据的位置基本信息数据
     *
     * @since V2013 新增字段
     */
    private JT808_Message_Content_0x0200 gpsData;
    /**
     * 多媒体数据包
     *
     * @since V2011
     */
    private byte[] mediaData;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808_Message_Content_0x0801 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x0801 content = new JT808_Message_Content_0x0801();
        content.deserialize(ctx, reader);
        return content;
    }
}
