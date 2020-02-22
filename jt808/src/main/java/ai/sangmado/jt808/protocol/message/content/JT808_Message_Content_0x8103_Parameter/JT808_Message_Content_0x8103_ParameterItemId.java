package ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter;

import ai.sangmado.gbcommon.enums.IProtocolVersion;
import ai.sangmado.jt808.protocol.exceptions.UnsupportedJT808MessageException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ai.sangmado.jt808.protocol.enums.JT808ProtocolVersion.*;

/**
 * 终端􏰉􏱀􏰏􏰙􏱁平台设置终端参数 - 参数项ID
 */
@Getter
@Setter
public class JT808_Message_Content_0x8103_ParameterItemId implements Comparable<JT808_Message_Content_0x8103_ParameterItemId> {
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0001 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0001", 0x0001, V2011, "终端心跳发送间隔");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0002 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0002", 0x0002, V2011, "TCP消息应答超时时间");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0003 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0003", 0x0003, V2011, "TCP消息重传次数");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0004 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0004", 0x0004, V2011, "UDP消息应答超时时间");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0005 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0005", 0x0005, V2011, "UDP消息重传次数");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0006 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0006", 0x0006, V2011, "SMS消息应答超时时间");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0007 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0007", 0x0007, V2011, "SMS消息重传次数");

    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0010 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0010", 0x0010, V2011, "主服务器APN无线通信拨号访问点");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0011 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0011", 0x0011, V2011, "主服务器无线通信拨号用户名");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0012 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0012", 0x0012, V2011, "主服务器无线通信拨号密码");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0013 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0013", 0x0013, V2011, "主服务器地址IP或域名");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0014 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0014", 0x0014, V2011, "备份服务器APN无线通信拨号访问点");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0015 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0015", 0x0015, V2011, "备份服务器无线通信拨号用户名");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0016 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0016", 0x0016, V2011, "备份服务器无线通信拨号密码");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0017 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0017", 0x0017, V2011, "备份服务器地址IP或域名");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0018 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0018", 0x0018, V2011, "服务器TCP端口");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0019 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0019", 0x0019, V2011, "服务器UDP端口");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x001A = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x001A", 0x001A, V2013, "道路运输证IC卡认证主服务器IP地址或域名");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x001B = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x001B", 0x001B, V2013, "道路运输证IC卡认证主服务器TCP端口");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x001C = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x001C", 0x001C, V2013, "道路运输证IC卡认证主服务器UDP端口");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x001D = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x001D", 0x001D, V2013, "道路运输证IC卡认证备份服务器IP地址或域名");

    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0020 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0020", 0x0020, V2011, "位置汇报策略");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0021 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0021", 0x0021, V2011, "位置汇报方案");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0022 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0022", 0x0022, V2011, "驾驶员未登录汇报时间间隔");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0023 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0023", 0x0023, V2019, "从服务器APN");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0024 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0024", 0x0024, V2019, "从服务器无线通信拨号用户名");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0025 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0025", 0x0025, V2019, "从服务器无线通信拨号密码");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0026 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0026", 0x0026, V2019, "从服务器备份地址IP或域名");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0027 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0027", 0x0027, V2011, "休眠时汇报时间间隔");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0028 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0028", 0x0028, V2011, "紧急报警时汇报时间间隔");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0029 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0029", 0x0029, V2011, "缺省时间汇报间隔");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x002C = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x002C", 0x002C, V2011, "缺省距离汇报间隔");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x002D = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x002D", 0x002D, V2011, "驾驶员未登录汇报距离间隔");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x002E = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x002E", 0x002E, V2011, "休眠时汇报距离间隔");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x002F = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x002F", 0x002F, V2011, "紧急报警时汇报距离间隔");

    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0030 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0030", 0x0030, V2011, "拐点补传角度");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0031 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0031", 0x0031, V2013, "电子围栏半径");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0032 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0032", 0x0032, V2019, "违规行驶时段范围");

    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0040 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0040", 0x0040, V2011, "监控平台电话号码");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0041 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0041", 0x0041, V2011, "复位电话号码");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0042 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0042", 0x0042, V2011, "恢复出厂设置的电话号码");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0043 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0043", 0x0043, V2011, "监控平台SMS电话号码");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0044 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0044", 0x0044, V2011, "接收终端SMS文本报警号码");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0045 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0045", 0x0045, V2011, "终端电话接听策略");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0046 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0046", 0x0046, V2011, "每次最长通话时间");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0047 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0047", 0x0047, V2011, "当月最长通话时间");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0048 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0048", 0x0048, V2011, "监听电话号码");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0049 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0049", 0x0049, V2011, "监管平台特权短信号码");

    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0050 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0050", 0x0050, V2011, "报警屏蔽字");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0051 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0051", 0x0051, V2011, "报警发送文本SMS开关");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0052 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0052", 0x0052, V2011, "报警拍摄开关");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0053 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0053", 0x0053, V2011, "报警拍摄存储标志");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0054 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0054", 0x0054, V2011, "关键标志");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0055 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0055", 0x0055, V2011, "最高速度");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0056 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0056", 0x0056, V2011, "超速持续时间");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0057 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0057", 0x0057, V2011, "连续驾驶时间门限");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0058 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0058", 0x0058, V2011, "当天累计驾驶时间门限");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0059 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0059", 0x0059, V2011, "最小休息时间");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x005A = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x005A", 0x005A, V2011, "最长停车时间");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x005B = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x005B", 0x005B, V2013, "超速报警预警差值");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x005C = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x005C", 0x005C, V2013, "疲劳驾驶预警差值");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x005D = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x005D", 0x005D, V2013, "碰撞报警参数设置");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x005E = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x005E", 0x005E, V2013, "侧翻报警参数设置");

    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0064 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0064", 0x0064, V2013, "定时拍照控制");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0065 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0065", 0x0065, V2013, "定距拍照控制");

    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0070 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0070", 0x0070, V2011, "图像视频质量");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0071 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0071", 0x0071, V2011, "亮度");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0072 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0072", 0x0072, V2011, "对比度");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0073 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0073", 0x0073, V2011, "饱和度");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0074 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0074", 0x0074, V2011, "色度");

    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0080 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0080", 0x0080, V2011, "车辆里程表读数");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0081 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0081", 0x0081, V2011, "车辆所在的省域");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0082 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0082", 0x0082, V2011, "车辆所在的市域");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0083 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0083", 0x0083, V2011, "公安交通管理部门颁发的机动车号牌");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0084 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0084", 0x0084, V2011, "车辆颜色");

    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0090 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0090", 0x0090, V2013, "GNSS定位模式");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0091 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0091", 0x0091, V2013, "GNSS波特率");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0092 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0092", 0x0092, V2013, "GNSS模块详细定位数据输出频率");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0093 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0093", 0x0093, V2013, "GNSS模块详细定位数据采集频率");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0094 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0094", 0x0094, V2013, "GNSS模块详细定位数据上传方式");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0095 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0095", 0x0095, V2013, "GNSS模块详细定位数据上传设置");

    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0100 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0100", 0x0100, V2013, "CAN总线通道1采集时间间隔");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0101 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0101", 0x0101, V2013, "CAN总线通道1上传时间间隔");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0102 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0102", 0x0102, V2013, "CAN总线通道2上传时间间隔");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0103 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0103", 0x0103, V2013, "CAN总线通道2上传时间间隔");
    public static final JT808_Message_Content_0x8103_ParameterItemId JT808_0x8103_0x0110 = new JT808_Message_Content_0x8103_ParameterItemId("JT808_0x8103_0x0110", 0x0110, V2013, "CAN总线ID单独采集设置");

    /**
     * 参数项ID名称
     */
    private String name;
    /**
     * 参数项ID值
     */
    private Long value;
    /**
     * 参数项ID来自版本
     */
    private IProtocolVersion since;
    /**
     * 参数项ID描述
     */
    private String description;

    public JT808_Message_Content_0x8103_ParameterItemId(String name, long value, IProtocolVersion since, String description) {
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
        if (!(obj instanceof JT808_Message_Content_0x8103_ParameterItemId)) {
            return false;
        }
        return ((JT808_Message_Content_0x8103_ParameterItemId) obj).getValue().equals(this.getValue());
    }

    @Override
    public int compareTo(JT808_Message_Content_0x8103_ParameterItemId o) {
        return this.getValue().compareTo(o.getValue());
    }

    private static final Map<Long, JT808_Message_Content_0x8103_ParameterItemId> mapping = new HashMap<>();
    private static final Map<Long, JT808_Message_Content_0x8103_ParameterItemId> extensions = new HashMap<>();

    static {
        mapping.put(JT808_0x8103_0x0001.getValue(), JT808_0x8103_0x0001);
        mapping.put(JT808_0x8103_0x0002.getValue(), JT808_0x8103_0x0002);
        mapping.put(JT808_0x8103_0x0003.getValue(), JT808_0x8103_0x0003);
        mapping.put(JT808_0x8103_0x0004.getValue(), JT808_0x8103_0x0004);
        mapping.put(JT808_0x8103_0x0005.getValue(), JT808_0x8103_0x0005);
        mapping.put(JT808_0x8103_0x0006.getValue(), JT808_0x8103_0x0006);
        mapping.put(JT808_0x8103_0x0007.getValue(), JT808_0x8103_0x0007);

        mapping.put(JT808_0x8103_0x0010.getValue(), JT808_0x8103_0x0010);
        mapping.put(JT808_0x8103_0x0011.getValue(), JT808_0x8103_0x0011);
        mapping.put(JT808_0x8103_0x0012.getValue(), JT808_0x8103_0x0012);
        mapping.put(JT808_0x8103_0x0013.getValue(), JT808_0x8103_0x0013);
        mapping.put(JT808_0x8103_0x0014.getValue(), JT808_0x8103_0x0014);
        mapping.put(JT808_0x8103_0x0015.getValue(), JT808_0x8103_0x0015);
        mapping.put(JT808_0x8103_0x0016.getValue(), JT808_0x8103_0x0016);
        mapping.put(JT808_0x8103_0x0017.getValue(), JT808_0x8103_0x0017);
        mapping.put(JT808_0x8103_0x0018.getValue(), JT808_0x8103_0x0018);
        mapping.put(JT808_0x8103_0x0019.getValue(), JT808_0x8103_0x0019);
        mapping.put(JT808_0x8103_0x001A.getValue(), JT808_0x8103_0x001A);
        mapping.put(JT808_0x8103_0x001B.getValue(), JT808_0x8103_0x001B);
        mapping.put(JT808_0x8103_0x001C.getValue(), JT808_0x8103_0x001C);
        mapping.put(JT808_0x8103_0x001D.getValue(), JT808_0x8103_0x001D);

        mapping.put(JT808_0x8103_0x0020.getValue(), JT808_0x8103_0x0020);
        mapping.put(JT808_0x8103_0x0021.getValue(), JT808_0x8103_0x0021);
        mapping.put(JT808_0x8103_0x0022.getValue(), JT808_0x8103_0x0022);
        mapping.put(JT808_0x8103_0x0023.getValue(), JT808_0x8103_0x0023);
        mapping.put(JT808_0x8103_0x0024.getValue(), JT808_0x8103_0x0024);
        mapping.put(JT808_0x8103_0x0025.getValue(), JT808_0x8103_0x0025);
        mapping.put(JT808_0x8103_0x0026.getValue(), JT808_0x8103_0x0026);
        mapping.put(JT808_0x8103_0x0027.getValue(), JT808_0x8103_0x0027);
        mapping.put(JT808_0x8103_0x0028.getValue(), JT808_0x8103_0x0028);
        mapping.put(JT808_0x8103_0x0029.getValue(), JT808_0x8103_0x0029);
        mapping.put(JT808_0x8103_0x002C.getValue(), JT808_0x8103_0x002C);
        mapping.put(JT808_0x8103_0x002D.getValue(), JT808_0x8103_0x002D);
        mapping.put(JT808_0x8103_0x002E.getValue(), JT808_0x8103_0x002E);
        mapping.put(JT808_0x8103_0x002F.getValue(), JT808_0x8103_0x002F);

        mapping.put(JT808_0x8103_0x0030.getValue(), JT808_0x8103_0x0030);
        mapping.put(JT808_0x8103_0x0031.getValue(), JT808_0x8103_0x0031);
        mapping.put(JT808_0x8103_0x0032.getValue(), JT808_0x8103_0x0032);

        mapping.put(JT808_0x8103_0x0040.getValue(), JT808_0x8103_0x0040);
        mapping.put(JT808_0x8103_0x0041.getValue(), JT808_0x8103_0x0041);
        mapping.put(JT808_0x8103_0x0042.getValue(), JT808_0x8103_0x0042);
        mapping.put(JT808_0x8103_0x0043.getValue(), JT808_0x8103_0x0043);
        mapping.put(JT808_0x8103_0x0044.getValue(), JT808_0x8103_0x0044);
        mapping.put(JT808_0x8103_0x0045.getValue(), JT808_0x8103_0x0045);
        mapping.put(JT808_0x8103_0x0046.getValue(), JT808_0x8103_0x0046);
        mapping.put(JT808_0x8103_0x0047.getValue(), JT808_0x8103_0x0047);
        mapping.put(JT808_0x8103_0x0048.getValue(), JT808_0x8103_0x0048);
        mapping.put(JT808_0x8103_0x0049.getValue(), JT808_0x8103_0x0049);

        mapping.put(JT808_0x8103_0x0050.getValue(), JT808_0x8103_0x0050);
        mapping.put(JT808_0x8103_0x0051.getValue(), JT808_0x8103_0x0051);
        mapping.put(JT808_0x8103_0x0052.getValue(), JT808_0x8103_0x0052);
        mapping.put(JT808_0x8103_0x0053.getValue(), JT808_0x8103_0x0053);
        mapping.put(JT808_0x8103_0x0054.getValue(), JT808_0x8103_0x0054);
        mapping.put(JT808_0x8103_0x0055.getValue(), JT808_0x8103_0x0055);
        mapping.put(JT808_0x8103_0x0056.getValue(), JT808_0x8103_0x0056);
        mapping.put(JT808_0x8103_0x0057.getValue(), JT808_0x8103_0x0057);
        mapping.put(JT808_0x8103_0x0058.getValue(), JT808_0x8103_0x0058);
        mapping.put(JT808_0x8103_0x0059.getValue(), JT808_0x8103_0x0059);
        mapping.put(JT808_0x8103_0x005A.getValue(), JT808_0x8103_0x005A);
        mapping.put(JT808_0x8103_0x005B.getValue(), JT808_0x8103_0x005B);
        mapping.put(JT808_0x8103_0x005C.getValue(), JT808_0x8103_0x005C);
        mapping.put(JT808_0x8103_0x005D.getValue(), JT808_0x8103_0x005D);
        mapping.put(JT808_0x8103_0x005E.getValue(), JT808_0x8103_0x005E);

        mapping.put(JT808_0x8103_0x0064.getValue(), JT808_0x8103_0x0064);
        mapping.put(JT808_0x8103_0x0065.getValue(), JT808_0x8103_0x0065);

        mapping.put(JT808_0x8103_0x0070.getValue(), JT808_0x8103_0x0070);
        mapping.put(JT808_0x8103_0x0071.getValue(), JT808_0x8103_0x0071);
        mapping.put(JT808_0x8103_0x0072.getValue(), JT808_0x8103_0x0072);
        mapping.put(JT808_0x8103_0x0073.getValue(), JT808_0x8103_0x0073);
        mapping.put(JT808_0x8103_0x0074.getValue(), JT808_0x8103_0x0074);

        mapping.put(JT808_0x8103_0x0080.getValue(), JT808_0x8103_0x0080);
        mapping.put(JT808_0x8103_0x0081.getValue(), JT808_0x8103_0x0081);
        mapping.put(JT808_0x8103_0x0082.getValue(), JT808_0x8103_0x0082);
        mapping.put(JT808_0x8103_0x0083.getValue(), JT808_0x8103_0x0083);
        mapping.put(JT808_0x8103_0x0084.getValue(), JT808_0x8103_0x0084);

        mapping.put(JT808_0x8103_0x0090.getValue(), JT808_0x8103_0x0090);
        mapping.put(JT808_0x8103_0x0091.getValue(), JT808_0x8103_0x0091);
        mapping.put(JT808_0x8103_0x0092.getValue(), JT808_0x8103_0x0092);
        mapping.put(JT808_0x8103_0x0093.getValue(), JT808_0x8103_0x0093);
        mapping.put(JT808_0x8103_0x0094.getValue(), JT808_0x8103_0x0094);
        mapping.put(JT808_0x8103_0x0095.getValue(), JT808_0x8103_0x0095);

        mapping.put(JT808_0x8103_0x0100.getValue(), JT808_0x8103_0x0100);
        mapping.put(JT808_0x8103_0x0101.getValue(), JT808_0x8103_0x0101);
        mapping.put(JT808_0x8103_0x0102.getValue(), JT808_0x8103_0x0102);
        mapping.put(JT808_0x8103_0x0103.getValue(), JT808_0x8103_0x0103);
        mapping.put(JT808_0x8103_0x0110.getValue(), JT808_0x8103_0x0110);
    }

    public static JT808_Message_Content_0x8103_ParameterItemId cast(long value) {
        JT808_Message_Content_0x8103_ParameterItemId item = tryCast(value);
        if (item == null) {
            throw new UnsupportedJT808MessageException(String.format(
                    "Cannot cast long [%s] to [%s] enum.",
                    value, JT808_Message_Content_0x8103_ParameterItemId.class.getSimpleName()));
        }
        return item;
    }

    public static JT808_Message_Content_0x8103_ParameterItemId tryCast(long value) {
        JT808_Message_Content_0x8103_ParameterItemId item = mapping.get(value);
        if (item == null) {
            item = extensions.get(value);
        }
        return item;
    }

    public static boolean exists(long value) {
        return tryCast(value) != null;
    }

    public static List<JT808_Message_Content_0x8103_ParameterItemId> list() {
        List<JT808_Message_Content_0x8103_ParameterItemId> l = new ArrayList<>(mapping.values());
        l.addAll(extensions.values());
        return l;
    }

    public static void putExtensions(List<JT808_Message_Content_0x8103_ParameterItemId> parameterItemIdList) {
        parameterItemIdList.forEach(i -> extensions.put(i.getValue(), i));
    }
}
