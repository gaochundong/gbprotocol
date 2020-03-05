package ai.sangmado.gbprotocol.jt808.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808OperationException;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItem;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItemId;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItemRegistration;
import lombok.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 平台设置终端参数
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808_Message_Content_0x8103 extends JT808MessageContent {
    public static final JT808MessageId MESSAGE_ID = JT808MessageId.JT808_Message_0x8103;

    @Override
    public JT808MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 参数项的个数
     */
    private Integer itemCount;
    /**
     * 参数项列表
     */
    private List<JT808_Message_Content_0x8103_ParameterItem> itemList;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {
        if (getItemList() == null || getItemList().size() == 0) {
            throw new UnsupportedJT808OperationException("参数项列表为空");
        }
        setItemCount(getItemList().size());

        writer.writeByte(itemCount);

        // 针对参数项列表排序后再写入
        for (JT808_Message_Content_0x8103_ParameterItem pi :
                getItemList().stream()
                        .sorted(Comparator.comparing(JT808_Message_Content_0x8103_ParameterItem::getParameterItemId))
                        .collect(Collectors.toList())) {
            pi.serialize(ctx, writer);
        }
    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        setItemCount(reader.readByte() & 0xFF);

        // 通过读取参数项ID进行判断
        setItemList(new ArrayList<>());
        while (reader.readableBytes() > 0) {
            reader.markIndex();
            long piId = reader.readDWord();
            reader.resetIndex();

            JT808_Message_Content_0x8103_ParameterItemId parameterItemId = JT808_Message_Content_0x8103_ParameterItemId.cast(piId);
            if (!JT808_Message_Content_0x8103_ParameterItemRegistration.getDecoders().containsKey(parameterItemId)) {
                throw new UnsupportedJT808OperationException("暂不支持该参数项ID:" + parameterItemId);
            }
            JT808_Message_Content_0x8103_ParameterItem pi =
                    JT808_Message_Content_0x8103_ParameterItemRegistration.getDecoders()
                            .get(parameterItemId).apply(ctx, reader);
            getItemList().add(pi);
        }
    }

    public static JT808_Message_Content_0x8103 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x8103 content = new JT808_Message_Content_0x8103();
        content.deserialize(ctx, reader);
        return content;
    }
}
