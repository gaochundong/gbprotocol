package ai.sangmado.gbprotocol.jt905.protocol.enums;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbprotocol.jt905.protocol.exceptions.UnsupportedJT905ProtocolVersionException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * JT/T 905 协议版本
 */
@Getter
@Setter
public class JT905ProtocolVersion implements IProtocolVersion {
    public static final JT905ProtocolVersion V2014 = new JT905ProtocolVersion("V2014", 2014, "JT/T 905 2014 版本");

    @JsonIgnore
    private String name;

    @JsonInclude
    private Integer value;

    @JsonIgnore
    private String description;

    public JT905ProtocolVersion(String name, int value, String description) {
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
        if (!(obj instanceof JT905ProtocolVersion)) {
            return false;
        }
        return this.getValue().equals(((JT905ProtocolVersion) obj).getValue());
    }

    @Override
    public int compareTo(IProtocolVersion o) {
        return this.getValue().compareTo(o.getValue());
    }

    private static final Map<Integer, JT905ProtocolVersion> mapping = new HashMap<>();

    static {
        mapping.put(V2014.getValue(), V2014);
    }

    public static JT905ProtocolVersion cast(int value) {
        JT905ProtocolVersion item = tryCast(value);
        if (item == null) {
            throw new UnsupportedJT905ProtocolVersionException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT905ProtocolVersion.class.getSimpleName()));
        }
        return item;
    }

    public static JT905ProtocolVersion tryCast(int value) {
        return mapping.get(value);
    }

    public static boolean exists(int value) {
        return tryCast(value) != null;
    }
}
