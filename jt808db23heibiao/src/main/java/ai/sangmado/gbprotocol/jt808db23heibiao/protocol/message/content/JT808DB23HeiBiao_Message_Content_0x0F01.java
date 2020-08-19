package ai.sangmado.gbprotocol.jt808db23heibiao.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808db23heibiao.protocol.enums.JT808DB23HeiBiaoMessageId;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 设备状态汇总上报日报
 * <p>
 * 设备状态汇总由终端设备根据设备的运行情况按自然日进行汇总，并自动上报。当数据上传未成功时，应进行补传。
 * <p>
 * 上传时机：
 * ——设备状态汇总上报的时机在每天0点之后自动上传前一天的汇总数据（如果ACC 为ON时），如果ACC OFF，当车辆ACC ON时进行上传或补传；
 * ——如果设备自然日内没有运行，则不产生设备状态汇总消息。
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808DB23HeiBiao_Message_Content_0x0F01 extends JT808MessageContent {
    public static final JT808DB23HeiBiaoMessageId MESSAGE_ID = JT808DB23HeiBiaoMessageId.JT808DB23HeiBiao_Message_0x0F01;

    @Override
    public JT808DB23HeiBiaoMessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 状态汇总日期
     */
    private LocalDateTime summaryTime;
    /**
     * 设备状态汇总数据
     * <p>
     * TLV嵌套形式[……] 数据格式为多组TLV数据。
     * 其中：
     * T为状态标识类型，参见下表A.35中的状态标识；
     * L为对状态数据的长度，L的数据类型为UINT8；参见下表4-32中的数据类型；
     * V为对应状态内容
     */
    private String summaryData;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB23HeiBiao_Message_Content_0x0F01 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB23HeiBiao_Message_Content_0x0F01 content = new JT808DB23HeiBiao_Message_Content_0x0F01();
        content.deserialize(ctx, reader);
        return content;
    }
}
