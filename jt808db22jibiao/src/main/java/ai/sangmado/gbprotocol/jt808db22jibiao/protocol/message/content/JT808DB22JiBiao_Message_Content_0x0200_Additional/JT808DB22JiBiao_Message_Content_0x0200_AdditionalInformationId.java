package ai.sangmado.gbprotocol.jt808db22jibiao.protocol.message.content.JT808DB22JiBiao_Message_Content_0x0200_Additional;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808MessageException;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x0200_Additional.JT808_Message_Content_0x0200_AdditionalInformationId;
import ai.sangmado.gbprotocol.jt808db22jibiao.protocol.enums.JT808DB22JiBiaoProtocolVersion;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 吉标 位置附加信息ID
 */
@Getter
@Setter
public class JT808DB22JiBiao_Message_Content_0x0200_AdditionalInformationId extends JT808_Message_Content_0x0200_AdditionalInformationId {
    public static final JT808DB22JiBiao_Message_Content_0x0200_AdditionalInformationId JT808DB22JiBiao_0x0200_0x64 = new JT808DB22JiBiao_Message_Content_0x0200_AdditionalInformationId("JT808DB22JiBiao_0x200_0x64", 0x64, JT808DB22JiBiaoProtocolVersion.V2019, "车辆运行监测系统报警信息");
    public static final JT808DB22JiBiao_Message_Content_0x0200_AdditionalInformationId JT808DB22JiBiao_0x0200_0x65 = new JT808DB22JiBiao_Message_Content_0x0200_AdditionalInformationId("JT808DB22JiBiao_0x200_0x65", 0x65, JT808DB22JiBiaoProtocolVersion.V2019, "驾驶员驾驶行为监测系统报警信息");

    public JT808DB22JiBiao_Message_Content_0x0200_AdditionalInformationId(String name, int value, IProtocolVersion since, String description) {
        super(name, value, since, description);
    }

    private static final Map<Integer, JT808DB22JiBiao_Message_Content_0x0200_AdditionalInformationId> mapping = new HashMap<>();

    static {
        mapping.put(JT808DB22JiBiao_0x0200_0x64.getValue(), JT808DB22JiBiao_0x0200_0x64);
        mapping.put(JT808DB22JiBiao_0x0200_0x65.getValue(), JT808DB22JiBiao_0x0200_0x65);
    }

    public static JT808DB22JiBiao_Message_Content_0x0200_AdditionalInformationId cast(int value) {
        JT808DB22JiBiao_Message_Content_0x0200_AdditionalInformationId item = tryCast(value);
        if (item == null) {
            throw new UnsupportedJT808MessageException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808DB22JiBiao_Message_Content_0x0200_AdditionalInformationId.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DB22JiBiao_Message_Content_0x0200_AdditionalInformationId tryCast(int value) {
        return mapping.get(value);
    }

    public static boolean exists(int value) {
        return tryCast(value) != null;
    }

    public static List<JT808DB22JiBiao_Message_Content_0x0200_AdditionalInformationId> get_JT808DB22JiBiao_Message_Content_0x0200_AdditionalInformationId_List() {
        return new ArrayList<>(mapping.values());
    }
}
