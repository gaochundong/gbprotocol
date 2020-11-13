package ai.sangmado.gbprotocol.jt1078.protocol.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 切换码流类型
 */
@Getter
public enum ChannelSwitchStreamKind {
    Main(0, "主码流"),
    Child(1, "子码流");

    @JsonInclude
    @JsonValue
    private final Integer value;

    @JsonIgnore
    private final String description;

    ChannelSwitchStreamKind(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, ChannelSwitchStreamKind> mapping = new HashMap<>();

    static {
        for (ChannelSwitchStreamKind level : values()) {
            mapping.put(level.getValue(), level);
        }
    }

    @JsonCreator
    public static ChannelSwitchStreamKind cast(int i) {
        ChannelSwitchStreamKind level = mapping.get(i);
        if (level == null) {
            throw new IllegalArgumentException("Cannot cast integer to enum.");
        }
        return level;
    }

    public static ChannelSwitchStreamKind parse(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        for (ChannelSwitchStreamKind level : values()) {
            if (level.name().equalsIgnoreCase(s)) {
                return level;
            }
        }
        throw new IllegalArgumentException("Cannot parse string to enum.");
    }
}