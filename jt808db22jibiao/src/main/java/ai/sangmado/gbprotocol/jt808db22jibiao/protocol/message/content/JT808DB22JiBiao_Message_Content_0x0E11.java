package ai.sangmado.gbprotocol.jt808db22jibiao.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808db22jibiao.protocol.enums.JT808DB22JiBiaoMessageId;
import lombok.*;

/**
 * 驾驶员身份库数据下载应答
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808DB22JiBiao_Message_Content_0x0E11 extends JT808MessageContent {
    public static final JT808DB22JiBiaoMessageId MESSAGE_ID = JT808DB22JiBiaoMessageId.JT808DB22JiBiao_Message_0x0E11;

    @Override
    public JT808DB22JiBiaoMessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 应答流水号
     * <p>
     * 对应人脸设置的流水号
     */
    private Integer ackSerialNumber;
    /**
     * 应答结果
     * <p>
     * 0：成功，1：失败
     */
    private Boolean ackResult;
    /**
     * 需要下载总数
     */
    private Integer numberOfToBeDownloaded;
    /**
     * 当前下载到第几个文件
     */
    private Integer currentDownloadedSequence;
    /**
     * 当前下载的人脸ID长度
     */
    private Integer currentDownloadedDriverFaceIdLength;
    /**
     * 当前下载的人脸ID
     */
    private String currentDownloadedDriverFaceId;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB22JiBiao_Message_Content_0x0E11 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB22JiBiao_Message_Content_0x0E11 content = new JT808DB22JiBiao_Message_Content_0x0E11();
        content.deserialize(ctx, reader);
        return content;
    }
}
