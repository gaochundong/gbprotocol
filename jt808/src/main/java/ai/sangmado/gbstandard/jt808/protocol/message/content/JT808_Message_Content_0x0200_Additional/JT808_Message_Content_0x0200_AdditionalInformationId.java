package ai.sangmado.gbstandard.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional;

import ai.sangmado.gbstandard.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbstandard.jt808.protocol.enums.JT808ProtocolVersion;
import ai.sangmado.gbstandard.jt808.protocol.exceptions.UnsupportedJT808MessageException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JT/T 808 位置附加信息ID
 */
@Getter
@Setter
public class JT808_Message_Content_0x0200_AdditionalInformationId implements Comparable<JT808_Message_Content_0x0200_AdditionalInformationId> {
    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x01 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x01", 0x01, JT808ProtocolVersion.V2011, "里程");
    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x02 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x02", 0x02, JT808ProtocolVersion.V2011, "油量");
    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x03 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x03", 0x03, JT808ProtocolVersion.V2011, "行驶记录功能获取的速度");
    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x04 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x04", 0x04, JT808ProtocolVersion.V2013, "需要人工确认报警事件的ID");
    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x05 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x05", 0x05, JT808ProtocolVersion.V2019, "胎压");
    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x06 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x06", 0x06, JT808ProtocolVersion.V2019, "车厢温度");

    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x11 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x11", 0x11, JT808ProtocolVersion.V2011, "超速报警附加信息");
    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x12 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x12", 0x12, JT808ProtocolVersion.V2011, "进出区域/路线报警附加信息");
    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x13 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x13", 0x13, JT808ProtocolVersion.V2011, "路段行驶时间不足/过长报警附加信息");

    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x25 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x25", 0x25, JT808ProtocolVersion.V2013, "扩展车辆信号状态位");
    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x2A = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x2A", 0x2A, JT808ProtocolVersion.V2013, "IO状态位");
    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x2B = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x2B", 0x2B, JT808ProtocolVersion.V2013, "模拟量");

    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x30 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x30", 0x30, JT808ProtocolVersion.V2013, "无线通信网络信号强度");
    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0x31 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0x31", 0x31, JT808ProtocolVersion.V2013, "GNSS定位卫星数");

    public static final JT808_Message_Content_0x0200_AdditionalInformationId JT808_0x0200_0xE0 = new JT808_Message_Content_0x0200_AdditionalInformationId("JT808_0x0200_0xE0", 0xE0, JT808ProtocolVersion.V2013, "后续自定义信息长度");

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
    private IProtocolVersion since;
    /**
     * 附件信息ID描述
     */
    private String description;

    public JT808_Message_Content_0x0200_AdditionalInformationId(String name, int value, IProtocolVersion since, String description) {
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

    @Override
    public int compareTo(JT808_Message_Content_0x0200_AdditionalInformationId o) {
        return this.getValue().compareTo(o.getValue());
    }

    private static final Map<Integer, JT808_Message_Content_0x0200_AdditionalInformationId> mapping = new HashMap<>();
    private static final Map<Integer, JT808_Message_Content_0x0200_AdditionalInformationId> extensions = new HashMap<>();

    static {
        mapping.put(JT808_0x0200_0x01.getValue(), JT808_0x0200_0x01);
        mapping.put(JT808_0x0200_0x02.getValue(), JT808_0x0200_0x02);
        mapping.put(JT808_0x0200_0x03.getValue(), JT808_0x0200_0x03);
        mapping.put(JT808_0x0200_0x04.getValue(), JT808_0x0200_0x04);
        mapping.put(JT808_0x0200_0x05.getValue(), JT808_0x0200_0x05);
        mapping.put(JT808_0x0200_0x06.getValue(), JT808_0x0200_0x06);

        mapping.put(JT808_0x0200_0x11.getValue(), JT808_0x0200_0x11);
        mapping.put(JT808_0x0200_0x12.getValue(), JT808_0x0200_0x12);
        mapping.put(JT808_0x0200_0x13.getValue(), JT808_0x0200_0x13);

        mapping.put(JT808_0x0200_0x25.getValue(), JT808_0x0200_0x25);
        mapping.put(JT808_0x0200_0x2A.getValue(), JT808_0x0200_0x2A);
        mapping.put(JT808_0x0200_0x2B.getValue(), JT808_0x0200_0x2B);

        mapping.put(JT808_0x0200_0x30.getValue(), JT808_0x0200_0x30);
        mapping.put(JT808_0x0200_0x31.getValue(), JT808_0x0200_0x31);

        mapping.put(JT808_0x0200_0xE0.getValue(), JT808_0x0200_0xE0);
    }

    public static JT808_Message_Content_0x0200_AdditionalInformationId cast(int value) {
        JT808_Message_Content_0x0200_AdditionalInformationId item = tryCast(value);
        if (item == null) {
            throw new UnsupportedJT808MessageException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808_Message_Content_0x0200_AdditionalInformationId.class.getSimpleName()));
        }
        return item;
    }

    public static JT808_Message_Content_0x0200_AdditionalInformationId tryCast(int value) {
        JT808_Message_Content_0x0200_AdditionalInformationId item = mapping.get(value);
        if (item == null) {
            item = extensions.get(value);
        }
        return item;
    }

    public static boolean exists(int value) {
        return tryCast(value) != null;
    }

    public static List<JT808_Message_Content_0x0200_AdditionalInformationId> list() {
        List<JT808_Message_Content_0x0200_AdditionalInformationId> l = new ArrayList<>(mapping.values());
        l.addAll(extensions.values());
        return l;
    }

    public static void putExtensions(List<JT808_Message_Content_0x0200_AdditionalInformationId> additionalInformationIdList) {
        additionalInformationIdList.forEach(i -> extensions.put(i.getValue(), i));
    }
}
