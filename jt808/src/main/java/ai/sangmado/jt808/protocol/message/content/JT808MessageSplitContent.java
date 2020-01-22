package ai.sangmado.jt808.protocol.message.content;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.jt808.protocol.message.codec.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.message.codec.IJT808MessageBufferWriter;
import lombok.Getter;
import lombok.Setter;

import java.nio.ByteBuffer;

/**
 * JT808 已分片消息体
 */
public class JT808MessageSplitContent extends JT808MessageContent {

    private JT808MessageContent originContent;

    @Getter
    private int splitByLength;

    @Getter
    private int splitIndex;

    public JT808MessageSplitContent(JT808MessageContent originContent, int splitByLength, int splitIndex) {
        this.originContent = originContent;
        this.splitByLength = splitByLength;
        this.splitIndex = splitIndex;
    }

    @Override
    public JT808MessageId getMessageId() {
        return this.originContent.getMessageId();
    }

    @Getter
    @Setter
    private ByteBuffer splitContent;

    @Override
    public int getContentLength(ISpecificationContext ctx) {
        return splitContent.remaining();
    }

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {
        writer.writeBytes(splitContent);
    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        byte[] buffer = reader.readBytes(splitByLength);
        setSplitContent(ByteBuffer.wrap(buffer));
    }
}
