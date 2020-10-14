package ai.sangmado.gbprotocol.jt808.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * JT/T 808 多媒体事件项编码
 */
@Getter
public enum JT808MediaDataActionCode {
    JT808_MediaData_ActionCode_0(0, JT808ProtocolVersion.V2011, "平台下发指令"),
    JT808_MediaData_ActionCode_1(1, JT808ProtocolVersion.V2011, "定时动作"),
    JT808_MediaData_ActionCode_2(2, JT808ProtocolVersion.V2011, "抢劫报警触发"),
    JT808_MediaData_ActionCode_3(3, JT808ProtocolVersion.V2011, "碰撞侧翻报警触发"),
    JT808_MediaData_ActionCode_4(4, JT808ProtocolVersion.V2013, "打开车门"),
    JT808_MediaData_ActionCode_5(5, JT808ProtocolVersion.V2013, "关闭车门"),
    JT808_MediaData_ActionCode_6(6, JT808ProtocolVersion.V2013, "车门由开变关，时速从＜20公里到超过20公里"),
    JT808_MediaData_ActionCode_7(7, JT808ProtocolVersion.V2013, "定距拍照"),
    ;

    @JsonInclude
    private final Integer value;

    @JsonIgnore
    private final JT808ProtocolVersion since;

    @JsonIgnore
    private final String description;

    JT808MediaDataActionCode(int value, JT808ProtocolVersion since, String description) {
        this.value = value;
        this.since = since;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808MediaDataActionCode> mapping = new HashMap<>();

    static {
        for (JT808MediaDataActionCode item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808MediaDataActionCode cast(int value) {
        JT808MediaDataActionCode item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808MediaDataActionCode.class.getSimpleName()));
        }
        return item;
    }

    public static JT808MediaDataActionCode parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808MediaDataActionCode item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
