package ai.sangmado.gbprotocol.jt808db51chuanbiao.protocol.enums;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808db51chuanbiao.protocol.exceptions.UnsupportedJT808DB51ChuanBiaoMessageException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ai.sangmado.gbprotocol.jt808db51chuanbiao.protocol.enums.JT808DB51ChuanBiaoProtocolVersion.V2019;

/**
 * 川标 消息ID
 */
@Getter
@Setter
public class JT808DB51ChuanBiaoMessageId extends JT808MessageId {
    public static final JT808DB51ChuanBiaoMessageId JT808DB51ChuanBiao_Message_0x1210 = new JT808DB51ChuanBiaoMessageId("JT808DB51ChuanBiao_Message_0x1210", 0x1210, V2019, "报警附件信息消息");
    public static final JT808DB51ChuanBiaoMessageId JT808DB51ChuanBiao_Message_0x1211 = new JT808DB51ChuanBiaoMessageId("JT808DB51ChuanBiao_Message_0x1211", 0x1211, V2019, "文件信息上传");
    public static final JT808DB51ChuanBiaoMessageId JT808DB51ChuanBiao_Message_0x1212 = new JT808DB51ChuanBiaoMessageId("JT808DB51ChuanBiao_Message_0x1212", 0x1212, V2019, "文件上传完成消息");
    public static final JT808DB51ChuanBiaoMessageId JT808DB51ChuanBiao_Message_0x9208 = new JT808DB51ChuanBiaoMessageId("JT808DB51ChuanBiao_Message_0x9208", 0x9208, V2019, "报警附件上传指令");
    public static final JT808DB51ChuanBiaoMessageId JT808DB51ChuanBiao_Message_0x9212 = new JT808DB51ChuanBiaoMessageId("JT808DB51ChuanBiao_Message_0x9212", 0x9212, V2019, "文件上传完成消息应答");

    public JT808DB51ChuanBiaoMessageId(String name, int value, IProtocolVersion since, String description) {
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
        if (!(obj instanceof JT808DB51ChuanBiaoMessageId)) {
            return false;
        }
        return this.getValue().equals(((JT808DB51ChuanBiaoMessageId) obj).getValue());
    }

    private static final Map<Integer, JT808DB51ChuanBiaoMessageId> mapping = new HashMap<>();

    static {
        mapping.put(JT808DB51ChuanBiao_Message_0x1210.getValue(), JT808DB51ChuanBiao_Message_0x1210);
        mapping.put(JT808DB51ChuanBiao_Message_0x1211.getValue(), JT808DB51ChuanBiao_Message_0x1211);
        mapping.put(JT808DB51ChuanBiao_Message_0x1212.getValue(), JT808DB51ChuanBiao_Message_0x1212);
        mapping.put(JT808DB51ChuanBiao_Message_0x9208.getValue(), JT808DB51ChuanBiao_Message_0x9208);
        mapping.put(JT808DB51ChuanBiao_Message_0x9212.getValue(), JT808DB51ChuanBiao_Message_0x9212);
    }

    public static JT808DB51ChuanBiaoMessageId cast(int value) {
        JT808DB51ChuanBiaoMessageId item = tryCast(value);
        if (item == null) {
            throw new UnsupportedJT808DB51ChuanBiaoMessageException(String.format(
                    "Cannot cast integer [%s] to [%s] enum.",
                    value, JT808DB51ChuanBiaoMessageId.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DB51ChuanBiaoMessageId tryCast(int value) {
        return mapping.get(value);
    }

    public static boolean exists(int value) {
        return mapping.containsKey(value);
    }

    public static List<JT808DB51ChuanBiaoMessageId> get_JT808DB51ChuanBiaoMessageId_List() {
        return new ArrayList<>(mapping.values());
    }
}
