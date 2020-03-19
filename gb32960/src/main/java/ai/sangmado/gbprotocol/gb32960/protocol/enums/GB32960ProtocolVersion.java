package ai.sangmado.gbprotocol.gb32960.protocol.enums;

import ai.sangmado.gbprotocol.gb32960.protocol.exceptions.UnsupportedGB32960ProtocolVersionException;
import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * GB/T 32960 协议版本
 */
@Getter
@Setter
public class GB32960ProtocolVersion implements IProtocolVersion {
    public static final GB32960ProtocolVersion V2016 = new GB32960ProtocolVersion("V2016", 2016, "GB/T 32960 2016 版本");

    private String name;

    private Integer value;

    private String description;

    public GB32960ProtocolVersion(String name, int value, String description) {
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
        if (!(obj instanceof GB32960ProtocolVersion)) {
            return false;
        }
        return this.getValue().equals(((GB32960ProtocolVersion) obj).getValue());
    }

    @Override
    public int compareTo(IProtocolVersion o) {
        return this.getValue().compareTo(o.getValue());
    }

    private static final Map<Integer, GB32960ProtocolVersion> mapping = new HashMap<>();

    static {
        mapping.put(V2016.getValue(), V2016);
    }

    public static GB32960ProtocolVersion cast(int value) {
        GB32960ProtocolVersion item = tryCast(value);
        if (item == null) {
            throw new UnsupportedGB32960ProtocolVersionException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, GB32960ProtocolVersion.class.getSimpleName()));
        }
        return item;
    }

    public static GB32960ProtocolVersion tryCast(int value) {
        return mapping.get(value);
    }

    public static boolean exists(int value) {
        return tryCast(value) != null;
    }
}
