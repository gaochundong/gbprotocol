package ai.sangmado.gbprotocol.jt808db23heibiao.protocol.message.content.JT808DB23HeiBiao_Message_Content_0x0200_Additional;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808MessageException;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformationId;
import ai.sangmado.gbprotocol.jt808db23heibiao.protocol.enums.JT808DB23HeiBiaoProtocolVersion;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 黑标 位置附加信息ID
 */
@Getter
@Setter
public class JT808DB23HeiBiao_Message_Content_0x0200_AdditionalInformationId extends JT808_Message_Content_0x0200_AdditionalInformationId {
    public static final JT808DB23HeiBiao_Message_Content_0x0200_AdditionalInformationId JT808DB23HeiBiao_0x0200_0x64 = new JT808DB23HeiBiao_Message_Content_0x0200_AdditionalInformationId("JT808DB23HeiBiao_0x200_0x64", 0x64, JT808DB23HeiBiaoProtocolVersion.V2020, "车辆运行监测系统报警信息");
    public static final JT808DB23HeiBiao_Message_Content_0x0200_AdditionalInformationId JT808DB23HeiBiao_0x0200_0x65 = new JT808DB23HeiBiao_Message_Content_0x0200_AdditionalInformationId("JT808DB23HeiBiao_0x200_0x65", 0x65, JT808DB23HeiBiaoProtocolVersion.V2020, "驾驶员驾驶行为监测系统报警信息");
    public static final JT808DB23HeiBiao_Message_Content_0x0200_AdditionalInformationId JT808DB23HeiBiao_0x0200_0x71 = new JT808DB23HeiBiao_Message_Content_0x0200_AdditionalInformationId("JT808DB23HeiBiao_0x200_0x71", 0x71, JT808DB23HeiBiaoProtocolVersion.V2020, "电子地图报警信息");
    public static final JT808DB23HeiBiao_Message_Content_0x0200_AdditionalInformationId JT808DB23HeiBiao_0x0200_0x32 = new JT808DB23HeiBiao_Message_Content_0x0200_AdditionalInformationId("JT808DB23HeiBiao_0x200_0x32", 0x32, JT808DB23HeiBiaoProtocolVersion.V2020, "路网图信息上传");

    public JT808DB23HeiBiao_Message_Content_0x0200_AdditionalInformationId(String name, int value, IProtocolVersion since, String description) {
        super(name, value, since, description);
    }

    private static final Map<Integer, JT808DB23HeiBiao_Message_Content_0x0200_AdditionalInformationId> mapping = new HashMap<>();

    static {
        mapping.put(JT808DB23HeiBiao_0x0200_0x64.getValue(), JT808DB23HeiBiao_0x0200_0x64);
        mapping.put(JT808DB23HeiBiao_0x0200_0x65.getValue(), JT808DB23HeiBiao_0x0200_0x65);
        mapping.put(JT808DB23HeiBiao_0x0200_0x71.getValue(), JT808DB23HeiBiao_0x0200_0x71);
        mapping.put(JT808DB23HeiBiao_0x0200_0x32.getValue(), JT808DB23HeiBiao_0x0200_0x32);
    }

    public static JT808DB23HeiBiao_Message_Content_0x0200_AdditionalInformationId cast(int value) {
        JT808DB23HeiBiao_Message_Content_0x0200_AdditionalInformationId item = tryCast(value);
        if (item == null) {
            throw new UnsupportedJT808MessageException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808DB23HeiBiao_Message_Content_0x0200_AdditionalInformationId.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DB23HeiBiao_Message_Content_0x0200_AdditionalInformationId tryCast(int value) {
        return mapping.get(value);
    }

    public static boolean exists(int value) {
        return tryCast(value) != null;
    }

    public static List<JT808DB23HeiBiao_Message_Content_0x0200_AdditionalInformationId> get_JT808DB23HeiBiao_Message_Content_0x0200_AdditionalInformationId_List() {
        return new ArrayList<>(mapping.values());
    }
}
