package ai.sangmado.gbprotocol.jt808.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.*;

/**
 * 终端升级结果通知
 *
 * @since V2013 终端在升级完成并重新连接后使用该命令通知监控中心。
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808_Message_Content_0x0108 extends JT808MessageContent {
    public static final JT808MessageId MESSAGE_ID = JT808MessageId.JT808_Message_0x0108;

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
     * 升级结果
     * <p>
     * 0：成功，1：失败，2：取消
     */
    private Integer upgradeResult;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808_Message_Content_0x0108 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x0108 content = new JT808_Message_Content_0x0108();
        content.deserialize(ctx, reader);
        return content;
    }
}
