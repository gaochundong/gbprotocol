package ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional;

import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageFormatter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 终端位置信息汇报 - 位置附加信息
 * <p>
 * 􏰢􏰣格式：附加信息ID+附加信息长度+附加信息
 */
@NoArgsConstructor
public abstract class JT808_Message_Content_0x0200_AdditionalInformation implements IJT808MessageFormatter {

    /**
     * 获取位置附加信息ID
     *
     * @return 位置附加信息ID
     */
    public abstract JT808_Message_Content_0x0200_AdditionalInformationId getAdditionalInformationId();

    /**
     * 附件信息长度
     */
    @Getter
    @Setter
    private Integer additionalInformationLength;
}
