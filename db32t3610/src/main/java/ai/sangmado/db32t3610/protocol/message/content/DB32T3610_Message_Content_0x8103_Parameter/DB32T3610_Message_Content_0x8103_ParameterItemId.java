package ai.sangmado.db32t3610.protocol.message.content.DB32T3610_Message_Content_0x8103_Parameter;

import ai.sangmado.gbcommon.enums.IProtocolVersion;
import ai.sangmado.jt808.protocol.exceptions.UnsupportedJT808MessageException;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItemId;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ai.sangmado.db32t3610.protocol.enums.DB32T3610ProtocolVersion.V2019;

/**
 * 终端􏰉􏱀􏰏􏰙􏱁平台设置终端参数 - 参数项ID
 */
@Getter
@Setter
public class DB32T3610_Message_Content_0x8103_ParameterItemId extends JT808_Message_Content_0x8103_ParameterItemId {
    public static final DB32T3610_Message_Content_0x8103_ParameterItemId DB32T3610_0x8103_0xF364 = new DB32T3610_Message_Content_0x8103_ParameterItemId("DB32T3610_0x8103_0xF364", 0xF364, V2019, "高级驾驶辅助系统参数");
    public static final DB32T3610_Message_Content_0x8103_ParameterItemId DB32T3610_0x8103_0xF365 = new DB32T3610_Message_Content_0x8103_ParameterItemId("DB32T3610_0x8103_0xF365", 0xF365, V2019, "驾驶员状态监测系统参数");
    public static final DB32T3610_Message_Content_0x8103_ParameterItemId DB32T3610_0x8103_0xF366 = new DB32T3610_Message_Content_0x8103_ParameterItemId("DB32T3610_0x8103_0xF366", 0xF366, V2019, "胎压监测系统参数");
    public static final DB32T3610_Message_Content_0x8103_ParameterItemId DB32T3610_0x8103_0xF367 = new DB32T3610_Message_Content_0x8103_ParameterItemId("DB32T3610_0x8103_0xF367", 0xF367, V2019, "盲区监测系统参数");

    public DB32T3610_Message_Content_0x8103_ParameterItemId(String name, long value, IProtocolVersion since, String description) {
        super(name, value, since, description);
    }

    private static final Map<Long, DB32T3610_Message_Content_0x8103_ParameterItemId> mapping = new HashMap<>();

    static {
        mapping.put(DB32T3610_0x8103_0xF364.getValue(), DB32T3610_0x8103_0xF364);
        mapping.put(DB32T3610_0x8103_0xF365.getValue(), DB32T3610_0x8103_0xF365);
        mapping.put(DB32T3610_0x8103_0xF366.getValue(), DB32T3610_0x8103_0xF366);
        mapping.put(DB32T3610_0x8103_0xF367.getValue(), DB32T3610_0x8103_0xF367);
    }

    public static DB32T3610_Message_Content_0x8103_ParameterItemId cast(long value) {
        DB32T3610_Message_Content_0x8103_ParameterItemId item = mapping.get(value);
        if (item == null) {
            throw new UnsupportedJT808MessageException(String.format(
                    "Cannot cast long [%s] to [%s] enum.",
                    value, DB32T3610_Message_Content_0x8103_ParameterItemId.class.getSimpleName()));
        }
        return item;
    }

    public static DB32T3610_Message_Content_0x8103_ParameterItemId tryCast(long value) {
        return mapping.get(value);
    }

    public static boolean exists(long value) {
        return tryCast(value) != null;
    }

    public static List<DB32T3610_Message_Content_0x8103_ParameterItemId> get_DB32T3610_Message_Content_0x8103_ParameterItemId_List() {
        return new ArrayList<>(mapping.values());
    }
}
