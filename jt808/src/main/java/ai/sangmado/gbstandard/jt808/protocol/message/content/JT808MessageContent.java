package ai.sangmado.gbstandard.jt808.protocol.message.content;

import ai.sangmado.gbstandard.gbcommon.memory.PooledByteArray;
import ai.sangmado.gbstandard.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.gbstandard.jt808.protocol.encoding.IJT808MessageFormatter;
import ai.sangmado.gbstandard.jt808.protocol.encoding.impl.JT808MessageByteBufferWriter;
import ai.sangmado.gbstandard.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbstandard.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbstandard.jt808.protocol.exceptions.UnsupportedJT808OperationException;
import com.google.common.collect.Lists;

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
     * 获取消息体长度
     *
     * @param ctx 协议规范上下文
     * @return 消息体长度
     */
    public int getContentLength(ISpecificationContext ctx) {
        PooledByteArray pba = ctx.getByteArrayPool().borrow();
        try {
            ByteBuffer buf = ByteBuffer.wrap(pba.array());
            IJT808MessageBufferWriter bufWriter = new JT808MessageByteBufferWriter(ctx, buf);
            this.serialize(ctx, bufWriter);
            buf.flip();
            return buf.remaining();
        } finally {
            ctx.getByteArrayPool().recycle(pba);
        }
    }

    /**
     * 是否能够按条件进行分包
     *
     * @param ctx 协议规范上下文
     * @return 是否能够按条件进行分包
     */
    public boolean couldSplitAccordingly(ISpecificationContext ctx) {
        return false;
    }

    /**
     * 获取分包长度
     *
     * @param ctx 协议规范上下文
     * @return 分包长度
     */
    public int getSplitByLength(ISpecificationContext ctx) {
        throw new UnsupportedJT808OperationException("未设置分包长度");
    }

    /**
     * 分包函数
     *
     * @param ctx 协议规范上下文
     * @return 分包列表
     */
    public List<JT808MessageContent> split(ISpecificationContext ctx) {
        // 是否配置允许分包
        if (!couldSplitAccordingly(ctx)) {
            throw new UnsupportedJT808OperationException("不适当的分包函数调用");
        }

        // 获取消息体长度
        int contentLength = getContentLength(ctx);
        // 获取分包长度
        int splitByLength = getSplitByLength(ctx);
        // 消息体长度大于分包长度，则进行分包，否则还是单包
        if (contentLength <= splitByLength) {
            return Lists.newArrayList(this);
        }

        // 分包时需要使用临时数组，此处的缺点是不能从池化数组中借用
        byte[] bufArray = new byte[contentLength];
        int splitCount = (contentLength / splitByLength) + (contentLength % splitByLength > 0 ? 1 : 0);
        List<JT808MessageContent> splitContents = new ArrayList<>(splitCount);
        for (int i = 0; i < splitCount; i++) {
            int splitContentLength = (i < splitCount - 1) ? splitByLength : (contentLength % splitByLength);
            JT808MessageSplitContent child =
                    new JT808MessageSplitContent(this, splitCount, i, splitContentLength);
            child.setSplitContent(ByteBuffer.wrap(bufArray, (i * splitByLength), splitContentLength));
            splitContents.add(child);
        }
        return splitContents;
    }
}
