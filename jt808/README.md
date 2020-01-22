# JT808协议

## JT808协议消息数据结构

### 消息结构 JT808MessagePackage

每条消息由标识位、消息头、消息体、校验码组成。

|   头标识    |       消息头       |       消息体        |  校验码  |  尾标识   |
| :---------: | :----------------: | :-----------------: | :------: | :-------: |
| BeginMarker | JT808MessageHeader | JT808MessageContent | Checksum | EndMarker |
|     7E      |         -          |          -          |    -     |    7E     |

### 消息头 JT808MessageHeader

|  消息ID   |                消息体属性                |   协议版本号    | 终端手机号  |  消息流水号  |              消息包封装项               |
| :-------: | :--------------------------------------: | :-------------: | :---------: | :----------: | :-------------------------------------: |
| MessageId | JT808MessageHeaderMessageContentProperty | ProtocolVersion | PhoneNumber | SerialNumber | JT808MessageHeaderMessagePacketProperty |

消息包封装项：如果消息体属性中相关标识位确定消息分包处理，则该项有内容，否则无该项。

### 消息头中消息体属性 JT808MessageHeaderMessageContentProperty

|  保留位  |     版本标识      |     是否分包      |    加密方式    |  消息体长度   |
| :------: | :---------------: | :---------------: | :------------: | :-----------: |
| Reserved | VersionIdentifier | IsMultiplePackets | EncryptionMode | ContentLength |

## 消息头中消息包封装项 JT808MessageHeaderMessagePacketProperty

|  消息总包数  |     包序号     |
| :----------: | :------------: |
| TotalPackets | PacketSequence |
