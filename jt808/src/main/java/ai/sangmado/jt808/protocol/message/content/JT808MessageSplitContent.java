package ai.sangmado.jt808.protocol.message.content;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.jt808.protocol.message.codec.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.message.codec.IJT808MessageBufferWriter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.nio.ByteBuffer;

/**
 * JT808 已分片消息体
 */
public class JT808MessageSplitContent extends JT808MessageContent {

    private JT808MessageContent originContent;

    @Override
    public JT808MessageId getMessageId() {
        return this.originContent.getMessageId();
    }

    @Getter
    private int totalSplits;

    @Getter
    private int splitIndex;

    @Getter(AccessLevel.PROTECTED)
    private int contentLength;

    @Getter
    @Setter
    private ByteBuffer splitContent;

    public JT808MessageSplitContent(JT808MessageContent originContent, int totalSplits, int splitIndex, int contentLength) {
        this.originContent = originContent;
        this.totalSplits = totalSplits;
        this.splitIndex = splitIndex;
        this.contentLength = contentLength;
    }

    @Override
    public int getContentLength(ISpecificationContext ctx) {
        return contentLength;
    }

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {
        writer.writeBytes(splitContent);
    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        byte[] buffer = reader.readBytes(contentLength);
        setSplitContent(ByteBuffer.wrap(buffer));
    }
}
