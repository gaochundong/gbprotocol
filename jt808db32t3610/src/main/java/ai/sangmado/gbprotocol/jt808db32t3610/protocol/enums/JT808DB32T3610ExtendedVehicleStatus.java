package ai.sangmado.gbprotocol.jt808db32t3610.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 车辆状态标志位
 */
@Getter
public enum JT808DB32T3610ExtendedVehicleStatus {
    JT808DB32T3610_ExtendedVehicleStatus_0(0, JT808DB32T3610ProtocolVersion.V2019, "ACC状态标志"),
    JT808DB32T3610_ExtendedVehicleStatus_1(1 << 1, JT808DB32T3610ProtocolVersion.V2019, "左转向状态标志"),
    JT808DB32T3610_ExtendedVehicleStatus_2(1 << 2, JT808DB32T3610ProtocolVersion.V2019, "右转向状态标志"),
    JT808DB32T3610_ExtendedVehicleStatus_3(1 << 3, JT808DB32T3610ProtocolVersion.V2019, "雨刷器状态标志"),
    JT808DB32T3610_ExtendedVehicleStatus_4(1 << 4, JT808DB32T3610ProtocolVersion.V2019, "制动状态标志"),
    JT808DB32T3610_ExtendedVehicleStatus_5(1 << 5, JT808DB32T3610ProtocolVersion.V2019, "插卡状态标志"),
    JT808DB32T3610_ExtendedVehicleStatus_10(1 << 10, JT808DB32T3610ProtocolVersion.V2019, "定位状态标志"),
    ;

    @JsonInclude
    @JsonValue
    private final Integer value;

    @JsonIgnore
    private final JT808DB32T3610ProtocolVersion since;

    @JsonIgnore
    private final String description;

    JT808DB32T3610ExtendedVehicleStatus(int value, JT808DB32T3610ProtocolVersion since, String description) {
        this.value = value;
        this.since = since;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808DB32T3610ExtendedVehicleStatus> mapping = new HashMap<>();

    static {
        for (JT808DB32T3610ExtendedVehicleStatus item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808DB32T3610ExtendedVehicleStatus cast(int value) {
        JT808DB32T3610ExtendedVehicleStatus item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808DB32T3610ExtendedVehicleStatus.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DB32T3610ExtendedVehicleStatus parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808DB32T3610ExtendedVehicleStatus item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
