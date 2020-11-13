package ai.sangmado.gbprotocol.jt809.protocol.enums;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * JT/T 809 报警类型编码
 */
@Getter
public enum JT809WarningType {
    JT809_Warning_0x0001(0x0001, JT809ProtocolVersion.V2011, true, "超速报警"),
    JT809_Warning_0x0002(0x0002, JT809ProtocolVersion.V2011, true, "疲劳驾驶报警"),
    JT809_Warning_0x0003(0x0003, JT809ProtocolVersion.V2011, true, "紧急报警"),
    JT809_Warning_0x0004(0x0004, JT809ProtocolVersion.V2011, true, "进入指定区域报警"),
    JT809_Warning_0x0005(0x0005, JT809ProtocolVersion.V2011, true, "离开指定区域报警"),
    JT809_Warning_0x0006(0x0006, JT809ProtocolVersion.V2011, true, "路段堵塞报警"),
    JT809_Warning_0x0007(0x0007, JT809ProtocolVersion.V2011, true, "危险路段报警"),
    JT809_Warning_0x0008(0x0008, JT809ProtocolVersion.V2011, true, "越界报警"),
    JT809_Warning_0x0009(0x0009, JT809ProtocolVersion.V2011, true, "盗警"),
    JT809_Warning_0x000A(0x000A, JT809ProtocolVersion.V2011, true, "劫警"),
    JT809_Warning_0x000B(0x000B, JT809ProtocolVersion.V2011, true, "偏离路线报警"),
    JT809_Warning_0x000C(0x000C, JT809ProtocolVersion.V2011, true, "车辆移动报警"),
    JT809_Warning_0x000D(0x000D, JT809ProtocolVersion.V2011, true, "超时驾驶报警"),
    JT809_Warning_0x0010(0x0010, JT809ProtocolVersion.V2019, true, "违规行驶报警"),
    JT809_Warning_0x0011(0x0011, JT809ProtocolVersion.V2019, true, "前撞报警"),
    JT809_Warning_0x0012(0x0012, JT809ProtocolVersion.V2019, true, "车道偏离报警"),
    JT809_Warning_0x0013(0x0013, JT809ProtocolVersion.V2019, true, "胎压异常报警"),
    JT809_Warning_0x0014(0x0014, JT809ProtocolVersion.V2019, true, "动态信息异常报警"),
    JT809_Warning_0x00FF(0x00FF, JT809ProtocolVersion.V2011, true, "其他位置相关报警"),

    JT809_Warning_0xA001(0xA001, JT809ProtocolVersion.V2019, false, "超时停车"),
    JT809_Warning_0xA002(0xA002, JT809ProtocolVersion.V2019, false, "车辆定位信息上报时间间隔异常"),
    JT809_Warning_0xA003(0xA003, JT809ProtocolVersion.V2019, false, "车辆定位信息上报距离间隔异常"),
    JT809_Warning_0xA004(0xA004, JT809ProtocolVersion.V2019, false, "下级平台异常断线"),
    JT809_Warning_0xA005(0xA005, JT809ProtocolVersion.V2019, false, "下级平台数据传输异常"),
    JT809_Warning_0xA006(0xA006, JT809ProtocolVersion.V2019, false, "路段堵塞报警"),
    JT809_Warning_0xA007(0xA007, JT809ProtocolVersion.V2019, false, "危险路段报警"),
    JT809_Warning_0xA008(0xA008, JT809ProtocolVersion.V2019, false, "雨雪天气报警"),
    JT809_Warning_0xA009(0xA009, JT809ProtocolVersion.V2019, false, "驾驶员身份异常识别"),
    JT809_Warning_0xA00A(0xA00A, JT809ProtocolVersion.V2019, false, "终端异常(含线路连接异常)"),
    JT809_Warning_0xA00B(0xA00B, JT809ProtocolVersion.V2019, false, "平台接入异常"),
    JT809_Warning_0xA00C(0xA00C, JT809ProtocolVersion.V2019, false, "核心数据异常"),
    JT809_Warning_0xA0FF(0xA0FF, JT809ProtocolVersion.V2019, false, "其他非位置相关报警"),
    ;

    @JsonInclude
    @JsonValue
    private final Long value;

    @JsonIgnore
    private final IProtocolVersion since;

    @JsonIgnore
    private final Boolean locationBased;

    @JsonIgnore
    private final String description;

    JT809WarningType(long value, IProtocolVersion since, boolean locationBased, String description) {
        this.value = value;
        this.since = since;
        this.locationBased = locationBased;
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
