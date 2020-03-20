package ai.sangmado.gbprotocol.gb32960.protocol.enums;

import ai.sangmado.gbprotocol.gb32960.protocol.exceptions.UnsupportedGB32960MessageException;
import ai.sangmado.gbprotocol.gbcommon.enums.IMessageId;
import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960ProtocolVersion.V2016;

/**
 * GB/T 32960 命令ID (平台)
 */
@Getter
@Setter
public class GB32960PlatformCommandId implements IMessageId {
    public static final GB32960PlatformCommandId GB32960_Platform_Command_0x01 = new GB32960PlatformCommandId("GB32960_Platform_Command_0x01", 0x01, V2016, "上行", "车辆登入");
    public static final GB32960PlatformCommandId GB32960_Platform_Command_0x02 = new GB32960PlatformCommandId("GB32960_Platform_Command_0x02", 0x02, V2016, "上行", "实时信息上报");
    public static final GB32960PlatformCommandId GB32960_Platform_Command_0x03 = new GB32960PlatformCommandId("GB32960_Platform_Command_0x03", 0x03, V2016, "上行", "补发信息上报");
    public static final GB32960PlatformCommandId GB32960_Platform_Command_0x04 = new GB32960PlatformCommandId("GB32960_Platform_Command_0x04", 0x04, V2016, "上行", "车辆登出");
    public static final GB32960PlatformCommandId GB32960_Platform_Command_0x05 = new GB32960PlatformCommandId("GB32960_Platform_Command_0x05", 0x05, V2016, "上行", "平台登入");
    public static final GB32960PlatformCommandId GB32960_Platform_Command_0x06 = new GB32960PlatformCommandId("GB32960_Platform_Command_0x06", 0x06, V2016, "上行", "平台登出");

    /**
     * 命令ID名称
     */
    private String name;
    /**
     * 命令ID值
     */
    private Integer value;
    /**
     * 命令ID来自版本
     */
    private IProtocolVersion since;
    /**
     * 命令方向
     */
    private String direction;
    /**
     * 命令ID描述
     */
    private String description;

    public GB32960PlatformCommandId(String name, int value, IProtocolVersion since, String direction, String description) {
        this.name = name;
        this.value = value;
        this.since = since;
        this.direction = direction;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof GB32960PlatformCommandId)) {
            return false;
        }
        return this.getValue().equals(((GB32960PlatformCommandId) obj).getValue());
    }

    @Override
    public int compareTo(IMessageId o) {
        return this.getValue().compareTo(o.getValue());
    }

    private static final Map<Integer, GB32960PlatformCommandId> mapping = new HashMap<>();
    private static final Map<Integer, GB32960PlatformCommandId> extensions = new HashMap<>();

    static {
        mapping.put(GB32960_Platform_Command_0x01.getValue(), GB32960_Platform_Command_0x01);
        mapping.put(GB32960_Platform_Command_0x02.getValue(), GB32960_Platform_Command_0x02);
        mapping.put(GB32960_Platform_Command_0x03.getValue(), GB32960_Platform_Command_0x03);
        mapping.put(GB32960_Platform_Command_0x04.getValue(), GB32960_Platform_Command_0x04);
        mapping.put(GB32960_Platform_Command_0x05.getValue(), GB32960_Platform_Command_0x05);
        mapping.put(GB32960_Platform_Command_0x06.getValue(), GB32960_Platform_Command_0x06);
    }

    public static GB32960PlatformCommandId cast(int value) {
        GB32960PlatformCommandId item = tryCast(value);
        if (item == null) {
            throw new UnsupportedGB32960MessageException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, GB32960PlatformCommandId.class.getSimpleName()));
        }
        return item;
    }

    public static GB32960PlatformCommandId tryCast(int value) {
        GB32960PlatformCommandId item = mapping.get(value);
        if (item == null) {
            item = extensions.get(value);
        }
        return item;
    }

    public static boolean exists(int value) {
        return tryCast(value) != null;
    }

    public static List<GB32960PlatformCommandId> list() {
        List<GB32960PlatformCommandId> l = new ArrayList<>(mapping.values());
        l.addAll(extensions.values());
        return l;
    }

    public static void putExtensions(List<GB32960PlatformCommandId> messages) {
        messages.forEach(i -> extensions.put(i.getValue(), i));
    }
}
