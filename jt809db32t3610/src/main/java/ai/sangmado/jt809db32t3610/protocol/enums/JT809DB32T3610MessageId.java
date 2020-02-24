package ai.sangmado.jt809db32t3610.protocol.enums;

import ai.sangmado.gbcommon.enums.IProtocolVersion;
import ai.sangmado.jt809.protocol.enums.JT809MessageId;
import ai.sangmado.jt809db32t3610.protocol.exceptions.UnsupportedJT809DB32T3610MessageException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DB32/T3610 消息ID
 */
@Getter
@Setter
public class JT809DB32T3610MessageId extends JT809MessageId {
    public static final JT809DB32T3610MessageId JT809DB32T3610_Message_0x1240 = new JT809DB32T3610MessageId("JT809DB32T3610_Message_0x1240", 0x1240, JT809DB32T3610ProtocolVersion.V2019, "UP_EXG_MSG_SAFETY_TERMINAL", "车辆动态信息交换业务类", "主链路", "主动上传车辆主动安全智能防控终端安装信息消息");
    public static final JT809DB32T3610MessageId JT809DB32T3610_Message_0x1301 = new JT809DB32T3610MessageId("JT809DB32T3610_Message_0x1301", 0x1301, JT809DB32T3610ProtocolVersion.V2019, "UP_PLATFORM_MSG_POST_QUERY_ACK", "从链路平台间信息交互消息", "主链路", "平台查岗应答消息");
    public static final JT809DB32T3610MessageId JT809DB32T3610_Message_0x1402 = new JT809DB32T3610MessageId("JT809DB32T3610_Message_0x1402", 0x1402, JT809DB32T3610ProtocolVersion.V2019, "UP_WARN_MSG_INFO", "车辆报警信息交互业务类", "主链路", "主动上报报警信息消息");
    public static final JT809DB32T3610MessageId JT809DB32T3610_Message_0x1403 = new JT809DB32T3610MessageId("JT809DB32T3610_Message_0x1403", 0x1403, JT809DB32T3610ProtocolVersion.V2019, "UP_WARN_MSG_OPERATION_INFO", "车辆报警信息交互业务类", "主链路", "主动上报报警处理消息");
    public static final JT809DB32T3610MessageId JT809DB32T3610_Message_0x1404 = new JT809DB32T3610MessageId("JT809DB32T3610_Message_0x1404", 0x1404, JT809DB32T3610ProtocolVersion.V2019, "UP_WARN_MSG_FILELIST_ACK", "车辆报警信息交互业务类", "主链路", "主动安全报警附件目录请求应答");
    public static final JT809DB32T3610MessageId JT809DB32T3610_Message_0x1405 = new JT809DB32T3610MessageId("JT809DB32T3610_Message_0x1405", 0x1405, JT809DB32T3610ProtocolVersion.V2019, "UP_WARN_MSG_CHECK_ACK", "车辆报警信息核查业务类", "主链路", "报警信息核查请求应答");
    public static final JT809DB32T3610MessageId JT809DB32T3610_Message_0x1406 = new JT809DB32T3610MessageId("JT809DB32T3610_Message_0x1406", 0x1406, JT809DB32T3610ProtocolVersion.V2019, "UP_WARN_MSG_STATICS_ACK", "车辆报警信息核查业务类", "主链路", "报警统计核查请求应答");

    public static final JT809DB32T3610MessageId JT809DB32T3610_Message_0x9301 = new JT809DB32T3610MessageId("JT809DB32T3610_Message_0x9301", 0x9301, JT809DB32T3610ProtocolVersion.V2019, "DOWN_PLATFORM_MSG_POST_QUERY_REQ", "从链路平台间信息交互消息", "从链路", "平台查岗请求消息");
    public static final JT809DB32T3610MessageId JT809DB32T3610_Message_0x9302 = new JT809DB32T3610MessageId("JT809DB32T3610_Message_0x9302", 0x9302, JT809DB32T3610ProtocolVersion.V2019, "DOWN_PLATFORM_MSG_INFO_REQ", "从链路平台间信息交互消息", "从链路", "下发平台间报文请求消息");
    public static final JT809DB32T3610MessageId JT809DB32T3610_Message_0x9404 = new JT809DB32T3610MessageId("JT809DB32T3610_Message_0x9404", 0x9404, JT809DB32T3610ProtocolVersion.V2019, "DOWN_WARN_MSG_FILELIST_REQ", "车辆报警信息交互业务类", "从链路", "主动安全报警附件目录请求消息");
    public static final JT809DB32T3610MessageId JT809DB32T3610_Message_0x9405 = new JT809DB32T3610MessageId("JT809DB32T3610_Message_0x9405", 0x9405, JT809DB32T3610ProtocolVersion.V2019, "DOWN_WARN_MSG_CHECK_REQ", "车辆报警信息核查业务类", "从链路", "报警信息核查请求消息");
    public static final JT809DB32T3610MessageId JT809DB32T3610_Message_0x9406 = new JT809DB32T3610MessageId("JT809DB32T3610_Message_0x9406", 0x9406, JT809DB32T3610ProtocolVersion.V2019, "DOWN_WARN_MSG_STATICS_REQ", "车辆报警信息核查业务类", "从链路", "报警统计核查请求消息");

    public JT809DB32T3610MessageId(String name, int value, IProtocolVersion since, String type, String category, String link, String description) {
        super(name, value, since, type, category, link, description);
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
        if (!(obj instanceof JT809DB32T3610MessageId)) {
            return false;
        }
        return this.getValue().equals(((JT809DB32T3610MessageId) obj).getValue());
    }

    private static final Map<Integer, JT809DB32T3610MessageId> mapping = new HashMap<>();

    static {
        mapping.put(JT809DB32T3610_Message_0x1240.getValue(), JT809DB32T3610_Message_0x1240);
        mapping.put(JT809DB32T3610_Message_0x1301.getValue(), JT809DB32T3610_Message_0x1301);
        mapping.put(JT809DB32T3610_Message_0x1402.getValue(), JT809DB32T3610_Message_0x1402);
        mapping.put(JT809DB32T3610_Message_0x1403.getValue(), JT809DB32T3610_Message_0x1403);
        mapping.put(JT809DB32T3610_Message_0x1404.getValue(), JT809DB32T3610_Message_0x1404);
        mapping.put(JT809DB32T3610_Message_0x1405.getValue(), JT809DB32T3610_Message_0x1405);
        mapping.put(JT809DB32T3610_Message_0x1406.getValue(), JT809DB32T3610_Message_0x1406);

        mapping.put(JT809DB32T3610_Message_0x9301.getValue(), JT809DB32T3610_Message_0x9301);
        mapping.put(JT809DB32T3610_Message_0x9302.getValue(), JT809DB32T3610_Message_0x9302);
        mapping.put(JT809DB32T3610_Message_0x9404.getValue(), JT809DB32T3610_Message_0x9404);
        mapping.put(JT809DB32T3610_Message_0x9405.getValue(), JT809DB32T3610_Message_0x9405);
        mapping.put(JT809DB32T3610_Message_0x9406.getValue(), JT809DB32T3610_Message_0x9406);
    }

    public static JT809DB32T3610MessageId cast(int value) {
        JT809DB32T3610MessageId item = tryCast(value);
        if (item == null) {
            throw new UnsupportedJT809DB32T3610MessageException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT809DB32T3610MessageId.class.getSimpleName()));
        }
        return item;
    }

    public static JT809DB32T3610MessageId tryCast(int value) {
        return mapping.get(value);
    }

    public static boolean exists(int value) {
        return mapping.containsKey(value);
    }

    public static List<JT809DB32T3610MessageId> get_JT809DB32T3610MessageId_List() {
        return new ArrayList<>(mapping.values());
    }
}
