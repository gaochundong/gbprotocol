package ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 平台设置终端参数 - 参数项 - 终端心跳发送间隔
 */
@NoArgsConstructor
public class JT808_Message_Content_0x8103_PI_0x0001 extends JT808_Message_Content_0x8103_ParameterItem {
    public static final JT808_Message_Content_0x8103_ParameterItemId PARAMETER_ITEM_ID =
            JT808_Message_Content_0x8103_ParameterItemId.JT808_0x8103_0x0001;

    @Override
    public JT808_Message_Content_0x8103_ParameterItemId getParameterItemId() {
        return PARAMETER_ITEM_ID;
    }

    @Override
    public Integer getParameterItemLength() {
        return 4;
    }

    /**
     * 终端心跳发送间隔
     */
    @Getter
    @Setter
    private Long heartbeatInterval;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {
        writer.writeDWord(getParameterItemId().getValue());
        writer.writeByte(getParameterItemLength());
        writer.writeDWord(getHeartbeatInterval());
    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        reader.readDWord();
        reader.readByte();
        setHeartbeatInterval(reader.readDWord());
    }

    public static JT808_Message_Content_0x8103_PI_0x0001 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x8103_PI_0x0001 content = new JT808_Message_Content_0x8103_PI_0x0001();
        content.deserialize(ctx, reader);
        return content;
    }
}
