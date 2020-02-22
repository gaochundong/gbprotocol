package ai.sangmado.jt809.protocol.enums;

import ai.sangmado.gbcommon.enums.IProtocolVersion;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

import static ai.sangmado.jt809.protocol.enums.JT809ProtocolVersion.V2011;
import static ai.sangmado.jt809.protocol.enums.JT809ProtocolVersion.V2019;

/**
 * JT/T 809 报警类型编码
 */
@Getter
public enum JT809WarningType {
    JT809_Warning_0x0001(0x0001, V2011, "超速报警"),
    JT809_Warning_0x0002(0x0002, V2011, "疲劳驾驶报警"),
    JT809_Warning_0x0003(0x0003, V2011, "紧急报警"),
    JT809_Warning_0x0004(0x0004, V2011, "进入指定区域报警"),
    JT809_Warning_0x0005(0x0005, V2011, "离开指定区域报警"),
    JT809_Warning_0x0006(0x0006, V2011, "路段赌赛报警"),
    JT809_Warning_0x0007(0x0007, V2011, "危险路段报警"),
    JT809_Warning_0x0008(0x0008, V2011, "越界报警"),
    JT809_Warning_0x0009(0x0009, V2011, "盗警"),
    JT809_Warning_0x000A(0x000A, V2011, "劫警"),
    JT809_Warning_0x000B(0x000B, V2011, "偏离路线报警"),
    JT809_Warning_0x000C(0x000C, V2011, "车辆移动报警"),
    JT809_Warning_0x000D(0x000D, V2011, "超时驾驶报警"),
    JT809_Warning_0x0010(0x0010, V2019, "违规行驶报警"),
    JT809_Warning_0x0011(0x0011, V2019, "前撞报警"),
    JT809_Warning_0x0012(0x0012, V2019, "车道偏离报警"),
    JT809_Warning_0x0013(0x0013, V2019, "胎压异常报警"),
    JT809_Warning_0x0014(0x0014, V2019, "动态信息异常报警"),
    JT809_Warning_0x00FF(0x00FF, V2011, "其他报警"),
    ;

    private Long value;

    private IProtocolVersion since;

    private String description;

    JT809WarningType(long value, IProtocolVersion since, String description) {
        this.value = value;
        this.since = since;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Long, JT809WarningType> mapping = new HashMap<>();

    static {
        for (JT809WarningType item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT809WarningType cast(long value) {
        JT809WarningType item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast long [%s] to [%s] enum.",
                    value, JT809WarningType.class.getSimpleName()));
        }
        return item;
    }

    public static JT809WarningType parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT809WarningType item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
