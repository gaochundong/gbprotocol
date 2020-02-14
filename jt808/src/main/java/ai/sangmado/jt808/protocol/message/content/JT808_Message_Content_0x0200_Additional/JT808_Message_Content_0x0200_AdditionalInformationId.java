package ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional;

import lombok.Getter;
import lombok.Setter;

import static ai.sangmado.jt808.protocol.enums.JT808ProtocolVersion.*;

/**
 * JT/T 808 位置附加信息ID
 */
@Getter
@Setter
public class JT808_Message_Content_0x0200_AdditionalInformationId {
    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x01 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x01", 0x01, V2011, "里程");
    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x02 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x02", 0x02, V2011, "油量");
    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x03 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x03", 0x03, V2011, "行驶记录功能获取的速度");
    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x04 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x04", 0x04, V2013, "需要人工确认报警事件的ID");
    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x05 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x05", 0x05, V2019, "胎压");
    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x06 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x06", 0x06, V2019, "车厢温度");

    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x11 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x11", 0x11, V2011, "超速报警附加信息");
    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x12 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x12", 0x12, V2011, "进出区域/路线报警附加信息");
    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x13 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x13", 0x13, V2011, "路段行驶时间不足/过长报警附加信息");

    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x25 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x25", 0x25, V2013, "扩展车辆信号状态位");
    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x2A = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x2A", 0x2A, V2013, "IO状态位");
    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x2B = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x2B", 0x2B, V2013, "模拟量");

    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x30 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x30", 0x30, V2013, "无线通信网络信号强度");
    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x31 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x31", 0x31, V2013, "GNSS定位卫星数");

    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0xE0 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0xE0", 0xE0, V2013, "后续自定义信息长度");

    /**
     * 附件信息ID名称
     */
    private String name;
    /**
     * 附件信息ID值
     */
    private Integer value;
    /**
     * 附件信息ID来自版本
     */
    private Object since;
    /**
     * 附件信息ID描述
     */
    private String description;

    public JT808_Message_Content_0x0200_AdditionalInformationId(String name, int value, Object since, String description) {
        this.name = name;
        this.value = value;
        this.since = since;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof JT808_Message_Content_0x0200_AdditionalInformationId)) {
            return false;
        }
        return ((JT808_Message_Content_0x0200_AdditionalInformationId) obj).getValue().equals(this.getValue());
    }
}
