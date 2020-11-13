package ai.sangmado.gbprotocol.jt808.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * JT/T 808 消息体加密方式
 */
@Getter
public enum JT808MessageContentEncryptionMode {
    None(0, JT808ProtocolVersion.V2011, "不加密"),
    RSA(1 << 10, JT808ProtocolVersion.V2011, "RSA算法加密");

    @JsonInclude
    @JsonValue
    private final Integer value;

    @JsonIgnore
    private final JT808ProtocolVersion since;

    @JsonIgnore
    private final String description;

    JT808MessageContentEncryptionMode(int value, JT808ProtocolVersion since, String description) {
        this.value = value;
        this.since = since;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808MessageContentEncryptionMode> mapping = new HashMap<>();

    static {
        for (JT808MessageContentEncryptionMode item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808MessageContentEncryptionMode cast(int value) {
        JT808MessageContentEncryptionMode item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808MessageContentEncryptionMode.class.getSimpleName()));
        }
        return item;
    }

    public static JT808MessageContentEncryptionMode parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808MessageContentEncryptionMode item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
