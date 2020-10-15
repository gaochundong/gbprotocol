package ai.sangmado.gbprotocol.jt808.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * JT/T 808 终端控制命令字
 */
@Getter
public enum JT808DeviceControlCommandId {
    JT808_DeviceControlCommandId_1(1, JT808ProtocolVersion.V2011, "无线升级"),
    JT808_DeviceControlCommandId_2(2, JT808ProtocolVersion.V2011, "控制终端连接指定服务器"),
    JT808_DeviceControlCommandId_3(3, JT808ProtocolVersion.V2011, "终端关机"),
    JT808_DeviceControlCommandId_4(4, JT808ProtocolVersion.V2011, "终端复位"),
    JT808_DeviceControlCommandId_5(5, JT808ProtocolVersion.V2011, "终端恢复出厂设置"),
    JT808_DeviceControlCommandId_6(6, JT808ProtocolVersion.V2011, "关闭数据通信"),
    JT808_DeviceControlCommandId_7(7, JT808ProtocolVersion.V2011, "关闭所有无线通信"),
    ;

    @JsonInclude
    private final Integer value;

    @JsonIgnore
    private final JT808ProtocolVersion since;

    @JsonIgnore
    private final String description;

    JT808DeviceControlCommandId(int value, JT808ProtocolVersion since, String description) {
        this.value = value;
        this.since = since;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808DeviceControlCommandId> mapping = new HashMap<>();

    static {
        for (JT808DeviceControlCommandId item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808DeviceControlCommandId cast(int value) {
        JT808DeviceControlCommandId item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808DeviceControlCommandId.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DeviceControlCommandId parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808DeviceControlCommandId item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
