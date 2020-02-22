package ai.sangmado.jt809.protocol.enums;

import ai.sangmado.gbcommon.enums.IProtocolVersion;
import ai.sangmado.jt809.protocol.exceptions.UnsupportedJT809ProtocolVersionException;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * JT/T 809 协议版本
 */
@Getter
@Setter
public class JT809ProtocolVersion implements IProtocolVersion {
    public static final JT809ProtocolVersion V2011 = new JT809ProtocolVersion("V2011", 2011, "JT/T 809 2011 版本");
    public static final JT809ProtocolVersion V2013 = new JT809ProtocolVersion("V2013", 2013, "JT/T 809 2013 版本");
    public static final JT809ProtocolVersion V2019 = new JT809ProtocolVersion("V2019", 2019, "JT/T 809 2019 版本");

    private String name;

    private Integer value;

    private String description;

    public JT809ProtocolVersion(String name, int value, String description) {
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
        if (!(obj instanceof JT809ProtocolVersion)) {
            return false;
        }
        return this.getValue().equals(((JT809ProtocolVersion) obj).getValue());
    }

    @Override
    public int compareTo(IProtocolVersion o) {
        return this.getValue().compareTo(o.getValue());
    }

    private static final Map<Integer, JT809ProtocolVersion> mapping = new HashMap<>();

    static {
        mapping.put(V2011.getValue(), V2011);
        mapping.put(V2013.getValue(), V2013);
        mapping.put(V2019.getValue(), V2019);
    }

    public static JT809ProtocolVersion cast(int value) {
        JT809ProtocolVersion item = tryCast(value);
        if (item == null) {
            throw new UnsupportedJT809ProtocolVersionException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT809ProtocolVersion.class.getSimpleName()));
        }
        return item;
    }

    public static JT809ProtocolVersion tryCast(int value) {
        return mapping.get(value);
    }

    public static boolean exists(int value) {
        return tryCast(value) != null;
    }
}
