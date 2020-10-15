package ai.sangmado.gbprotocol.jt808.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.*;

/**
 * 平台下发终端升级包
 *
 * @since V2013 对该命令终端使用通用应答确认是否正确收到升级包数据。
 * @since 苏标 苏标中修改了升级的消息交互流程，终端通过JT/T808-2011中的终端控制指令0x8105对终端进行升级，通过0x0108做结果应答；
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808_Message_Content_0x8108 extends JT808MessageContent {
    public static final JT808MessageId MESSAGE_ID = JT808MessageId.JT808_Message_0x8108;

    @Override
    public JT808MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 升级类型
     * <p>
     * 0：终端
     * 12：道路运输证IC卡读卡器
     * 52：北斗卫星定位模块
     */
    private Integer upgradeTarget;
    /**
     * 制造商ID
     */
    private String manufacturerId;
    /**
     * 终端固件版本号长度
     */
    private Integer firmwareVersionNumberLength;
    /**
     * 终端固件版本号
     */
    private String firmwareVersionNumber;
    /**
     * 升级数据包长度
     */
    private Long upgradeFirmwareDataLength;
    /**
     * 升级数据包
     */
    private byte[] upgradeFirmwareData;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808_Message_Content_0x8108 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x8108 content = new JT808_Message_Content_0x8108();
        content.deserialize(ctx, reader);
        return content;
    }
}
