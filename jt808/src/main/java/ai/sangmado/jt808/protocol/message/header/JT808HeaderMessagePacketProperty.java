package ai.sangmado.jt808.protocol.message.header;

import lombok.*;

/**
 * JT808 消息头中消息包封装项
 */
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class JT808HeaderMessagePacketProperty {

    /**
     * 消息总包数
     */
    private int totalPackets;

    /**
     * 包序号
     */
    private int sequence;
}
