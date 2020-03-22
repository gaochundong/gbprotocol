package ai.sangmado.gbprotocol.jt905.protocol.enums;

import ai.sangmado.gbprotocol.gbcommon.enums.IMessageId;
import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbprotocol.jt905.protocol.exceptions.UnsupportedJT905MessageException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ai.sangmado.gbprotocol.jt905.protocol.enums.JT905ProtocolVersion.V2014;

/**
 * JT/T 905 消息ID
 */
@Getter
@Setter
public class JT905MessageId implements IMessageId {
    public static final JT905MessageId JT905_Message_0x0001 = new JT905MessageId("JT905_Message_0x0001", 0x0001, V2014, "ISU通用应答");
    public static final JT905MessageId JT905_Message_0x8001 = new JT905MessageId("JT905_Message_0x8001", 0x8001, V2014, "中心通用应答");

    /**
     * 消息ID名称
     */
    private String name;
    /**
     * 消息ID值
     */
    private Integer value;
    /**
     * 消息ID来自版本
     */
    private IProtocolVersion since;
    /**
     * 消息ID描述
     */
    private String description;

    public JT905MessageId(String name, int value, IProtocolVersion since, String description) {
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
        if (!(obj instanceof JT905MessageId)) {
            return false;
        }
        return this.getValue().equals(((JT905MessageId) obj).getValue());
    }

    @Override
    public int compareTo(IMessageId o) {
        return this.getValue().compareTo(o.getValue());
    }

    private static final Map<Integer, JT905MessageId> mapping = new HashMap<>();
    private static final Map<Integer, JT905MessageId> extensions = new HashMap<>();

    static {
        mapping.put(JT905_Message_0x0001.getValue(), JT905_Message_0x0001);
        mapping.put(JT905_Message_0x8001.getValue(), JT905_Message_0x8001);
    }

    public static JT905MessageId cast(int value) {
        JT905MessageId item = tryCast(value);
        if (item == null) {
            throw new UnsupportedJT905MessageException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT905MessageId.class.getSimpleName()));
        }
        return item;
    }

    public static JT905MessageId tryCast(int value) {
        JT905MessageId item = mapping.get(value);
        if (item == null) {
            item = extensions.get(value);
        }
        return item;
    }

    public static boolean exists(int value) {
        return tryCast(value) != null;
    }

    public static List<JT905MessageId> list() {
        List<JT905MessageId> l = new ArrayList<>(mapping.values());
        l.addAll(extensions.values());
        return l;
    }

    public static void putExtensions(List<JT905MessageId> messages) {
        messages.forEach(i -> extensions.put(i.getValue(), i));
    }
}
