package ai.sangmado.gbprotocol.jt808db32t3610.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 变道决策辅助系统 - 报警/事件类型
 */
@Getter
public enum JT808DB32T3610ExtendedLaneChangingAssistWarningType {
    LCA_Rear(0x01, JT808DB32T3610ProtocolVersion.V2019, "后方接近报警"),
    LCA_LeftRear(0x02, JT808DB32T3610ProtocolVersion.V2019, "左侧后方接近报警"),
    LCA_RightRear(0x03, JT808DB32T3610ProtocolVersion.V2019, "右侧后方接近报警"),
    ;

    @JsonInclude
    @JsonValue
    private final Integer value;

    @JsonIgnore
    private final JT808DB32T3610ProtocolVersion since;

    @JsonIgnore
    private final String description;

    JT808DB32T3610ExtendedLaneChangingAssistWarningType(int value, JT808DB32T3610ProtocolVersion since, String description) {
        this.value = value;
        this.since = since;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808DB32T3610ExtendedLaneChangingAssistWarningType> mapping = new HashMap<>();

    static {
        for (JT808DB32T3610ExtendedLaneChangingAssistWarningType item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808DB32T3610ExtendedLaneChangingAssistWarningType cast(int value) {
        JT808DB32T3610ExtendedLaneChangingAssistWarningType item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808DB32T3610ExtendedLaneChangingAssistWarningType.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DB32T3610ExtendedLaneChangingAssistWarningType parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808DB32T3610ExtendedLaneChangingAssistWarningType item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
