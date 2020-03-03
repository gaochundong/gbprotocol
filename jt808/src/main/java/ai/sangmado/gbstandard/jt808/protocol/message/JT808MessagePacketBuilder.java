package ai.sangmado.gbstandard.jt808.protocol.message;

import ai.sangmado.gbstandard.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbstandard.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbstandard.jt808.protocol.message.header.JT808MessageHeader;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * JT808 消息包构造器
 */
public final class JT808MessagePacketBuilder {

    public static List<JT808MessagePacket> buildPackets(
            ISpecificationContext ctx, JT808MessageHeader header, JT808MessageContent content) {

        // 如果配置了可以按照条件进行分包，则进行分包判断
        if (content.couldSplitAccordingly(ctx)) {
            return buildSplitPackets(ctx, header, content);
        }

        // 不满足以上条件，则不进行分包操作，只有1个包
        return buildSinglePacket(ctx, header, content);
    }

    private static List<JT808MessagePacket> buildSplitPackets(
            ISpecificationContext ctx, JT808MessageHeader header, JT808MessageContent content) {

        List<JT808MessageContent> splitContents = content.split(ctx);

        // 如果分完包还是只有1个包，则当做单包处理
        if (splitContents.size() == 1) {
            return buildSinglePacket(ctx, header, content);
        }

        List<JT808MessagePacket> packets = new ArrayList<>(splitContents.size());

        for (int i = 0; i < splitContents.size(); i++) {
            JT808MessageContent splitContent = splitContents.get(i);

            // 子包结构复制
            JT808MessageHeader childHeader = header.clone();
            childHeader.getMessageContentProperty().setIsMultiplePackets(true);
            childHeader.getMessageContentProperty().setContentLength(splitContent.getContentLength(ctx));
            childHeader.getMessagePacketProperty().setTotalPackets(splitContents.size());
            childHeader.getMessagePacketProperty().setPacketSequence(i + 1);
            JT808MessagePacket childPacket = new JT808MessagePacket();
            childPacket.setHeader(childHeader);
            childPacket.setContent(splitContent);

            packets.add(childPacket);
        }

        return packets;
    }

    private static List<JT808MessagePacket> buildSinglePacket(
            ISpecificationContext ctx, JT808MessageHeader header, JT808MessageContent content) {

        header.getMessageContentProperty().setIsMultiplePackets(false);
        header.getMessageContentProperty().setContentLength(content.getContentLength(ctx));
        header.getMessagePacketProperty().setTotalPackets(1);
        header.getMessagePacketProperty().setPacketSequence(1);
        JT808MessagePacket packet = new JT808MessagePacket();
        packet.setHeader(header);
        packet.setContent(content);

        return Lists.newArrayList(packet);
    }
}
