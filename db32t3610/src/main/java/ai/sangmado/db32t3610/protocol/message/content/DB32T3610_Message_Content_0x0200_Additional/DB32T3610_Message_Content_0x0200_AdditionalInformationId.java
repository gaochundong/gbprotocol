package ai.sangmado.db32t3610.protocol.message.content.DB32T3610_Message_Content_0x0200_Additional;

import ai.sangmado.gbcommon.enums.IProtocolVersion;
import ai.sangmado.jt808.protocol.exceptions.UnsupportedJT808MessageException;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformationId;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ai.sangmado.db32t3610.protocol.enums.DB32T3610ProtocolVersion.V2019;

/**
 * DB32/T3610 位置附加信息ID
 */
@Getter
@Setter
public class DB32T3610_Message_Content_0x0200_AdditionalInformationId extends JT808_Message_Content_0x0200_AdditionalInformationId {
    public static final DB32T3610_Message_Content_0x0200_AdditionalInformationId DB32T3610_0x0200_0x64 = new DB32T3610_Message_Content_0x0200_AdditionalInformationId("DB32T3610_0x200_0x64", 0x64, V2019, "高级驾驶辅助系统报警信息");
    public static final DB32T3610_Message_Content_0x0200_AdditionalInformationId DB32T3610_0x0200_0x65 = new DB32T3610_Message_Content_0x0200_AdditionalInformationId("DB32T3610_0x200_0x65", 0x65, V2019, "驾驶员状态监测系统报警信息");
    public static final DB32T3610_Message_Content_0x0200_AdditionalInformationId DB32T3610_0x0200_0x66 = new DB32T3610_Message_Content_0x0200_AdditionalInformationId("DB32T3610_0x200_0x66", 0x66, V2019, "胎压监测系统报警信息");
    public static final DB32T3610_Message_Content_0x0200_AdditionalInformationId DB32T3610_0x0200_0x67 = new DB32T3610_Message_Content_0x0200_AdditionalInformationId("DB32T3610_0x200_0x67", 0x67, V2019, "盲区监测系统报警信息");

    public DB32T3610_Message_Content_0x0200_AdditionalInformationId(String name, int value, IProtocolVersion since, String description) {
        super(name, value, since, description);
    }

    private static final Map<Integer, DB32T3610_Message_Content_0x0200_AdditionalInformationId> mapping = new HashMap<>();

    static {
        mapping.put(DB32T3610_0x0200_0x64.getValue(), DB32T3610_0x0200_0x64);
        mapping.put(DB32T3610_0x0200_0x65.getValue(), DB32T3610_0x0200_0x65);
        mapping.put(DB32T3610_0x0200_0x66.getValue(), DB32T3610_0x0200_0x66);
        mapping.put(DB32T3610_0x0200_0x67.getValue(), DB32T3610_0x0200_0x67);
    }

    public static DB32T3610_Message_Content_0x0200_AdditionalInformationId cast(int value) {
        DB32T3610_Message_Content_0x0200_AdditionalInformationId item = tryCast(value);
        if (item == null) {
            throw new UnsupportedJT808MessageException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, DB32T3610_Message_Content_0x0200_AdditionalInformationId.class.getSimpleName()));
        }
        return item;
    }

    public static DB32T3610_Message_Content_0x0200_AdditionalInformationId tryCast(int value) {
        return mapping.get(value);
    }

    public static boolean exists(int value) {
        return tryCast(value) != null;
    }

    public static List<DB32T3610_Message_Content_0x0200_AdditionalInformationId> get_DB32T3610_Message_Content_0x0200_AdditionalInformationId_List() {
        return new ArrayList<>(mapping.values());
    }
}
