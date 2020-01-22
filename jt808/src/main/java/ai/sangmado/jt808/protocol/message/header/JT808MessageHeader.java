package ai.sangmado.jt808.protocol.message.header;

import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.jt808.protocol.message.IJT808MessageFormatter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * JT808 消息头
 */
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class JT808MessageHeader implements IJT808MessageFormatter {

    /**
     * 消息ID
     */
    private JT808MessageId messageId;

    /**
     * 消息体属性
     */
    private JT808MessageHeaderMessageContentProperty messageContentProperty;

    /**
     * 消息流水号
     * 按发送顺序从0开始循环累加。
     */
    private int serialNumber;

    /**
     * 消息包封装项
     * 如果消息体属性中相关标识位确定消息分包处理，则该项有内容，否则无该项。
     */
    private JT808MessageHeaderMessagePacketProperty messagePacketProperty;
}
