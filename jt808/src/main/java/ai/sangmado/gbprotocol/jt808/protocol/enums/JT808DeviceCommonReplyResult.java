package ai.sangmado.gbprotocol.jt808.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 终端通用应答结果
 */
@Getter
public enum JT808DeviceCommonReplyResult {
    Success(0x00, JT808ProtocolVersion.V2011, "成功/确认"),
    Failed(0x01, JT808ProtocolVersion.V2011, "失败"),
    InvalidMessage(0x02, JT808ProtocolVersion.V2011, "消息有误"),
    NotSupported(0x03, JT808ProtocolVersion.V2011, "不支持"),
    ;

    @JsonInclude
    @JsonValue
    private final Integer value;

    @JsonIgnore
    private final JT808ProtocolVersion since;

    @JsonIgnore
    private final String description;

    JT808DeviceCommonReplyResult(int value, JT808ProtocolVersion since, String description) {
        this.value = value;
        this.since = since;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808DeviceCommonReplyResult> mapping = new HashMap<>();

    static {
        for (JT808DeviceCommonReplyResult item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808DeviceCommonReplyResult cast(int value) {
        JT808DeviceCommonReplyResult item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808DeviceCommonReplyResult.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DeviceCommonReplyResult parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808DeviceCommonReplyResult item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
