package ai.sangmado.gbprotocol.jt809.protocol.message;

import ai.sangmado.gbprotocol.jt809.protocol.message.content.JT809MessageContent;
import ai.sangmado.gbprotocol.jt809.protocol.message.header.JT809MessageHeader;
import ai.sangmado.gbprotocol.jt809.protocol.ISpecificationContext;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * JT809 消息装配器
 */
public final class JT809MessageAssembler {

    public static List<JT809Message> assemble(
            ISpecificationContext ctx, JT809MessageHeader header, JT809MessageContent content) {

        header.setMessageLength(header.getMessageLengthWithoutContent() + content.getContentLength(ctx));

        JT809Message message = new JT809Message();
        message.setHeader(header);
        message.setContent(content);

        return Lists.newArrayList(message);
    }
}
