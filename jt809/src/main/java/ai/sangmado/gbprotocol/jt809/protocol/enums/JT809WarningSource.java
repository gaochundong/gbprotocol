package ai.sangmado.gbprotocol.jt809.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * JT/T 809 报警信息来源
 */
@Getter
public enum JT809WarningSource {
    VehicleBox(0, "车载终端"),
    EnterprisePlatform(1, "企业监控平台"),
    GovernmentPlatform(1, "政府监管平台"),
    Others(1, "其他");

    @JsonInclude
    @JsonValue
    private final Integer value;

    @JsonIgnore
    private final String description;

    JT809WarningSource(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT809WarningSource> mapping = new HashMap<>();

    static {
        for (JT809WarningSource item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT809WarningSource cast(int value) {
        JT809WarningSource item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT809WarningSource.class.getSimpleName()));
        }
        return item;
    }

    public static JT809WarningSource parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT809WarningSource item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
