package ai.sangmado.gbprotocol.jt1078.protocol.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 音视频实时传输控制关闭音视频类型
 */
@Getter
public enum ChannelCloseKind {
    CloseChannel(0, "关闭该通道有关的音视频数据"),
    CloseAudioOnly(1, "只关闭该通道有关的音频，保留该通道有关的视频"),
    CloseVideoOnly(2, "只关闭该通道有关的视频，保留该通道有关的音频"),
    ;

    @JsonInclude
    @JsonValue
    private Integer value;

    @JsonIgnore
    private String description;

    ChannelCloseKind(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, ChannelCloseKind> mapping = new HashMap<>();

    static {
        for (ChannelCloseKind level : values()) {
            mapping.put(level.getValue(), level);
        }
    }

    @JsonCreator
    public static ChannelCloseKind cast(int i) {
        ChannelCloseKind level = mapping.get(i);
        if (level == null) {
            throw new IllegalArgumentException("Cannot cast integer to enum.");
        }
        return level;
    }

    public static ChannelCloseKind parse(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        for (ChannelCloseKind level : values()) {
            if (level.name().equalsIgnoreCase(s)) {
                return level;
            }
        }
        throw new IllegalArgumentException("Cannot parse string to enum.");
    }
}