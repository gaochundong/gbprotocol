package ai.sangmado.jt808.protocol.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

import static ai.sangmado.jt808.protocol.enums.JT808ProtocolVersion.*;

/**
 * JT/T 808 消息ID
 */
@Getter
public enum JT808MessageId {
    JT808_Message_0x0001(0x0001, V2011, "终端通用应答"),
    JT808_Message_0x0002(0x0002, V2011, "终端心跳"),
    JT808_Message_0x0003(0x0003, V2013, "终端注销"),
    JT808_Message_0x0004(0x0004, V2019, "终端查询服务器时间请求"),
    JT808_Message_0x0005(0x0005, V2019, "终端补传分包请求"),
    JT808_Message_0x0100(0x0100, V2011, "终端注册"),
    JT808_Message_0x0102(0x0102, V2011, "终端鉴权"),
    JT808_Message_0x0104(0x0104, V2011, "终端平台查询终端参数应答"),
    JT808_Message_0x0107(0x0107, V2013, "终端平台查询终端属性应答"),
    JT808_Message_0x0108(0x0108, V2013, "终端升级结果通知"),
    JT808_Message_0x0200(0x0200, V2011, "终端位置信息汇报"),
    JT808_Message_0x0201(0x0201, V2011, "终端位置信息查询应答"),
    JT808_Message_0x0301(0x0301, V2011, "终端事件报告"),
    JT808_Message_0x0302(0x0302, V2011, "终端提问应答"),
    JT808_Message_0x0303(0x0303, V2011, "终端信息点播或取消"),
    JT808_Message_0x0500(0x0500, V2011, "终端车辆控制应答"),
    JT808_Message_0x0608(0x0608, V2019, "终端查询区域或线路数据应答"),
    JT808_Message_0x0700(0x0700, V2011, "终端行驶记录数据上传"),
    JT808_Message_0x0701(0x0701, V2011, "终端电子运单上报"),
    JT808_Message_0x0702(0x0702, V2013, "终端驾驶员身份信息采集上报"),
    JT808_Message_0x0704(0x0704, V2013, "终端定位数据批量上传"),
    JT808_Message_0x0705(0x0705, V2013, "终端CAN总线数据上传"),
    JT808_Message_0x0800(0x0800, V2011, "终端多媒体事件信息上传"),
    JT808_Message_0x0801(0x0801, V2011, "终端多媒体数据上传"),
    JT808_Message_0x0802(0x0802, V2011, "终端存储多媒体数据检索应答"),
    JT808_Message_0x0805(0x0805, V2013, "终端摄像头立即拍摄命令应答"),
    JT808_Message_0x0900(0x0900, V2011, "终端数据上行透传"),
    JT808_Message_0x0901(0x0901, V2011, "终端数据压缩上报"),
    JT808_Message_0x0A00(0x0A00, V2011, "终端RSA公钥"),

    JT808_Message_0x8001(0x8001, V2011, "平台通用应答"),
    JT808_Message_0x8003(0x8003, V2013, "平台补传分包请求"),
    JT808_Message_0x8004(0x8004, V2019, "平台查询服务器时间应答"),
    JT808_Message_0x8100(0x8100, V2011, "平台终端注册应答"),
    JT808_Message_0x8103(0x8103, V2011, "平台设置终端参数"),
    JT808_Message_0x8104(0x8104, V2011, "平台查询终端参数"),
    JT808_Message_0x8105(0x8105, V2011, "平台终端控制"),
    JT808_Message_0x8106(0x8106, V2013, "平台查询指定终端参数"),
    JT808_Message_0x8107(0x8107, V2013, "平台查询终端属性"),
    JT808_Message_0x8108(0x8108, V2013, "平台下发终端升级包"),
    JT808_Message_0x8201(0x8201, V2011, "平台位置信息查询"),
    JT808_Message_0x8202(0x8202, V2011, "平台临时位置跟踪控制"),
    JT808_Message_0x8203(0x8203, V2013, "平台人工确认报警消息"),
    JT808_Message_0x8204(0x8204, V2019, "平台终端链路检测指令"),
    JT808_Message_0x8300(0x8300, V2011, "平台文本信息下发"),
    JT808_Message_0x8301(0x8301, V2011, "平台事件设置"),
    JT808_Message_0x8302(0x8302, V2011, "平台提问下发"),
    JT808_Message_0x8303(0x8303, V2011, "平台信息点播菜单设置"),
    JT808_Message_0x8304(0x8304, V2011, "平台信息服务"),
    JT808_Message_0x8400(0x8400, V2011, "平台电话回拨"),
    JT808_Message_0x8401(0x8401, V2011, "平台设置电话本"),
    JT808_Message_0x8500(0x8500, V2011, "平台车辆控制"),
    JT808_Message_0x8600(0x8600, V2011, "平台设置圆形区域"),
    JT808_Message_0x8601(0x8601, V2011, "平台删除圆形区域"),
    JT808_Message_0x8602(0x8602, V2011, "平台设置矩形区域"),
    JT808_Message_0x8603(0x8603, V2011, "平台删除矩形区域"),
    JT808_Message_0x8604(0x8604, V2011, "平台设置多边形区域"),
    JT808_Message_0x8605(0x8605, V2011, "平台删除多边形区域"),
    JT808_Message_0x8606(0x8606, V2011, "平台设置路线"),
    JT808_Message_0x8607(0x8607, V2011, "平台删除路线"),
    JT808_Message_0x8608(0x8608, V2019, "平台查询区域或线路数据"),
    JT808_Message_0x8700(0x8700, V2011, "平台行驶记录数据采集命令"),
    JT808_Message_0x8701(0x8701, V2011, "平台行驶记录参数下传命令"),
    JT808_Message_0x8702(0x8702, V2013, "平台上报驾驶员身份信息请求"),
    JT808_Message_0x8800(0x8800, V2011, "平台多媒体数据上传应答"),
    JT808_Message_0x8801(0x8801, V2011, "平台摄像头立即拍摄命令"),
    JT808_Message_0x8802(0x8802, V2011, "平台存储多媒体数据检索"),
    JT808_Message_0x8803(0x8803, V2011, "平台存储多媒体数据上传"),
    JT808_Message_0x8804(0x8804, V2011, "平台录音开始命令"),
    JT808_Message_0x8805(0x8805, V2013, "平台单条存储多媒体数据检索上传命令"),
    JT808_Message_0x8900(0x8900, V2011, "平台数据下行透传"),
    JT808_Message_0x8A00(0x8A00, V2011, "平台RSA公钥"),
    ;

    private Integer value;

    private JT808ProtocolVersion since;

    private String description;

    JT808MessageId(int value, JT808ProtocolVersion since, String description) {
        this.value = value;
        this.since = since;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, JT808MessageId> mapping = new HashMap<>();

    static {
        for (JT808MessageId item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808MessageId cast(int value) {
        JT808MessageId item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808MessageId.class.getSimpleName()));
        }
        return item;
    }

    public static JT808MessageId parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808MessageId item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
