package ai.sangmado.jt808.protocol.enums;

import ai.sangmado.jt808.protocol.exceptions.UnsupportedJT808ProtocolVersionException;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * JT/T 808 协议版本
 */
@Getter
@Setter
public class JT808ProtocolVersion implements IProtocolVersion {
    public static final JT808ProtocolVersion V2011 = new JT808ProtocolVersion("V2011", 2011, "JT/T 808 2011 版本");
    public static final JT808ProtocolVersion V2013 = new JT808ProtocolVersion("V2013", 2013, "JT/T 808 2013 版本");
    public static final JT808ProtocolVersion V2019 = new JT808ProtocolVersion("V2019", 2019, "JT/T 808 2019 版本");

    private String name;

    private Integer value;

    private String description;

    public JT808ProtocolVersion(String name, int value, String description) {
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
        if (!(obj instanceof JT808ProtocolVersion)) {
            return false;
        }
        return this.getValue().equals(((JT808ProtocolVersion) obj).getValue());
    }

    @Override
    public int compareTo(IProtocolVersion o) {
        return this.getValue().compareTo(o.getValue());
    }

    private static final Map<Integer, JT808ProtocolVersion> mapping = new HashMap<>();

    static {
        mapping.put(V2011.getValue(), V2011);
        mapping.put(V2013.getValue(), V2013);
        mapping.put(V2019.getValue(), V2019);
    }

    public static JT808ProtocolVersion cast(int value) {
        JT808ProtocolVersion item = tryCast(value);
        if (item == null) {
            throw new UnsupportedJT808ProtocolVersionException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808ProtocolVersion.class.getSimpleName()));
        }
        return item;
    }

    public static JT808ProtocolVersion tryCast(int value) {
        return mapping.get(value);
    }

    public static boolean exists(int value) {
        return tryCast(value) != null;
    }
}
