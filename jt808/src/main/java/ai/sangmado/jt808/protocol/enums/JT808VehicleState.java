package ai.sangmado.jt808.protocol.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

import static ai.sangmado.jt808.protocol.enums.JT808ProtocolVersion.*;

/**
 * JT/T 808 车辆状态位定义
 */
@Getter
public enum JT808VehicleState {
    JT808_Vehicle_State_0(1, V2011, "ACC开"),
    JT808_Vehicle_State_1(1 << 1, V2011, "定位"),
    JT808_Vehicle_State_2(1 << 2, V2011, "南纬"),
    JT808_Vehicle_State_3(1 << 3, V2011, "西经"),
    JT808_Vehicle_State_4(1 << 4, V2011, "停运状态"),
    JT808_Vehicle_State_5(1 << 5, V2011, "经纬度已经保密插件加密"),
    JT808_Vehicle_State_6(1 << 6, V2019, "紧急刹车系统采集的前撞预警"),
    JT808_Vehicle_State_7(1 << 7, V2019, "车道偏移预警"),
    JT808_Vehicle_State_8_01(1 << 8, V2013, "半载，00空车，01半载"),
    JT808_Vehicle_State_9_11(1 << 9 + 1 << 8, V2013, "满载，10保留，11满载"),
    JT808_Vehicle_State_10(1 << 10, V2011, "车辆油路断开"),
    JT808_Vehicle_State_11(1 << 11, V2011, "车辆电路断开"),
    JT808_Vehicle_State_12(1 << 12, V2011, "车门加锁"),
    JT808_Vehicle_State_13(1 << 13, V2013, "门1开，前门"),
    JT808_Vehicle_State_14(1 << 14, V2013, "门2开，中门"),
    JT808_Vehicle_State_15(1 << 15, V2013, "门3开，后门"),
    JT808_Vehicle_State_16(1 << 16, V2013, "门4开，驾驶席门"),
    JT808_Vehicle_State_17(1 << 17, V2013, "门5开，自定义"),
    JT808_Vehicle_State_18(1 << 18, V2013, "使用GPS卫星进行定位"),
    JT808_Vehicle_State_19(1 << 19, V2013, "使用北斗卫星进行定位"),
    JT808_Vehicle_State_20(1 << 20, V2013, "使用GLONASS卫星进行定位"),
    JT808_Vehicle_State_21(1 << 21, V2013, "使用Galileo卫星进行定位"),
    JT808_Vehicle_State_22(1 << 22, V2019, "车辆处于行驶状态"),
    JT808_Vehicle_State_23(1 << 23, V2011, "保留"),
    JT808_Vehicle_State_24(1 << 24, V2011, "保留"),
    JT808_Vehicle_State_25(1 << 25, V2011, "保留"),
    JT808_Vehicle_State_26(1 << 26, V2011, "保留"),
    JT808_Vehicle_State_27(1 << 27, V2011, "保留"),
    JT808_Vehicle_State_28(1 << 28, V2011, "保留"),
    JT808_Vehicle_State_29(1 << 29, V2011, "保留"),
    JT808_Vehicle_State_30(1 << 20, V2011, "保留"),
    JT808_Vehicle_State_31(1 << 31, V2011, "保留"),
    ;

    private Integer value;

    private JT808ProtocolVersion since;

    private String description;

    JT808VehicleState(int value, JT808ProtocolVersion since, String description) {
        this.value = value;
        this.since = since;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808VehicleState> mapping = new HashMap<>();

    static {
        for (JT808VehicleState item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808VehicleState cast(int value) {
        JT808VehicleState item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808VehicleState.class.getSimpleName()));
        }
        return item;
    }

    public static JT808VehicleState parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808VehicleState item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
