package ai.sangmado.gbprotocol.jt808.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * JT/T 808 车牌颜色
 *
 * @since V2011 版本 按照 JT/T415-2006 的 5.4.12。未上牌时，取值为 0。
 * @since V2013 版本 按照 JT/T415-2006 的 5.4.12。未上牌时，取值为 0。
 * @since V2019 版本 按照 JT/T697.7-2014 中的规定。未上牌时，取值为 0。
 */
@Getter
public enum JT808VehiclePlateColor {
    JT808_Vehicle_Color_NoPlate(0x00, JT808ProtocolVersion.V2011, "未上牌"),
    JT808_Vehicle_Color_Blue(0x01, JT808ProtocolVersion.V2011, "蓝色"),
    JT808_Vehicle_Color_Yellow(0x02, JT808ProtocolVersion.V2011, "黄色"),
    JT808_Vehicle_Color_Black(0x03, JT808ProtocolVersion.V2011, "黑色"),
    JT808_Vehicle_Color_White(0x04, JT808ProtocolVersion.V2011, "白色"),
    JT808_Vehicle_Color_Green(0x05, JT808ProtocolVersion.V2011, "绿色"),
    JT808_Vehicle_Color_YellowGreen(0x06, JT808ProtocolVersion.V2011, "黄绿色"),
    JT808_Vehicle_Color_Other(0x09, JT808ProtocolVersion.V2011, "其它"),
    ;

    @JsonInclude
    private final Integer value;

    @JsonIgnore
    private final JT808ProtocolVersion since;

    @JsonIgnore
    private final String description;

    JT808VehiclePlateColor(int value, JT808ProtocolVersion since, String description) {
        this.value = value;
        this.since = since;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808VehiclePlateColor> mapping = new HashMap<>();

    static {
        for (JT808VehiclePlateColor item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808VehiclePlateColor cast(int value) {
        JT808VehiclePlateColor item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808VehiclePlateColor.class.getSimpleName()));
        }
        return item;
    }

    public static Optional<JT808VehiclePlateColor> tryCast(int value) {
        JT808VehiclePlateColor item = mapping.get(value);
        return Optional.ofNullable(item);
    }

    public static JT808VehiclePlateColor parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808VehiclePlateColor item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
