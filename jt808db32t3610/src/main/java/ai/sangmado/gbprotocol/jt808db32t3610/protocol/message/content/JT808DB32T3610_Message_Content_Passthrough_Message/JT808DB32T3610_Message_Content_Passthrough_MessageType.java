package ai.sangmado.gbprotocol.jt808db32t3610.protocol.message.content.JT808DB32T3610_Message_Content_Passthrough_Message;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808MessageException;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_Passthrough_Message.JT808_Message_Content_Passthrough_MessageType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ai.sangmado.gbprotocol.jt808db32t3610.protocol.enums.JT808DB32T3610ProtocolVersion.V2019;

/**
 * 透传消息扩展
 *
 * @see JT808_Message_Content_Passthrough_MessageType 0x8900/0x0900扩展
 */
@Getter
@Setter
public class JT808DB32T3610_Message_Content_Passthrough_MessageType extends JT808_Message_Content_Passthrough_MessageType {
    public static final JT808DB32T3610_Message_Content_Passthrough_MessageType JT808DB32T3610_Passthrough_Message_0xF7 = new JT808DB32T3610_Message_Content_Passthrough_MessageType("JT808DB32T3610_Passthrough_Message_0xF7", 0xF7, V2019, "状态查询");
    public static final JT808DB32T3610_Message_Content_Passthrough_MessageType JT808DB32T3610_Passthrough_Message_0xF8 = new JT808DB32T3610_Message_Content_Passthrough_MessageType("JT808DB32T3610_Passthrough_Message_0xF8", 0xF8, V2019, "信息查询");

    public JT808DB32T3610_Message_Content_Passthrough_MessageType(String name, int value, IProtocolVersion since, String description) {
        super(name, value, since, description);
    }

    private static final Map<Integer, JT808DB32T3610_Message_Content_Passthrough_MessageType> mapping = new HashMap<>();

    static {
        mapping.put(JT808DB32T3610_Passthrough_Message_0xF7.getValue(), JT808DB32T3610_Passthrough_Message_0xF7);
        mapping.put(JT808DB32T3610_Passthrough_Message_0xF8.getValue(), JT808DB32T3610_Passthrough_Message_0xF8);
    }

    public static JT808DB32T3610_Message_Content_Passthrough_MessageType cast(int value) {
        JT808DB32T3610_Message_Content_Passthrough_MessageType item = mapping.get(value);
        if (item == null) {
            throw new UnsupportedJT808MessageException(String.format(
                    "Cannot cast int [%s] to [%s] enum.",
                    value, JT808DB32T3610_Message_Content_Passthrough_MessageType.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DB32T3610_Message_Content_Passthrough_MessageType tryCast(int value) {
        return mapping.get(value);
    }

    public static boolean exists(int value) {
        return tryCast(value) != null;
    }

    public static List<JT808DB32T3610_Message_Content_Passthrough_MessageType> get_JT808DB32T3610_Message_Content_Passthrough_MessageType_List() {
        return new ArrayList<>(mapping.values());
    }
}
