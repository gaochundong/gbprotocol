package ai.sangmado.gbprotocol.jt808db23heibiao.protocol.enums;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808db23heibiao.protocol.exceptions.UnsupportedJT808DB23HeiBiaoMessageException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ai.sangmado.gbprotocol.jt808db23heibiao.protocol.enums.JT808DB23HeiBiaoProtocolVersion.V2020;

/**
 * 黑标 消息ID
 */
@Getter
@Setter
public class JT808DB23HeiBiaoMessageId extends JT808MessageId {
    public static final JT808DB23HeiBiaoMessageId JT808DB23HeiBiao_Message_0x1210 = new JT808DB23HeiBiaoMessageId("JT808DB23HeiBiao_Message_0x1210", 0x1210, V2020, "报警附件信息消息");
    public static final JT808DB23HeiBiaoMessageId JT808DB23HeiBiao_Message_0x1211 = new JT808DB23HeiBiaoMessageId("JT808DB23HeiBiao_Message_0x1211", 0x1211, V2020, "文件信息上传");
    public static final JT808DB23HeiBiaoMessageId JT808DB23HeiBiao_Message_0x1212 = new JT808DB23HeiBiaoMessageId("JT808DB23HeiBiao_Message_0x1212", 0x1212, V2020, "文件上传完成消息");
    public static final JT808DB23HeiBiaoMessageId JT808DB23HeiBiao_Message_0x9208 = new JT808DB23HeiBiaoMessageId("JT808DB23HeiBiao_Message_0x9208", 0x9208, V2020, "报警附件上传指令");
    public static final JT808DB23HeiBiaoMessageId JT808DB23HeiBiao_Message_0x9212 = new JT808DB23HeiBiaoMessageId("JT808DB23HeiBiao_Message_0x9212", 0x9212, V2020, "文件上传完成消息应答");

    public static final JT808DB23HeiBiaoMessageId JT808DB23HeiBiao_Message_0x8C01 = new JT808DB23HeiBiaoMessageId("JT808DB23HeiBiao_Message_0x8C01", 0x8C01, V2020, "人证照片更新通知");
    public static final JT808DB23HeiBiaoMessageId JT808DB23HeiBiao_Message_0x0C02 = new JT808DB23HeiBiaoMessageId("JT808DB23HeiBiao_Message_0x0C02", 0x0C02, V2020, "驾驶员人证照片更新请求");
    public static final JT808DB23HeiBiaoMessageId JT808DB23HeiBiao_Message_0x8C02 = new JT808DB23HeiBiaoMessageId("JT808DB23HeiBiao_Message_0x8C02", 0x8C02, V2020, "驾驶员人证照片更新请求应答");
    public static final JT808DB23HeiBiaoMessageId JT808DB23HeiBiao_Message_0x0C00 = new JT808DB23HeiBiaoMessageId("JT808DB23HeiBiao_Message_0x0C00", 0x0C00, V2020, "驾驶员身份识别上报");
    
    public static final JT808DB23HeiBiaoMessageId JT808DB23HeiBiao_Message_0x0F01 = new JT808DB23HeiBiaoMessageId("JT808DB23HeiBiao_Message_0x0F01", 0x0F01, V2020, "设备状态汇总上报日报");

    public JT808DB23HeiBiaoMessageId(String name, int value, IProtocolVersion since, String description) {
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
        if (!(obj instanceof JT808DB23HeiBiaoMessageId)) {
            return false;
        }
        return this.getValue().equals(((JT808DB23HeiBiaoMessageId) obj).getValue());
    }

    private static final Map<Integer, JT808DB23HeiBiaoMessageId> mapping = new HashMap<>();

    static {
        mapping.put(JT808DB23HeiBiao_Message_0x1210.getValue(), JT808DB23HeiBiao_Message_0x1210);
        mapping.put(JT808DB23HeiBiao_Message_0x1211.getValue(), JT808DB23HeiBiao_Message_0x1211);
        mapping.put(JT808DB23HeiBiao_Message_0x1212.getValue(), JT808DB23HeiBiao_Message_0x1212);
        mapping.put(JT808DB23HeiBiao_Message_0x9208.getValue(), JT808DB23HeiBiao_Message_0x9208);
        mapping.put(JT808DB23HeiBiao_Message_0x9212.getValue(), JT808DB23HeiBiao_Message_0x9212);

        mapping.put(JT808DB23HeiBiao_Message_0x8C01.getValue(), JT808DB23HeiBiao_Message_0x8C01);
        mapping.put(JT808DB23HeiBiao_Message_0x0C02.getValue(), JT808DB23HeiBiao_Message_0x0C02);
        mapping.put(JT808DB23HeiBiao_Message_0x8C02.getValue(), JT808DB23HeiBiao_Message_0x8C02);
        mapping.put(JT808DB23HeiBiao_Message_0x0C00.getValue(), JT808DB23HeiBiao_Message_0x0C00);

        mapping.put(JT808DB23HeiBiao_Message_0x0F01.getValue(), JT808DB23HeiBiao_Message_0x0F01);
    }

    public static JT808DB23HeiBiaoMessageId cast(int value) {
        JT808DB23HeiBiaoMessageId item = tryCast(value);
        if (item == null) {
            throw new UnsupportedJT808DB23HeiBiaoMessageException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808DB23HeiBiaoMessageId.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DB23HeiBiaoMessageId tryCast(int value) {
        return mapping.get(value);
    }

    public static boolean exists(int value) {
        return mapping.containsKey(value);
    }

    public static List<JT808DB23HeiBiaoMessageId> get_JT808DB23HeiBiaoMessageId_List() {
        return new ArrayList<>(mapping.values());
    }
}
