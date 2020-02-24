# JT809协议

## JT809协议消息数据结构

### 消息结构 JT809MessagePackage

|   头标识    |       数据头       |       数据体        |  校验码  |  尾标识   |
| :---------: | :----------------: | :-----------------: | :------: | :-------: |
| BeginMarker | JT809MessageHeader | JT809MessageContent | Checksum | EndMarker |
|     5B      |         -          |          -          |    -     |    5D     |

### 消息头 JT809MessageHeader 2011

|   数据长度    |      报文序列号       | 业务数据类型 | 下级平台接入码 | 协议版本号标识 | 报文加密标识位 | 数据加密密匙  |
| :-----------: | :-------------------: | :----------: | :------------: | :------------: | :------------: | :-----------: |
| messageLength | messageSequenceNumber |  messageId   |  gnssCenterId  |  versionFlag   | encryptionMode | encryptionKey |

### 消息头 JT809MessageHeader 2019

|   数据长度    |      报文序列号       | 业务数据类型 | 下级平台接入码 | 协议版本号标识 | 报文加密标识位 | 数据加密密匙  |  时间戳   |
| :-----------: | :-------------------: | :----------: | :------------: | :------------: | :------------: | :-----------: | :-------: |
| messageLength | messageSequenceNumber |  messageId   |  gnssCenterId  |  versionFlag   | encryptionMode | encryptionKey | timestamp |
