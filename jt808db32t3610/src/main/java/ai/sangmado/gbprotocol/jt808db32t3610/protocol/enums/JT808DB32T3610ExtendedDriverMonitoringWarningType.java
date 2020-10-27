package ai.sangmado.gbprotocol.jt808db32t3610.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 驾驶员行为监测功能 - 报警/事件类型
 */
@Getter
public enum JT808DB32T3610ExtendedDriverMonitoringWarningType {
    FatigueDriving(0x01, JT808DB32T3610ProtocolVersion.V2019, "疲劳驾驶报警"),
    PhoneCall(0x02, JT808DB32T3610ProtocolVersion.V2019, "接打手持电话报警"),
    Smoking(0x03, JT808DB32T3610ProtocolVersion.V2019, "抽烟报警"),
    LongTimeNotLookAhead(0x04, JT808DB32T3610ProtocolVersion.V2019, "长时间不目视前方报警"),
    NoDriverDetected(0x05, JT808DB32T3610ProtocolVersion.V2019, "未检测到驾驶员报警"),
    BothHandsOffSteering(0x06, JT808DB32T3610ProtocolVersion.V2019, "双手同时脱离方向盘报警"),
    FunctionFailure(0x07, JT808DB32T3610ProtocolVersion.V2019, "驾驶员行为监测功能失效报警"),
    PhotoTaking(0x10, JT808DB32T3610ProtocolVersion.V2019, "自动抓拍事件"),
    DriverChanged(0x11, JT808DB32T3610ProtocolVersion.V2019, "驾驶员变更事件"),
    ;

    @JsonInclude
    private final Integer value;

    @JsonIgnore
    private final JT808DB32T3610ProtocolVersion since;

    @JsonIgnore
    private final String description;

    JT808DB32T3610ExtendedDriverMonitoringWarningType(int value, JT808DB32T3610ProtocolVersion since, String description) {
        this.value = value;
        this.since = since;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808DB32T3610ExtendedDriverMonitoringWarningType> mapping = new HashMap<>();

    static {
        for (JT808DB32T3610ExtendedDriverMonitoringWarningType item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808DB32T3610ExtendedDriverMonitoringWarningType cast(int value) {
        JT808DB32T3610ExtendedDriverMonitoringWarningType item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808DB32T3610ExtendedDriverMonitoringWarningType.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DB32T3610ExtendedDriverMonitoringWarningType parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808DB32T3610ExtendedDriverMonitoringWarningType item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
