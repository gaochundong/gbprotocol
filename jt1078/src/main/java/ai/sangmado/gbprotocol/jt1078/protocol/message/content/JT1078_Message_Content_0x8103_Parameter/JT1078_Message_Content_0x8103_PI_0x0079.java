package ai.sangmado.gbprotocol.jt1078.protocol.message.content.JT1078_Message_Content_0x8103_Parameter;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItem;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItemId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 平台设置终端参数 - 参数项 - 特殊报警录像参数设置
 */
@NoArgsConstructor
public class JT1078_Message_Content_0x8103_PI_0x0079 extends JT808_Message_Content_0x8103_ParameterItem {
    public static final JT808_Message_Content_0x8103_ParameterItemId PARAMETER_ITEM_ID =
            JT1078_Message_Content_0x8103_ParameterItemId.JT1078_0x8103_0x0079;

    @Override
    public JT808_Message_Content_0x8103_ParameterItemId getParameterItemId() {
        return PARAMETER_ITEM_ID;
    }

    @Override
    public Integer getParameterItemLength() {
        return 4;
    }

    /**
     * 特殊报警录像存储阈值
     *
     * 特殊报警录像占用主存储器存储阈值百分比，取值1 ～99，默认值为20
     */
    @Getter
    @Setter
    private Integer specialWarningVideoRecordStorageThreshold;
    /**
     * 特殊报警录像持续时间
     *
     * 特殊报警录像的最长持续时间，单位为分钟(min)，默认值为5
     */
    @Getter
    @Setter
    private Integer specialWarningVideoRecordStorageDuration;
    /**
     * 特殊报警标识起始时间
     *
     * 特殊报警发生前进行标记的录像时间，单位为分钟(min)，默认值为1
     */
    @Getter
    @Setter
    private Integer specialWarningVideoRecordMarkedBeginTime;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT1078_Message_Content_0x8103_PI_0x0079 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT1078_Message_Content_0x8103_PI_0x0079 content = new JT1078_Message_Content_0x8103_PI_0x0079();
        content.deserialize(ctx, reader);
        return content;
    }
}
