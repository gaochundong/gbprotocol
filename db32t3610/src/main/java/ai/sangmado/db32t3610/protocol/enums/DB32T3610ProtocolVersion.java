package ai.sangmado.db32t3610.protocol.enums;

import ai.sangmado.db32t3610.protocol.exceptions.UnsupportedDB32T3610ProtocolVersionException;
import ai.sangmado.gbcommon.enums.IProtocolVersion;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * DB32/T3610 协议版本
 */
@Getter
@Setter
public class DB32T3610ProtocolVersion implements IProtocolVersion {
    public static final DB32T3610ProtocolVersion V2019 = new DB32T3610ProtocolVersion("V2019", 2019, "DB32/T3610 2019 版本");

    private String name;

    private Integer value;

    private String description;

    public DB32T3610ProtocolVersion(String name, int value, String description) {
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
        if (!(obj instanceof DB32T3610ProtocolVersion)) {
            return false;
        }
        return this.getValue().equals(((DB32T3610ProtocolVersion) obj).getValue());
    }

    @Override
    public int compareTo(IProtocolVersion o) {
        return this.getValue().compareTo(o.getValue());
    }

    private static final Map<Integer, DB32T3610ProtocolVersion> mapping = new HashMap<>();

    static {
        mapping.put(V2019.getValue(), V2019);
    }

    public static DB32T3610ProtocolVersion cast(int value) {
        DB32T3610ProtocolVersion item = mapping.get(value);
        if (item == null) {
            throw new UnsupportedDB32T3610ProtocolVersionException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, DB32T3610ProtocolVersion.class.getSimpleName()));
        }
        return item;
    }

    public static DB32T3610ProtocolVersion tryCast(int value) {
        return mapping.get(value);
    }

    public static boolean isInstanceOf(int value) {
        return tryCast(value) != null;
    }
}
