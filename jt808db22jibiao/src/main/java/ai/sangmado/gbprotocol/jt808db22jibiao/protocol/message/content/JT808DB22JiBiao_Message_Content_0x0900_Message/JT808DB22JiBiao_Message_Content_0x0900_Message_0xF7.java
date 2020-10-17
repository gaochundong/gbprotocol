package ai.sangmado.gbprotocol.jt808db22jibiao.protocol.message.content.JT808DB22JiBiao_Message_Content_0x0900_Message;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_Passthrough_Message.JT808_Message_Content_0x0900_Base;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 透传消息 - 状态查询
 */
@NoArgsConstructor
public class JT808DB22JiBiao_Message_Content_0x0900_Message_0xF7 extends JT808_Message_Content_0x0900_Base {
    public static final JT808DB22JiBiao_Message_Content_Passthrough_MessageType MESSAGE_TYPE =
            JT808DB22JiBiao_Message_Content_Passthrough_MessageType.JT808DB22JiBiao_Passthrough_Message_0xF7;

    @Override
    public JT808DB22JiBiao_Message_Content_Passthrough_MessageType getPassthroughMessageType() {
        return MESSAGE_TYPE;
    }

    /**
     * 外设ID
     */
    @Getter
    @Setter
    private JT808DB22JiBiao_Message_Content_Passthrough_PeripheralId peripheralId;
    /**
     * 消息长度
     */
    @Getter
    @Setter
    private Integer messageLength;
    /**
     * 工作状态
     */
    @Getter
    @Setter
    private Integer workState;
    /**
     * 报警状态
     */
    @Getter
    @Setter
    private Integer warningStatus;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB22JiBiao_Message_Content_0x0900_Message_0xF7 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB22JiBiao_Message_Content_0x0900_Message_0xF7 content = new JT808DB22JiBiao_Message_Content_0x0900_Message_0xF7();
        content.deserialize(ctx, reader);
        return content;
    }
}
