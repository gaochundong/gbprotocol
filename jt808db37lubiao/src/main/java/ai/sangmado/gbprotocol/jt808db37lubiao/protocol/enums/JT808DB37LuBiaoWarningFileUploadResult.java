package ai.sangmado.gbprotocol.jt808db37lubiao.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 报警附件文件上传结果
 */
@Getter
public enum JT808DB37LuBiaoWarningFileUploadResult {
    Done(0x00, "完成"),
    Pardon(0x01, "需要补传"),
    ;

    @JsonInclude
    private Integer value;

    @JsonIgnore
    private String description;

    JT808DB37LuBiaoWarningFileUploadResult(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808DB37LuBiaoWarningFileUploadResult> mapping = new HashMap<>();

    static {
        for (JT808DB37LuBiaoWarningFileUploadResult item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808DB37LuBiaoWarningFileUploadResult cast(int value) {
        JT808DB37LuBiaoWarningFileUploadResult item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808DB37LuBiaoWarningFileUploadResult.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DB37LuBiaoWarningFileUploadResult parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808DB37LuBiaoWarningFileUploadResult item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
