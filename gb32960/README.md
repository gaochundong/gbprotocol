# GB32960协议

GB/T32960 Technical specifications of remote service and management system for electric vehicles,
Part 3: Communication protocol and data format
GB/T32960 电动汽车远程服务与管理系统技术规范 第3部分：通信协议及数据格式

## 数据包结构和定义

|   起始符1    |   起始符2    | 命令标识  | 应答标志 | 唯一识别码 | 数据单元加密方式 | 数据单元长度  | 数据单元 |  校验码  |
| :----------: | :----------: | :-------: | :------: | :--------: | :--------------: | :-----------: | :------: | :------: |
| BeginMarker1 | BeginMarker2 | CommandId | ReplyId  |    VIN     |  EncryptionMode  | ContentLength | Content  | Checksum |
