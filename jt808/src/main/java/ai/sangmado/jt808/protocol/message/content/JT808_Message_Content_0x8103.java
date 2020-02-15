package ai.sangmado.jt808.protocol.message.content;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.enums.IProtocolVersion;
import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItem;
import lombok.*;

import java.util.List;

/**
 * 平台设置终端参数
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808_Message_Content_0x8103<TProtocolVersion extends IProtocolVersion> extends JT808MessageContent<JT808MessageId, TProtocolVersion> {

    @Override
    public JT808MessageId getMessageId() {
        return JT808MessageId.JT808_Message_0x8103;
    }

    /**
     * 参数项的个数
     */
    private Integer itemCount;
    /**
     * 参数项列表
     */
    private List<JT808_Message_Content_0x8103_ParameterItem<TProtocolVersion>> itemList;

    @Override
    public void serialize(ISpecificationContext<TProtocolVersion> ctx, IJT808MessageBufferWriter writer) {
    }

    @Override
    public void deserialize(ISpecificationContext<TProtocolVersion> ctx, IJT808MessageBufferReader reader) {
    }
}
