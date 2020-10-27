package ai.sangmado.gbprotocol.jt808db32t3610.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 偏离类型
 */
@Getter
public enum JT808DB32T3610ExtendedWarningRoadSignType {
    None(0x00, JT808DB32T3610ProtocolVersion.V2019, "无效"),
    SpeedLimit(0x01, JT808DB32T3610ProtocolVersion.V2019, "限速标志"),
    HighLimit(0x02, JT808DB32T3610ProtocolVersion.V2019, "限高标志"),
    WeightLimit(0x03, JT808DB32T3610ProtocolVersion.V2019, "限重标志"),
    ;

    @JsonInclude
    private final Integer value;

    @JsonIgnore
    private final JT808DB32T3610ProtocolVersion since;

    @JsonIgnore
    private final String description;

    JT808DB32T3610ExtendedWarningRoadSignType(int value, JT808DB32T3610ProtocolVersion since, String description) {
        this.value = value;
        this.since = since;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808DB32T3610ExtendedWarningRoadSignType> mapping = new HashMap<>();

    static {
        for (JT808DB32T3610ExtendedWarningRoadSignType item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808DB32T3610ExtendedWarningRoadSignType cast(int value) {
        JT808DB32T3610ExtendedWarningRoadSignType item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808DB32T3610ExtendedWarningRoadSignType.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DB32T3610ExtendedWarningRoadSignType parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808DB32T3610ExtendedWarningRoadSignType item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
