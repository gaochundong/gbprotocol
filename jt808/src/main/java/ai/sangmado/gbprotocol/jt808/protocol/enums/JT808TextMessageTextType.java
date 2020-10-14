package ai.sangmado.gbprotocol.jt808.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * JT/T 808 文本信息文本类型
 */
@Getter
public enum JT808TextMessageTextType {
    Notification(1, JT808ProtocolVersion.V2019, "通知"),
    Service(2, JT808ProtocolVersion.V2019, "服务"),
    ;

    @JsonInclude
    private final Integer value;

    @JsonIgnore
    private final JT808ProtocolVersion since;

    @JsonIgnore
    private final String description;

    JT808TextMessageTextType(int value, JT808ProtocolVersion since, String description) {
        this.value = value;
        this.since = since;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808TextMessageTextType> mapping = new HashMap<>();

    static {
        for (JT808TextMessageTextType item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808TextMessageTextType cast(int value) {
        JT808TextMessageTextType item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808TextMessageTextType.class.getSimpleName()));
        }
        return item;
    }

    public static JT808TextMessageTextType parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808TextMessageTextType item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
