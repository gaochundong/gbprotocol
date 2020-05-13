package ai.sangmado.gbprotocol.gb19056.protocol.message.content;

import ai.sangmado.gbprotocol.gbcommon.enums.IMessageId;
import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageFormatter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * GB19056 消息包
 */
@Slf4j
@NoArgsConstructor
public class GB19056MessagePacket<T extends IMessageId> implements IJT808MessageFormatter {

    /**
     * 头标识
     */
    @Getter
    @Setter
    private int beginMarker = 0x557A;
    /**
     * 命令字
     */
    @Getter
    @Setter
    private T messageId;
    /**
     * 保留字段
     */
    @Getter
    @Setter
    private int reservedField = 0x00;
    /**
     * 数据块长度
     */
    @Getter
    @Setter
    private int blockLength;
    /**
     * 数据块
     */
    @Getter
    @Setter
    private GB19056MessageBlock<T> block;
    /**
     * 校验码
     */
    @Getter
    @Setter
    private int checksum;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }
}
