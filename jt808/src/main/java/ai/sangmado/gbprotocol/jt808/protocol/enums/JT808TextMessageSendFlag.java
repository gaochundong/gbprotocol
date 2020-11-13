package ai.sangmado.gbprotocol.jt808.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * JT/T 808 文本信息标志位
 */
@Getter
public enum JT808TextMessageSendFlag {
    JT808_TextMessage_SendFlag_10(1, JT808ProtocolVersion.V2011, "01:服务,10:紧急,11:通知"),
    JT808_TextMessage_SendFlag_01(1 << 1, JT808ProtocolVersion.V2019, "01:服务,10:紧急,11:通知"),
    JT808_TextMessage_SendFlag_11(1 << 1 + 1, JT808ProtocolVersion.V2019, "01:服务,10:紧急,11:通知"),
    JT808_TextMessage_SendFlag_2(1 << 2, JT808ProtocolVersion.V2011, "1:终端显示器显示"),
    JT808_TextMessage_SendFlag_3(1 << 3, JT808ProtocolVersion.V2011, "1:终端TTS播读"),
    JT808_TextMessage_SendFlag_4(1 << 4, JT808ProtocolVersion.V2011, "1:广告屏显示"),
    JT808_TextMessage_SendFlag_5(1 << 5, JT808ProtocolVersion.V2013, "0:中心导航信息,1:CAN故障码信息"),
    JT808_TextMessage_SendFlag_6(1 << 6, JT808ProtocolVersion.V2011, "保留"),
    JT808_TextMessage_SendFlag_7(1 << 7, JT808ProtocolVersion.V2011, "保留"),
    ;

    @JsonInclude
    @JsonValue
    private final Integer value;

    @JsonIgnore
    private final JT808ProtocolVersion since;

    @JsonIgnore
    private final String description;

    JT808TextMessageSendFlag(int value, JT808ProtocolVersion since, String description) {
        this.value = value;
        this.since = since;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808TextMessageSendFlag> mapping = new HashMap<>();

    static {
        for (JT808TextMessageSendFlag item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808TextMessageSendFlag cast(int value) {
        JT808TextMessageSendFlag item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808TextMessageSendFlag.class.getSimpleName()));
        }
        return item;
    }

    public static JT808TextMessageSendFlag parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808TextMessageSendFlag item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
