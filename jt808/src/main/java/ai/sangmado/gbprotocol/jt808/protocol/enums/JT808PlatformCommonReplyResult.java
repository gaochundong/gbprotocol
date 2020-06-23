package ai.sangmado.gbprotocol.jt808.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 平台通用应答结果
 */
@Getter
public enum JT808PlatformCommonReplyResult {
    Success(0x00, "成功/确认"),
    Failed(0x01, "失败"),
    InvalidMessage(0x02, "消息有误"),
    NotSupported(0x03, "不支持"),
    WarningHandled(0x04, "报警处理确认"),
    ;

    @JsonInclude
    private Integer value;

    @JsonIgnore
    private String description;

    JT808PlatformCommonReplyResult(int value, String description) {
        this.value = value;
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
