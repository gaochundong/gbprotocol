package ai.sangmado.gbprotocol.jt808.protocol.message;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.message.header.JT808MessageHeader;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * JT808 消息装配器
 */
public final class JT808MessageAssembler {

    public static List<JT808Message> assemble(
            IVersionedSpecificationContext ctx, JT808MessageHeader header, JT808MessageContent content) {

        // 如果配置了可以按照条件进行分包，则进行分包判断
        if (content.couldSplitAccordingly(ctx)) {
            return split(ctx, header, content);
        }

        // 不满足以上条件，则不进行分包操作，只有1个包
        return single(ctx, header, content);
    }

    private static List<JT808Message> split(
            IVersionedSpecificationContext ctx, JT808MessageHeader header, JT808MessageContent content) {

        List<JT808MessageContent> splitContents = content.split(ctx);

        // 如果分完包还是只有1个包，则当做单包处理
        if (splitContents.size() == 1) {
            return single(ctx, header, content);
        }

        List<JT808Message> messages = new ArrayList<>(splitContents.size());

        for (int i = 0; i < splitContents.size(); i++) {
            JT808MessageContent childContent = splitContents.get(i);

            // 子包结构复制
            JT808MessageHeader childHeader = header.clone();
            childHeader.getMessageContentProperty().setIsMultiplePackets(true);
            childHeader.getMessageContentProperty().setContentLength(childContent.getContentLength(ctx));
            childHeader.getMessagePacketProperty().setTotalPackets(splitContents.size());
            childHeader.getMessagePacketProperty().setPacketSequence(i + 1);

            JT808Message child = new JT808Message();
            child.setHeader(childHeader);
            child.setContent(childContent);

            messages.add(child);
        }

        return messages;
    }

    private static List<JT808Message> single(
            IVersionedSpecificationContext ctx, JT808MessageHeader header, JT808MessageContent content) {

        header.getMessageContentProperty().setIsMultiplePackets(false);
        header.getMessageContentProperty().setContentLength(content.getContentLength(ctx));
        header.getMessagePacketProperty().setTotalPackets(1);
        header.getMessagePacketProperty().setPacketSequence(1);

        JT808Message message = new JT808Message();
        message.setHeader(header);
        message.setContent(content);

        return Lists.newArrayList(message);
    }
}
