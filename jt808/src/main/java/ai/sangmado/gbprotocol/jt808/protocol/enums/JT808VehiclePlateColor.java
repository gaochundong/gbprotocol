package ai.sangmado.gbprotocol.jt808.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * JT/T 808 车牌颜色
 *
 * @since V2011 版本 按照 JT/T415-2006《道路运输电子政务平台 编目编码规则》的 5.4.12。未上牌时，取值为 0。
 * @since V2013 版本 按照 JT/T415-2006《道路运输电子政务平台 编目编码规则》的 5.4.12。未上牌时，取值为 0。
 * @since V2019 版本 按照 JT/T697.7-2014《交通信息基础数据元 第7部分：道路运输信息基础数据元》的 5.6。未上牌时，取值为 0。
 */
@Getter
public enum JT808VehiclePlateColor {
    JT808_Vehicle_Color_NoPlate(0, JT808ProtocolVersion.V2011, "未上牌", "无标准"),
    JT808_Vehicle_Color_Blue(1, JT808ProtocolVersion.V2011, "蓝色", "JT/T415-2006, JT/T697.7-2014"),
    JT808_Vehicle_Color_Yellow(2, JT808ProtocolVersion.V2011, "黄色", "JT/T415-2006, JT/T697.7-2014"),
    JT808_Vehicle_Color_Black(3, JT808ProtocolVersion.V2011, "黑色", "JT/T415-2006, JT/T697.7-2014"),
    JT808_Vehicle_Color_White(4, JT808ProtocolVersion.V2011, "白色", "JT/T415-2006, JT/T697.7-2014"),
    JT808_Vehicle_Color_Green(5, JT808ProtocolVersion.V2019, "绿色", "JT/T697.7-2014"),
    JT808_Vehicle_Color_Other(9, JT808ProtocolVersion.V2011, "其它", "JT/T415-2006, JT/T697.7-2014"),
    ;

    @JsonInclude
    @JsonValue
    private final Integer value;

    @JsonIgnore
    private final JT808ProtocolVersion since;

    @JsonIgnore
    private final String description;

    @JsonIgnore
    private final String reference;

    JT808VehiclePlateColor(int value, JT808ProtocolVersion since, String description, String reference) {
        this.value = value;
        this.since = since;
        this.description = description;
        this.reference = reference;
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
