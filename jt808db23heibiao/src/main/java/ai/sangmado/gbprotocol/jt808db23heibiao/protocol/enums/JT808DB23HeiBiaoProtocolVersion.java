package ai.sangmado.gbprotocol.jt808db23heibiao.protocol.enums;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbprotocol.jt808db23heibiao.protocol.exceptions.UnsupportedJT808DB23HeiBiaoProtocolVersionException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 黑标 协议版本
 */
@Getter
@Setter
public class JT808DB23HeiBiaoProtocolVersion implements IProtocolVersion {
    public static final JT808DB23HeiBiaoProtocolVersion V2020 = new JT808DB23HeiBiaoProtocolVersion("V2020", 2020, "黑标 2020 版本");

    @JsonIgnore
    private String name;

    @JsonInclude
    private Integer value;

    @JsonIgnore
    private String description;

    public JT808DB23HeiBiaoProtocolVersion(String name, int value, String description) {
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
        if (!(obj instanceof JT808DB23HeiBiaoProtocolVersion)) {
            return false;
        }
        return this.getValue().equals(((JT808DB23HeiBiaoProtocolVersion) obj).getValue());
    }

    @Override
    public int compareTo(IProtocolVersion o) {
        return this.getValue().compareTo(o.getValue());
    }

    private static final Map<Integer, JT808DB23HeiBiaoProtocolVersion> mapping = new HashMap<>();

    static {
        mapping.put(V2020.getValue(), V2020);
    }

    public static JT808DB23HeiBiaoProtocolVersion cast(int value) {
        JT808DB23HeiBiaoProtocolVersion item = mapping.get(value);
        if (item == null) {
            throw new UnsupportedJT808DB23HeiBiaoProtocolVersionException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808DB23HeiBiaoProtocolVersion.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DB23HeiBiaoProtocolVersion tryCast(int value) {
        return mapping.get(value);
    }

    public static boolean isInstanceOf(int value) {
        return tryCast(value) != null;
    }
}
