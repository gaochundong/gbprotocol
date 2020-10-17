package ai.sangmado.gbprotocol.jt808db23heibiao.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808db23heibiao.protocol.enums.JT808DB23HeiBiaoMessageId;
import ai.sangmado.gbprotocol.jt808db23heibiao.protocol.enums.JT808DB23HeiBiaoWarningFileType;
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
public class JT808DB23HeiBiao_Message_Content_0x1211 extends JT808MessageContent {
    public static final JT808DB23HeiBiaoMessageId MESSAGE_ID = JT808DB23HeiBiaoMessageId.JT808DB23HeiBiao_Message_0x1211;

    @Override
    public JT808DB23HeiBiaoMessageId getMessageId() {
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
    private JT808DB23HeiBiaoWarningFileType fileType;
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

    public static JT808DB23HeiBiao_Message_Content_0x1211 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB23HeiBiao_Message_Content_0x1211 content = new JT808DB23HeiBiao_Message_Content_0x1211();
        content.deserialize(ctx, reader);
        return content;
    }
}
