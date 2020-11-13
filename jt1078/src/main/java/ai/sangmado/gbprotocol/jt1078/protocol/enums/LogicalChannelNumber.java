package ai.sangmado.gbprotocol.jt1078.protocol.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 营运车辆车载视频终端音视频通道定义表 (JT1076 表2)
 */
@Getter
public enum LogicalChannelNumber {
    Channel1(1, "通道1", "音视频/视频", "驾驶员"),
    Channel2(2, "通道2", "音视频/视频", "车辆正前方"),
    Channel3(3, "通道3", "音视频/视频", "车前门"),
    Channel4(4, "通道4", "音视频/视频", "车厢前部"),
    Channel5(5, "通道5", "音视频/视频", "车厢后部"),
    Channel6(6, "通道6", "音视频/视频", "车后门"),
    Channel7(7, "通道7", "音视频/视频", "行李舱"),
    Channel8(8, "通道8", "音视频/视频", "车辆左侧"),
    Channel9(9, "通道9", "音视频/视频", "车辆右侧"),
    Channel10(10, "通道10", "音视频/视频", "车辆正后方"),
    Channel11(11, "通道11", "音视频/视频", "车厢中部"),
    Channel12(12, "通道12", "音视频/视频", "车中门"),
    Channel13(13, "通道13", "音视频/视频", "驾驶席车门"),

    Channel33(33, "通道33", "音频", "驾驶员"),
    Channel36(36, "通道36", "音频", "车厢前部"),
    Channel37(37, "通道37", "音频", "车厢后部"),
    ;

    @JsonInclude
    @JsonValue
    private final Integer value;

    @JsonIgnore
    private final String channelName;

    @JsonIgnore
    private final String channelType;

    @JsonIgnore
    private final String monitorArea;

    LogicalChannelNumber(int value, String channelName, String channelType, String monitorArea) {
        this.value = value;
        this.channelName = channelName;
        this.channelType = channelType;
        this.monitorArea = monitorArea;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, LogicalChannelNumber> mapping = new HashMap<>();

    static {
        for (LogicalChannelNumber level : values()) {
            mapping.put(level.getValue(), level);
        }
    }

    @JsonCreator
    public static LogicalChannelNumber cast(int i) {
        LogicalChannelNumber level = mapping.get(i);
        if (level == null) {
            throw new IllegalArgumentException("Cannot cast integer to enum.");
        }
        return level;
    }

    public static LogicalChannelNumber parse(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        for (LogicalChannelNumber level : values()) {
            if (level.name().equalsIgnoreCase(s)) {
                return level;
            }
        }
        throw new IllegalArgumentException("Cannot parse string to enum.");
    }
}