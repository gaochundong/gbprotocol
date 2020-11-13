package ai.sangmado.gbprotocol.jt1078.protocol.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 音视频实时传输控制指令
 */
@Getter
public enum ChannelControlCommand {
    CloseChannel(0, "关闭音视频传输指令"),
    SwitchStreamType(1, "切换码流（增加暂停和继续）"),
    PauseChannel(2, "暂停该通道所有流的发送"),
    ResumeChannel(3, "恢复暂停前流的发送,与暂停前的流类型一致"),
    StopVoiceIntercom(4, "关闭双向对讲"),
    ;

    @JsonInclude
    @JsonValue
    private final Integer value;

    @JsonIgnore
    private final String description;

    ChannelControlCommand(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, ChannelControlCommand> mapping = new HashMap<>();

    static {
        for (ChannelControlCommand level : values()) {
            mapping.put(level.getValue(), level);
        }
    }

    @JsonCreator
    public static ChannelControlCommand cast(int i) {
        ChannelControlCommand level = mapping.get(i);
        if (level == null) {
            throw new IllegalArgumentException("Cannot cast integer to enum.");
        }
        return level;
    }

    public static ChannelControlCommand parse(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        for (ChannelControlCommand level : values()) {
            if (level.name().equalsIgnoreCase(s)) {
                return level;
            }
        }
        throw new IllegalArgumentException("Cannot parse string to enum.");
    }
}