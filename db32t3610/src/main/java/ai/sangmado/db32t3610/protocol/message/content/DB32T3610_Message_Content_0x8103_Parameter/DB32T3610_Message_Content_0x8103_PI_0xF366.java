package ai.sangmado.db32t3610.protocol.message.content.DB32T3610_Message_Content_0x8103_Parameter;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItem;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItemId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 平台设置终端参数 - 参数项 - 胎压监测系统参数
 */
@NoArgsConstructor
public class DB32T3610_Message_Content_0x8103_PI_0xF366 extends JT808_Message_Content_0x8103_ParameterItem {
    public static final JT808_Message_Content_0x8103_ParameterItemId PARAMETER_ITEM_ID =
            DB32T3610_Message_Content_0x8103_ParameterItemId.DB32T3610_0x8103_0xF366;

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

    public static DB32T3610_Message_Content_0x8103_PI_0xF366 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        DB32T3610_Message_Content_0x8103_PI_0xF366 content = new DB32T3610_Message_Content_0x8103_PI_0xF366();
        content.deserialize(ctx, reader);
        return content;
    }
}
