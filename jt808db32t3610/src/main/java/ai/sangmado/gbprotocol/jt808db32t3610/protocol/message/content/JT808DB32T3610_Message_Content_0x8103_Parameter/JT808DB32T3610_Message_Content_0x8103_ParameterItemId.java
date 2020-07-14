package ai.sangmado.gbprotocol.jt808db32t3610.protocol.message.content.JT808DB32T3610_Message_Content_0x8103_Parameter;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808MessageException;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItemId;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ai.sangmado.gbprotocol.jt808db32t3610.protocol.enums.JT808DB32T3610ProtocolVersion.V2019;

/**
 * 终端􏰉􏱀􏰏􏰙􏱁平台设置终端参数 - 参数项ID
 */
@Getter
@Setter
public class JT808DB32T3610_Message_Content_0x8103_ParameterItemId extends JT808_Message_Content_0x8103_ParameterItemId {
    public static final JT808DB32T3610_Message_Content_0x8103_ParameterItemId JT808DB32T3610_0x8103_0xF364 = new JT808DB32T3610_Message_Content_0x8103_ParameterItemId("JT808DB32T3610_0x8103_0xF364", 0xF364, V2019, "驾驶辅助功能参数");
    public static final JT808DB32T3610_Message_Content_0x8103_ParameterItemId JT808DB32T3610_0x8103_0xF365 = new JT808DB32T3610_Message_Content_0x8103_ParameterItemId("JT808DB32T3610_0x8103_0xF365", 0xF365, V2019, "驾驶员行为监测功能参数");
    public static final JT808DB32T3610_Message_Content_0x8103_ParameterItemId JT808DB32T3610_0x8103_0xF366 = new JT808DB32T3610_Message_Content_0x8103_ParameterItemId("JT808DB32T3610_0x8103_0xF366", 0xF366, V2019, "轮胎状态监测功能参数");
    public static final JT808DB32T3610_Message_Content_0x8103_ParameterItemId JT808DB32T3610_0x8103_0xF367 = new JT808DB32T3610_Message_Content_0x8103_ParameterItemId("JT808DB32T3610_0x8103_0xF367", 0xF367, V2019, "变道决策辅助功能参数");
    public static final JT808DB32T3610_Message_Content_0x8103_ParameterItemId JT808DB32T3610_0x8103_0xF370 = new JT808DB32T3610_Message_Content_0x8103_ParameterItemId("JT808DB32T3610_0x8103_0xF370", 0xF370, V2019, "激烈驾驶检测功能参数");

    public static final JT808DB32T3610_Message_Content_0x8103_ParameterItemId JT808DB32T3610_0x8103_0xFF00 = new JT808DB32T3610_Message_Content_0x8103_ParameterItemId("JT808DB32T3610_0x8103_0xFF00", 0xFF00, V2019, "终端MAC地址");
    public static final JT808DB32T3610_Message_Content_0x8103_ParameterItemId JT808DB32T3610_0x8103_0xFF01 = new JT808DB32T3610_Message_Content_0x8103_ParameterItemId("JT808DB32T3610_0x8103_0xFF01", 0xFF01, V2019, "扩展制造商ID, 主动安全智能防控终端制造商编码");
    public static final JT808DB32T3610_Message_Content_0x8103_ParameterItemId JT808DB32T3610_0x8103_0xFF02 = new JT808DB32T3610_Message_Content_0x8103_ParameterItemId("JT808DB32T3610_0x8103_0xFF02", 0xFF02, V2019, "扩展终端型号, 主动安全智能防控终端型号");

    public JT808DB32T3610_Message_Content_0x8103_ParameterItemId(String name, long value, IProtocolVersion since, String description) {
        super(name, value, since, description);
    }

    private static final Map<Long, JT808DB32T3610_Message_Content_0x8103_ParameterItemId> mapping = new HashMap<>();

    static {
        mapping.put(JT808DB32T3610_0x8103_0xF364.getValue(), JT808DB32T3610_0x8103_0xF364);
        mapping.put(JT808DB32T3610_0x8103_0xF365.getValue(), JT808DB32T3610_0x8103_0xF365);
        mapping.put(JT808DB32T3610_0x8103_0xF366.getValue(), JT808DB32T3610_0x8103_0xF366);
        mapping.put(JT808DB32T3610_0x8103_0xF367.getValue(), JT808DB32T3610_0x8103_0xF367);
        mapping.put(JT808DB32T3610_0x8103_0xF370.getValue(), JT808DB32T3610_0x8103_0xF370);

        mapping.put(JT808DB32T3610_0x8103_0xFF00.getValue(), JT808DB32T3610_0x8103_0xFF00);
        mapping.put(JT808DB32T3610_0x8103_0xFF01.getValue(), JT808DB32T3610_0x8103_0xFF01);
        mapping.put(JT808DB32T3610_0x8103_0xFF02.getValue(), JT808DB32T3610_0x8103_0xFF02);
    }

    public static JT808DB32T3610_Message_Content_0x8103_ParameterItemId cast(long value) {
        JT808DB32T3610_Message_Content_0x8103_ParameterItemId item = mapping.get(value);
        if (item == null) {
            throw new UnsupportedJT808MessageException(String.format(
                    "Cannot cast long [%s] to [%s] enum.",
                    value, JT808DB32T3610_Message_Content_0x8103_ParameterItemId.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DB32T3610_Message_Content_0x8103_ParameterItemId tryCast(long value) {
        return mapping.get(value);
    }

    public static boolean exists(long value) {
        return tryCast(value) != null;
    }

    public static List<JT808DB32T3610_Message_Content_0x8103_ParameterItemId> get_JT808DB32T3610_Message_Content_0x8103_ParameterItemId_List() {
        return new ArrayList<>(mapping.values());
    }
}
