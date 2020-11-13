package ai.sangmado.gbprotocol.jt808.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * JT/T 808 扩展车辆IO状态位
 */
@Getter
public enum JT808VehicleExtendedIOState {
    JT808_Vehicle_ExtendedIOState_0(0, JT808ProtocolVersion.V2013, "1：深度休眠状态"),
    JT808_Vehicle_ExtendedIOState_1(1 << 1, JT808ProtocolVersion.V2013, "1：休眠状态"),
    ;

    @JsonInclude
    @JsonValue
    private final Integer value;

    @JsonIgnore
    private final JT808ProtocolVersion since;

    @JsonIgnore
    private final String description;

    JT808VehicleExtendedIOState(int value, JT808ProtocolVersion since, String description) {
        this.value = value;
        this.since = since;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808VehicleExtendedIOState> mapping = new HashMap<>();

    static {
        for (JT808VehicleExtendedIOState item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808VehicleExtendedIOState cast(int value) {
        JT808VehicleExtendedIOState item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808VehicleExtendedIOState.class.getSimpleName()));
        }
        return item;
    }

    public static JT808VehicleExtendedIOState parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808VehicleExtendedIOState item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
