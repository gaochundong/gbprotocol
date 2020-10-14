package ai.sangmado.gbprotocol.jt808.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * JT/T 808 多媒体格式编码
 */
@Getter
public enum JT808MediaDataCodingFormat {
    JPEG(0, JT808ProtocolVersion.V2011, "JPEG"),
    TIF(1, JT808ProtocolVersion.V2011, "TIF"),
    MP3(2, JT808ProtocolVersion.V2011, "MP3"),
    WAV(3, JT808ProtocolVersion.V2011, "WAV"),
    WMV(4, JT808ProtocolVersion.V2011, "WMV"),
    ;

    @JsonInclude
    private final Integer value;

    @JsonIgnore
    private final JT808ProtocolVersion since;

    @JsonIgnore
    private final String description;

    JT808MediaDataCodingFormat(int value, JT808ProtocolVersion since, String description) {
        this.value = value;
        this.since = since;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808MediaDataCodingFormat> mapping = new HashMap<>();

    static {
        for (JT808MediaDataCodingFormat item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808MediaDataCodingFormat cast(int value) {
        JT808MediaDataCodingFormat item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808MediaDataCodingFormat.class.getSimpleName()));
        }
        return item;
    }

    public static JT808MediaDataCodingFormat parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808MediaDataCodingFormat item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
