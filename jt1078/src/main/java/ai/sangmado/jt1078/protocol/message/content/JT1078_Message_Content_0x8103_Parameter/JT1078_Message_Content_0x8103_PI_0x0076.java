package ai.sangmado.jt1078.protocol.message.content.JT1078_Message_Content_0x8103_Parameter;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 终端􏰉􏱀􏰏􏰙􏱁终端􏰉􏱀􏰏􏰙􏱁平台设置终端参数 - 参数项 - 音视频通道列表设置
 */
@NoArgsConstructor
public class JT1078_Message_Content_0x8103_PI_0x0076 extends JT808_Message_Content_0x8103_ParameterItem {

    @Override
    public JT1078_Message_Content_0x8103_ParameterItemId getParameterItemId() {
        return JT1078_Message_Content_0x8103_ParameterItemId.JT1078_0x8103_0x0076;
    }

    /**
     * 音视频通道列表设置
     */
    @Getter
    @Setter
    private Integer notImplementedSoFar;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }
}
