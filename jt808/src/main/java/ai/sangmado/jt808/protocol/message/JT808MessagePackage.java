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
public class JT808MessagePackage implements IJT808MessageFormatter {

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
     * 从消息头开始，同后一字节异或，直到校验码前一个字节，占用一个字节。
     */
    private Byte checksum;

    /**
     * 尾标识
     */
    private Byte endMarker = 0x7e;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

        getHeader().getMessageContentProperty().setContentLength(1);
//
//        // ---------------开始组包--------------
//        // 1.起始符
//        writer.writeByte(getBeginMarker());
//
//
//
//        // 2.写入头部 //部分有带数据体的长度，那么先跳过写入头部部分
//        //  2.1.消息ID
//        writer.writeWord(getHeader().getMessageId().getValue());
//        //  2.2.消息体属性(包含消息体长度所以先跳过)
//        writer.Skip(2, out int msgBodiesPropertyPosition);
//
//
//
//        int headerLength = writer.GetCurrentPosition();
//        // 3.处理数据体部分
//        if (value.Bodies != null)
//        {
//            if (!value.Bodies.SkipSerialization)
//            {
//                JT808MessagePackFormatterResolverExtensions.JT808DynamicSerialize(value.Bodies,
//                        ref writer, value.Bodies,
//                        config);
//            }
//        }
//        //  3.1.处理数据体长度
//        // 2.2.回写消息体属性
//        value.Header.MessageBodyProperty.DataLength = (writer.GetCurrentPosition() - headerLength);
//        writer.WriteUInt16Return(value.Header.MessageBodyProperty.Wrap(), msgBodiesPropertyPosition);
//        // 4.校验码
//        writer.WriteXor();
//        // 5.终止符
//        writer.WriteEnd();
//        // 6.编码
//        writer.WriteEncode();
//        // ---------------组包结束--------------
    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }
}
