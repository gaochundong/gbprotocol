package ai.sangmado.jt808.protocol.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * JT/T 808 协议版本
 */
@Getter
public enum JT808ProtocolVersion {
    V2011(2011, "JT/T 808 2011 版本"),
    V2013(2013, "JT/T 808 2013 版本"),
    V2019(2019, "JT/T 808 2019 版本");

    private Integer value;

    private String description;

    JT808ProtocolVersion(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808ProtocolVersion> mapping = new HashMap<>();

    static {
        for (JT808ProtocolVersion item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808ProtocolVersion cast(int value) {
        JT808ProtocolVersion item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808ProtocolVersion.class.getSimpleName()));
        }
        return item;
    }

    public static JT808ProtocolVersion parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808ProtocolVersion item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
