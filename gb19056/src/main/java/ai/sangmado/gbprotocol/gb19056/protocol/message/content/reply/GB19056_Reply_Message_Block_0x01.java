package ai.sangmado.gbprotocol.gb19056.protocol.message.content.reply;

import ai.sangmado.gbprotocol.gb19056.protocol.enums.GB19056ReplyMessageId;
import ai.sangmado.gbprotocol.gb19056.protocol.message.content.GB19056MessageBlock;
import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.Getter;
import lombok.Setter;

/**
 * 采集当前驾驶人信息
 */
@Getter
@Setter
public class GB19056_Reply_Message_Block_0x01 extends GB19056MessageBlock<GB19056ReplyMessageId> {
    public static final GB19056ReplyMessageId MESSAGE_ID = GB19056ReplyMessageId.GB19056_Message_Reply_0x01;

    @Override
    public GB19056ReplyMessageId getMessageId() {
        return MESSAGE_ID;
    }

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static GB19056_Reply_Message_Block_0x01 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        GB19056_Reply_Message_Block_0x01 content = new GB19056_Reply_Message_Block_0x01();
        content.deserialize(ctx, reader);
        return content;
    }
}
