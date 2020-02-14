package ai.sangmado.jt1078.protocol.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * JT/T 1078 协议版本
 */
@Getter
public enum JT1078ProtocolVersion {
    V2016(2016, "JT/T 1078 2016 版本");

    private Integer value;

    private String description;

    JT1078ProtocolVersion(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT1078ProtocolVersion> mapping = new HashMap<>();

    static {
        for (JT1078ProtocolVersion item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT1078ProtocolVersion cast(int value) {
        JT1078ProtocolVersion item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT1078ProtocolVersion.class.getSimpleName()));
        }
        return item;
    }

    public static JT1078ProtocolVersion parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT1078ProtocolVersion item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
