package ai.sangmado.gbprotocol.jt808db32t3610.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 状态标志
 * <p>
 * 该字段仅适用于有开始和结束标志类型的报警和事件
 */
@Getter
public enum JT808DB32T3610ExtendedWarningSectionFlag {
    None(0x00, JT808DB32T3610ProtocolVersion.V2019, "不可用"),
    Begin(0x01, JT808DB32T3610ProtocolVersion.V2019, "开始标志"),
    End(0x02, JT808DB32T3610ProtocolVersion.V2019, "结束标志"),
    ;

    @JsonInclude
    @JsonValue
    private final Integer value;

    @JsonIgnore
    private final JT808DB32T3610ProtocolVersion since;

    @JsonIgnore
    private final String description;

    JT808DB32T3610ExtendedWarningSectionFlag(int value, JT808DB32T3610ProtocolVersion since, String description) {
        this.value = value;
        this.since = since;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808DB32T3610ExtendedWarningSectionFlag> mapping = new HashMap<>();

    static {
        for (JT808DB32T3610ExtendedWarningSectionFlag item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808DB32T3610ExtendedWarningSectionFlag cast(int value) {
        JT808DB32T3610ExtendedWarningSectionFlag item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808DB32T3610ExtendedWarningSectionFlag.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DB32T3610ExtendedWarningSectionFlag parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808DB32T3610ExtendedWarningSectionFlag item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
