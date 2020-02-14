package ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.enums.JT808ProtocolVersion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 终端􏰉􏱀􏰏􏰙􏱁终端􏰉􏱀􏰏􏰙􏱁平台设置终端参数 - 参数项 - UDP消息应答超时时间
 */
@NoArgsConstructor
public class JT808_Message_Content_0x8103_PI_0x0004 extends JT808_Message_Content_0x8103_ParameterItem<JT808ProtocolVersion> {

    @Override
    public JT808_Message_Content_0x8103_ParameterItemId getParameterItemId() {
        return JT808_Message_Content_0x8103_ParameterItemId.JT808_0x8103_0x0004;
    }

    /**
     * UDP消息应答超时时间
     */
    @Getter
    @Setter
    private Integer udpReplyTimeout;

    @Override
    public void serialize(ISpecificationContext<JT808ProtocolVersion> ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext<JT808ProtocolVersion> ctx, IJT808MessageBufferReader reader) {

    }
}
