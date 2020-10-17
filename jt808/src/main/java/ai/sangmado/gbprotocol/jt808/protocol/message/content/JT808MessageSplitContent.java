package ai.sangmado.gbprotocol.jt808.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
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

    public JT808MessageSplitContent(
            JT808MessageContent originContent,
            int totalSplits, int splitIndex, int contentLength) {
        this.originContent = originContent;
        this.totalSplits = totalSplits;
        this.splitIndex = splitIndex;
        this.contentLength = contentLength;
    }

    @Override
    public int getContentLength(IVersionedSpecificationContext ctx) {
        return contentLength;
    }

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {
        writer.writeBytes(splitContent);
    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        byte[] buffer = reader.readBytes(contentLength);
        setSplitContent(ByteBuffer.wrap(buffer));
    }
}
