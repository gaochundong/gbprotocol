package ai.sangmado.gbprotocol.jt808.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 平台通用应答结果
 */
@Getter
public enum JT808PlatformCommonReplyResult {
    Success(0x00, JT808ProtocolVersion.V2011, "成功/确认"),
    Failed(0x01, JT808ProtocolVersion.V2011, "失败"),
    InvalidMessage(0x02, JT808ProtocolVersion.V2011, "消息有误"),
    NotSupported(0x03, JT808ProtocolVersion.V2011, "不支持"),
    WarningHandled(0x04, JT808ProtocolVersion.V2011, "报警处理确认"),
    ;

    @JsonInclude
    @JsonValue
    private final Integer value;

    @JsonIgnore
    private final JT808ProtocolVersion since;

    @JsonIgnore
    private final String description;

    JT808PlatformCommonReplyResult(int value, JT808ProtocolVersion since, String description) {
        this.value = value;
        this.since = since;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808PlatformCommonReplyResult> mapping = new HashMap<>();

    static {
        for (JT808PlatformCommonReplyResult item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808PlatformCommonReplyResult cast(int value) {
        JT808PlatformCommonReplyResult item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808PlatformCommonReplyResult.class.getSimpleName()));
        }
        return item;
    }

    public static JT808PlatformCommonReplyResult parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808PlatformCommonReplyResult item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
