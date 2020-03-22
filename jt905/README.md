# JT905协议

JT/T905 Taxi service and management information system - Part2: Special operation equipment

JT/T905 出租汽车服务管理信息系统 第2部分：运营专用设备

## JT905协议消息数据结构

### 消息结构 JT905MessagePackage

每条消息由标识位、消息头、消息体、校验码组成。

|   头标识    |       消息头       |       消息体        |  校验码  |  尾标识   |
| :---------: | :----------------: | :-----------------: | :------: | :-------: |
| BeginMarker | JT905MessageHeader | JT905MessageContent | Checksum | EndMarker |
|    0x7e     |         -          |          -          |    -     |   0x7e    |

### 消息头 JT905MessageHeader

|  消息ID   |  消息体属性   | ISU标识 |  消息流水号  |
| :-------: | :-----------: | :-----: | :----------: |
| MessageId | ContentLength |   ISU   | SerialNumber |

