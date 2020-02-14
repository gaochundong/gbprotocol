package ai.sangmado.jt1078.protocol.enums;

import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import lombok.Getter;
import lombok.Setter;

/**
 * JT/T 1078 消息ID
 */
@Getter
@Setter
public class JT1078MessageId extends JT808MessageId {
    public static final JT1078MessageId JT1078_Message_0x1003 = new JT1078MessageId("JT1078_Message_0x1003", 0x1003, JT1078ProtocolVersion.V2016, "终端上传音视频属性");
    public static final JT1078MessageId JT1078_Message_0x1005 = new JT1078MessageId("JT1078_Message_0x1005", 0x1005, JT1078ProtocolVersion.V2016, "终端上传乘客流量");
    public static final JT1078MessageId JT1078_Message_0x1205 = new JT1078MessageId("JT1078_Message_0x1205", 0x1205, JT1078ProtocolVersion.V2016, "终端上传音视频资源列表");
    public static final JT1078MessageId JT1078_Message_0x1206 = new JT1078MessageId("JT1078_Message_0x1206", 0x1206, JT1078ProtocolVersion.V2016, "终端文件上传完成通知");

    public static final JT1078MessageId JT1078_Message_0x9003 = new JT1078MessageId("JT1078_Message_0x9003", 0x9003, JT1078ProtocolVersion.V2016, "平台查询终端音视频属性");
    public static final JT1078MessageId JT1078_Message_0x9101 = new JT1078MessageId("JT1078_Message_0x9101", 0x9101, JT1078ProtocolVersion.V2016, "平台下发实时音视频传输请求");
    public static final JT1078MessageId JT1078_Message_0x9102 = new JT1078MessageId("JT1078_Message_0x9102", 0x9102, JT1078ProtocolVersion.V2016, "平台下发音视频实时传输控制");
    public static final JT1078MessageId JT1078_Message_0x9105 = new JT1078MessageId("JT1078_Message_0x9105", 0x9105, JT1078ProtocolVersion.V2016, "平台下发实时音视频传输状态通知");
    public static final JT1078MessageId JT1078_Message_0x9201 = new JT1078MessageId("JT1078_Message_0x9201", 0x9201, JT1078ProtocolVersion.V2016, "平台下发远程录像回放请求");
    public static final JT1078MessageId JT1078_Message_0x9202 = new JT1078MessageId("JT1078_Message_0x9202", 0x9202, JT1078ProtocolVersion.V2016, "平台下发远程录像回放控制");
    public static final JT1078MessageId JT1078_Message_0x9205 = new JT1078MessageId("JT1078_Message_0x9205", 0x9205, JT1078ProtocolVersion.V2016, "平台下发查询音视频资源列表");
    public static final JT1078MessageId JT1078_Message_0x9206 = new JT1078MessageId("JT1078_Message_0x9206", 0x9206, JT1078ProtocolVersion.V2016, "平台下发文件上传指令");
    public static final JT1078MessageId JT1078_Message_0x9207 = new JT1078MessageId("JT1078_Message_0x9207", 0x9207, JT1078ProtocolVersion.V2016, "平台下发文件上传控制");
    public static final JT1078MessageId JT1078_Message_0x9301 = new JT1078MessageId("JT1078_Message_0x9301", 0x9301, JT1078ProtocolVersion.V2016, "平台下发云台旋转");
    public static final JT1078MessageId JT1078_Message_0x9302 = new JT1078MessageId("JT1078_Message_0x9302", 0x9302, JT1078ProtocolVersion.V2016, "平台下发云台调整焦距控制");
    public static final JT1078MessageId JT1078_Message_0x9303 = new JT1078MessageId("JT1078_Message_0x9303", 0x9303, JT1078ProtocolVersion.V2016, "平台下发云台调整光圈控制");
    public static final JT1078MessageId JT1078_Message_0x9304 = new JT1078MessageId("JT1078_Message_0x9304", 0x9304, JT1078ProtocolVersion.V2016, "平台下发云台雨刷控制");
    public static final JT1078MessageId JT1078_Message_0x9305 = new JT1078MessageId("JT1078_Message_0x9305", 0x9305, JT1078ProtocolVersion.V2016, "平台下发红外补光控制");
    public static final JT1078MessageId JT1078_Message_0x9306 = new JT1078MessageId("JT1078_Message_0x9306", 0x9306, JT1078ProtocolVersion.V2016, "平台下发云台变倍控制");

    public JT1078MessageId(String name, int value, Object since, String description) {
        super(name, value, since, description);
    }
}
