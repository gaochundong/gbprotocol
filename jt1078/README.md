# JT1078协议

JT/T1078 Global navigation satellite system for operating vehicles - Video communication protocol

JT/T1078 道路运输车辆卫星定位系统 视频通信协议

## 指令描述

继承使用 JT/T808—2011 中除消息ID为0x8804(录音开始命令)外的其他指令。

此外，JT/T808—2011中 :

- 0x0800(多媒体事件消息上传)
- 0x0801(多媒体数据上传)
- 0x8802(存储多媒体数据检 索)
- 0x0802(存储多媒体数据检索应答)
- 0x8803(存储多媒体数据上传)

共五条指令中多媒体类型字段，在本标准中应只包含图片类型，音频和视频类型的数据应按照 5.4 和 5.5 的要求进行传输。

## 实时音视频流数据的传输

实时音视频流数据的传输参考RTP协议，使用UDP或TCP承载。 

负载包格式在 IETF RFC3550 RTP定义的基础上补充了消息流水号、SIM卡号、音视频通道号等字段，其负载包格式定义见表19。 
表中定义的 bit 位按照大端模式(big-endian)进行填写。

|    帧头标识     | VPXCCMPT |     包序号     | SIM 卡号 |     逻辑通道号     | 数据类型 |  时间戳   | Last I Frame Interval | Last Frame Interval | 数据体长度 | 数据体 |
| :-------------: | :------: | :------------: | :------: | :----------------: | :------: | :-------: | :-------------------: | :-----------------: | :--------: | :----: |
| FrameHeadMarker | VPXCCMPT | SequenceNumber |   SIM    | LogicChannelNumber | DateType | Timestamp |  LastIFrameInterval   |  LastFrameInterval  | BodyLength |  Body  |

### VPXCCMPT

| RTP协议的版本号 | 填充标志 | 扩展标志 | CSRC计数器 | 标志位 | 负载类型 |
| :-------------: | :------: | :------: | :--------: | :----: | :------: |
|        V        |    P     |    X     |     CC     |   M    |    PT    |

version (V): 2 bits 
RTP版本标识，当前规范定义值为2.
This field identifies the version of RTP. The version defined by this specification is two (2).
(The value 1 is used by the first draft version of RTP and the value 0 is used by the 
protocol initially implemented in the \vat" audio tool.)

padding (P)：1 bit
如果设定padding，在报文的末端就会包含一个或者多个padding 字节，这不属于payload。
最后一个字节的padding 有一个计数器，标识需要忽略多少个padding 字节(包括自己)。
一些加密算法可能需要固定块长度的padding，或者是为了在更低层数据单元中携带一些RTP 报文。
If the padding bit is set, the packet contains one or more additional padding octets at the
end which are not part of the payload. The last octet of the padding contains a count of
how many padding octets should be ignored, including itself. Padding may be needed by
some encryption algorithms with fixed block sizes or for carrying several RTP packets in 
a lower-layer protocol data unit.

extension (X)：1 bit 
如果设定了extension 位，定长头字段后面会有一个头扩展。
If the extension bit is set, the fixed header must be followed by exactly one header extensio.

CSRC count (CC)：4 bits 
CSRC count 标识了定长头字段中包含的CSRC identifier 的数量。
The CSRC count contains the number of CSRC identifiers that follow the fixed header.

marker (M)：1 bit 
marker 是由一个profile 定义的。用来允许标识在像报文流中界定帧界等的事件。
一个profile 可能定义了附加的标识位或者通过修改payload type 域中的位数量来指定没有标识位.
The interpretation of the marker is defined by a profile. It is intended to allow significant
events such as frame boundaries to be marked in the packet stream. A profile may define
additional marker bits or specify that there is no marker bit by changing the number 
of bits in the payload type field.

payload type (PT)：7 bits
这个字段定一个RTPpayload 的格式和在应用中定义解释。
profile 可能指定一个从payload type 码字到payload format 的默认静态映射。
也可以通过non-RTP 方法来定义附加的payload type 码字(见第3 章)。
在 RFC 3551[1]中定义了一系列的默认音视频映射。
一个RTP 源有可能在会话中改变payload type，但是这个域在复用独立的媒体时是不同的。(见5.2 节)。
接收者必须忽略它不识别的payload type。
This field identifies the format of the RTP payload and determines its interpretation by the
application. A profile may specify a default static mapping of payload type codes to payload
formats. Additional payload type codes may be defined dynamically through non-RTP means
(see Section 3). A set of default mappings for audio and video is specified in the companion
RFC 3551 [1]. An RTP source may change the payload type during a session, but this field
should not be used for multiplexing separate media streams (see Section 5.2).
A receiver must ignore packets with payload types that it does not understand.

### SequenceNumber

sequence number：16 bits
每发送一个RTP 数据报文序列号值加一，接收者也可用来检测丢失的包或者重建报文序列。
初始的值是随机的，这样就使得known-plaintext 攻击更加困难， 即使源并没有加密(见9。1)，
因为要通过的translator 会做这些事情。关于选择随机数方面的技术见[17]。
The sequence number increments by one for each RTP data packet sent, and may be used
by the receiver to detect packet loss and to restore packet sequence. The initial value of the
sequence number should be random (unpredictable) to make known-plaintext attacks on
encryption more dificult, even if the source itself does not encrypt according to the method
in Section 9.1, because the packets may flow through a translator that does. Techniques for
choosing unpredictable numbers are discussed in [17].

### Timestamp

timestamp：32 bits
timestamp 反映的是RTP 数据报文中的第一个字段的采样时刻的时间瞬时值。
采样时间值必须是从恒定的和线性的时间中得到以便于同步和jitter 计算(见第6.4.1 节)。
必须保证同步和测量保温jitter 到来所需要的时间精度(一帧一个tick 一般情况下是不够的)。
时钟频率是与payload 所携带的数据格式有关的，在profile 中静态的定义或是在定义格式的payload format 中，
或通过non-RTP 方法所定义的payload format 中动态的定义。如果RTP 报文周期的生成，就采用虚拟的(nominal) 
采样时钟而不是从系统时钟读数。例如，在固定比特率的音频中，timestamp 时钟会在每个采样周期时加一。
如果音频应用中从输入设备中读入160 个采样周期的块，the timestamp 就会每一块增加160，而不管块是否传输了或是丢弃了。
对于序列号来说，timestamp 初始值是随机的。只要它们是同时(逻辑上)同时生成的，这些连续的的 RTP 报文就会有相同的timestamp，
例如，同属一个视频帧。正像在MPEG 中内插视频帧一样，连续的但不是按顺序发送的RTP 报文可能含有相同的timestamp。
The timestamp reflects the sampling instant of the first octet in the RTP data packet. The
sampling instant must be derived from a clock that increments monotonically and linearly
in time to allow synchronization and jitter calculations (see Section 6.4.1). The resolution
of the clock must be suficient for the desired synchronization accuracy and for measuring
packet arrival jitter (one tick per video frame is typically not suficient). The clock frequency
is dependent on the format of data carried as payload and is specified statically in the profile
or payload format specification that defines the format, or may be specified dynamically for
payload formats defined through non-RTP means. If RTP packets are generated periodically,
the nominal sampling instant as determined from the sampling clock is to be used, not a
reading of the system clock. As an example, for fixed-rate audio the timestamp clock would
likely increment by one for each sampling period. If an audio application reads blocks covering
160 sampling periods from the input device, the timestamp would be increased by 160 for
each such block, regardless of whether the block is transmitted in a packet or dropped as silent.

### DateType

| 数据类型 | 分包处理标记 |
| :------: | :----------: |
| DataType |  PacketType  |
