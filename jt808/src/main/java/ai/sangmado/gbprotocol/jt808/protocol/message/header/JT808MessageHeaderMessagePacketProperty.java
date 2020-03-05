package ai.sangmado.gbprotocol.jt808.protocol.message.header;

import lombok.*;

/**
 * JT808 消息头中消息包封装项
 */
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@Builder
public class JT808MessageHeaderMessagePacketProperty implements Cloneable {

    /**
     * 消息总包数
     */
    private Integer totalPackets;

    /**
     * 包序号
     */
    private Integer packetSequence;

    /**
     * 克隆对象
     *
     * @return 克隆对象
     */
    @Override
    public JT808MessageHeaderMessagePacketProperty clone() throws CloneNotSupportedException {
        return (JT808MessageHeaderMessagePacketProperty) super.clone();
    }
}
