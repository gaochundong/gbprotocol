package ai.sangmado.gbstandard.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter;

import ai.sangmado.gbstandard.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbstandard.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.gbstandard.jt808.protocol.encoding.IJT808MessageBufferWriter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 平台设置终端参数 - 参数项 - TCP消息应答超时时间
 */
@NoArgsConstructor
public class JT808_Message_Content_0x8103_PI_0x0002 extends JT808_Message_Content_0x8103_ParameterItem {
    public static final JT808_Message_Content_0x8103_ParameterItemId PARAMETER_ITEM_ID =
            JT808_Message_Content_0x8103_ParameterItemId.JT808_0x8103_0x0002;

    @Override
    public JT808_Message_Content_0x8103_ParameterItemId getParameterItemId() {
        return PARAMETER_ITEM_ID;
    }

    @Override
    public Integer getParameterItemLength() {
        return 4;
    }

    /**
     * TCP消息应答超时时间
     */
    @Getter
    @Setter
    private Long tcpReplyTimeout;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {
        writer.writeDWord(getParameterItemId().getValue());
        writer.writeByte(getParameterItemLength());
        writer.writeDWord(getTcpReplyTimeout());
    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        reader.readDWord();
        reader.readByte();
        setTcpReplyTimeout(reader.readDWord());
    }

    public static JT808_Message_Content_0x8103_PI_0x0002 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x8103_PI_0x0002 content = new JT808_Message_Content_0x8103_PI_0x0002();
        content.deserialize(ctx, reader);
        return content;
    }
}