package ai.sangmado.gbprotocol.jt808db51chuanbiao.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808db51chuanbiao.protocol.enums.JT808DB51ChuanBiaoMessageId;
import ai.sangmado.gbprotocol.jt808db51chuanbiao.protocol.enums.JT808DB51ChuanBiaoWarningFileType;
import ai.sangmado.gbprotocol.jt808db51chuanbiao.protocol.enums.JT808DB51ChuanBiaoWarningFileUploadResult;
import lombok.*;

import java.util.List;

/**
 * 文件上传完成消息应答
 * <p>
 * 附件服务器收到终端上报的文件发送完成消息时，向终端发送文件上传完成消息应答
 * 全部文件发送完成后，终端主动与附件服务器断开连接。
 *
 * @implNote 该消息是附件服务器下发给终端的
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808DB51ChuanBiao_Message_Content_0x9212 extends JT808MessageContent {
    public static final JT808DB51ChuanBiaoMessageId MESSAGE_ID = JT808DB51ChuanBiaoMessageId.JT808DB51ChuanBiao_Message_0x9212;

    @Override
    public JT808DB51ChuanBiaoMessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 文件名称长度
     */
    private Integer fileNameLength;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 文件类型
     */
    private JT808DB51ChuanBiaoWarningFileType fileType;
    /**
     * 上传结果
     */
    private JT808DB51ChuanBiaoWarningFileUploadResult uploadResult;
    /**
     * 补传数据包数量
     */
    private Integer dataPacketCount;
    /**
     * 补传数据包列表
     */
    private List<Integer> dataPacketList;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB51ChuanBiao_Message_Content_0x9212 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB51ChuanBiao_Message_Content_0x9212 content = new JT808DB51ChuanBiao_Message_Content_0x9212();
        content.deserialize(ctx, reader);
        return content;
    }
}
