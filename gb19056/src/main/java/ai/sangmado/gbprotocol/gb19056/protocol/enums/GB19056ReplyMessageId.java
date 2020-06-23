package ai.sangmado.gbprotocol.gb19056.protocol.enums;

import ai.sangmado.gbprotocol.gb19056.protocol.exceptions.UnsupportedGB19056MessageException;
import ai.sangmado.gbprotocol.gbcommon.enums.IMessageId;
import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ai.sangmado.gbprotocol.gb19056.protocol.enums.GB19056ProtocolVersion.V2012;

/**
 * GB19056 消息ID - 应答帧
 */
@Getter
@Setter
public class GB19056ReplyMessageId implements IMessageId {
    public static final GB19056ReplyMessageId GB19056_Message_Reply_0x00 = new GB19056ReplyMessageId("GB19056_Message_Reply_0x00", 0x00, V2012, "采集记录仪执行标准版本");
    public static final GB19056ReplyMessageId GB19056_Message_Reply_0x01 = new GB19056ReplyMessageId("GB19056_Message_Reply_0x01", 0x01, V2012, "采集当前驾驶人信息");
    public static final GB19056ReplyMessageId GB19056_Message_Reply_0x02 = new GB19056ReplyMessageId("GB19056_Message_Reply_0x02", 0x02, V2012, "采集记录仪实时时间");
    public static final GB19056ReplyMessageId GB19056_Message_Reply_0x03 = new GB19056ReplyMessageId("GB19056_Message_Reply_0x03", 0x03, V2012, "采集累计行驶里程");
    public static final GB19056ReplyMessageId GB19056_Message_Reply_0x04 = new GB19056ReplyMessageId("GB19056_Message_Reply_0x04", 0x04, V2012, "采集记录仪脉冲系数");
    public static final GB19056ReplyMessageId GB19056_Message_Reply_0x05 = new GB19056ReplyMessageId("GB19056_Message_Reply_0x05", 0x05, V2012, "采集车辆信息");
    public static final GB19056ReplyMessageId GB19056_Message_Reply_0x06 = new GB19056ReplyMessageId("GB19056_Message_Reply_0x06", 0x06, V2012, "采集记录仪状态信号配置信息");
    public static final GB19056ReplyMessageId GB19056_Message_Reply_0x07 = new GB19056ReplyMessageId("GB19056_Message_Reply_0x07", 0x07, V2012, "采集记录仪唯一性编号");
    public static final GB19056ReplyMessageId GB19056_Message_Reply_0x08 = new GB19056ReplyMessageId("GB19056_Message_Reply_0x08", 0x08, V2012, "采集指定的行驶速度记录");
    public static final GB19056ReplyMessageId GB19056_Message_Reply_0x09 = new GB19056ReplyMessageId("GB19056_Message_Reply_0x09", 0x09, V2012, "采集指定的位置信息记录");
    public static final GB19056ReplyMessageId GB19056_Message_Reply_0x10 = new GB19056ReplyMessageId("GB19056_Message_Reply_0x10", 0x10, V2012, "采集指定的事故疑点记录");
    public static final GB19056ReplyMessageId GB19056_Message_Reply_0x11 = new GB19056ReplyMessageId("GB19056_Message_Reply_0x11", 0x11, V2012, "采集指定的超时驾驶记录");
    public static final GB19056ReplyMessageId GB19056_Message_Reply_0x12 = new GB19056ReplyMessageId("GB19056_Message_Reply_0x12", 0x12, V2012, "采集指定的驾驶人身份记录");
    public static final GB19056ReplyMessageId GB19056_Message_Reply_0x13 = new GB19056ReplyMessageId("GB19056_Message_Reply_0x13", 0x13, V2012, "采集指定的外部供电记录");
    public static final GB19056ReplyMessageId GB19056_Message_Reply_0x14 = new GB19056ReplyMessageId("GB19056_Message_Reply_0x14", 0x14, V2012, "采集指定的参数修改记录");
    public static final GB19056ReplyMessageId GB19056_Message_Reply_0x15 = new GB19056ReplyMessageId("GB19056_Message_Reply_0x15", 0x15, V2012, "采集指定的速度状态日志");

    public static final GB19056ReplyMessageId GB19056_Message_Reply_0x82 = new GB19056ReplyMessageId("GB19056_Message_Reply_0x82", 0x82, V2012, "设置车辆信息");
    public static final GB19056ReplyMessageId GB19056_Message_Reply_0x83 = new GB19056ReplyMessageId("GB19056_Message_Reply_0x83", 0x83, V2012, "设置记录仪初次安装日期");
    public static final GB19056ReplyMessageId GB19056_Message_Reply_0x84 = new GB19056ReplyMessageId("GB19056_Message_Reply_0x84", 0x84, V2012, "设置状态量配置信息");
    public static final GB19056ReplyMessageId GB19056_Message_Reply_0xC2 = new GB19056ReplyMessageId("GB19056_Message_Reply_0xC2", 0xC2, V2012, "设置记录仪时间");
    public static final GB19056ReplyMessageId GB19056_Message_Reply_0xC3 = new GB19056ReplyMessageId("GB19056_Message_Reply_0xC3", 0xC3, V2012, "设置记录仪脉冲系数");
    public static final GB19056ReplyMessageId GB19056_Message_Reply_0xC4 = new GB19056ReplyMessageId("GB19056_Message_Reply_0xC4", 0xC4, V2012, "设置初始里程");

    public static final GB19056ReplyMessageId GB19056_Message_Reply_0xE0 = new GB19056ReplyMessageId("GB19056_Message_Reply_0xE0", 0xE0, V2012, "进入或保持检定状态");
    public static final GB19056ReplyMessageId GB19056_Message_Reply_0xE1 = new GB19056ReplyMessageId("GB19056_Message_Reply_0xE1", 0xE1, V2012, "进入里程误差测量");
    public static final GB19056ReplyMessageId GB19056_Message_Reply_0xE2 = new GB19056ReplyMessageId("GB19056_Message_Reply_0xE2", 0xE2, V2012, "进入脉冲系数误差测量");
    public static final GB19056ReplyMessageId GB19056_Message_Reply_0xE3 = new GB19056ReplyMessageId("GB19056_Message_Reply_0xE3", 0xE3, V2012, "进入实时时间误差测量");
    public static final GB19056ReplyMessageId GB19056_Message_Reply_0xE4 = new GB19056ReplyMessageId("GB19056_Message_Reply_0xE4", 0xE4, V2012, "返回正常工作状态");

    /**
     * 消息ID名称
     */
    @JsonIgnore
    private String name;
    /**
     * 消息ID值
     */
    @JsonInclude
    private Integer value;
    /**
     * 消息ID来自版本
     */
    @JsonIgnore
    private IProtocolVersion since;
    /**
     * 消息ID描述
     */
    @JsonIgnore
    private String description;

    public GB19056ReplyMessageId(String name, int value, IProtocolVersion since, String description) {
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
        if (!(obj instanceof GB19056ReplyMessageId)) {
            return false;
        }
        return this.getValue().equals(((GB19056ReplyMessageId) obj).getValue());
    }

    @Override
    public int compareTo(IMessageId o) {
        return this.getValue().compareTo(o.getValue());
    }

    private static final Map<Integer, GB19056ReplyMessageId> mapping = new HashMap<>();
    private static final Map<Integer, GB19056ReplyMessageId> extensions = new HashMap<>();

    static {
        mapping.put(GB19056_Message_Reply_0x00.getValue(), GB19056_Message_Reply_0x00);
        mapping.put(GB19056_Message_Reply_0x01.getValue(), GB19056_Message_Reply_0x01);
        mapping.put(GB19056_Message_Reply_0x02.getValue(), GB19056_Message_Reply_0x02);
        mapping.put(GB19056_Message_Reply_0x03.getValue(), GB19056_Message_Reply_0x03);
        mapping.put(GB19056_Message_Reply_0x04.getValue(), GB19056_Message_Reply_0x04);
        mapping.put(GB19056_Message_Reply_0x05.getValue(), GB19056_Message_Reply_0x05);
        mapping.put(GB19056_Message_Reply_0x06.getValue(), GB19056_Message_Reply_0x06);
        mapping.put(GB19056_Message_Reply_0x07.getValue(), GB19056_Message_Reply_0x07);
        mapping.put(GB19056_Message_Reply_0x08.getValue(), GB19056_Message_Reply_0x08);
        mapping.put(GB19056_Message_Reply_0x09.getValue(), GB19056_Message_Reply_0x09);
        mapping.put(GB19056_Message_Reply_0x10.getValue(), GB19056_Message_Reply_0x10);
        mapping.put(GB19056_Message_Reply_0x11.getValue(), GB19056_Message_Reply_0x11);
        mapping.put(GB19056_Message_Reply_0x12.getValue(), GB19056_Message_Reply_0x12);
        mapping.put(GB19056_Message_Reply_0x13.getValue(), GB19056_Message_Reply_0x13);
        mapping.put(GB19056_Message_Reply_0x14.getValue(), GB19056_Message_Reply_0x14);
        mapping.put(GB19056_Message_Reply_0x15.getValue(), GB19056_Message_Reply_0x15);

        mapping.put(GB19056_Message_Reply_0x82.getValue(), GB19056_Message_Reply_0x82);
        mapping.put(GB19056_Message_Reply_0x83.getValue(), GB19056_Message_Reply_0x83);
        mapping.put(GB19056_Message_Reply_0x84.getValue(), GB19056_Message_Reply_0x84);
        mapping.put(GB19056_Message_Reply_0xC2.getValue(), GB19056_Message_Reply_0xC2);
        mapping.put(GB19056_Message_Reply_0xC3.getValue(), GB19056_Message_Reply_0xC3);
        mapping.put(GB19056_Message_Reply_0xC4.getValue(), GB19056_Message_Reply_0xC4);

        mapping.put(GB19056_Message_Reply_0xE0.getValue(), GB19056_Message_Reply_0xE0);
        mapping.put(GB19056_Message_Reply_0xE1.getValue(), GB19056_Message_Reply_0xE1);
        mapping.put(GB19056_Message_Reply_0xE2.getValue(), GB19056_Message_Reply_0xE2);
        mapping.put(GB19056_Message_Reply_0xE3.getValue(), GB19056_Message_Reply_0xE3);
        mapping.put(GB19056_Message_Reply_0xE4.getValue(), GB19056_Message_Reply_0xE4);
    }

    public static GB19056ReplyMessageId cast(int value) {
        GB19056ReplyMessageId item = tryCast(value);
        if (item == null) {
            throw new UnsupportedGB19056MessageException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, GB19056ReplyMessageId.class.getSimpleName()));
        }
        return item;
    }

    public static GB19056ReplyMessageId tryCast(int value) {
        GB19056ReplyMessageId item = mapping.get(value);
        if (item == null) {
            item = extensions.get(value);
        }
        return item;
    }

    public static boolean exists(int value) {
        return tryCast(value) != null;
    }

    public static List<GB19056ReplyMessageId> list() {
        List<GB19056ReplyMessageId> l = new ArrayList<>(mapping.values());
        l.addAll(extensions.values());
        return l;
    }

    public static void putExtensions(List<GB19056ReplyMessageId> messages) {
        messages.forEach(i -> extensions.put(i.getValue(), i));
    }
}
