package ai.sangmado.gbprotocol.jt808db32t3610.protocol.enums;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808db32t3610.protocol.exceptions.UnsupportedJT808DB32T3610MessageException;
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
public class JT808DB32T3610MessageId extends JT808MessageId {
    public static final JT808DB32T3610MessageId JT808DB32T3610_Message_0x1210 = new JT808DB32T3610MessageId("JT808DB32T3610_Message_0x1210", 0x1210, JT808DB32T3610ProtocolVersion.V2019, "报警附件信息消息");
    public static final JT808DB32T3610MessageId JT808DB32T3610_Message_0x1211 = new JT808DB32T3610MessageId("JT808DB32T3610_Message_0x1211", 0x1211, JT808DB32T3610ProtocolVersion.V2019, "文件信息上传");
    public static final JT808DB32T3610MessageId JT808DB32T3610_Message_0x1212 = new JT808DB32T3610MessageId("JT808DB32T3610_Message_0x1212", 0x1212, JT808DB32T3610ProtocolVersion.V2019, "文件上传完成消息");
    public static final JT808DB32T3610MessageId JT808DB32T3610_Message_0x9208 = new JT808DB32T3610MessageId("JT808DB32T3610_Message_0x9208", 0x9208, JT808DB32T3610ProtocolVersion.V2019, "报警附件上传指令");
    public static final JT808DB32T3610MessageId JT808DB32T3610_Message_0x9212 = new JT808DB32T3610MessageId("JT808DB32T3610_Message_0x9212", 0x9212, JT808DB32T3610ProtocolVersion.V2019, "文件上传完成消息应答");

    public JT808DB32T3610MessageId(String name, int value, IProtocolVersion since, String description) {
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
        if (!(obj instanceof JT808DB32T3610MessageId)) {
            return false;
        }
        return this.getValue().equals(((JT808DB32T3610MessageId) obj).getValue());
    }

    private static final Map<Integer, JT808DB32T3610MessageId> mapping = new HashMap<>();

    static {
        mapping.put(JT808DB32T3610_Message_0x1210.getValue(), JT808DB32T3610_Message_0x1210);
        mapping.put(JT808DB32T3610_Message_0x1211.getValue(), JT808DB32T3610_Message_0x1211);
        mapping.put(JT808DB32T3610_Message_0x1212.getValue(), JT808DB32T3610_Message_0x1212);
        mapping.put(JT808DB32T3610_Message_0x9208.getValue(), JT808DB32T3610_Message_0x9208);
        mapping.put(JT808DB32T3610_Message_0x9212.getValue(), JT808DB32T3610_Message_0x9212);
    }

    public static JT808DB32T3610MessageId cast(int value) {
        JT808DB32T3610MessageId item = tryCast(value);
        if (item == null) {
            throw new UnsupportedJT808DB32T3610MessageException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808DB32T3610MessageId.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DB32T3610MessageId tryCast(int value) {
        return mapping.get(value);
    }

    public static boolean exists(int value) {
        return mapping.containsKey(value);
    }

    public static List<JT808DB32T3610MessageId> get_JT808DB32T3610MessageId_List() {
        return new ArrayList<>(mapping.values());
    }
}
