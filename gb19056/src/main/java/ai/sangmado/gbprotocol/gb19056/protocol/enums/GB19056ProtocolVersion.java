package ai.sangmado.gbprotocol.gb19056.protocol.enums;

import ai.sangmado.gbprotocol.gb19056.protocol.exceptions.UnsupportedGB19056ProtocolVersionException;
import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * GB19056 协议版本
 */
@Getter
@Setter
public class GB19056ProtocolVersion implements IProtocolVersion {
    public static final GB19056ProtocolVersion V2003 = new GB19056ProtocolVersion("V2003", 2003, "GB19056 2003 版本");
    public static final GB19056ProtocolVersion V2012 = new GB19056ProtocolVersion("V2012", 2012, "GB19056 2012 版本");

    private String name;

    private Integer value;

    private String description;

    public GB19056ProtocolVersion(String name, int value, String description) {
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
        if (!(obj instanceof GB19056ProtocolVersion)) {
            return false;
        }
        return this.getValue().equals(((GB19056ProtocolVersion) obj).getValue());
    }

    @Override
    public int compareTo(IProtocolVersion o) {
        return this.getValue().compareTo(o.getValue());
    }

    private static final Map<Integer, GB19056ProtocolVersion> mapping = new HashMap<>();

    static {
        mapping.put(V2003.getValue(), V2003);
        mapping.put(V2012.getValue(), V2012);
    }

    public static GB19056ProtocolVersion cast(int value) {
        GB19056ProtocolVersion item = mapping.get(value);
        if (item == null) {
            throw new UnsupportedGB19056ProtocolVersionException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, GB19056ProtocolVersion.class.getSimpleName()));
        }
        return item;
    }

    public static GB19056ProtocolVersion tryCast(int value) {
        return mapping.get(value);
    }

    public static boolean isInstanceOf(int value) {
        return tryCast(value) != null;
    }
}
