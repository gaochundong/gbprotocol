package ai.sangmado.gbprotocol.jt808db37t6666.protocol.enums;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbprotocol.jt808db37t6666.protocol.exceptions.UnsupportedJT808DB37T6666ProtocolVersionException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 鲁标 协议版本
 */
@Getter
@Setter
public class JT808DB37T6666ProtocolVersion implements IProtocolVersion {
    public static final JT808DB37T6666ProtocolVersion V2020 = new JT808DB37T6666ProtocolVersion("V2020", 2020, "鲁标 2020 版本");

    @JsonIgnore
    private String name;

    @JsonInclude
    private Integer value;

    @JsonIgnore
    private String description;

    public JT808DB37T6666ProtocolVersion(String name, int value, String description) {
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
        if (!(obj instanceof JT808DB37T6666ProtocolVersion)) {
            return false;
        }
        return this.getValue().equals(((JT808DB37T6666ProtocolVersion) obj).getValue());
    }

    @Override
    public int compareTo(IProtocolVersion o) {
        return this.getValue().compareTo(o.getValue());
    }

    private static final Map<Integer, JT808DB37T6666ProtocolVersion> mapping = new HashMap<>();

    static {
        mapping.put(V2020.getValue(), V2020);
    }

    public static JT808DB37T6666ProtocolVersion cast(int value) {
        JT808DB37T6666ProtocolVersion item = mapping.get(value);
        if (item == null) {
            throw new UnsupportedJT808DB37T6666ProtocolVersionException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808DB37T6666ProtocolVersion.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DB37T6666ProtocolVersion tryCast(int value) {
        return mapping.get(value);
    }

    public static boolean isInstanceOf(int value) {
        return tryCast(value) != null;
    }
}
