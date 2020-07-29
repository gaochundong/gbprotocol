package ai.sangmado.gbprotocol.jt808db37lubiao.protocol.enums;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808db37lubiao.protocol.exceptions.UnsupportedJT808DB37LuBiaoMessageException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ai.sangmado.gbprotocol.jt808db37lubiao.protocol.enums.JT808DB37LuBiaoProtocolVersion.V2020;

/**
 * 鲁标 消息ID
 */
@Getter
@Setter
public class JT808DB37LuBiaoMessageId extends JT808MessageId {
    public static final JT808DB37LuBiaoMessageId JT808DB37LuBiao_Message_0x1210 = new JT808DB37LuBiaoMessageId("JT808DB37LuBiao_Message_0x1210", 0x1210, V2020, "报警附件信息消息");
    public static final JT808DB37LuBiaoMessageId JT808DB37LuBiao_Message_0x1211 = new JT808DB37LuBiaoMessageId("JT808DB37LuBiao_Message_0x1211", 0x1211, V2020, "文件信息上传");
    public static final JT808DB37LuBiaoMessageId JT808DB37LuBiao_Message_0x1212 = new JT808DB37LuBiaoMessageId("JT808DB37LuBiao_Message_0x1212", 0x1212, V2020, "文件上传完成消息");
    public static final JT808DB37LuBiaoMessageId JT808DB37LuBiao_Message_0x9208 = new JT808DB37LuBiaoMessageId("JT808DB37LuBiao_Message_0x9208", 0x9208, V2020, "报警附件上传指令");
    public static final JT808DB37LuBiaoMessageId JT808DB37LuBiao_Message_0x9212 = new JT808DB37LuBiaoMessageId("JT808DB37LuBiao_Message_0x9212", 0x9212, V2020, "文件上传完成消息应答");

    public static final JT808DB37LuBiaoMessageId JT808DB37LuBiao_Message_0x8E10 = new JT808DB37LuBiaoMessageId("JT808DB37LuBiao_Message_0x8E10", 0x8E10, V2020, "驾驶员比对结果上报应答");
    public static final JT808DB37LuBiaoMessageId JT808DB37LuBiao_Message_0x8E11 = new JT808DB37LuBiaoMessageId("JT808DB37LuBiao_Message_0x8E11", 0x8E11, V2020, "驾驶员图片信息设置");
    public static final JT808DB37LuBiaoMessageId JT808DB37LuBiao_Message_0x8E12 = new JT808DB37LuBiaoMessageId("JT808DB37LuBiao_Message_0x8E12", 0x8E12, V2020, "驾驶员信息查询");

    public static final JT808DB37LuBiaoMessageId JT808DB37LuBiao_Message_0x0E10 = new JT808DB37LuBiaoMessageId("JT808DB37LuBiao_Message_0x0E10", 0x0E10, V2020, "驾驶员比对结果上报");
    public static final JT808DB37LuBiaoMessageId JT808DB37LuBiao_Message_0x0E11 = new JT808DB37LuBiaoMessageId("JT808DB37LuBiao_Message_0x0E11", 0x0E11, V2020, "驾驶员图片下载应答");
    public static final JT808DB37LuBiaoMessageId JT808DB37LuBiao_Message_0x0E12 = new JT808DB37LuBiaoMessageId("JT808DB37LuBiao_Message_0x0E12", 0x0E12, V2020, "驾驶员信息应答");

    public JT808DB37LuBiaoMessageId(String name, int value, IProtocolVersion since, String description) {
        super(name, value, since, description);
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
        if (!(obj instanceof JT808DB37LuBiaoMessageId)) {
            return false;
        }
        return this.getValue().equals(((JT808DB37LuBiaoMessageId) obj).getValue());
    }

    private static final Map<Integer, JT808DB37LuBiaoMessageId> mapping = new HashMap<>();

    static {
        mapping.put(JT808DB37LuBiao_Message_0x1210.getValue(), JT808DB37LuBiao_Message_0x1210);
        mapping.put(JT808DB37LuBiao_Message_0x1211.getValue(), JT808DB37LuBiao_Message_0x1211);
        mapping.put(JT808DB37LuBiao_Message_0x1212.getValue(), JT808DB37LuBiao_Message_0x1212);
        mapping.put(JT808DB37LuBiao_Message_0x9208.getValue(), JT808DB37LuBiao_Message_0x9208);
        mapping.put(JT808DB37LuBiao_Message_0x9212.getValue(), JT808DB37LuBiao_Message_0x9212);

        mapping.put(JT808DB37LuBiao_Message_0x8E10.getValue(), JT808DB37LuBiao_Message_0x8E10);
        mapping.put(JT808DB37LuBiao_Message_0x8E11.getValue(), JT808DB37LuBiao_Message_0x8E11);
        mapping.put(JT808DB37LuBiao_Message_0x8E12.getValue(), JT808DB37LuBiao_Message_0x8E12);

        mapping.put(JT808DB37LuBiao_Message_0x0E10.getValue(), JT808DB37LuBiao_Message_0x0E10);
        mapping.put(JT808DB37LuBiao_Message_0x0E11.getValue(), JT808DB37LuBiao_Message_0x0E11);
        mapping.put(JT808DB37LuBiao_Message_0x0E12.getValue(), JT808DB37LuBiao_Message_0x0E12);
    }

    public static JT808DB37LuBiaoMessageId cast(int value) {
        JT808DB37LuBiaoMessageId item = tryCast(value);
        if (item == null) {
            throw new UnsupportedJT808DB37LuBiaoMessageException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808DB37LuBiaoMessageId.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DB37LuBiaoMessageId tryCast(int value) {
        return mapping.get(value);
    }

    public static boolean exists(int value) {
        return mapping.containsKey(value);
    }

    public static List<JT808DB37LuBiaoMessageId> get_JT808DB37LuBiaoMessageId_List() {
        return new ArrayList<>(mapping.values());
    }
}
