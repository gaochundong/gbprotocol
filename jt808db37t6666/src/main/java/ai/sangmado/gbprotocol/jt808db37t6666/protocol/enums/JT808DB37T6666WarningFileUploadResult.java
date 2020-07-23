package ai.sangmado.gbprotocol.jt808db37t6666.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 报警附件文件上传结果
 */
@Getter
public enum JT808DB37T6666WarningFileUploadResult {
    Done(0x00, "完成"),
    Pardon(0x01, "需要补传"),
    ;

    @JsonInclude
    private Integer value;

    @JsonIgnore
    private String description;

    JT808DB37T6666WarningFileUploadResult(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808DB37T6666WarningFileUploadResult> mapping = new HashMap<>();

    static {
        for (JT808DB37T6666WarningFileUploadResult item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808DB37T6666WarningFileUploadResult cast(int value) {
        JT808DB37T6666WarningFileUploadResult item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808DB37T6666WarningFileUploadResult.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DB37T6666WarningFileUploadResult parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808DB37T6666WarningFileUploadResult item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
