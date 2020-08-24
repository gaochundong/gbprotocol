package ai.sangmado.gbprotocol.jt808db51chuanbiao.protocol.enums;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbprotocol.jt808db51chuanbiao.protocol.exceptions.UnsupportedJT808DB51ChuanBiaoProtocolVersionException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 川标 协议版本
 */
@Getter
@Setter
public class JT808DB51ChuanBiaoProtocolVersion implements IProtocolVersion {
    public static final JT808DB51ChuanBiaoProtocolVersion V2019 = new JT808DB51ChuanBiaoProtocolVersion("V2019", 2019, "川标 2019 版本");

    @JsonIgnore
    private String name;

    @JsonInclude
    private Integer value;

    @JsonIgnore
    private String description;

    public JT808DB51ChuanBiaoProtocolVersion(String name, int value, String description) {
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
        if (!(obj instanceof JT808DB51ChuanBiaoProtocolVersion)) {
            return false;
        }
        return this.getValue().equals(((JT808DB51ChuanBiaoProtocolVersion) obj).getValue());
    }

    @Override
    public int compareTo(IProtocolVersion o) {
        return this.getValue().compareTo(o.getValue());
    }

    private static final Map<Integer, JT808DB51ChuanBiaoProtocolVersion> mapping = new HashMap<>();

    static {
        mapping.put(V2019.getValue(), V2019);
    }

    public static JT808DB51ChuanBiaoProtocolVersion cast(int value) {
        JT808DB51ChuanBiaoProtocolVersion item = mapping.get(value);
        if (item == null) {
            throw new UnsupportedJT808DB51ChuanBiaoProtocolVersionException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808DB51ChuanBiaoProtocolVersion.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DB51ChuanBiaoProtocolVersion tryCast(int value) {
        return mapping.get(value);
    }

    public static boolean isInstanceOf(int value) {
        return tryCast(value) != null;
    }
}
