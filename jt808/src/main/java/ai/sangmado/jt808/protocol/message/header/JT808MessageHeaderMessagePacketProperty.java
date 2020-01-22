package ai.sangmado.jt808.protocol.message.header;

import lombok.*;

/**
 * JT808 消息头中消息包封装项
 */
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@Builder
public class JT808MessageHeaderMessagePacketProperty {

    /**
     * 消息总包数
     */
    private Integer totalPackets;

    /**
     * 包序号
     */
    private Integer packetSequence;
}
