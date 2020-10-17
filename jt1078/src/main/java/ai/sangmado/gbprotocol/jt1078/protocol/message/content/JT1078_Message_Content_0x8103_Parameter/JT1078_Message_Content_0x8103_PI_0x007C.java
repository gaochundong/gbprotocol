package ai.sangmado.gbprotocol.jt1078.protocol.message.content.JT1078_Message_Content_0x8103_Parameter;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItem;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItemId;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 平台设置终端参数 - 参数项 - 终端休眠唤醒模式设置
 */
@NoArgsConstructor
public class JT1078_Message_Content_0x8103_PI_0x007C extends JT808_Message_Content_0x8103_ParameterItem {
    public static final JT808_Message_Content_0x8103_ParameterItemId PARAMETER_ITEM_ID =
            JT1078_Message_Content_0x8103_ParameterItemId.JT1078_0x8103_0x007C;

    @Override
    public JT808_Message_Content_0x8103_ParameterItemId getParameterItemId() {
        return PARAMETER_ITEM_ID;
    }

    @Override
    public Integer getParameterItemLength() {
        return 4;
    }

    /**
     * 休眠唤醒模式
     * <p>
     * 按位设置：0 表示不设置，1 表示设置；
     * bit0：条件唤醒；
     * bit1：定时唤醒；
     * bit2：手动唤醒
     */
    @Getter
    @Setter
    private Integer sleepWakeMode;
    /**
     * 唤醒条件类型
     * <p>
     * 休眠唤醒模式中bit0 为1 时此字段有效，否则置0；
     * 按位设置：0 表示不设置，1 表示设置；
     * bit0：紧急报警；
     * bit1：碰撞侧翻报警；
     * bit2：车辆开门
     */
    @Getter
    @Setter
    private Integer wakeConditionType;
    /**
     * 定时唤醒日设置
     * <p>
     * 按位设置：0 表示不设置，1 表示设置；
     * bit0：周一；
     * bit1：周二；
     * bit2：周三；
     * bit3：周四；
     * bit4：周五；
     * bit5：周六；
     * bit6：周日
     */
    @Getter
    @Setter
    private Integer regularWakeDaySetting;
    /**
     * 日定时唤醒参数列表
     * <p>
     * 见表10，各时间段应不重叠
     */
    @Getter
    @Setter
    private Integer dailyWakingParameters;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT1078_Message_Content_0x8103_PI_0x007C decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT1078_Message_Content_0x8103_PI_0x007C content = new JT1078_Message_Content_0x8103_PI_0x007C();
        content.deserialize(ctx, reader);
        return content;
    }
}
