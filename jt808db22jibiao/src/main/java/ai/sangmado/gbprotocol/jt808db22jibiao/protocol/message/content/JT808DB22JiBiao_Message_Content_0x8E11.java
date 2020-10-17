package ai.sangmado.gbprotocol.jt808db22jibiao.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808db22jibiao.protocol.enums.JT808DB22JiBiaoMessageId;
import lombok.*;

import java.util.List;

/**
 * 驾驶员身份信息库下发
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808DB22JiBiao_Message_Content_0x8E11 extends JT808MessageContent {
    public static final JT808DB22JiBiaoMessageId MESSAGE_ID = JT808DB22JiBiaoMessageId.JT808DB22JiBiao_Message_0x8E11;

    @Override
    public JT808DB22JiBiaoMessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 设置类型
     * <p>
     * 0：增加（全替换），
     * 1：删除（全删除），
     * 2：删除指定条目，
     * 3：修改(如果设备存在人脸id，那么替换当前设备的人脸图片。如果设备不存在人脸id，那么新增人脸)
     */
    private String settingType;
    /**
     * 驾驶员库列表个数
     */
    private Integer driverRepositoryItemCount;
    /**
     * 驾驶员库信息列表
     */
    private List<String> driverRepositoryItems;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB22JiBiao_Message_Content_0x8E11 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB22JiBiao_Message_Content_0x8E11 content = new JT808DB22JiBiao_Message_Content_0x8E11();
        content.deserialize(ctx, reader);
        return content;
    }
}
