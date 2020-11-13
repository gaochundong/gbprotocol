package ai.sangmado.gbprotocol.jt1078.protocol.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据类型
 */
@Getter
public enum StreamingDataType {
    AV(0, "音视频"),
    Video(1, "视频"),
    VoiceIntercom(2, "双向对讲"),
    Monitor(3, "监听"),
    Broadcast(4, "中心广播"),
    PassThrough(5, "透传"),
    ;

    @JsonInclude
    @JsonValue
    private final Integer value;

    @JsonIgnore
    private final String description;

    StreamingDataType(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, StreamingDataType> mapping = new HashMap<>();

    static {
        for (StreamingDataType level : values()) {
            mapping.put(level.getValue(), level);
        }
    }

    @JsonCreator
    public static StreamingDataType cast(int i) {
        StreamingDataType level = mapping.get(i);
        if (level == null) {
            throw new IllegalArgumentException("Cannot cast integer to enum.");
        }
        return level;
    }

    public static StreamingDataType parse(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        for (StreamingDataType level : values()) {
            if (level.name().equalsIgnoreCase(s)) {
                return level;
            }
        }
        throw new IllegalArgumentException("Cannot parse string to enum.");
    }
}