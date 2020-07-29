package ai.sangmado.gbprotocol.jt808db37lubiao.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808db37lubiao.protocol.enums.JT808DB37LuBiaoMessageId;
import ai.sangmado.gbprotocol.jt808db37lubiao.protocol.enums.JT808DB37LuBiaoWarningFileType;
import lombok.*;

/**
 * 文件信息上传
 * <p>
 * 终端向附件服务器发送报警附件信息指令并得到应答后，向附件服务器发送附件文件信息消息
 *
 * @implNote 该消息是发给附件服务器的
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808DB37LuBiao_Message_Content_0x1211 extends JT808MessageContent {
    public static final JT808DB37LuBiaoMessageId MESSAGE_ID = JT808DB37LuBiaoMessageId.JT808DB37LuBiao_Message_0x1211;

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

    public static JT808DB37LuBiao_Message_Content_0x1211 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB37LuBiao_Message_Content_0x1211 content = new JT808DB37LuBiao_Message_Content_0x1211();
        content.deserialize(ctx, reader);
        return content;
    }
}
