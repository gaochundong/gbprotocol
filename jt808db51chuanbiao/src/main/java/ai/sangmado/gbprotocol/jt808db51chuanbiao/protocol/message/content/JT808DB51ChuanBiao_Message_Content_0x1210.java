package ai.sangmado.gbprotocol.jt808db51chuanbiao.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808db51chuanbiao.protocol.enums.JT808DB51ChuanBiaoMessageId;
import lombok.*;

import java.util.List;

/**
 * 报警附件信息消息
 * <p>
 * 终端根据附件上传指令连接附件服务器，并向服务器发送报警附件信息消息
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808DB51ChuanBiao_Message_Content_0x1210 extends JT808MessageContent {
    public static final JT808DB51ChuanBiaoMessageId MESSAGE_ID = JT808DB51ChuanBiaoMessageId.JT808DB51ChuanBiao_Message_0x1210;

    @Override
    public JT808DB51ChuanBiaoMessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 终端ID
     * <p>
     * 7个字节，由大写字母和数字组成，此终端ID由制造商自行定义，位数不足时，后补0x00
     */
    private String deviceId;
    /**
     * 报警标识号
     */
    private JT808DB51ChuanBiao_WarningIdentity warningIdentity;
    /**
     * 报警编号
     * <p>
     * 平台给报警分配的唯一编号
     */
    private String warningId;
    /**
     * 信息类型
     * <p>
     * 0x00：正常报警文件信息
     * 0x01：补传报警文件信息
     */
    private Integer infoType;
    /**
     * 附件数量
     * <p>
     * 表示该报警对应的附件数量
     */
    private Integer fileCount;
    /**
     * 附件信息列表
     */
    private List<JT808DB51ChuanBiao_WarningFileDescription> fileList;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB51ChuanBiao_Message_Content_0x1210 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB51ChuanBiao_Message_Content_0x1210 content = new JT808DB51ChuanBiao_Message_Content_0x1210();
        content.deserialize(ctx, reader);
        return content;
    }
}
