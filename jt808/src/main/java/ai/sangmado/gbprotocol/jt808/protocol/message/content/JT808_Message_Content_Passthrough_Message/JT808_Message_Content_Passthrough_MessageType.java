package ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_Passthrough_Message;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbprotocol.gbcommon.serializer.IntegerToHex2StringSerializer;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808MessageException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ai.sangmado.gbprotocol.jt808.protocol.enums.JT808ProtocolVersion.V2013;

/**
 * 透传消息类型
 *
 * @implSpec 0xF0-0xFF 用户自定义透传消息
 */
@Getter
@Setter
public class JT808_Message_Content_Passthrough_MessageType implements Comparable<JT808_Message_Content_Passthrough_MessageType> {
    public static final JT808_Message_Content_Passthrough_MessageType JT808_Passthrough_Message_0x00 = new JT808_Message_Content_Passthrough_MessageType("JT808_Passthrough_Message_0x00", 0x00, V2013, "GNSS模块详细定位数据");
    public static final JT808_Message_Content_Passthrough_MessageType JT808_Passthrough_Message_0x0B = new JT808_Message_Content_Passthrough_MessageType("JT808_Passthrough_Message_0x0B", 0x0B, V2013, "道路运输证IC卡信息");
    public static final JT808_Message_Content_Passthrough_MessageType JT808_Passthrough_Message_0x41 = new JT808_Message_Content_Passthrough_MessageType("JT808_Passthrough_Message_0x41", 0x41, V2013, "串口1透传");
    public static final JT808_Message_Content_Passthrough_MessageType JT808_Passthrough_Message_0x42 = new JT808_Message_Content_Passthrough_MessageType("JT808_Passthrough_Message_0x42", 0x42, V2013, "串口2透传");

    /**
     * 透传消息ID名称
     */
    @JsonIgnore
    private String name;
    /**
     * 透传消息ID值
     */
    @JsonInclude
    @JsonSerialize(using = IntegerToHex2StringSerializer.class, as = Object.class)
    private Integer value;
    /**
     * 透传消息ID来自版本
     */
    @JsonIgnore
    private IProtocolVersion since;
    /**
     * 透传消息ID描述
     */
    @JsonIgnore
    private String description;

    public JT808_Message_Content_Passthrough_MessageType(String name, int value, IProtocolVersion since, String description) {
        this.name = name;
        this.value = value;
        this.since = since;
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
        if (!(obj instanceof JT808_Message_Content_Passthrough_MessageType)) {
            return false;
        }
        return this.getValue().equals(((JT808_Message_Content_Passthrough_MessageType) obj).getValue());
    }

    @Override
    public int compareTo(JT808_Message_Content_Passthrough_MessageType o) {
        return this.getValue().compareTo(o.getValue());
    }

    private static final Map<Integer, JT808_Message_Content_Passthrough_MessageType> mapping = new HashMap<>();
    private static final Map<Integer, JT808_Message_Content_Passthrough_MessageType> extensions = new HashMap<>();

    static {
        mapping.put(JT808_Passthrough_Message_0x00.getValue(), JT808_Passthrough_Message_0x00);
        mapping.put(JT808_Passthrough_Message_0x0B.getValue(), JT808_Passthrough_Message_0x0B);
        mapping.put(JT808_Passthrough_Message_0x41.getValue(), JT808_Passthrough_Message_0x41);
        mapping.put(JT808_Passthrough_Message_0x42.getValue(), JT808_Passthrough_Message_0x42);
    }

    public static JT808_Message_Content_Passthrough_MessageType cast(int value) {
        JT808_Message_Content_Passthrough_MessageType item = tryCast(value);
        if (item == null) {
            throw new UnsupportedJT808MessageException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808_Message_Content_Passthrough_MessageType.class.getSimpleName()));
        }
        return item;
    }

    public static JT808_Message_Content_Passthrough_MessageType tryCast(int value) {
        JT808_Message_Content_Passthrough_MessageType item = mapping.get(value);
        if (item == null) {
            item = extensions.get(value);
        }
        return item;
    }

    public static boolean exists(int value) {
        return tryCast(value) != null;
    }

    public static List<JT808_Message_Content_Passthrough_MessageType> list() {
        List<JT808_Message_Content_Passthrough_MessageType> l = new ArrayList<>(mapping.values());
        l.addAll(extensions.values());
        return l;
    }

    public static void putExtensions(List<JT808_Message_Content_Passthrough_MessageType> messages) {
        messages.forEach(i -> extensions.put(i.getValue(), i));
    }
}
