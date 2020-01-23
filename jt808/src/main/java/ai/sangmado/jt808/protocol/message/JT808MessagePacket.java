package ai.sangmado.jt808.protocol.message;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.message.codec.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.message.codec.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.jt808.protocol.message.header.JT808MessageHeader;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * JT808 消息包
 */
@Getter
@Setter
@NoArgsConstructor
public class JT808MessagePacket implements IJT808MessageFormatter {

    /**
     * 头标识
     */
    private Byte beginMarker = 0x7e;

    /**
     * 消息头
     */
    private JT808MessageHeader header;

    /**
     * 消息体
     */
    private JT808MessageContent content;

    /**
     * 校验码
     * 从消息头首字节开始，同后一字节进行异或操作，直到消息体末字节结束。校验码占用一个字节。
     */
    private Byte checksum;

    /**
     * 尾标识
     */
    private Byte endMarker = 0x7e;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }
}
