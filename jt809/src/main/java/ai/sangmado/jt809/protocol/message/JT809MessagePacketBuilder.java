package ai.sangmado.jt809.protocol.message;

import ai.sangmado.jt809.protocol.ISpecificationContext;
import ai.sangmado.jt809.protocol.message.content.JT809MessageContent;
import ai.sangmado.jt809.protocol.message.header.JT809MessageHeader;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * JT809 消息包构造器
 */
public final class JT809MessagePacketBuilder {

    public static List<JT809MessagePacket> buildPackets(
            ISpecificationContext ctx, JT809MessageHeader header, JT809MessageContent content) {
        JT809MessagePacket packet = new JT809MessagePacket();
        packet.setHeader(header);
        packet.setContent(content);
        return Lists.newArrayList(packet);
    }
}
