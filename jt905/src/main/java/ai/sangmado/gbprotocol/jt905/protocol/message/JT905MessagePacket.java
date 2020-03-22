package ai.sangmado.gbprotocol.jt905.protocol.message;

import ai.sangmado.gbprotocol.jt905.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt905.protocol.enums.JT905MessageId;
import ai.sangmado.gbprotocol.jt905.protocol.enums.JT905ProtocolVersion;
import ai.sangmado.gbprotocol.jt905.protocol.message.content.JT905MessageContent;
import ai.sangmado.gbprotocol.jt905.protocol.message.header.JT905MessageHeader;
import ai.sangmado.gbprotocol.jt905.protocol.serialization.IJT905MessageBufferReader;
import ai.sangmado.gbprotocol.jt905.protocol.serialization.IJT905MessageBufferWriter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * JT905 消息包
 */
@Slf4j
@NoArgsConstructor
public class JT905MessagePacket implements IJT905Message {

    /**
     * 头标识
     */
    @Getter
    @Setter
    private byte beginMarker = 0x7e;

    /**
     * 消息头
     */
    @Getter
    @Setter
    private JT905MessageHeader header;

    /**
     * 消息体
     */
    @Getter
    @Setter
    private JT905MessageContent content;

    /**
     * 校验码
     * 从消息头首字节开始，同后一字节进行异或操作，直到消息体末字节结束。校验码占用一个字节。
     */
    @Getter
    @Setter
    private int checksum;

    /**
     * 尾标识
     */
    @Getter
    @Setter
    private byte endMarker = 0x7e;

    /**
     * 获取协议版本
     *
     * @return 协议版本
     */
    @Override
    public JT905ProtocolVersion getProtocolVersion() {
        return this.header.getProtocolVersion();
    }

    /**
     * 获取消息ID
     *
     * @return 消息ID
     */
    @Override
    public JT905MessageId getMessageId() {
        return this.header.getMessageId();
    }

    @Override
    public void serialize(ISpecificationContext ctx, IJT905MessageBufferWriter writer) {
    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT905MessageBufferReader reader) {
    }
}
