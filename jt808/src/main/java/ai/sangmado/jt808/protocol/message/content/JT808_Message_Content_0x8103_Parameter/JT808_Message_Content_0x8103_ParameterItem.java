package ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter;

import ai.sangmado.jt808.protocol.encoding.IJT808MessageFormatter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 终端􏰉􏱀􏰏􏰙􏱁平台设置终端参数 - 参数项
 */
@NoArgsConstructor
public abstract class JT808_Message_Content_0x8103_ParameterItem implements IJT808MessageFormatter {

    /**
     * 获取参数项ID
     *
     * @return 参数项ID
     */
    public abstract JT808_Message_Content_0x8103_ParameterItemId getParameterItemId();

    /**
     * 参数项长度
     */
    @Getter
    @Setter
    private Integer parameterItemLength;
}
