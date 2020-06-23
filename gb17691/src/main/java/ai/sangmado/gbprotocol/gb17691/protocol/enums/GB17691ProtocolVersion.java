package ai.sangmado.gbprotocol.gb17691.protocol.enums;

import ai.sangmado.gbprotocol.gb17691.protocol.exceptions.UnsupportedGB17691ProtocolVersionException;
import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * GB17691 协议版本
 */
@Getter
@Setter
public class GB17691ProtocolVersion implements IProtocolVersion {
    public static final GB17691ProtocolVersion V2005 = new GB17691ProtocolVersion("V2005", 2005, "GB17691 2005 版本");
    public static final GB17691ProtocolVersion V2018 = new GB17691ProtocolVersion("V2018", 2018, "GB17691 2018 版本");

    @JsonIgnore
    private String name;

    @JsonInclude
    private Integer value;

    @JsonIgnore
    private String description;

    public GB17691ProtocolVersion(String name, int value, String description) {
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
        if (!(obj instanceof GB17691ProtocolVersion)) {
            return false;
        }
        return this.getValue().equals(((GB17691ProtocolVersion) obj).getValue());
    }

    @Override
    public int compareTo(IProtocolVersion o) {
        return this.getValue().compareTo(o.getValue());
    }

    private static final Map<Integer, GB17691ProtocolVersion> mapping = new HashMap<>();

    static {
        mapping.put(V2005.getValue(), V2005);
        mapping.put(V2018.getValue(), V2018);
    }

    public static GB17691ProtocolVersion cast(int value) {
        GB17691ProtocolVersion item = mapping.get(value);
        if (item == null) {
            throw new UnsupportedGB17691ProtocolVersionException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, GB17691ProtocolVersion.class.getSimpleName()));
        }
        return item;
    }

    public static GB17691ProtocolVersion tryCast(int value) {
        return mapping.get(value);
    }

    public static boolean isInstanceOf(int value) {
        return tryCast(value) != null;
    }
}
