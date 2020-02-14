package ai.sangmado.jt808.protocol.message.content;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.nio.ByteBuffer;

/**
 * JT808 已分片消息体
 */
public class JT808MessageSplitContent<TMessageId extends JT808MessageId, TProtocolVersion>
        extends JT808MessageContent<TMessageId, TProtocolVersion> {

    private JT808MessageContent<TMessageId, TProtocolVersion> originContent;

    @Override
    public TMessageId getMessageId() {
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

    public JT808MessageSplitContent(
            JT808MessageContent<TMessageId, TProtocolVersion> originContent,
            int totalSplits, int splitIndex, int contentLength) {
        this.originContent = originContent;
        this.totalSplits = totalSplits;
        this.splitIndex = splitIndex;
        this.contentLength = contentLength;
    }

    @Override
    public int getContentLength(ISpecificationContext<TProtocolVersion> ctx) {
        return contentLength;
    }

    @Override
    public void serialize(ISpecificationContext<TProtocolVersion> ctx, IJT808MessageBufferWriter writer) {
        writer.writeBytes(splitContent);
    }

    @Override
    public void deserialize(ISpecificationContext<TProtocolVersion> ctx, IJT808MessageBufferReader reader) {
        byte[] buffer = reader.readBytes(contentLength);
        setSplitContent(ByteBuffer.wrap(buffer));
    }
}
