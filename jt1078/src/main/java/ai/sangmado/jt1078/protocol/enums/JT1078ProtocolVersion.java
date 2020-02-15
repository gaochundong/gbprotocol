package ai.sangmado.jt1078.protocol.enums;

import ai.sangmado.jt1078.protocol.exceptions.UnsupportedJT1078ProtocolVersionException;
import ai.sangmado.jt808.protocol.enums.IProtocolVersion;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * JT/T 1078 协议版本
 */
@Getter
@Setter
public class JT1078ProtocolVersion implements IProtocolVersion {
    public static final JT1078ProtocolVersion V2016 = new JT1078ProtocolVersion("V2016", 2016, "JT/T 1078 2016 版本");

    private String name;

    private Integer value;

    private String description;

    public JT1078ProtocolVersion(String name, int value, String description) {
        this.name = name;
        this.value = value;
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
        if (!(obj instanceof JT1078ProtocolVersion)) {
            return false;
        }
        return this.getValue().equals(((JT1078ProtocolVersion) obj).getValue());
    }

    private static final Map<Integer, JT1078ProtocolVersion> mapping = new HashMap<>();

    static {
        mapping.put(V2016.getValue(), V2016);
    }

    public static JT1078ProtocolVersion cast(int value) {
        JT1078ProtocolVersion item = mapping.get(value);
        if (item == null) {
            throw new UnsupportedJT1078ProtocolVersionException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT1078ProtocolVersion.class.getSimpleName()));
        }
        return item;
    }

    public static JT1078ProtocolVersion tryCast(int value) {
        return mapping.get(value);
    }

    public static boolean isInstanceOf(int value) {
        return tryCast(value) != null;
    }
}
