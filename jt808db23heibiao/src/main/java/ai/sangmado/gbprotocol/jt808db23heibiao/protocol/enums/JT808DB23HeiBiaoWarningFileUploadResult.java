package ai.sangmado.gbprotocol.jt808db23heibiao.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 报警附件文件上传结果
 */
@Getter
public enum JT808DB23HeiBiaoWarningFileUploadResult {
    Done(0x00, "完成"),
    Pardon(0x01, "需要补传"),
    ;

    @JsonInclude
    @JsonValue
    private final Integer value;

    @JsonIgnore
    private final String description;

    JT808DB23HeiBiaoWarningFileUploadResult(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808DB23HeiBiaoWarningFileUploadResult> mapping = new HashMap<>();

    static {
        for (JT808DB23HeiBiaoWarningFileUploadResult item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808DB23HeiBiaoWarningFileUploadResult cast(int value) {
        JT808DB23HeiBiaoWarningFileUploadResult item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808DB23HeiBiaoWarningFileUploadResult.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DB23HeiBiaoWarningFileUploadResult parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808DB23HeiBiaoWarningFileUploadResult item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
