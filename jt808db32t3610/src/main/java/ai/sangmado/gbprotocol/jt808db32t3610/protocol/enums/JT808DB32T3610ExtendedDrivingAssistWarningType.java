package ai.sangmado.gbprotocol.jt808db32t3610.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 驾驶辅助功能 - 报警/事件类型
 */
@Getter
public enum JT808DB32T3610ExtendedDrivingAssistWarningType {
    FCW(0x01, JT808DB32T3610ProtocolVersion.V2019, "前向碰撞预警"),
    LDW(0x02, JT808DB32T3610ProtocolVersion.V2019, "车道偏离报警"),
    HMW(0x03, JT808DB32T3610ProtocolVersion.V2019, "车距过近报警"),
    PCW(0x04, JT808DB32T3610ProtocolVersion.V2019, "行人碰撞报警"),
    FrequentLaneChange(0x05, JT808DB32T3610ProtocolVersion.V2019, "频繁变道报警"),
    RoadMarkingLimitExceeded(0x06, JT808DB32T3610ProtocolVersion.V2019, "道路标识超限报警"),
    Roadblock(0x07, JT808DB32T3610ProtocolVersion.V2019, "障碍物报警"),
    FunctionFailure(0x08, JT808DB32T3610ProtocolVersion.V2019, "驾驶辅助功能失效报警"),
    RoadSignIdentified(0x10, JT808DB32T3610ProtocolVersion.V2019, "道路标志识别事件"),
    PhotoTaking(0x11, JT808DB32T3610ProtocolVersion.V2019, "主动抓拍事件"),
    ;

    @JsonInclude
    private final Integer value;

    @JsonIgnore
    private final JT808DB32T3610ProtocolVersion since;

    @JsonIgnore
    private final String description;

    JT808DB32T3610ExtendedDrivingAssistWarningType(int value, JT808DB32T3610ProtocolVersion since, String description) {
        this.value = value;
        this.since = since;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808DB32T3610ExtendedDrivingAssistWarningType> mapping = new HashMap<>();

    static {
        for (JT808DB32T3610ExtendedDrivingAssistWarningType item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808DB32T3610ExtendedDrivingAssistWarningType cast(int value) {
        JT808DB32T3610ExtendedDrivingAssistWarningType item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808DB32T3610ExtendedDrivingAssistWarningType.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DB32T3610ExtendedDrivingAssistWarningType parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808DB32T3610ExtendedDrivingAssistWarningType item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
