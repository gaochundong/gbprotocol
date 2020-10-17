package ai.sangmado.gbprotocol.jt808db22jibiao.protocol.enums;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbprotocol.jt808db22jibiao.protocol.exceptions.UnsupportedJT808DB22JiBiaoProtocolVersionException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 吉标 协议版本
 */
@Getter
@Setter
public class JT808DB22JiBiaoProtocolVersion implements IProtocolVersion {
    public static final JT808DB22JiBiaoProtocolVersion V2019 = new JT808DB22JiBiaoProtocolVersion("V2019", 2019, "吉标 2019 版本");

    @JsonIgnore
    private String name;

    @JsonInclude
    private Integer value;

    @JsonIgnore
    private String description;

    public JT808DB22JiBiaoProtocolVersion(String name, int value, String description) {
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
        if (!(obj instanceof JT808DB22JiBiaoProtocolVersion)) {
            return false;
        }
        return this.getValue().equals(((JT808DB22JiBiaoProtocolVersion) obj).getValue());
    }

    @Override
    public int compareTo(IProtocolVersion o) {
        return this.getValue().compareTo(o.getValue());
    }

    private static final Map<Integer, JT808DB22JiBiaoProtocolVersion> mapping = new HashMap<>();

    static {
        mapping.put(V2019.getValue(), V2019);
    }

    public static JT808DB22JiBiaoProtocolVersion cast(int value) {
        JT808DB22JiBiaoProtocolVersion item = mapping.get(value);
        if (item == null) {
            throw new UnsupportedJT808DB22JiBiaoProtocolVersionException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808DB22JiBiaoProtocolVersion.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DB22JiBiaoProtocolVersion tryCast(int value) {
        return mapping.get(value);
    }

    public static boolean isInstanceOf(int value) {
        return tryCast(value) != null;
    }
}
