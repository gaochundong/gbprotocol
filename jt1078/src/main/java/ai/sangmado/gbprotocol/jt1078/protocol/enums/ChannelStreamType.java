package ai.sangmado.gbprotocol.jt1078.protocol.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 码流类型
 */
@Getter
public enum ChannelStreamType {
    Main(0, "主码流"),
    Child(1, "子码流");

    @JsonInclude
    @JsonValue
    private Integer value;

    @JsonIgnore
    private String description;

    ChannelStreamType(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, ChannelStreamType> mapping = new HashMap<>();

    static {
        for (ChannelStreamType level : values()) {
            mapping.put(level.getValue(), level);
        }
    }

    @JsonCreator
    public static ChannelStreamType cast(int i) {
        ChannelStreamType level = mapping.get(i);
        if (level == null) {
            throw new IllegalArgumentException("Cannot cast integer to enum.");
        }
        return level;
    }

    public static ChannelStreamType parse(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        for (ChannelStreamType level : values()) {
            if (level.name().equalsIgnoreCase(s)) {
                return level;
            }
        }
        throw new IllegalArgumentException("Cannot parse string to enum.");
    }
}