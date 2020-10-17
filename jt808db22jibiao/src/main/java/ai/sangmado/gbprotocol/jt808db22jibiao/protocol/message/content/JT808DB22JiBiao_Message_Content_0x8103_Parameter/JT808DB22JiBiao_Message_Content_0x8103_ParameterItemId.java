package ai.sangmado.gbprotocol.jt808db22jibiao.protocol.message.content.JT808DB22JiBiao_Message_Content_0x8103_Parameter;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808MessageException;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItemId;
import ai.sangmado.gbprotocol.jt808db22jibiao.protocol.enums.JT808DB22JiBiaoProtocolVersion;
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
public class JT808DB22JiBiao_Message_Content_0x8103_ParameterItemId extends JT808_Message_Content_0x8103_ParameterItemId {
    public static final JT808DB22JiBiao_Message_Content_0x8103_ParameterItemId JT808DB22JiBiao_0x8103_0xF364 = new JT808DB22JiBiao_Message_Content_0x8103_ParameterItemId("JT808DB22JiBiao_0x8103_0xF364", 0xF364, JT808DB22JiBiaoProtocolVersion.V2019, "车辆运行监测系统参数");
    public static final JT808DB22JiBiao_Message_Content_0x8103_ParameterItemId JT808DB22JiBiao_0x8103_0xF365 = new JT808DB22JiBiao_Message_Content_0x8103_ParameterItemId("JT808DB22JiBiao_0x8103_0xF365", 0xF365, JT808DB22JiBiaoProtocolVersion.V2019, "驾驶员驾驶行为监测系统参数");

    public JT808DB22JiBiao_Message_Content_0x8103_ParameterItemId(String name, long value, IProtocolVersion since, String description) {
        super(name, value, since, description);
    }

    private static final Map<Long, JT808DB22JiBiao_Message_Content_0x8103_ParameterItemId> mapping = new HashMap<>();

    static {
        mapping.put(JT808DB22JiBiao_0x8103_0xF364.getValue(), JT808DB22JiBiao_0x8103_0xF364);
        mapping.put(JT808DB22JiBiao_0x8103_0xF365.getValue(), JT808DB22JiBiao_0x8103_0xF365);
    }

    public static JT808DB22JiBiao_Message_Content_0x8103_ParameterItemId cast(long value) {
        JT808DB22JiBiao_Message_Content_0x8103_ParameterItemId item = mapping.get(value);
        if (item == null) {
            throw new UnsupportedJT808MessageException(String.format(
                    "Cannot cast long [%s] to [%s] enum.",
                    value, JT808DB22JiBiao_Message_Content_0x8103_ParameterItemId.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DB22JiBiao_Message_Content_0x8103_ParameterItemId tryCast(long value) {
        return mapping.get(value);
    }

    public static boolean exists(long value) {
        return tryCast(value) != null;
    }

    public static List<JT808DB22JiBiao_Message_Content_0x8103_ParameterItemId> get_JT808DB22JiBiao_Message_Content_0x8103_ParameterItemId_List() {
        return new ArrayList<>(mapping.values());
    }
}
