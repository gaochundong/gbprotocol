package ai.sangmado.jt808.protocol.message;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.jt808.protocol.message.header.JT808MessageHeader;

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
            // 此处需要获取到消息体的总长度，然后通过分包长度判断是否满足分包条件，进而进行分包操作
            int contentLength = content.getContentLength(ctx);
            int splitByLength = content.getSplitByLength(ctx);

            // 总消息体长度大于分包长度，则进行分包
            if (contentLength > splitByLength) {
                List<JT808MessageContent> splitContents = content.split(ctx);
                List<JT808MessagePacket> packets = new ArrayList<>(splitContents.size());

                for (int i = 0; i < splitContents.size(); i++) {
                    JT808MessageContent splitContent = splitContents.get(i);

                    // 子包结构
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
        }

        // 不满足以上条件，则不进行分包操作，只有1个包
        header.getMessageContentProperty().setIsMultiplePackets(false);
        header.getMessageContentProperty().setContentLength(content.getContentLength(ctx));
        header.getMessagePacketProperty().setTotalPackets(1);
        header.getMessagePacketProperty().setPacketSequence(1);
        JT808MessagePacket packet = new JT808MessagePacket();
        packet.setHeader(header);
        packet.setContent(content);

        List<JT808MessagePacket> packets = new ArrayList<>(1);
        packets.add(packet);
        return packets;
    }
}
