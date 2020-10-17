package ai.sangmado.gbprotocol.gb19056.protocol.message.content.command;

import ai.sangmado.gbprotocol.gb19056.protocol.enums.GB19056CommandMessageId;
import ai.sangmado.gbprotocol.gb19056.protocol.message.content.GB19056MessageBlock;
import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.Getter;
import lombok.Setter;

/**
 * 采集记录仪执行标准版本
 */
@Getter
@Setter
public class GB19056_Command_Message_Block_0x00 extends GB19056MessageBlock<GB19056CommandMessageId> {
    public static final GB19056CommandMessageId MESSAGE_ID = GB19056CommandMessageId.GB19056_Message_Command_0x00;

    @Override
    public GB19056CommandMessageId getMessageId() {
        return MESSAGE_ID;
    }

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static GB19056_Command_Message_Block_0x00 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        GB19056_Command_Message_Block_0x00 content = new GB19056_Command_Message_Block_0x00();
        content.deserialize(ctx, reader);
        return content;
    }
}
