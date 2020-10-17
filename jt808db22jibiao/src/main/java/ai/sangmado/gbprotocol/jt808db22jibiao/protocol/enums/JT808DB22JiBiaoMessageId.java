package ai.sangmado.gbprotocol.jt808db22jibiao.protocol.enums;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808db22jibiao.protocol.exceptions.UnsupportedJT808DB22JiBiaoMessageException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ai.sangmado.gbprotocol.jt808db22jibiao.protocol.enums.JT808DB22JiBiaoProtocolVersion.V2019;

/**
 * 吉标 消息ID
 */
@Getter
@Setter
public class JT808DB22JiBiaoMessageId extends JT808MessageId {
    public static final JT808DB22JiBiaoMessageId JT808DB22JiBiao_Message_0x1210 = new JT808DB22JiBiaoMessageId("JT808DB22JiBiao_Message_0x1210", 0x1210, V2019, "报警附件信息消息");
    public static final JT808DB22JiBiaoMessageId JT808DB22JiBiao_Message_0x1211 = new JT808DB22JiBiaoMessageId("JT808DB22JiBiao_Message_0x1211", 0x1211, V2019, "文件信息上传");
    public static final JT808DB22JiBiaoMessageId JT808DB22JiBiao_Message_0x1212 = new JT808DB22JiBiaoMessageId("JT808DB22JiBiao_Message_0x1212", 0x1212, V2019, "文件上传完成消息");
    public static final JT808DB22JiBiaoMessageId JT808DB22JiBiao_Message_0x9208 = new JT808DB22JiBiaoMessageId("JT808DB22JiBiao_Message_0x9208", 0x9208, V2019, "报警附件上传指令");
    public static final JT808DB22JiBiaoMessageId JT808DB22JiBiao_Message_0x9212 = new JT808DB22JiBiaoMessageId("JT808DB22JiBiao_Message_0x9212", 0x9212, V2019, "文件上传完成消息应答");

    public static final JT808DB22JiBiaoMessageId JT808DB22JiBiao_Message_0x8E11 = new JT808DB22JiBiaoMessageId("JT808DB22JiBiao_Message_0x8E11", 0x8E11, V2019, "驾驶员身份信息库下发");
    public static final JT808DB22JiBiaoMessageId JT808DB22JiBiao_Message_0x0E11 = new JT808DB22JiBiaoMessageId("JT808DB22JiBiao_Message_0x0E11", 0x0E11, V2019, "驾驶员身份库数据下载应答");
    public static final JT808DB22JiBiaoMessageId JT808DB22JiBiao_Message_0x8E12 = new JT808DB22JiBiaoMessageId("JT808DB22JiBiao_Message_0x8E12", 0x8E12, V2019, "驾驶员身份库信息查询");
    public static final JT808DB22JiBiaoMessageId JT808DB22JiBiao_Message_0x0E12 = new JT808DB22JiBiaoMessageId("JT808DB22JiBiao_Message_0x0E12", 0x0E12, V2019, "驾驶员身份库查询应答");
    public static final JT808DB22JiBiaoMessageId JT808DB22JiBiao_Message_0x8E10 = new JT808DB22JiBiaoMessageId("JT808DB22JiBiao_Message_0x8E10", 0x8E10, V2019, "驾驶员身份识别上报应答");
    public static final JT808DB22JiBiaoMessageId JT808DB22JiBiao_Message_0x0E10 = new JT808DB22JiBiaoMessageId("JT808DB22JiBiao_Message_0x0E10", 0x0E10, V2019, "驾驶员身份识别上报");

    public JT808DB22JiBiaoMessageId(String name, int value, IProtocolVersion since, String description) {
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
        if (!(obj instanceof JT808DB22JiBiaoMessageId)) {
            return false;
        }
        return this.getValue().equals(((JT808DB22JiBiaoMessageId) obj).getValue());
    }

    private static final Map<Integer, JT808DB22JiBiaoMessageId> mapping = new HashMap<>();

    static {
        mapping.put(JT808DB22JiBiao_Message_0x1210.getValue(), JT808DB22JiBiao_Message_0x1210);
        mapping.put(JT808DB22JiBiao_Message_0x1211.getValue(), JT808DB22JiBiao_Message_0x1211);
        mapping.put(JT808DB22JiBiao_Message_0x1212.getValue(), JT808DB22JiBiao_Message_0x1212);
        mapping.put(JT808DB22JiBiao_Message_0x9208.getValue(), JT808DB22JiBiao_Message_0x9208);
        mapping.put(JT808DB22JiBiao_Message_0x9212.getValue(), JT808DB22JiBiao_Message_0x9212);

        mapping.put(JT808DB22JiBiao_Message_0x8E11.getValue(), JT808DB22JiBiao_Message_0x8E11);
        mapping.put(JT808DB22JiBiao_Message_0x0E11.getValue(), JT808DB22JiBiao_Message_0x0E11);
        mapping.put(JT808DB22JiBiao_Message_0x8E12.getValue(), JT808DB22JiBiao_Message_0x8E12);
        mapping.put(JT808DB22JiBiao_Message_0x0E12.getValue(), JT808DB22JiBiao_Message_0x0E12);
        mapping.put(JT808DB22JiBiao_Message_0x0E10.getValue(), JT808DB22JiBiao_Message_0x0E10);
    }

    public static JT808DB22JiBiaoMessageId cast(int value) {
        JT808DB22JiBiaoMessageId item = tryCast(value);
        if (item == null) {
            throw new UnsupportedJT808DB22JiBiaoMessageException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808DB22JiBiaoMessageId.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DB22JiBiaoMessageId tryCast(int value) {
        return mapping.get(value);
    }

    public static boolean exists(int value) {
        return mapping.containsKey(value);
    }

    public static List<JT808DB22JiBiaoMessageId> get_JT808DB22JiBiaoMessageId_List() {
        return new ArrayList<>(mapping.values());
    }
}
