package ai.sangmado.gbprotocol.jt1078.protocol.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 操作结果
 */
@Getter
public enum OperationResult {
    Success(0, "成功"),
    Failed(1, "失败");

    @JsonInclude
    @JsonValue
    private Integer value;

    @JsonIgnore
    private String description;

    OperationResult(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, OperationResult> mapping = new HashMap<>();

    static {
        for (OperationResult level : values()) {
            mapping.put(level.getValue(), level);
        }
    }

    @JsonCreator
    public static OperationResult cast(int i) {
        OperationResult level = mapping.get(i);
        if (level == null) {
            throw new IllegalArgumentException("Cannot cast integer to enum.");
        }
        return level;
    }

    public static OperationResult parse(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        for (OperationResult level : values()) {
            if (level.name().equalsIgnoreCase(s)) {
                return level;
            }
        }
        throw new IllegalArgumentException("Cannot parse string to enum.");
    }
}