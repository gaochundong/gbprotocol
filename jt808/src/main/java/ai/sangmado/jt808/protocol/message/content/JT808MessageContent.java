package ai.sangmado.jt808.protocol.message.content;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.jt808.protocol.exceptions.UnsupportedJT808OperationException;
import ai.sangmado.jt808.protocol.message.IJT808MessageFormatter;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * JT808 消息体
 */
public abstract class JT808MessageContent implements IJT808MessageFormatter {

    /**
     * 获取消息体定义的消息ID
     *
     * @return 消息ID
     */
    public abstract JT808MessageId getMessageId();

    /**
     * 是否能够按条件进行分包
     *
     * @return 是否能够按条件进行分包
     */
    public boolean canSplitAccordingly() {
        return false;
    }

    /**
     * 获取分包长度
     *
     * @return 分包长度
     */
    public int getSplitByLength() {
        throw new UnsupportedJT808OperationException("未设置分包长度");
    }

    /**
     * 按照条件进行分包
     *
     * @param ctx 协议规范上下文
     * @return 分包列表
     */
    public List<JT808MessageContent> split(ISpecificationContext ctx) {
//        IJT808MessageBufferWriter writer = null;
//        this.serialize(ctx, writer);
//        writer.Flush();
        byte[] buffer = new byte[10];

        int splitCount = (buffer.length / getSplitByLength()) + (buffer.length % getSplitByLength() > 0 ? 1 : 0);
        List<JT808MessageContent> splitContents = new ArrayList<>(splitCount);
        for (int i = 0; i < splitCount; i++) {
            JT808MessageSplitContent child = new JT808MessageSplitContent(this, getSplitByLength(), i);
            child.setSplitContent(
                    ByteBuffer.wrap(
                            buffer,
                            (i * getSplitByLength()),
                            (i < splitCount - 1) ? getSplitByLength() : (buffer.length % getSplitByLength())));
            splitContents.add(child);
        }
        return splitContents;
    }
}
