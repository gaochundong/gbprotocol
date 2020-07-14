package ai.sangmado.gbprotocol.jt808.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808OperationException;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItemId;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItemRegistration;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 平台查询指定终端参数
 * <p>
 * 查询指定终端参数消息体数据格式见表15，终端采用0x0104指令应答。
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808_Message_Content_0x8106 extends JT808MessageContent {
    public static final JT808MessageId MESSAGE_ID = JT808MessageId.JT808_Message_0x8106;

    @Override
    public JT808MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 参数总数
     */
    private Integer itemCount;
    /**
     * 参数ID列表
     */
    private List<JT808_Message_Content_0x8103_ParameterItemId> itemList;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {
        if (getItemList() == null || getItemList().size() == 0) {
            throw new UnsupportedJT808OperationException("参数列表为空");
        }
        setItemCount(getItemList().size());

        writer.writeByte(itemCount);

        // 针对参数ID列表排序后再写入
        for (JT808_Message_Content_0x8103_ParameterItemId pi :
                getItemList().stream()
                        .sorted(Comparator.comparing(JT808_Message_Content_0x8103_ParameterItemId::getValue))
                        .collect(Collectors.toList())) {
            writer.writeDWord(pi.getValue());
        }
    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        setItemCount(reader.readByte() & 0xFF);

        // 按数量读取参数ID
        setItemList(new ArrayList<>(getItemCount()));
        for (int i = 0; i < getItemCount(); i++) {
            long piId = reader.readDWord();
            JT808_Message_Content_0x8103_ParameterItemId parameterItemId = JT808_Message_Content_0x8103_ParameterItemId.cast(piId);
            if (!JT808_Message_Content_0x8103_ParameterItemRegistration.getDecoders().containsKey(parameterItemId)) {
                throw new UnsupportedJT808OperationException("暂不支持该参数项ID:" + parameterItemId);
            }
            getItemList().add(parameterItemId);
        }
    }

    public static JT808_Message_Content_0x8106 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x8106 content = new JT808_Message_Content_0x8106();
        content.deserialize(ctx, reader);
        return content;
    }
}
