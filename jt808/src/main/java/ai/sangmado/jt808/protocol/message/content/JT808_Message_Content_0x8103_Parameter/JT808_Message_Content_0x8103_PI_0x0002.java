package ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 终端􏰉􏱀􏰏􏰙􏱁终端􏰉􏱀􏰏􏰙􏱁平台设置终端参数 - 参数项 - TCP消息应答超时时间
 */
@NoArgsConstructor
public class JT808_Message_Content_0x8103_PI_0x0002 extends JT808_Message_Content_0x8103_ParameterItem {

    @Override
    public JT808_Message_Content_0x8103_ParameterItemId getParameterItemId() {
        return JT808_Message_Content_0x8103_ParameterItemId.JT808_0x8103_0x0002;
    }

    /**
     * TCP消息应答超时时间
     */
    @Getter
    @Setter
    private Integer tcpReplyTimeout;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }
}
