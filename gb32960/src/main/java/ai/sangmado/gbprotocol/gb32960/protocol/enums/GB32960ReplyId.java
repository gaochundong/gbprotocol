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
 * GB/T 32960 应答ID
 */
@Getter
@Setter
public class GB32960ReplyId implements IMessageId {
    public static final GB32960ReplyId GB32960_Reply_0x01 = new GB32960ReplyId("GB32960_Reply_0x01", 0x01, V2016, "成功");
    public static final GB32960ReplyId GB32960_Reply_0x02 = new GB32960ReplyId("GB32960_Reply_0x02", 0x02, V2016, "错误");
    public static final GB32960ReplyId GB32960_Reply_0x03 = new GB32960ReplyId("GB32960_Reply_0x03", 0x03, V2016, "VIN重复");
    public static final GB32960ReplyId GB32960_Reply_0xFE = new GB32960ReplyId("GB32960_Reply_0xFE", 0xFE, V2016, "命令");

    /**
     * 应答ID名称
     */
    private String name;
    /**
     * 应答ID值
     */
    private Integer value;
    /**
     * 应答ID来自版本
     */
    private IProtocolVersion since;
    /**
     * 应答ID描述
     */
    private String description;

    public GB32960ReplyId(String name, int value, IProtocolVersion since, String description) {
        this.name = name;
        this.value = value;
        this.since = since;
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
        if (!(obj instanceof GB32960ReplyId)) {
            return false;
        }
        return this.getValue().equals(((GB32960ReplyId) obj).getValue());
    }

    @Override
    public int compareTo(IMessageId o) {
        return this.getValue().compareTo(o.getValue());
    }

    private static final Map<Integer, GB32960ReplyId> mapping = new HashMap<>();
    private static final Map<Integer, GB32960ReplyId> extensions = new HashMap<>();

    static {
        mapping.put(GB32960_Reply_0x01.getValue(), GB32960_Reply_0x01);
        mapping.put(GB32960_Reply_0x02.getValue(), GB32960_Reply_0x02);
        mapping.put(GB32960_Reply_0x03.getValue(), GB32960_Reply_0x03);
        mapping.put(GB32960_Reply_0xFE.getValue(), GB32960_Reply_0xFE);
    }

    public static GB32960ReplyId cast(int value) {
        GB32960ReplyId item = tryCast(value);
        if (item == null) {
            throw new UnsupportedGB32960MessageException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, GB32960ReplyId.class.getSimpleName()));
        }
        return item;
    }

    public static GB32960ReplyId tryCast(int value) {
        GB32960ReplyId item = mapping.get(value);
        if (item == null) {
            item = extensions.get(value);
        }
        return item;
    }

    public static boolean exists(int value) {
        return tryCast(value) != null;
    }

    public static List<GB32960ReplyId> list() {
        List<GB32960ReplyId> l = new ArrayList<>(mapping.values());
        l.addAll(extensions.values());
        return l;
    }

    public static void putExtensions(List<GB32960ReplyId> messages) {
        messages.forEach(i -> extensions.put(i.getValue(), i));
    }
}
