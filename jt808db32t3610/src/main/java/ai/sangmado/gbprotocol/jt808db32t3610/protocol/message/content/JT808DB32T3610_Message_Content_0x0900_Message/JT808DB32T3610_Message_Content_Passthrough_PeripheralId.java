package ai.sangmado.gbprotocol.jt808db32t3610.protocol.message.content.JT808DB32T3610_Message_Content_0x0900_Message;

import ai.sangmado.gbprotocol.gbcommon.enums.IProtocolVersion;
import ai.sangmado.gbprotocol.gbcommon.serializer.IntegerToHex2StringSerializer;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808MessageException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ai.sangmado.gbprotocol.jt808db32t3610.protocol.enums.JT808DB32T3610ProtocolVersion.V2019;

/**
 * 透传消息扩展 - 外设ID定义
 */
@Getter
@Setter
public class JT808DB32T3610_Message_Content_Passthrough_PeripheralId {
    public static final JT808DB32T3610_Message_Content_Passthrough_PeripheralId JT808DB32T3610_Passthrough_Peripheral_0x64 = new JT808DB32T3610_Message_Content_Passthrough_PeripheralId("JT808DB32T3610_Passthrough_Peripheral_0x64", 0x64, V2019, "驾驶辅助设备");
    public static final JT808DB32T3610_Message_Content_Passthrough_PeripheralId JT808DB32T3610_Passthrough_Peripheral_0x65 = new JT808DB32T3610_Message_Content_Passthrough_PeripheralId("JT808DB32T3610_Passthrough_Peripheral_0x65", 0x65, V2019, "驾驶员行为监测设备");
    public static final JT808DB32T3610_Message_Content_Passthrough_PeripheralId JT808DB32T3610_Passthrough_Peripheral_0x66 = new JT808DB32T3610_Message_Content_Passthrough_PeripheralId("JT808DB32T3610_Passthrough_Peripheral_0x66", 0x66, V2019, "轮胎状态监测");
    public static final JT808DB32T3610_Message_Content_Passthrough_PeripheralId JT808DB32T3610_Passthrough_Peripheral_0x67 = new JT808DB32T3610_Message_Content_Passthrough_PeripheralId("JT808DB32T3610_Passthrough_Peripheral_0x67", 0x67, V2019, "变道决策辅助");

    /**
     * 外设ID名称
     */
    @JsonIgnore
    private String name;
    /**
     * 外设ID值
     */
    @JsonInclude
    @JsonSerialize(using = IntegerToHex2StringSerializer.class, as = Object.class)
    private Integer value;
    /**
     * 外设ID来自版本
     */
    @JsonIgnore
    private IProtocolVersion since;
    /**
     * 外设ID描述
     */
    @JsonIgnore
    private String description;

    public JT808DB32T3610_Message_Content_Passthrough_PeripheralId(String name, int value, IProtocolVersion since, String description) {
        this.name = name;
        this.value = value;
        this.since = since;
        this.description = description;
    }

    private static final Map<Integer, JT808DB32T3610_Message_Content_Passthrough_PeripheralId> mapping = new HashMap<>();

    static {
        mapping.put(JT808DB32T3610_Passthrough_Peripheral_0x64.getValue(), JT808DB32T3610_Passthrough_Peripheral_0x64);
        mapping.put(JT808DB32T3610_Passthrough_Peripheral_0x65.getValue(), JT808DB32T3610_Passthrough_Peripheral_0x65);
        mapping.put(JT808DB32T3610_Passthrough_Peripheral_0x66.getValue(), JT808DB32T3610_Passthrough_Peripheral_0x66);
        mapping.put(JT808DB32T3610_Passthrough_Peripheral_0x67.getValue(), JT808DB32T3610_Passthrough_Peripheral_0x67);
    }

    public static JT808DB32T3610_Message_Content_Passthrough_PeripheralId cast(int value) {
        JT808DB32T3610_Message_Content_Passthrough_PeripheralId item = mapping.get(value);
        if (item == null) {
            throw new UnsupportedJT808MessageException(String.format(
                    "Cannot cast int [%s] to [%s] enum.",
                    value, JT808DB32T3610_Message_Content_Passthrough_PeripheralId.class.getSimpleName()));
        }
        return item;
    }

    public static JT808DB32T3610_Message_Content_Passthrough_PeripheralId tryCast(int value) {
        return mapping.get(value);
    }

    public static boolean exists(int value) {
        return tryCast(value) != null;
    }

    public static List<JT808DB32T3610_Message_Content_Passthrough_PeripheralId> get_JT808DB32T3610_Message_Content_Passthrough_PeripheralId_List() {
        return new ArrayList<>(mapping.values());
    }
}
