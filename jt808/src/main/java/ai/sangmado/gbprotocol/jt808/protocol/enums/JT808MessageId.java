package ai.sangmado.gbprotocol.jt808.protocol.enums;

import ai.sangmado.gbprotocol.gbcommon.enums.IMessageId;
import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808MessageException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ai.sangmado.gbprotocol.jt808.protocol.enums.JT808ProtocolVersion.*;

/**
 * JT/T 808 消息ID
 */
@Getter
@Setter
public class JT808MessageId implements IMessageId {
    public static final JT808MessageId JT808_Message_0x0001 = new JT808MessageId("JT808_Message_0x0001", 0x0001, V2011, "终端通用应答");
    public static final JT808MessageId JT808_Message_0x0002 = new JT808MessageId("JT808_Message_0x0002", 0x0002, V2011, "终端心跳");
    public static final JT808MessageId JT808_Message_0x0003 = new JT808MessageId("JT808_Message_0x0003", 0x0003, V2013, "终端注销");
    public static final JT808MessageId JT808_Message_0x0004 = new JT808MessageId("JT808_Message_0x0004", 0x0004, V2019, "终端查询服务器时间请求");
    public static final JT808MessageId JT808_Message_0x0005 = new JT808MessageId("JT808_Message_0x0005", 0x0005, V2019, "终端补传分包请求");
    public static final JT808MessageId JT808_Message_0x0100 = new JT808MessageId("JT808_Message_0x0100", 0x0100, V2011, "终端注册");
    public static final JT808MessageId JT808_Message_0x0102 = new JT808MessageId("JT808_Message_0x0102", 0x0102, V2011, "终端鉴权");
    public static final JT808MessageId JT808_Message_0x0104 = new JT808MessageId("JT808_Message_0x0104", 0x0104, V2011, "终端平台查询终端参数应答");
    public static final JT808MessageId JT808_Message_0x0107 = new JT808MessageId("JT808_Message_0x0107", 0x0107, V2013, "终端平台查询终端属性应答");
    public static final JT808MessageId JT808_Message_0x0108 = new JT808MessageId("JT808_Message_0x0108", 0x0108, V2013, "终端升级结果通知");
    public static final JT808MessageId JT808_Message_0x0200 = new JT808MessageId("JT808_Message_0x0200", 0x0200, V2011, "终端位置信息汇报");
    public static final JT808MessageId JT808_Message_0x0201 = new JT808MessageId("JT808_Message_0x0201", 0x0201, V2011, "终端位置信息查询应答");
    public static final JT808MessageId JT808_Message_0x0301 = new JT808MessageId("JT808_Message_0x0301", 0x0301, V2011, "终端事件报告");
    public static final JT808MessageId JT808_Message_0x0302 = new JT808MessageId("JT808_Message_0x0302", 0x0302, V2011, "终端提问应答");
    public static final JT808MessageId JT808_Message_0x0303 = new JT808MessageId("JT808_Message_0x0303", 0x0303, V2011, "终端信息点播或取消");
    public static final JT808MessageId JT808_Message_0x0500 = new JT808MessageId("JT808_Message_0x0500", 0x0500, V2011, "终端车辆控制应答");
    public static final JT808MessageId JT808_Message_0x0608 = new JT808MessageId("JT808_Message_0x0608", 0x0608, V2019, "终端查询区域或线路数据应答");
    public static final JT808MessageId JT808_Message_0x0700 = new JT808MessageId("JT808_Message_0x0700", 0x0700, V2011, "终端行驶记录数据上传");
    public static final JT808MessageId JT808_Message_0x0701 = new JT808MessageId("JT808_Message_0x0701", 0x0701, V2011, "终端电子运单上报");
    public static final JT808MessageId JT808_Message_0x0702 = new JT808MessageId("JT808_Message_0x0702", 0x0702, V2013, "终端驾驶员身份信息采集上报");
    public static final JT808MessageId JT808_Message_0x0704 = new JT808MessageId("JT808_Message_0x0704", 0x0704, V2013, "终端定位数据批量上传");
    public static final JT808MessageId JT808_Message_0x0705 = new JT808MessageId("JT808_Message_0x0705", 0x0705, V2013, "终端CAN总线数据上传");
    public static final JT808MessageId JT808_Message_0x0800 = new JT808MessageId("JT808_Message_0x0800", 0x0800, V2011, "终端多媒体事件信息上传");
    public static final JT808MessageId JT808_Message_0x0801 = new JT808MessageId("JT808_Message_0x0801", 0x0801, V2011, "终端多媒体数据上传");
    public static final JT808MessageId JT808_Message_0x0802 = new JT808MessageId("JT808_Message_0x0802", 0x0802, V2011, "终端存储多媒体数据检索应答");
    public static final JT808MessageId JT808_Message_0x0805 = new JT808MessageId("JT808_Message_0x0805", 0x0805, V2013, "终端摄像头立即拍摄命令应答");
    public static final JT808MessageId JT808_Message_0x0900 = new JT808MessageId("JT808_Message_0x0900", 0x0900, V2011, "终端数据上行透传");
    public static final JT808MessageId JT808_Message_0x0901 = new JT808MessageId("JT808_Message_0x0901", 0x0901, V2011, "终端数据压缩上报");
    public static final JT808MessageId JT808_Message_0x0A00 = new JT808MessageId("JT808_Message_0x0A00", 0x0A00, V2011, "终端RSA公钥");

    public static final JT808MessageId JT808_Message_0x8001 = new JT808MessageId("JT808_Message_0x8001", 0x8001, V2011, "平台通用应答");
    public static final JT808MessageId JT808_Message_0x8003 = new JT808MessageId("JT808_Message_0x8003", 0x8003, V2013, "平台补传分包请求");
    public static final JT808MessageId JT808_Message_0x8004 = new JT808MessageId("JT808_Message_0x8004", 0x8004, V2019, "平台查询服务器时间应答");
    public static final JT808MessageId JT808_Message_0x8100 = new JT808MessageId("JT808_Message_0x8100", 0x8100, V2011, "平台终端注册应答");
    public static final JT808MessageId JT808_Message_0x8103 = new JT808MessageId("JT808_Message_0x8103", 0x8103, V2011, "平台设置终端参数");
    public static final JT808MessageId JT808_Message_0x8104 = new JT808MessageId("JT808_Message_0x8104", 0x8104, V2011, "平台查询终端参数");
    public static final JT808MessageId JT808_Message_0x8105 = new JT808MessageId("JT808_Message_0x8105", 0x8105, V2011, "平台终端控制");
    public static final JT808MessageId JT808_Message_0x8106 = new JT808MessageId("JT808_Message_0x8106", 0x8106, V2013, "平台查询指定终端参数");
    public static final JT808MessageId JT808_Message_0x8107 = new JT808MessageId("JT808_Message_0x8107", 0x8107, V2013, "平台查询终端属性");
    public static final JT808MessageId JT808_Message_0x8108 = new JT808MessageId("JT808_Message_0x8108", 0x8108, V2013, "平台下发终端升级包");
    public static final JT808MessageId JT808_Message_0x8201 = new JT808MessageId("JT808_Message_0x8201", 0x8201, V2011, "平台位置信息查询");
    public static final JT808MessageId JT808_Message_0x8202 = new JT808MessageId("JT808_Message_0x8202", 0x8202, V2011, "平台临时位置跟踪控制");
    public static final JT808MessageId JT808_Message_0x8203 = new JT808MessageId("JT808_Message_0x8203", 0x8203, V2013, "平台人工确认报警消息");
    public static final JT808MessageId JT808_Message_0x8204 = new JT808MessageId("JT808_Message_0x8204", 0x8204, V2019, "平台终端链路检测指令");
    public static final JT808MessageId JT808_Message_0x8300 = new JT808MessageId("JT808_Message_0x8300", 0x8300, V2011, "平台文本信息下发");
    public static final JT808MessageId JT808_Message_0x8301 = new JT808MessageId("JT808_Message_0x8301", 0x8301, V2011, "平台事件设置");
    public static final JT808MessageId JT808_Message_0x8302 = new JT808MessageId("JT808_Message_0x8302", 0x8302, V2011, "平台提问下发");
    public static final JT808MessageId JT808_Message_0x8303 = new JT808MessageId("JT808_Message_0x8303", 0x8303, V2011, "平台信息点播菜单设置");
    public static final JT808MessageId JT808_Message_0x8304 = new JT808MessageId("JT808_Message_0x8304", 0x8304, V2011, "平台信息服务");
    public static final JT808MessageId JT808_Message_0x8400 = new JT808MessageId("JT808_Message_0x8400", 0x8400, V2011, "平台电话回拨");
    public static final JT808MessageId JT808_Message_0x8401 = new JT808MessageId("JT808_Message_0x8401", 0x8401, V2011, "平台设置电话本");
    public static final JT808MessageId JT808_Message_0x8500 = new JT808MessageId("JT808_Message_0x8500", 0x8500, V2011, "平台车辆控制");
    public static final JT808MessageId JT808_Message_0x8600 = new JT808MessageId("JT808_Message_0x8600", 0x8600, V2011, "平台设置圆形区域");
    public static final JT808MessageId JT808_Message_0x8601 = new JT808MessageId("JT808_Message_0x8601", 0x8601, V2011, "平台删除圆形区域");
    public static final JT808MessageId JT808_Message_0x8602 = new JT808MessageId("JT808_Message_0x8602", 0x8602, V2011, "平台设置矩形区域");
    public static final JT808MessageId JT808_Message_0x8603 = new JT808MessageId("JT808_Message_0x8603", 0x8603, V2011, "平台删除矩形区域");
    public static final JT808MessageId JT808_Message_0x8604 = new JT808MessageId("JT808_Message_0x8604", 0x8604, V2011, "平台设置多边形区域");
    public static final JT808MessageId JT808_Message_0x8605 = new JT808MessageId("JT808_Message_0x8605", 0x8605, V2011, "平台删除多边形区域");
    public static final JT808MessageId JT808_Message_0x8606 = new JT808MessageId("JT808_Message_0x8606", 0x8606, V2011, "平台设置路线");
    public static final JT808MessageId JT808_Message_0x8607 = new JT808MessageId("JT808_Message_0x8607", 0x8607, V2011, "平台删除路线");
    public static final JT808MessageId JT808_Message_0x8608 = new JT808MessageId("JT808_Message_0x8608", 0x8608, V2019, "平台查询区域或线路数据");
    public static final JT808MessageId JT808_Message_0x8700 = new JT808MessageId("JT808_Message_0x8700", 0x8700, V2011, "平台行驶记录数据采集命令");
    public static final JT808MessageId JT808_Message_0x8701 = new JT808MessageId("JT808_Message_0x8701", 0x8701, V2011, "平台行驶记录参数下传命令");
    public static final JT808MessageId JT808_Message_0x8702 = new JT808MessageId("JT808_Message_0x8702", 0x8702, V2013, "平台上报驾驶员身份信息请求");
    public static final JT808MessageId JT808_Message_0x8800 = new JT808MessageId("JT808_Message_0x8800", 0x8800, V2011, "平台多媒体数据上传应答");
    public static final JT808MessageId JT808_Message_0x8801 = new JT808MessageId("JT808_Message_0x8801", 0x8801, V2011, "平台摄像头立即拍摄命令");
    public static final JT808MessageId JT808_Message_0x8802 = new JT808MessageId("JT808_Message_0x8802", 0x8802, V2011, "平台存储多媒体数据检索");
    public static final JT808MessageId JT808_Message_0x8803 = new JT808MessageId("JT808_Message_0x8803", 0x8803, V2011, "平台存储多媒体数据上传");
    public static final JT808MessageId JT808_Message_0x8804 = new JT808MessageId("JT808_Message_0x8804", 0x8804, V2011, "平台录音开始命令");
    public static final JT808MessageId JT808_Message_0x8805 = new JT808MessageId("JT808_Message_0x8805", 0x8805, V2013, "平台单条存储多媒体数据检索上传命令");
    public static final JT808MessageId JT808_Message_0x8900 = new JT808MessageId("JT808_Message_0x8900", 0x8900, V2011, "平台数据下行透传");
    public static final JT808MessageId JT808_Message_0x8A00 = new JT808MessageId("JT808_Message_0x8A00", 0x8A00, V2011, "平台RSA公钥");

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

    public JT808MessageId(String name, int value, IProtocolVersion since, String description) {
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
        if (!(obj instanceof JT808MessageId)) {
            return false;
        }
        return this.getValue().equals(((JT808MessageId) obj).getValue());
    }

    @Override
    public int compareTo(IMessageId o) {
        return this.getValue().compareTo(o.getValue());
    }

    private static final Map<Integer, JT808MessageId> mapping = new HashMap<>();
    private static final Map<Integer, JT808MessageId> extensions = new HashMap<>();

    static {
        mapping.put(JT808_Message_0x0001.getValue(), JT808_Message_0x0001);
        mapping.put(JT808_Message_0x0002.getValue(), JT808_Message_0x0002);
        mapping.put(JT808_Message_0x0003.getValue(), JT808_Message_0x0003);
        mapping.put(JT808_Message_0x0004.getValue(), JT808_Message_0x0004);
        mapping.put(JT808_Message_0x0005.getValue(), JT808_Message_0x0005);
        mapping.put(JT808_Message_0x0100.getValue(), JT808_Message_0x0100);
        mapping.put(JT808_Message_0x0102.getValue(), JT808_Message_0x0102);
        mapping.put(JT808_Message_0x0104.getValue(), JT808_Message_0x0104);
        mapping.put(JT808_Message_0x0107.getValue(), JT808_Message_0x0107);
        mapping.put(JT808_Message_0x0108.getValue(), JT808_Message_0x0108);
        mapping.put(JT808_Message_0x0200.getValue(), JT808_Message_0x0200);
        mapping.put(JT808_Message_0x0201.getValue(), JT808_Message_0x0201);
        mapping.put(JT808_Message_0x0301.getValue(), JT808_Message_0x0301);
        mapping.put(JT808_Message_0x0302.getValue(), JT808_Message_0x0302);
        mapping.put(JT808_Message_0x0303.getValue(), JT808_Message_0x0303);
        mapping.put(JT808_Message_0x0500.getValue(), JT808_Message_0x0500);
        mapping.put(JT808_Message_0x0608.getValue(), JT808_Message_0x0608);
        mapping.put(JT808_Message_0x0700.getValue(), JT808_Message_0x0700);
        mapping.put(JT808_Message_0x0701.getValue(), JT808_Message_0x0701);
        mapping.put(JT808_Message_0x0702.getValue(), JT808_Message_0x0702);
        mapping.put(JT808_Message_0x0704.getValue(), JT808_Message_0x0704);
        mapping.put(JT808_Message_0x0705.getValue(), JT808_Message_0x0705);
        mapping.put(JT808_Message_0x0800.getValue(), JT808_Message_0x0800);
        mapping.put(JT808_Message_0x0801.getValue(), JT808_Message_0x0801);
        mapping.put(JT808_Message_0x0802.getValue(), JT808_Message_0x0802);
        mapping.put(JT808_Message_0x0805.getValue(), JT808_Message_0x0805);
        mapping.put(JT808_Message_0x0900.getValue(), JT808_Message_0x0900);
        mapping.put(JT808_Message_0x0901.getValue(), JT808_Message_0x0901);
        mapping.put(JT808_Message_0x0A00.getValue(), JT808_Message_0x0A00);

        mapping.put(JT808_Message_0x8001.getValue(), JT808_Message_0x8001);
        mapping.put(JT808_Message_0x8003.getValue(), JT808_Message_0x8003);
        mapping.put(JT808_Message_0x8004.getValue(), JT808_Message_0x8004);
        mapping.put(JT808_Message_0x8100.getValue(), JT808_Message_0x8100);
        mapping.put(JT808_Message_0x8103.getValue(), JT808_Message_0x8103);
        mapping.put(JT808_Message_0x8104.getValue(), JT808_Message_0x8104);
        mapping.put(JT808_Message_0x8105.getValue(), JT808_Message_0x8105);
        mapping.put(JT808_Message_0x8106.getValue(), JT808_Message_0x8106);
        mapping.put(JT808_Message_0x8107.getValue(), JT808_Message_0x8107);
        mapping.put(JT808_Message_0x8108.getValue(), JT808_Message_0x8108);
        mapping.put(JT808_Message_0x8201.getValue(), JT808_Message_0x8201);
        mapping.put(JT808_Message_0x8202.getValue(), JT808_Message_0x8202);
        mapping.put(JT808_Message_0x8203.getValue(), JT808_Message_0x8203);
        mapping.put(JT808_Message_0x8204.getValue(), JT808_Message_0x8204);
        mapping.put(JT808_Message_0x8300.getValue(), JT808_Message_0x8300);
        mapping.put(JT808_Message_0x8301.getValue(), JT808_Message_0x8301);
        mapping.put(JT808_Message_0x8302.getValue(), JT808_Message_0x8302);
        mapping.put(JT808_Message_0x8303.getValue(), JT808_Message_0x8303);
        mapping.put(JT808_Message_0x8304.getValue(), JT808_Message_0x8304);
        mapping.put(JT808_Message_0x8400.getValue(), JT808_Message_0x8400);
        mapping.put(JT808_Message_0x8401.getValue(), JT808_Message_0x8401);
        mapping.put(JT808_Message_0x8500.getValue(), JT808_Message_0x8500);
        mapping.put(JT808_Message_0x8600.getValue(), JT808_Message_0x8600);
        mapping.put(JT808_Message_0x8601.getValue(), JT808_Message_0x8601);
        mapping.put(JT808_Message_0x8602.getValue(), JT808_Message_0x8602);
        mapping.put(JT808_Message_0x8603.getValue(), JT808_Message_0x8603);
        mapping.put(JT808_Message_0x8604.getValue(), JT808_Message_0x8604);
        mapping.put(JT808_Message_0x8605.getValue(), JT808_Message_0x8605);
        mapping.put(JT808_Message_0x8606.getValue(), JT808_Message_0x8606);
        mapping.put(JT808_Message_0x8607.getValue(), JT808_Message_0x8607);
        mapping.put(JT808_Message_0x8608.getValue(), JT808_Message_0x8608);
        mapping.put(JT808_Message_0x8700.getValue(), JT808_Message_0x8700);
        mapping.put(JT808_Message_0x8701.getValue(), JT808_Message_0x8701);
        mapping.put(JT808_Message_0x8702.getValue(), JT808_Message_0x8702);
        mapping.put(JT808_Message_0x8800.getValue(), JT808_Message_0x8800);
        mapping.put(JT808_Message_0x8801.getValue(), JT808_Message_0x8801);
        mapping.put(JT808_Message_0x8802.getValue(), JT808_Message_0x8802);
        mapping.put(JT808_Message_0x8803.getValue(), JT808_Message_0x8803);
        mapping.put(JT808_Message_0x8804.getValue(), JT808_Message_0x8804);
        mapping.put(JT808_Message_0x8805.getValue(), JT808_Message_0x8805);
        mapping.put(JT808_Message_0x8900.getValue(), JT808_Message_0x8900);
        mapping.put(JT808_Message_0x8A00.getValue(), JT808_Message_0x8A00);
    }

    public static JT808MessageId cast(int value) {
        JT808MessageId item = tryCast(value);
        if (item == null) {
            throw new UnsupportedJT808MessageException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808MessageId.class.getSimpleName()));
        }
        return item;
    }

    public static JT808MessageId tryCast(int value) {
        JT808MessageId item = mapping.get(value);
        if (item == null) {
            item = extensions.get(value);
        }
        return item;
    }

    public static boolean exists(int value) {
        return tryCast(value) != null;
    }

    public static List<JT808MessageId> list() {
        List<JT808MessageId> l = new ArrayList<>(mapping.values());
        l.addAll(extensions.values());
        return l;
    }

    public static void putExtensions(List<JT808MessageId> messages) {
        messages.forEach(i -> extensions.put(i.getValue(), i));
    }
}
