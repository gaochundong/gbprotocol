package ai.sangmado.gbprotocol.jt808db51chuanbiao.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808db51chuanbiao.protocol.enums.JT808DB51ChuanBiaoMessageId;
import ai.sangmado.gbprotocol.jt808db51chuanbiao.protocol.enums.JT808DB51ChuanBiaoWarningFileType;
import lombok.*;

/**
 * 文件上传完成消息
 * <p>
 * 终端向附件服务器完成一个文件数据发送时，向附件服务器发送文件发送完成消息.
 *
 * @implNote 该消息是发给附件服务器的
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808DB51ChuanBiao_Message_Content_0x1212 extends JT808MessageContent {
    public static final JT808DB51ChuanBiaoMessageId MESSAGE_ID = JT808DB51ChuanBiaoMessageId.JT808DB51ChuanBiao_Message_0x1212;

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
     * 文件大小
     */
    private Long fileSize;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB51ChuanBiao_Message_Content_0x1212 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB51ChuanBiao_Message_Content_0x1212 content = new JT808DB51ChuanBiao_Message_Content_0x1212();
        content.deserialize(ctx, reader);
        return content;
    }
}
