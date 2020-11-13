package ai.sangmado.gbprotocol.jt808.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * JT/T 808 多媒体类型
 */
@Getter
public enum JT808MediaDataType {
    Image(0, JT808ProtocolVersion.V2011, "图像"),
    Audio(1, JT808ProtocolVersion.V2011, "音频"),
    Video(2, JT808ProtocolVersion.V2011, "视频"),
    ;

    @JsonInclude
    @JsonValue
    private final Integer value;

    @JsonIgnore
    private final JT808ProtocolVersion since;

    @JsonIgnore
    private final String description;

    JT808MediaDataType(int value, JT808ProtocolVersion since, String description) {
        this.value = value;
        this.since = since;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808MediaDataType> mapping = new HashMap<>();

    static {
        for (JT808MediaDataType item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808MediaDataType cast(int value) {
        JT808MediaDataType item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808MediaDataType.class.getSimpleName()));
        }
        return item;
    }

    public static JT808MediaDataType parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808MediaDataType item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
