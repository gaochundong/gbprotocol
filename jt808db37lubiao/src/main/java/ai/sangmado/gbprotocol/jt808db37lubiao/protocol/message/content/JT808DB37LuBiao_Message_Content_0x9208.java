package ai.sangmado.gbprotocol.jt808db37lubiao.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808db37lubiao.protocol.enums.JT808DB37LuBiaoMessageId;
import lombok.*;

/**
 * 报警附件上传指令
 * <p>
 * 平台接收到带有附件的报警事件信息后，向终端下发附件上传指令
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808DB37LuBiao_Message_Content_0x9208 extends JT808MessageContent {
    public static final JT808DB37LuBiaoMessageId MESSAGE_ID = JT808DB37LuBiaoMessageId.JT808DB37LuBiao_Message_0x9208;

    @Override
    public JT808DB37LuBiaoMessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 服务器IP地址长度
     */
    private Integer storageServerIPAddressLength;
    /**
     * 服务器IP地址
     */
    private String storageServerIPAddress;
    /**
     * 服务器监听端口号(TCP)
     */
    private Integer storageServerTcpPort;
    /**
     * 服务器监听端口号（UDP）
     */
    private Integer storageServerUdpPort;
    /**
     * 报警标识号
     */
    private JT808DB37LuBiao_WarningIdentity warningIdentity;
    /**
     * 报警编号
     * <p>
     * 平台给报警分配的唯一编号
     */
    private String warningId;
    /**
     * 预留
     */
    @Builder.Default
    private byte[] reserved = RESERVED;

    private static final byte[] RESERVED = new byte[16];

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB37LuBiao_Message_Content_0x9208 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB37LuBiao_Message_Content_0x9208 content = new JT808DB37LuBiao_Message_Content_0x9208();
        content.deserialize(ctx, reader);
        return content;
    }
}
