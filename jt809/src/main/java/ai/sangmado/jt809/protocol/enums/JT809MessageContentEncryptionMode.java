package ai.sangmado.jt809.protocol.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息体加密选项
 */
@Getter
public enum JT809MessageContentEncryptionMode {
    None(0, "不加密"),
    Encrypted(1, "算法加密");

    private Integer value;

    private String description;

    JT809MessageContentEncryptionMode(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT809MessageContentEncryptionMode> mapping = new HashMap<>();

    static {
        for (JT809MessageContentEncryptionMode item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT809MessageContentEncryptionMode cast(int value) {
        JT809MessageContentEncryptionMode item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT809MessageContentEncryptionMode.class.getSimpleName()));
        }
        return item;
    }

    public static JT809MessageContentEncryptionMode parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT809MessageContentEncryptionMode item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
