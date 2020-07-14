package ai.sangmado.gbprotocol.jt808db32t3610.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808db32t3610.protocol.enums.JT808DB32T3610MessageId;
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
public class JT808DB32T3610_Message_Content_0x9208 extends JT808MessageContent {
    public static final JT808DB32T3610MessageId MESSAGE_ID = JT808DB32T3610MessageId.JT808DB32T3610_Message_0x9208;

    @Override
    public JT808DB32T3610MessageId getMessageId() {
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
    private JT808DB32T3610_WarningIdentity warningIdentity;
    /**
     * 报警编号
     * <p>
     * 平台给报警分配的唯一编号
     */
    private String warningId;
    /**
     * 预留
     */
    private byte[] reserved = RESERVED;

    private static final byte[] RESERVED = new byte[16];

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB32T3610_Message_Content_0x9208 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB32T3610_Message_Content_0x9208 content = new JT808DB32T3610_Message_Content_0x9208();
        content.deserialize(ctx, reader);
        return content;
    }
}
