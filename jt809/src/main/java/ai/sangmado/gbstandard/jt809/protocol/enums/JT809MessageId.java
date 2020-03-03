package ai.sangmado.gbstandard.jt809.protocol.enums;

import ai.sangmado.gbstandard.gbcommon.enums.IMessageId;
import ai.sangmado.gbstandard.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbstandard.jt809.protocol.exceptions.UnsupportedJT809MessageException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ai.sangmado.gbstandard.jt809.protocol.enums.JT809ProtocolVersion.V2011;
import static ai.sangmado.gbstandard.jt809.protocol.enums.JT809ProtocolVersion.V2019;

/**
 * JT/T 809 消息ID
 */
@Getter
@Setter
public class JT809MessageId implements IMessageId {
    public static final JT809MessageId JT809_Message_0x1001 = new JT809MessageId("JT809_Message_0x1001", 0x1001, V2011, "UP_CONNECT_REQ", "链路管理类", "主链路", "主链路登录请求消息");
    public static final JT809MessageId JT809_Message_0x1002 = new JT809MessageId("JT809_Message_0x1002", 0x1002, V2011, "UP_CONNECT_RSP", "链路管理类", "主链路", "主链路登录应答消息");
    public static final JT809MessageId JT809_Message_0x1003 = new JT809MessageId("JT809_Message_0x1003", 0x1003, V2011, "UP_DISCONNECT_REQ", "链路管理类", "主链路", "主链路注销请求消息");
    public static final JT809MessageId JT809_Message_0x1004 = new JT809MessageId("JT809_Message_0x1004", 0x1004, V2011, "UP_DISCONNECT_RSP", "链路管理类", "主链路", "主链路注销应答消息");
    public static final JT809MessageId JT809_Message_0x1005 = new JT809MessageId("JT809_Message_0x1005", 0x1005, V2011, "UP_LINKTEST_REQ", "链路管理类", "主链路", "主链路连接保持请求消息");
    public static final JT809MessageId JT809_Message_0x1006 = new JT809MessageId("JT809_Message_0x1006", 0x1006, V2011, "UP_LINKTEST_RSP", "链路管理类", "主链路", "主链路连接保持应答消息");
    public static final JT809MessageId JT809_Message_0x1007 = new JT809MessageId("JT809_Message_0x1007", 0x1007, V2011, "UP_DISCONNECT_INFORM", "链路管理类", "主链路", "主链路断开通知消息");
    public static final JT809MessageId JT809_Message_0x1008 = new JT809MessageId("JT809_Message_0x1008", 0x1008, V2011, "UP_CLOSELINK_INFORM", "链路管理类", "主链路", "下级平台主动关闭链路通知消息");

    public static final JT809MessageId JT809_Message_0x9001 = new JT809MessageId("JT809_Message_0x9001", 0x9001, V2011, "DOWN_CONNECT_REQ", "链路管理类", "从链路", "从链路连接请求消息");
    public static final JT809MessageId JT809_Message_0x9002 = new JT809MessageId("JT809_Message_0x9002", 0x9002, V2011, "DOWN_CONNECT_RSP", "链路管理类", "从链路", "从链路连接应答消息");
    public static final JT809MessageId JT809_Message_0x9003 = new JT809MessageId("JT809_Message_0x9003", 0x9003, V2011, "DOWN_DISCONNECT_REQ", "链路管理类", "从链路", "从链路注销请求消息");
    public static final JT809MessageId JT809_Message_0x9004 = new JT809MessageId("JT809_Message_0x9004", 0x9004, V2011, "DOWN_DISCONNECT_RSP", "链路管理类", "从链路", "从链路注销应答消息");
    public static final JT809MessageId JT809_Message_0x9005 = new JT809MessageId("JT809_Message_0x9005", 0x9005, V2011, "DOWN_LINKTEST_REQ", "链路管理类", "从链路", "从链路连接保持请求消息");
    public static final JT809MessageId JT809_Message_0x9006 = new JT809MessageId("JT809_Message_0x9006", 0x9006, V2011, "DOWN_LINKTEST_RSP", "链路管理类", "从链路", "从链路连接保持应答消息");
    public static final JT809MessageId JT809_Message_0x9007 = new JT809MessageId("JT809_Message_0x9007", 0x9007, V2011, "DOWN_DISCONNECT_INFORM", "链路管理类", "从链路", "从链路断开通知消息");
    public static final JT809MessageId JT809_Message_0x9008 = new JT809MessageId("JT809_Message_0x9008", 0x9008, V2011, "DOWN_CLOSELINK_INFORM", "链路管理类", "从链路", "上级平台主动关闭链路通知消息");

    public static final JT809MessageId JT809_Message_0x1101 = new JT809MessageId("JT809_Message_0x1101", 0x1101, V2019, "UP_MANAGE_TOTAL_RECV_BACK_MSG", "信息统计类", "主链路", "发送车辆定位信息数量通知消息");
    public static final JT809MessageId JT809_Message_0x9101 = new JT809MessageId("JT809_Message_0x9101", 0x9101, V2011, "DOWN_TOTAL_RECV_BACK_MSG", "信息统计类", "从链路", "接收车辆定位信息数量通知消息");
    public static final JT809MessageId JT809_Message_0x1102 = new JT809MessageId("JT809_Message_0x1102", 0x1102, V2019, "UP_MANAGE_MSG_RSP", "信息统计类", "主链路", "平台链路连接情况与车辆定位消息传输情况上报应答消息");
    public static final JT809MessageId JT809_Message_0x9102 = new JT809MessageId("JT809_Message_0x9102", 0x9102, V2019, "DOWN_MANAGE_MSG_REQ", "信息统计类", "从链路", "平台链路连接情况与车辆定位消息传输情况上报请求消息");
    public static final JT809MessageId JT809_Message_0x1103 = new JT809MessageId("JT809_Message_0x1103", 0x1103, V2019, "UP_MANAGE_MSG_SN_INFORM", "信息统计类", "主链路", "上传平台间消息序列号通知消息");
    public static final JT809MessageId JT809_Message_0x9103 = new JT809MessageId("JT809_Message_0x9103", 0x9103, V2019, "DOWN_MANAGE_MSG_SN_INFORM", "信息统计类", "从链路", "下发平台间消息序列号通知消息");

    public static final JT809MessageId JT809_Message_0x1200 = new JT809MessageId("JT809_Message_0x1200", 0x1200, V2011, "UP_EXG_MSG", "车辆动态信息交换", "主链路", "主链路动态信息交换消息");
    public static final JT809MessageId JT809_Message_0x9200 = new JT809MessageId("JT809_Message_0x9200", 0x9200, V2011, "DOWN_EXG_MSG", "车辆动态信息交换", "从链路", "从链路动态信息交换消息");

    public static final JT809MessageId JT809_Message_0x1300 = new JT809MessageId("JT809_Message_0x1300", 0x1300, V2011, "UP_PLATFORM_MSG", "平台间信息交互类", "主链路", "主链路平台间信息交互消息");
    public static final JT809MessageId JT809_Message_0x9300 = new JT809MessageId("JT809_Message_0x9300", 0x9300, V2011, "DOWN_PLATFORM_MSG", "平台间信息交互类", "从链路", "从链路平台间信息交互消息");

    public static final JT809MessageId JT809_Message_0x1400 = new JT809MessageId("JT809_Message_0x1400", 0x1400, V2011, "UP_WARN_MSG", "车辆报警信息交互类", "主链路", "主链路报警信息交互消息");
    public static final JT809MessageId JT809_Message_0x9400 = new JT809MessageId("JT809_Message_0x9400", 0x9400, V2011, "DOWN_WARN_MSG", "车辆报警信息交互类", "从链路", "从链路报警信息交互消息");

    public static final JT809MessageId JT809_Message_0x1500 = new JT809MessageId("JT809_Message_0x1500", 0x1500, V2011, "UP_CTRL_MSG", "车辆监管类", "主链路", "主链路车辆监管消息");
    public static final JT809MessageId JT809_Message_0x9500 = new JT809MessageId("JT809_Message_0x9500", 0x9500, V2011, "DOWN_CTRL_MSG", "车辆监管类", "从链路", "从链路车辆监管消息");

    public static final JT809MessageId JT809_Message_0x1600 = new JT809MessageId("JT809_Message_0x1600", 0x1600, V2011, "UP_BASE_MSG", "车辆静态信息交换类", "主链路", "主链路静态信息交换消息");
    public static final JT809MessageId JT809_Message_0x9600 = new JT809MessageId("JT809_Message_0x9600", 0x9600, V2011, "DOWN_BASE_MSG", "车辆静态信息交换类", "从链路", "从链路静态信息交换消息");

    /**
     * 消息ID名称
     */
    private String name;
    /**
     * 消息ID值
     */
    private Integer value;
    /**
     * 消息ID来自版本
     */
    private IProtocolVersion since;
    /**
     * 消息业务数据类型标识
     */
    private String type;
    /**
     * 消息种类
     */
    private String category;
    /**
     * 消息链路
     */
    private String link;
    /**
     * 消息ID描述
     */
    private String description;

    public JT809MessageId(String name, int value, IProtocolVersion since, String type, String category, String link, String description) {
        this.name = name;
        this.value = value;
        this.since = since;
        this.type = type;
        this.category = category;
        this.link = link;
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
        if (!(obj instanceof JT809MessageId)) {
            return false;
        }
        return this.getValue().equals(((JT809MessageId) obj).getValue());
    }

    @Override
    public int compareTo(IMessageId o) {
        return this.getValue().compareTo(o.getValue());
    }

    private static final Map<Integer, JT809MessageId> mapping = new HashMap<>();
    private static final Map<Integer, JT809MessageId> extensions = new HashMap<>();

    static {
        mapping.put(JT809_Message_0x1001.getValue(), JT809_Message_0x1001);
        mapping.put(JT809_Message_0x1002.getValue(), JT809_Message_0x1002);
        mapping.put(JT809_Message_0x1003.getValue(), JT809_Message_0x1003);
        mapping.put(JT809_Message_0x1004.getValue(), JT809_Message_0x1004);
        mapping.put(JT809_Message_0x1005.getValue(), JT809_Message_0x1005);
        mapping.put(JT809_Message_0x1006.getValue(), JT809_Message_0x1006);
        mapping.put(JT809_Message_0x1007.getValue(), JT809_Message_0x1007);
        mapping.put(JT809_Message_0x1008.getValue(), JT809_Message_0x1008);

        mapping.put(JT809_Message_0x9001.getValue(), JT809_Message_0x9001);
        mapping.put(JT809_Message_0x9002.getValue(), JT809_Message_0x9002);
        mapping.put(JT809_Message_0x9003.getValue(), JT809_Message_0x9003);
        mapping.put(JT809_Message_0x9004.getValue(), JT809_Message_0x9004);
        mapping.put(JT809_Message_0x9005.getValue(), JT809_Message_0x9005);
        mapping.put(JT809_Message_0x9006.getValue(), JT809_Message_0x9006);
        mapping.put(JT809_Message_0x9007.getValue(), JT809_Message_0x9007);
        mapping.put(JT809_Message_0x9008.getValue(), JT809_Message_0x9008);

        mapping.put(JT809_Message_0x1101.getValue(), JT809_Message_0x1101);
        mapping.put(JT809_Message_0x9101.getValue(), JT809_Message_0x9101);
        mapping.put(JT809_Message_0x1102.getValue(), JT809_Message_0x1102);
        mapping.put(JT809_Message_0x9102.getValue(), JT809_Message_0x9102);
        mapping.put(JT809_Message_0x1103.getValue(), JT809_Message_0x1103);
        mapping.put(JT809_Message_0x9103.getValue(), JT809_Message_0x9103);

        mapping.put(JT809_Message_0x1200.getValue(), JT809_Message_0x1200);
        mapping.put(JT809_Message_0x9200.getValue(), JT809_Message_0x9200);

        mapping.put(JT809_Message_0x1300.getValue(), JT809_Message_0x1300);
        mapping.put(JT809_Message_0x9300.getValue(), JT809_Message_0x9300);

        mapping.put(JT809_Message_0x1400.getValue(), JT809_Message_0x1400);
        mapping.put(JT809_Message_0x9400.getValue(), JT809_Message_0x9400);

        mapping.put(JT809_Message_0x1500.getValue(), JT809_Message_0x1500);
        mapping.put(JT809_Message_0x9500.getValue(), JT809_Message_0x9500);

        mapping.put(JT809_Message_0x1600.getValue(), JT809_Message_0x1600);
        mapping.put(JT809_Message_0x9600.getValue(), JT809_Message_0x9600);
    }

    public static JT809MessageId cast(int value) {
        JT809MessageId item = tryCast(value);
        if (item == null) {
            throw new UnsupportedJT809MessageException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT809MessageId.class.getSimpleName()));
        }
        return item;
    }

    public static JT809MessageId tryCast(int value) {
        JT809MessageId item = mapping.get(value);
        if (item == null) {
            item = extensions.get(value);
        }
        return item;
    }

    public static boolean exists(int value) {
        return tryCast(value) != null;
    }

    public static List<JT809MessageId> list() {
        List<JT809MessageId> l = new ArrayList<>(mapping.values());
        l.addAll(extensions.values());
        return l;
    }

    public static void putExtensions(List<JT809MessageId> messages) {
        messages.forEach(i -> extensions.put(i.getValue(), i));
    }
}
