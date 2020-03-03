package ai.sangmado.gbstandard.jt808.protocol.enums;

import ai.sangmado.gbstandard.gbcommon.enums.IProtocolVersion;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

import static ai.sangmado.gbstandard.jt808.protocol.enums.JT808ProtocolVersion.*;
import static ai.sangmado.gbstandard.jt808.protocol.enums.JT808WarningDisposition.ResetAfterAck;
import static ai.sangmado.gbstandard.jt808.protocol.enums.JT808WarningDisposition.UntilLifted;

/**
 * JT/T 808 报警标志位定义
 */
@Getter
public enum JT808WarningType {
    JT808_Warning_0(1, V2011, ResetAfterAck, "紧急报警，触动报警开关后触发，收到应答后清零"),
    JT808_Warning_1(1 << 1, V2011, UntilLifted, "超速报警，标志维持至报警条件解除"),
    JT808_Warning_2(1 << 2, V2011, UntilLifted, "疲劳驾驶报警，标志维持至报警条件解除"),
    JT808_Warning_3(1 << 3, V2011, UntilLifted, "危险驾驶行为报警，标志维持至报警条件解除"),
    JT808_Warning_4(1 << 4, V2011, UntilLifted, "GNSS模块发生故障报警，标志维持至报警条件解除"),
    JT808_Warning_5(1 << 5, V2011, UntilLifted, "GNSS天线未接或被剪断报警，标志维持至报警条件解除"),
    JT808_Warning_6(1 << 6, V2011, UntilLifted, "GNSS天线短路报警，标志维持至报警条件解除"),
    JT808_Warning_7(1 << 7, V2011, UntilLifted, "终端主电源欠压报警，标志维持至报警条件解除"),
    JT808_Warning_8(1 << 8, V2011, UntilLifted, "终端主电源掉电报警，标志维持至报警条件解除"),
    JT808_Warning_9(1 << 9, V2011, UntilLifted, "终端LCD或显示器故障报警，标志维持至报警条件解除"),
    JT808_Warning_10(1 << 10, V2011, UntilLifted, "TTS模块故障报警，标志维持至报警条件解除"),
    JT808_Warning_11(1 << 11, V2011, UntilLifted, "摄像头故障报警，标志维持至报警条件解除"),
    JT808_Warning_12(1 << 12, V2013, UntilLifted, "道路运输证IC卡模块故障报警，标志维持至报警条件解除"),
    JT808_Warning_13(1 << 13, V2013, UntilLifted, "超速预警，标志维持至报警条件解除"),
    JT808_Warning_14(1 << 14, V2013, UntilLifted, "疲劳驾驶预警，标志维持至报警条件解除"),
    JT808_Warning_15(1 << 15, V2019, UntilLifted, "违规行驶报警，标志维持至报警条件解除"),
    JT808_Warning_16(1 << 16, V2019, UntilLifted, "胎压预警，标志维持至报警条件解除"),
    JT808_Warning_17(1 << 17, V2019, UntilLifted, "右转盲区异常报警，标志维持至报警条件解除"),
    JT808_Warning_18(1 << 18, V2011, UntilLifted, "当天累计驾驶超时报警，标志维持至报警条件解除"),
    JT808_Warning_19(1 << 19, V2011, UntilLifted, "超时停车报警，标志维持至报警条件解除"),
    JT808_Warning_20(1 << 20, V2011, ResetAfterAck, "进出区域报警，收到应答后清零"),
    JT808_Warning_21(1 << 21, V2011, ResetAfterAck, "进出路线报警，收到应答后清零"),
    JT808_Warning_22(1 << 22, V2011, ResetAfterAck, "路段行驶时间不足/过长报警，收到应答后清零"),
    JT808_Warning_23(1 << 23, V2011, UntilLifted, "路线偏离报警，标志维持至报警条件解除"),
    JT808_Warning_24(1 << 24, V2011, UntilLifted, "车辆VSS故障报警，标志维持至报警条件解除"),
    JT808_Warning_25(1 << 25, V2011, UntilLifted, "车辆油量异常报警，标志维持至报警条件解除"),
    JT808_Warning_26(1 << 26, V2011, UntilLifted, "车辆被盗报警，通过车辆防盗器，标志维持至报警条件解除"),
    JT808_Warning_27(1 << 27, V2011, ResetAfterAck, "车辆非法点火报警，收到应答后清零"),
    JT808_Warning_28(1 << 28, V2011, ResetAfterAck, "车辆非法位移报警，收到应答后清零"),
    JT808_Warning_29(1 << 29, V2011, UntilLifted, "碰撞报警，标志维持至报警条件解除"),
    JT808_Warning_30(1 << 20, V2013, UntilLifted, "侧翻预警，标志维持至报警条件解除"),
    JT808_Warning_31(1 << 31, V2013, ResetAfterAck, "非法开门报警，终端未设置区域时，不判断非法开门，收到应答后清零"),
    ;

    private Long value;

    private IProtocolVersion since;

    private JT808WarningDisposition disposition;

    private String description;

    JT808WarningType(long value, IProtocolVersion since, JT808WarningDisposition disposition, String description) {
        this.value = value;
        this.since = since;
        this.disposition = disposition;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Long, JT808WarningType> mapping = new HashMap<>();

    static {
        for (JT808WarningType item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808WarningType cast(long value) {
        JT808WarningType item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast long [%s] to [%s] enum.",
                    value, JT808WarningType.class.getSimpleName()));
        }
        return item;
    }

    public static JT808WarningType parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808WarningType item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
