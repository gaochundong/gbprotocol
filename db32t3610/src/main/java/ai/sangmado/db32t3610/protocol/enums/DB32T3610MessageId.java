package ai.sangmado.db32t3610.protocol.enums;

import ai.sangmado.gbcommon.enums.IProtocolVersion;
import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.jt808.protocol.exceptions.UnsupportedJT808MessageException;
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
public class DB32T3610MessageId extends JT808MessageId {
    public static final DB32T3610MessageId DB32T3610_Message_0x1210 = new DB32T3610MessageId("DB32T3610_Message_0x1210", 0x1210, DB32T3610ProtocolVersion.V2019, "报警附件信息消息");
    public static final DB32T3610MessageId DB32T3610_Message_0x1211 = new DB32T3610MessageId("DB32T3610_Message_0x1211", 0x1211, DB32T3610ProtocolVersion.V2019, "文件信息上传");
    public static final DB32T3610MessageId DB32T3610_Message_0x1212 = new DB32T3610MessageId("DB32T3610_Message_0x1212", 0x1212, DB32T3610ProtocolVersion.V2019, "文件上传完成消息");
    public static final DB32T3610MessageId DB32T3610_Message_0x9208 = new DB32T3610MessageId("DB32T3610_Message_0x9208", 0x9208, DB32T3610ProtocolVersion.V2019, "报警附件上传指令");
    public static final DB32T3610MessageId DB32T3610_Message_0x9212 = new DB32T3610MessageId("DB32T3610_Message_0x9212", 0x9212, DB32T3610ProtocolVersion.V2019, "文件上传完成消息应答");

    public DB32T3610MessageId(String name, int value, IProtocolVersion since, String description) {
        super(name, value, since, description);
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
        if (!(obj instanceof DB32T3610MessageId)) {
            return false;
        }
        return this.getValue().equals(((DB32T3610MessageId) obj).getValue());
    }

    private static final Map<Integer, DB32T3610MessageId> mapping = new HashMap<>();

    static {
        mapping.put(DB32T3610_Message_0x1210.getValue(), DB32T3610_Message_0x1210);
        mapping.put(DB32T3610_Message_0x1211.getValue(), DB32T3610_Message_0x1211);
        mapping.put(DB32T3610_Message_0x1212.getValue(), DB32T3610_Message_0x1212);
        mapping.put(DB32T3610_Message_0x9208.getValue(), DB32T3610_Message_0x9208);
        mapping.put(DB32T3610_Message_0x9212.getValue(), DB32T3610_Message_0x9212);
    }

    public static DB32T3610MessageId cast(int value) {
        DB32T3610MessageId item = tryCast(value);
        if (item == null) {
            throw new UnsupportedJT808MessageException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, DB32T3610MessageId.class.getSimpleName()));
        }
        return item;
    }

    public static DB32T3610MessageId tryCast(int value) {
        return mapping.get(value);
    }

    public static boolean exists(int value) {
        return mapping.containsKey(value);
    }

    public static List<DB32T3610MessageId> get_DB32T3610MessageId_List() {
        return new ArrayList<>(mapping.values());
    }
}
