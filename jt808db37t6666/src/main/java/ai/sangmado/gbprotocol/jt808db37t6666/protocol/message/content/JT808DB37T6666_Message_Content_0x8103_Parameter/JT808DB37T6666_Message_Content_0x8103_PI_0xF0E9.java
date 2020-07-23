package ai.sangmado.gbprotocol.jt808db37t6666.protocol.message.content.JT808DB37T6666_Message_Content_0x8103_Parameter;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItem;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItemId;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 平台设置终端参数 - 参数项 - 驾驶员比对参数
 */
@NoArgsConstructor
public class JT808DB37T6666_Message_Content_0x8103_PI_0xF0E9 extends JT808_Message_Content_0x8103_ParameterItem {
    public static final JT808_Message_Content_0x8103_ParameterItemId PARAMETER_ITEM_ID =
            JT808DB37T6666_Message_Content_0x8103_ParameterItemId.JT808DB37T6666_0x8103_0xF0E9;

    @Override
    public JT808_Message_Content_0x8103_ParameterItemId getParameterItemId() {
        return PARAMETER_ITEM_ID;
    }

    @Override
    public Integer getParameterItemLength() {
        return 4;
    }

    /**
     * xxx
     */
    @Getter
    @Setter
    private Integer xxx;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB37T6666_Message_Content_0x8103_PI_0xF0E9 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB37T6666_Message_Content_0x8103_PI_0xF0E9 content = new JT808DB37T6666_Message_Content_0x8103_PI_0xF0E9();
        content.deserialize(ctx, reader);
        return content;
    }
}
