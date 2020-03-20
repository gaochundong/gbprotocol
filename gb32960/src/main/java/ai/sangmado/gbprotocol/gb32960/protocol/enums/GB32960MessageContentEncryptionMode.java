package ai.sangmado.gbprotocol.gb32960.protocol.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据单元加密方式
 */
@Getter
public enum GB32960MessageContentEncryptionMode {
    None(0x01, "数据不加密"),
    RSA(0x02, "数据经过RSA算法加密"),
    AES128(0x03, "数据经过AES128算法加密"),
    Abnormal(0xFE, "异常"),
    Invalid(0xFF, "无效"),
    ;

    private Integer value;

    private String description;

    GB32960MessageContentEncryptionMode(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, GB32960MessageContentEncryptionMode> mapping = new HashMap<>();

    static {
        for (GB32960MessageContentEncryptionMode item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static GB32960MessageContentEncryptionMode cast(int value) {
        GB32960MessageContentEncryptionMode item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, GB32960MessageContentEncryptionMode.class.getSimpleName()));
        }
        return item;
    }

    public static GB32960MessageContentEncryptionMode parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (GB32960MessageContentEncryptionMode item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
