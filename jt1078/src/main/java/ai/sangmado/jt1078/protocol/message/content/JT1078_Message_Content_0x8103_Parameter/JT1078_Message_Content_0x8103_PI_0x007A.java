package ai.sangmado.jt1078.protocol.message.content.JT1078_Message_Content_0x8103_Parameter;

import ai.sangmado.jt1078.protocol.enums.JT1078ProtocolVersion;
import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 终端􏰉􏱀􏰏􏰙􏱁终端􏰉􏱀􏰏􏰙􏱁平台设置终端参数 - 参数项 - 视频相关报警屏蔽字
 */
@NoArgsConstructor
public class JT1078_Message_Content_0x8103_PI_0x007A extends JT808_Message_Content_0x8103_ParameterItem<JT1078ProtocolVersion> {

    @Override
    public JT1078_Message_Content_0x8103_ParameterItemId getParameterItemId() {
        return JT1078_Message_Content_0x8103_ParameterItemId.JT1078_0x8103_0x007A;
    }

    /**
     * 视频相关报警屏蔽字
     */
    @Getter
    @Setter
    private Integer notImplementedSoFar;

    @Override
    public void serialize(ISpecificationContext<JT1078ProtocolVersion> ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext<JT1078ProtocolVersion> ctx, IJT808MessageBufferReader reader) {

    }
}
