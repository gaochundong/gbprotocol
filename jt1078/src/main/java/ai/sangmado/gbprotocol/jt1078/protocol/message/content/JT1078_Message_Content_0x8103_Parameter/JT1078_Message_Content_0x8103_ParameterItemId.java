package ai.sangmado.gbprotocol.jt1078.protocol.message.content.JT1078_Message_Content_0x8103_Parameter;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbprotocol.jt1078.protocol.enums.JT1078ProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808MessageException;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItemId;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 终端􏰉􏱀􏰏􏰙􏱁平台设置终端参数 - 参数项ID
 */
@Getter
@Setter
public class JT1078_Message_Content_0x8103_ParameterItemId extends JT808_Message_Content_0x8103_ParameterItemId {
    public static final JT1078_Message_Content_0x8103_ParameterItemId JT1078_0x8103_0x0075 = new JT1078_Message_Content_0x8103_ParameterItemId("JT1078_0x8103_0x0075", 0x0075, JT1078ProtocolVersion.V2016, "音视频参数设置");
    public static final JT1078_Message_Content_0x8103_ParameterItemId JT1078_0x8103_0x0076 = new JT1078_Message_Content_0x8103_ParameterItemId("JT1078_0x8103_0x0076", 0x0076, JT1078ProtocolVersion.V2016, "音视频通道列表设置");
    public static final JT1078_Message_Content_0x8103_ParameterItemId JT1078_0x8103_0x0077 = new JT1078_Message_Content_0x8103_ParameterItemId("JT1078_0x8103_0x0077", 0x0077, JT1078ProtocolVersion.V2016, "单独视频通道参数设置");
    public static final JT1078_Message_Content_0x8103_ParameterItemId JT1078_0x8103_0x0079 = new JT1078_Message_Content_0x8103_ParameterItemId("JT1078_0x8103_0x0079", 0x0079, JT1078ProtocolVersion.V2016, "特殊报警录像参数设置");
    public static final JT1078_Message_Content_0x8103_ParameterItemId JT1078_0x8103_0x007A = new JT1078_Message_Content_0x8103_ParameterItemId("JT1078_0x8103_0x007A", 0x007A, JT1078ProtocolVersion.V2016, "视频相关报警屏蔽字");
    public static final JT1078_Message_Content_0x8103_ParameterItemId JT1078_0x8103_0x007B = new JT1078_Message_Content_0x8103_ParameterItemId("JT1078_0x8103_0x007B", 0x007B, JT1078ProtocolVersion.V2016, "图像分析报警参数设置");
    public static final JT1078_Message_Content_0x8103_ParameterItemId JT1078_0x8103_0x007C = new JT1078_Message_Content_0x8103_ParameterItemId("JT1078_0x8103_0x007C", 0x007C, JT1078ProtocolVersion.V2016, "终端休眠唤醒模式设置");

    public JT1078_Message_Content_0x8103_ParameterItemId(String name, long value, IProtocolVersion since, String description) {
        super(name, value, since, description);
    }

    private static final Map<Long, JT1078_Message_Content_0x8103_ParameterItemId> mapping = new HashMap<>();

    static {
        mapping.put(JT1078_0x8103_0x0075.getValue(), JT1078_0x8103_0x0075);
        mapping.put(JT1078_0x8103_0x0076.getValue(), JT1078_0x8103_0x0076);
        mapping.put(JT1078_0x8103_0x0077.getValue(), JT1078_0x8103_0x0077);
        mapping.put(JT1078_0x8103_0x0079.getValue(), JT1078_0x8103_0x0079);
        mapping.put(JT1078_0x8103_0x007A.getValue(), JT1078_0x8103_0x007A);
        mapping.put(JT1078_0x8103_0x007B.getValue(), JT1078_0x8103_0x007B);
        mapping.put(JT1078_0x8103_0x007C.getValue(), JT1078_0x8103_0x007C);
    }

    public static JT1078_Message_Content_0x8103_ParameterItemId cast(long value) {
        JT1078_Message_Content_0x8103_ParameterItemId item = mapping.get(value);
        if (item == null) {
            throw new UnsupportedJT808MessageException(String.format(
                    "Cannot cast long [%s] to [%s] enum.",
                    value, JT1078_Message_Content_0x8103_ParameterItemId.class.getSimpleName()));
        }
        return item;
    }

    public static JT1078_Message_Content_0x8103_ParameterItemId tryCast(long value) {
        return mapping.get(value);
    }

    public static boolean exists(long value) {
        return tryCast(value) != null;
    }

    public static List<JT1078_Message_Content_0x8103_ParameterItemId> get_JT1078_Message_Content_0x8103_ParameterItemId_List() {
        return new ArrayList<>(mapping.values());
    }
}
