package ai.sangmado.gbprotocol.jt808db32t3610.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 激烈驾驶报警 - 报警/事件类型
 */
@Getter
public enum JT808DB32T3610ExtendedIntenseDrivingWarningType {
    SuddenAcceleration(0x01, JT808DB32T3610ProtocolVersion.V2019, "急加速报警"),
    SuddenDeceleration(0x02, JT808DB32T3610ProtocolVersion.V2019, "急减速报警"),
    SuddenTurn(0x03, JT808DB32T3610ProtocolVersion.V2019, "急转弯报警"),
    Idling(0x04, JT808DB32T3610ProtocolVersion.V2019, "怠速报警"),
    AbnormalStalling(0x05, JT808DB32T3610ProtocolVersion.V2019, "异常熄火报警"),
    NeutralTaxiing(0x06, JT808DB32T3610ProtocolVersion.V2019, "空档滑行报警"),
    EngineOverturning(0x07, JT808DB32T3610ProtocolVersion.V2019, "发动机超转报警"),
    ;

    @JsonInclude
    private final Integer value;

    @JsonIgnore
    private final JT808DB32T3610ProtocolVersion since;

    @JsonIgnore
    private final String description;

    JT808DB32T3610ExtendedIntenseDrivingWarningType(int value, JT808DB32T3610ProtocolVersion since, String description) {
        this.value = value;
        this.since = since;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808DB32T3610ExtendedIntenseDrivingWarningType> mapping = new HashMap<>();

    static {
        for (JT808DB32T3610ExtendedIntenseDrivingWarningType item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808DB32T3610ExtendedIntenseDrivingWarningType cast(int value) {
        JT808DB32T3610ExtendedIntenseDrivingWarningType item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808DB32T3610ExtendedIntenseDrivingWarningType.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DB32T3610ExtendedIntenseDrivingWarningType parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808DB32T3610ExtendedIntenseDrivingWarningType item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
