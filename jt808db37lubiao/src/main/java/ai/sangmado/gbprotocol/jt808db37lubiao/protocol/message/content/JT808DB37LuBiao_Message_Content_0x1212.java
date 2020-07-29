package ai.sangmado.gbprotocol.jt808db37lubiao.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808db37lubiao.protocol.enums.JT808DB37LuBiaoWarningFileType;
import ai.sangmado.gbprotocol.jt808db37lubiao.protocol.enums.JT808DB37LuBiaoMessageId;
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
public class JT808DB37LuBiao_Message_Content_0x1212 extends JT808MessageContent {
    public static final JT808DB37LuBiaoMessageId MESSAGE_ID = JT808DB37LuBiaoMessageId.JT808DB37LuBiao_Message_0x1212;

    @Override
    public JT808DB37LuBiaoMessageId getMessageId() {
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
    private JT808DB37LuBiaoWarningFileType fileType;
    /**
     * 文件大小
     */
    private Long fileSize;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB37LuBiao_Message_Content_0x1212 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB37LuBiao_Message_Content_0x1212 content = new JT808DB37LuBiao_Message_Content_0x1212();
        content.deserialize(ctx, reader);
        return content;
    }
}
