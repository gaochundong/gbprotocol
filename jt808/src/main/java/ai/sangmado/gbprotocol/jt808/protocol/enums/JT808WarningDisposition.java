package ai.sangmado.gbprotocol.jt808.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * JT/T 808 报警处置规则
 */
@Getter
public enum JT808WarningDisposition {
    ResetAfterAck(0, "收到应答后清零"),
    UntilLifted(1, "标志维持至报警条件解除");

    @JsonInclude
    private Integer value;

    @JsonIgnore
    private String description;

    JT808WarningDisposition(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808WarningDisposition> mapping = new HashMap<>();

    static {
        for (JT808WarningDisposition item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808WarningDisposition cast(int value) {
        JT808WarningDisposition item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808WarningDisposition.class.getSimpleName()));
        }
        return item;
    }

    public static JT808WarningDisposition parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808WarningDisposition item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
