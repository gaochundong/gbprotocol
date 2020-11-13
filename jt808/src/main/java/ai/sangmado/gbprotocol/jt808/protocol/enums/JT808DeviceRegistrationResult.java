package ai.sangmado.gbprotocol.jt808.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 终端注册结果
 */
@Getter
public enum JT808DeviceRegistrationResult {
    Success(0x00, JT808ProtocolVersion.V2011, "成功"),
    VehicleAlreadyRegistered(0x01, JT808ProtocolVersion.V2011, "车辆已被注册"),
    NoVehicleWithinDatabase(0x02, JT808ProtocolVersion.V2011, "数据库中无该车辆"),
    DeviceAlreadyRegistered(0x03, JT808ProtocolVersion.V2011, "终端已被注册"),
    NoDeviceWithinDatabase(0x04, JT808ProtocolVersion.V2011, "数据库中无该终端"),
    ;

    @JsonInclude
    @JsonValue
    private final Integer value;

    @JsonIgnore
    private final JT808ProtocolVersion since;

    @JsonIgnore
    private final String description;

    JT808DeviceRegistrationResult(int value, JT808ProtocolVersion since, String description) {
        this.value = value;
        this.since = since;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808DeviceRegistrationResult> mapping = new HashMap<>();

    static {
        for (JT808DeviceRegistrationResult item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808DeviceRegistrationResult cast(int value) {
        JT808DeviceRegistrationResult item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808DeviceRegistrationResult.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DeviceRegistrationResult parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808DeviceRegistrationResult item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
