package ai.sangmado.jt809.protocol.enums;

import ai.sangmado.gbcommon.enums.IMessageId;
import ai.sangmado.gbcommon.enums.IProtocolVersion;
import ai.sangmado.jt809.protocol.exceptions.UnsupportedJT809MessageException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ai.sangmado.jt809.protocol.enums.JT809ProtocolVersion.V2011;
import static ai.sangmado.jt809.protocol.enums.JT809ProtocolVersion.V2019;

/**
 * JT/T 809 子消息ID
 */
@Getter
@Setter
public class JT809SubMessageId implements IMessageId {
    public static final JT809SubMessageId JT809_Sub_Message_0x1201 = new JT809SubMessageId("JT809_Sub_Message_0x1201", 0x1201, V2011, "UP_EXG_MSG_REGISTER", "主链路动态信息交换消息 UP_EXG_MSG", "主链路", "上传车辆注册信息");
    public static final JT809SubMessageId JT809_Sub_Message_0x1202 = new JT809SubMessageId("JT809_Sub_Message_0x1202", 0x1202, V2011, "UP_EXG_MSG_REAL_LOCATION", "主链路动态信息交换消息 UP_EXG_MSG", "主链路", "实时上传车辆定位信息");
    public static final JT809SubMessageId JT809_Sub_Message_0x1203 = new JT809SubMessageId("JT809_Sub_Message_0x1203", 0x1203, V2011, "UP_EXG_MSG_HISTORY_LOCATION", "主链路动态信息交换消息 UP_EXG_MSG", "主链路", "车辆定位信息自动补报");
    public static final JT809SubMessageId JT809_Sub_Message_0x1205 = new JT809SubMessageId("JT809_Sub_Message_0x1205", 0x1205, V2011, "UP_EXG_MSG_RETURN_STARTUP_ACK", "主链路动态信息交换消息 UP_EXG_MSG", "主链路", "启动车辆定位信息交换应答");
    public static final JT809SubMessageId JT809_Sub_Message_0x1206 = new JT809SubMessageId("JT809_Sub_Message_0x1206", 0x1206, V2011, "UP_EXG_MSG_RETURN_END_ACK", "主链路动态信息交换消息 UP_EXG_MSG", "主链路", "结束车辆定位信息交换应答");
    public static final JT809SubMessageId JT809_Sub_Message_0x1207 = new JT809SubMessageId("JT809_Sub_Message_0x1207", 0x1207, V2011, "UP_EXG_MSG_APPLY_FOR_MONITOR_STARTUP", "主链路动态信息交换消息 UP_EXG_MSG", "主链路", "申请交换指定车辆定位信息请求");
    public static final JT809SubMessageId JT809_Sub_Message_0x1208 = new JT809SubMessageId("JT809_Sub_Message_0x1208", 0x1208, V2011, "UP_EXG_MSG_APPLY_FOR_MONITOR_END", "主链路动态信息交换消息 UP_EXG_MSG", "主链路", "取消交换指定车辆定位信息请求");
    public static final JT809SubMessageId JT809_Sub_Message_0x1209 = new JT809SubMessageId("JT809_Sub_Message_0x1209", 0x1209, V2011, "UP_EXG_MSG_APPLY_HISGNSSDATA_REQ", "主链路动态信息交换消息 UP_EXG_MSG", "主链路", "补发车辆定位信息请求");
    public static final JT809SubMessageId JT809_Sub_Message_0x120A = new JT809SubMessageId("JT809_Sub_Message_0x120A", 0x120A, V2011, "UP_EXG_MSG_REPORT_DRIVER_INFO_ACK", "主链路动态信息交换消息 UP_EXG_MSG", "主链路", "上报车辆驾驶员身份识别信息应答");
    public static final JT809SubMessageId JT809_Sub_Message_0x120B = new JT809SubMessageId("JT809_Sub_Message_0x120B", 0x120B, V2011, "UP_EXG_MSG_TAKE_EWAYBILL_ACK", "主链路动态信息交换消息 UP_EXG_MSG", "主链路", "上报车辆电子运单应答");
    public static final JT809SubMessageId JT809_Sub_Message_0x120C = new JT809SubMessageId("JT809_Sub_Message_0x120C", 0x120C, V2019, "UP_EXG_MSG_REPORT_DRIVER_INFO", "主链路动态信息交换消息 UP_EXG_MSG", "主链路", "主动上报驾驶员身份信息");
    public static final JT809SubMessageId JT809_Sub_Message_0x120D = new JT809SubMessageId("JT809_Sub_Message_0x120D", 0x120D, V2019, "UP_EXG_MSG_REPORT_EWAYBILL_INFO", "主链路动态信息交换消息 UP_EXG_MSG", "主链路", "主动上报车辆电子运单信息");
    public static final JT809SubMessageId JT809_Sub_Message_0x120E = new JT809SubMessageId("JT809_Sub_Message_0x120E", 0x120E, V2019, "UP_EXG_MSG_DRVLINE_INFO", "主链路动态信息交换消息 UP_EXG_MSG", "主链路", "主动上报车辆行驶路线信息");

    public static final JT809SubMessageId JT809_Sub_Message_0x9201 = new JT809SubMessageId("JT809_Sub_Message_0x9201", 0x9201, V2019, "DOWN_EXG_MSG_REGISTER_ACK", "从链路动态信息交换消息 DOWN_EXG_MSG", "从链路", "车辆注册信息应答消息");
    public static final JT809SubMessageId JT809_Sub_Message_0x9202 = new JT809SubMessageId("JT809_Sub_Message_0x9202", 0x9202, V2011, "DOWN_EXG_MSG_CAR_LOCATION", "从链路动态信息交换消息 DOWN_EXG_MSG", "从链路", "实时上传车辆定位信息");
    public static final JT809SubMessageId JT809_Sub_Message_0x9203 = new JT809SubMessageId("JT809_Sub_Message_0x9203", 0x9203, V2011, "DOWN_EXG_MSG_HISTORY_ARCOSSAREA", "从链路动态信息交换消息 DOWN_EXG_MSG", "从链路", "车辆定位信息交换补发");
    public static final JT809SubMessageId JT809_Sub_Message_0x9204 = new JT809SubMessageId("JT809_Sub_Message_0x9204", 0x9204, V2011, "DOWN_EXG_MSG_CAR_INFO", "从链路动态信息交换消息 DOWN_EXG_MSG", "从链路", "交换车辆静态信息");
    public static final JT809SubMessageId JT809_Sub_Message_0x9205 = new JT809SubMessageId("JT809_Sub_Message_0x9205", 0x9205, V2011, "DOWN_EXG_MSG_RETURN_STARTUP", "从链路动态信息交换消息 DOWN_EXG_MSG", "从链路", "启动车辆定位信息交换请求");
    public static final JT809SubMessageId JT809_Sub_Message_0x9206 = new JT809SubMessageId("JT809_Sub_Message_0x9206", 0x9206, V2011, "DOWN_EXG_MSG_RETURN_END", "从链路动态信息交换消息 DOWN_EXG_MSG", "从链路", "结束车辆定位信息交换请求");
    public static final JT809SubMessageId JT809_Sub_Message_0x9207 = new JT809SubMessageId("JT809_Sub_Message_0x9207", 0x9207, V2011, "DOWN_EXG_MSG_APPLY_FOR_MONITOR_STARTUP_ACK", "从链路动态信息交换消息 DOWN_EXG_MSG", "从链路", "申请交换指定车辆定位信息应答");
    public static final JT809SubMessageId JT809_Sub_Message_0x9208 = new JT809SubMessageId("JT809_Sub_Message_0x9208", 0x9208, V2011, "DOWN_EXG_MSG_APPLY_FOR_MONITOR_END_ACK", "从链路动态信息交换消息 DOWN_EXG_MSG", "从链路", "取消交换指定车辆定位信息应答");
    public static final JT809SubMessageId JT809_Sub_Message_0x9209 = new JT809SubMessageId("JT809_Sub_Message_0x9209", 0x9209, V2011, "DOWN_EXG_MSG_APPLY_HISGNSSDATA_ACK", "从链路动态信息交换消息 DOWN_EXG_MSG", "从链路", "补发车辆定位信息应答");
    public static final JT809SubMessageId JT809_Sub_Message_0x920A = new JT809SubMessageId("JT809_Sub_Message_0x920A", 0x920A, V2011, "DOWN_EXG_MSG_REPORT_DRIVER_INFO", "从链路动态信息交换消息 DOWN_EXG_MSG", "从链路", "上报车辆驾驶员身份识别信息请求");
    public static final JT809SubMessageId JT809_Sub_Message_0x920B = new JT809SubMessageId("JT809_Sub_Message_0x920B", 0x920B, V2011, "DOWN_EXG_MSG_TAKE_EWAYBILL_REQ", "从链路动态信息交换消息 DOWN_EXG_MSG", "从链路", "上报车辆电子运单请求");
    public static final JT809SubMessageId JT809_Sub_Message_0x920C = new JT809SubMessageId("JT809_Sub_Message_0x920C", 0x920C, V2019, "DOWN_BASE_MSG_DRVLINE_REQ", "从链路动态信息交换消息 DOWN_EXG_MSG", "从链路", "上报车辆行驶路线请求");
    public static final JT809SubMessageId JT809_Sub_Message_0x920D = new JT809SubMessageId("JT809_Sub_Message_0x920D", 0x920D, V2019, "DOWN_BASE_MSG_DRVLINE_ACK", "从链路动态信息交换消息 DOWN_EXG_MSG", "从链路", "车辆行驶录像请求应答");

    public static final JT809SubMessageId JT809_Sub_Message_0x1301 = new JT809SubMessageId("JT809_Sub_Message_0x1301", 0x1301, V2011, "UP_PLATFORM_MSG_POST_QUERY_ACK", "主链路平台信息交互消息 UP_PLATFORM_MSG", "主链路", "平台查岗应答");
    public static final JT809SubMessageId JT809_Sub_Message_0x1302 = new JT809SubMessageId("JT809_Sub_Message_0x1302", 0x1302, V2011, "UP_PLATFORM_MSG_INFO_ACK", "主链路平台信息交互消息 UP_PLATFORM_MSG", "主链路", "下发平台间报文应答");
    public static final JT809SubMessageId JT809_Sub_Message_0x1303 = new JT809SubMessageId("JT809_Sub_Message_0x1303", 0x1303, V2019, "UP_PLATFORM_MSG_RETRAN_REQ", "主链路平台信息交互消息 UP_PLATFORM_MSG", "主链路", "上传平台间消息补传请求");
    public static final JT809SubMessageId JT809_Sub_Message_0x9301 = new JT809SubMessageId("JT809_Sub_Message_0x9301", 0x9301, V2011, "DOWN_PLATFORM_MSG_POST_QUERY_REQ", "从链路平台信息交互消息 DOWN_PLATFORM_MSG", "从链路", "平台查岗请求");
    public static final JT809SubMessageId JT809_Sub_Message_0x9302 = new JT809SubMessageId("JT809_Sub_Message_0x9302", 0x9302, V2011, "DOWN_PLATFORM_MSG_INFO_REQ", "从链路平台信息交互消息 DOWN_PLATFORM_MSG", "从链路", "下发平台间报文请求");
    public static final JT809SubMessageId JT809_Sub_Message_0x9303 = new JT809SubMessageId("JT809_Sub_Message_0x9303", 0x9303, V2019, "DOWN_PLATFORM_MSG_RETRAN_REQ", "从链路平台信息交互消息 DOWN_PLATFORM_MSG", "从链路", "下发平台间消息补传请求");

    public static final JT809SubMessageId JT809_Sub_Message_0x1401 = new JT809SubMessageId("JT809_Sub_Message_0x1401", 0x1401, V2011, "UP_WARN_MSG_URGE_TODO_ACK", "主链路报警信息交互消息 UP_WARN_MSG", "主链路", "报警督办应答");
    public static final JT809SubMessageId JT809_Sub_Message_0x1402 = new JT809SubMessageId("JT809_Sub_Message_0x1402", 0x1402, V2011, "UP_WARN_MSG_ADPT_INFO", "主链路报警信息交互消息 UP_WARN_MSG", "主链路", "上报报警信息");
    public static final JT809SubMessageId JT809_Sub_Message_0x1403 = new JT809SubMessageId("JT809_Sub_Message_0x1403", 0x1403, V2019, "UP_WARN_MSG_INFORM_TIPS", "主链路报警信息交互消息 UP_WARN_MSG", "主链路", "上报报警预警消息");
    public static final JT809SubMessageId JT809_Sub_Message_0x1411 = new JT809SubMessageId("JT809_Sub_Message_0x1411", 0x1411, V2019, "UP_WARN_MSG_URGE_TODO_ACK_INFO", "主链路报警信息交互消息 UP_WARN_MSG", "主链路", "上报报警督办应答消息");
    public static final JT809SubMessageId JT809_Sub_Message_0x1412 = new JT809SubMessageId("JT809_Sub_Message_0x1412", 0x1412, V2019, "UP_WARN_MSG_ADPT_TODO_INFO", "主链路报警信息交互消息 UP_WARN_MSG", "主链路", "主动上报报警处理结果信息");
    public static final JT809SubMessageId JT809_Sub_Message_0x1413 = new JT809SubMessageId("JT809_Sub_Message_0x1413", 0x1413, V2019, "UP_WARN_MSG_URGE_TODO_REQ_INFO", "主链路报警信息交互消息 UP_WARN_MSG", "主链路", "上报报警督办请求消息");
    public static final JT809SubMessageId JT809_Sub_Message_0x9401 = new JT809SubMessageId("JT809_Sub_Message_0x9401", 0x9401, V2011, "DOWN_WARN_MSG_URGE_TODO_REQ", "从链路报警信息交互消息 DOWN_WARN_MSG", "从链路", "报警督办请求");
    public static final JT809SubMessageId JT809_Sub_Message_0x9402 = new JT809SubMessageId("JT809_Sub_Message_0x9402", 0x9402, V2011, "DOWN_WARN_MSG_INFORM_TIPS", "从链路报警信息交互消息 DOWN_WARN_MSG", "从链路", "报警预警");
    public static final JT809SubMessageId JT809_Sub_Message_0x9403 = new JT809SubMessageId("JT809_Sub_Message_0x9403", 0x9403, V2011, "DOWN_WARN_MSG_EXG_INFORM", "从链路报警信息交互消息 DOWN_WARN_MSG", "从链路", "实时交换报警信息");

    public static final JT809SubMessageId JT809_Sub_Message_0x1501 = new JT809SubMessageId("JT809_Sub_Message_0x1501", 0x1501, V2011, "UP_CTRL_MSG_MONITOR_VEHICLE_ACK", "主链路车辆监管消息 UP_CTRL_MSG", "主链路", "车辆单向监听应答");
    public static final JT809SubMessageId JT809_Sub_Message_0x1502 = new JT809SubMessageId("JT809_Sub_Message_0x1502", 0x1502, V2011, "UP_CTRL_MSG_TAKE_PHOTO_ACK", "主链路车辆监管消息 UP_CTRL_MSG", "主链路", "车辆拍照应答");
    public static final JT809SubMessageId JT809_Sub_Message_0x1503 = new JT809SubMessageId("JT809_Sub_Message_0x1503", 0x1503, V2011, "UP_CTRL_MSG_TEXT_INFO_ACK", "主链路车辆监管消息 UP_CTRL_MSG", "主链路", "下发车辆报文应答");
    public static final JT809SubMessageId JT809_Sub_Message_0x1504 = new JT809SubMessageId("JT809_Sub_Message_0x1504", 0x1504, V2011, "UP_CTRL_MSG_TAKE_TRAVEL_ACK", "主链路车辆监管消息 UP_CTRL_MSG", "主链路", "启动车辆定位信息交换应答");
    public static final JT809SubMessageId JT809_Sub_Message_0x1505 = new JT809SubMessageId("JT809_Sub_Message_0x1505", 0x1505, V2011, "UP_CTRL_MSG_EMERGENCY_MONITORING_ACK", "主链路车辆监管消息 UP_CTRL_MSG", "主链路", "车辆应急接入监管平台应答消息");
    public static final JT809SubMessageId JT809_Sub_Message_0x9501 = new JT809SubMessageId("JT809_Sub_Message_0x9501", 0x9501, V2011, "DOWN_CTRL_MSG_MONITOR_VEHICLE_REQ", "从链路车辆监管消息 DOWN_CTRL_MSG", "从链路", "车辆单向监听请求");
    public static final JT809SubMessageId JT809_Sub_Message_0x9502 = new JT809SubMessageId("JT809_Sub_Message_0x9502", 0x9502, V2011, "DOWN_CTRL_MSG_TAKE_PHOTO_REQ", "从链路车辆监管消息 DOWN_CTRL_MSG", "从链路", "车辆拍照请求");
    public static final JT809SubMessageId JT809_Sub_Message_0x9503 = new JT809SubMessageId("JT809_Sub_Message_0x9503", 0x9503, V2011, "DOWN_CTRL_MSG_TEXT_INFO", "从链路车辆监管消息 DOWN_CTRL_MSG", "从链路", "下发车辆报文请求");
    public static final JT809SubMessageId JT809_Sub_Message_0x9504 = new JT809SubMessageId("JT809_Sub_Message_0x9504", 0x9504, V2011, "DOWN_CTRL_MSG_TAKE_TRAVEL_REQ", "从链路车辆监管消息 DOWN_CTRL_MSG", "从链路", "上报车辆行驶记录请求");
    public static final JT809SubMessageId JT809_Sub_Message_0x9505 = new JT809SubMessageId("JT809_Sub_Message_0x9505", 0x9505, V2011, "DOWN_CTRL_MSG_EMERGENCY_MONITORING_REQ", "从链路车辆监管消息 DOWN_CTRL_MSG", "从链路", "车辆应急接入监管平台请求消息");

    public static final JT809SubMessageId JT809_Sub_Message_0x1601 = new JT809SubMessageId("JT809_Sub_Message_0x1601", 0x1601, V2011, "UP_BASE_MSG_VEHICLE_ADDED_ACK", "主链路静态信息交换消息 UP_BASE_MSG", "主链路", "补报车辆静态信息应答");
    public static final JT809SubMessageId JT809_Sub_Message_0x1602 = new JT809SubMessageId("JT809_Sub_Message_0x1602", 0x1602, V2019, "UP_BASE_MSG_DRVLINE_ADDED_ACK", "主链路静态信息交换消息 UP_BASE_MSG", "主链路", "补报车辆行驶路线信息应答");
    public static final JT809SubMessageId JT809_Sub_Message_0x9601 = new JT809SubMessageId("JT809_Sub_Message_0x9601", 0x9601, V2011, "DOWN_BASE_MSG_VEHICLE_ADDED", "从链路静态信息交换消息 DOWN_BASE_MSG", "从链路", "补报车辆静态信息请求");

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

    public JT809SubMessageId(String name, int value, IProtocolVersion since, String type, String category, String link, String description) {
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
        if (!(obj instanceof JT809SubMessageId)) {
            return false;
        }
        return this.getValue().equals(((JT809SubMessageId) obj).getValue());
    }

    @Override
    public int compareTo(IMessageId o) {
        return this.getValue().compareTo(o.getValue());
    }

    private static final Map<Integer, JT809SubMessageId> mapping = new HashMap<>();
    private static final Map<Integer, JT809SubMessageId> extensions = new HashMap<>();

    static {
        mapping.put(JT809_Sub_Message_0x1201.getValue(), JT809_Sub_Message_0x1201);
        mapping.put(JT809_Sub_Message_0x1202.getValue(), JT809_Sub_Message_0x1202);
        mapping.put(JT809_Sub_Message_0x1203.getValue(), JT809_Sub_Message_0x1203);
        mapping.put(JT809_Sub_Message_0x1205.getValue(), JT809_Sub_Message_0x1205);
        mapping.put(JT809_Sub_Message_0x1206.getValue(), JT809_Sub_Message_0x1206);
        mapping.put(JT809_Sub_Message_0x1207.getValue(), JT809_Sub_Message_0x1207);
        mapping.put(JT809_Sub_Message_0x1208.getValue(), JT809_Sub_Message_0x1208);
        mapping.put(JT809_Sub_Message_0x1209.getValue(), JT809_Sub_Message_0x1209);
        mapping.put(JT809_Sub_Message_0x120A.getValue(), JT809_Sub_Message_0x120A);
        mapping.put(JT809_Sub_Message_0x120B.getValue(), JT809_Sub_Message_0x120B);
        mapping.put(JT809_Sub_Message_0x120C.getValue(), JT809_Sub_Message_0x120C);
        mapping.put(JT809_Sub_Message_0x120D.getValue(), JT809_Sub_Message_0x120D);
        mapping.put(JT809_Sub_Message_0x120E.getValue(), JT809_Sub_Message_0x120E);

        mapping.put(JT809_Sub_Message_0x9201.getValue(), JT809_Sub_Message_0x9201);
        mapping.put(JT809_Sub_Message_0x9202.getValue(), JT809_Sub_Message_0x9202);
        mapping.put(JT809_Sub_Message_0x9203.getValue(), JT809_Sub_Message_0x9203);
        mapping.put(JT809_Sub_Message_0x9204.getValue(), JT809_Sub_Message_0x9204);
        mapping.put(JT809_Sub_Message_0x9205.getValue(), JT809_Sub_Message_0x9205);
        mapping.put(JT809_Sub_Message_0x9206.getValue(), JT809_Sub_Message_0x9206);
        mapping.put(JT809_Sub_Message_0x9207.getValue(), JT809_Sub_Message_0x9207);
        mapping.put(JT809_Sub_Message_0x9208.getValue(), JT809_Sub_Message_0x9208);
        mapping.put(JT809_Sub_Message_0x9209.getValue(), JT809_Sub_Message_0x9209);
        mapping.put(JT809_Sub_Message_0x920A.getValue(), JT809_Sub_Message_0x920A);
        mapping.put(JT809_Sub_Message_0x920B.getValue(), JT809_Sub_Message_0x920B);
        mapping.put(JT809_Sub_Message_0x920C.getValue(), JT809_Sub_Message_0x920C);
        mapping.put(JT809_Sub_Message_0x920D.getValue(), JT809_Sub_Message_0x920D);

        mapping.put(JT809_Sub_Message_0x1301.getValue(), JT809_Sub_Message_0x1301);
        mapping.put(JT809_Sub_Message_0x1302.getValue(), JT809_Sub_Message_0x1302);
        mapping.put(JT809_Sub_Message_0x1303.getValue(), JT809_Sub_Message_0x1303);
        mapping.put(JT809_Sub_Message_0x9301.getValue(), JT809_Sub_Message_0x9301);
        mapping.put(JT809_Sub_Message_0x9302.getValue(), JT809_Sub_Message_0x9302);
        mapping.put(JT809_Sub_Message_0x9303.getValue(), JT809_Sub_Message_0x9303);

        mapping.put(JT809_Sub_Message_0x1401.getValue(), JT809_Sub_Message_0x1401);
        mapping.put(JT809_Sub_Message_0x1402.getValue(), JT809_Sub_Message_0x1402);
        mapping.put(JT809_Sub_Message_0x1403.getValue(), JT809_Sub_Message_0x1403);
        mapping.put(JT809_Sub_Message_0x1411.getValue(), JT809_Sub_Message_0x1411);
        mapping.put(JT809_Sub_Message_0x1412.getValue(), JT809_Sub_Message_0x1412);
        mapping.put(JT809_Sub_Message_0x1413.getValue(), JT809_Sub_Message_0x1413);
        mapping.put(JT809_Sub_Message_0x9401.getValue(), JT809_Sub_Message_0x9401);
        mapping.put(JT809_Sub_Message_0x9402.getValue(), JT809_Sub_Message_0x9402);
        mapping.put(JT809_Sub_Message_0x9403.getValue(), JT809_Sub_Message_0x9403);

        mapping.put(JT809_Sub_Message_0x1501.getValue(), JT809_Sub_Message_0x1501);
        mapping.put(JT809_Sub_Message_0x1502.getValue(), JT809_Sub_Message_0x1502);
        mapping.put(JT809_Sub_Message_0x1503.getValue(), JT809_Sub_Message_0x1503);
        mapping.put(JT809_Sub_Message_0x1504.getValue(), JT809_Sub_Message_0x1504);
        mapping.put(JT809_Sub_Message_0x1505.getValue(), JT809_Sub_Message_0x1505);
        mapping.put(JT809_Sub_Message_0x9501.getValue(), JT809_Sub_Message_0x9501);
        mapping.put(JT809_Sub_Message_0x9502.getValue(), JT809_Sub_Message_0x9502);
        mapping.put(JT809_Sub_Message_0x9503.getValue(), JT809_Sub_Message_0x9503);
        mapping.put(JT809_Sub_Message_0x9504.getValue(), JT809_Sub_Message_0x9504);
        mapping.put(JT809_Sub_Message_0x9505.getValue(), JT809_Sub_Message_0x9505);

        mapping.put(JT809_Sub_Message_0x1601.getValue(), JT809_Sub_Message_0x1601);
        mapping.put(JT809_Sub_Message_0x1602.getValue(), JT809_Sub_Message_0x1602);
        mapping.put(JT809_Sub_Message_0x9601.getValue(), JT809_Sub_Message_0x9601);
    }

    public static JT809SubMessageId cast(int value) {
        JT809SubMessageId item = tryCast(value);
        if (item == null) {
            throw new UnsupportedJT809MessageException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT809SubMessageId.class.getSimpleName()));
        }
        return item;
    }

    public static JT809SubMessageId tryCast(int value) {
        JT809SubMessageId item = mapping.get(value);
        if (item == null) {
            item = extensions.get(value);
        }
        return item;
    }

    public static boolean exists(int value) {
        return tryCast(value) != null;
    }

    public static List<JT809SubMessageId> list() {
        List<JT809SubMessageId> l = new ArrayList<>(mapping.values());
        l.addAll(extensions.values());
        return l;
    }

    public static void putExtensions(List<JT809SubMessageId> messages) {
        messages.forEach(i -> extensions.put(i.getValue(), i));
    }
}
