package ai.sangmado.gbprotocol.jt808.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * JT/T 808 扩展车辆信号状态位
 */
@Getter
public enum JT808VehicleExtendedSignalState {
    JT808_Vehicle_ExtendedSignalState_0(0, JT808ProtocolVersion.V2013, "1：近光灯信号"),
    JT808_Vehicle_ExtendedSignalState_1(1 << 1, JT808ProtocolVersion.V2013, "1：远光灯信号"),
    JT808_Vehicle_ExtendedSignalState_2(1 << 2, JT808ProtocolVersion.V2013, "1：右转向灯信号"),
    JT808_Vehicle_ExtendedSignalState_3(1 << 3, JT808ProtocolVersion.V2013, "1：左转向灯信号"),
    JT808_Vehicle_ExtendedSignalState_4(1 << 4, JT808ProtocolVersion.V2013, "1：制动信号"),
    JT808_Vehicle_ExtendedSignalState_5(1 << 5, JT808ProtocolVersion.V2013, "1：倒档信号"),
    JT808_Vehicle_ExtendedSignalState_6(1 << 6, JT808ProtocolVersion.V2013, "1：雾灯信号"),
    JT808_Vehicle_ExtendedSignalState_7(1 << 7, JT808ProtocolVersion.V2013, "1：示廓灯"),
    JT808_Vehicle_ExtendedSignalState_8(1 << 8, JT808ProtocolVersion.V2013, "1：喇叭信号"),
    JT808_Vehicle_ExtendedSignalState_9(1 << 9, JT808ProtocolVersion.V2013, "1：空调状态"),
    JT808_Vehicle_ExtendedSignalState_10(1 << 10, JT808ProtocolVersion.V2013, "1：空挡信号"),
    JT808_Vehicle_ExtendedSignalState_11(1 << 11, JT808ProtocolVersion.V2013, "1：缓速器工作"),
    JT808_Vehicle_ExtendedSignalState_12(1 << 12, JT808ProtocolVersion.V2013, "1：ABS 工作"),
    JT808_Vehicle_ExtendedSignalState_13(1 << 13, JT808ProtocolVersion.V2013, "1：加热器工作"),
    JT808_Vehicle_ExtendedSignalState_14(1 << 14, JT808ProtocolVersion.V2013, "1：离合器状态"),
    ;

    @JsonInclude
    private final Integer value;

    @JsonIgnore
    private final JT808ProtocolVersion since;

    @JsonIgnore
    private final String description;

    JT808VehicleExtendedSignalState(int value, JT808ProtocolVersion since, String description) {
        this.value = value;
        this.since = since;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808VehicleExtendedSignalState> mapping = new HashMap<>();

    static {
        for (JT808VehicleExtendedSignalState item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808VehicleExtendedSignalState cast(int value) {
        JT808VehicleExtendedSignalState item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808VehicleExtendedSignalState.class.getSimpleName()));
        }
        return item;
    }

    public static JT808VehicleExtendedSignalState parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808VehicleExtendedSignalState item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
