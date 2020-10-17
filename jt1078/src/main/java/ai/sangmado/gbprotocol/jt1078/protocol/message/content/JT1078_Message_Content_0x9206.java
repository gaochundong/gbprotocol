package ai.sangmado.gbprotocol.jt1078.protocol.message.content;

import ai.sangmado.gbprotocol.jt1078.protocol.enums.JT1078MessageId;
import ai.sangmado.gbprotocol.jt1078.protocol.enums.LogicalChannelNumber;
import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.*;

/**
 * 平台下发文件上传指令
 * <p>
 * 平台向终端下发文件上传命令，终端回复通用应答后通过FTP方式将文件上传到目标FTP服务器的指定路径。
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT1078_Message_Content_0x9206 extends JT808MessageContent {
    public static final JT1078MessageId MESSAGE_ID = JT1078MessageId.JT1078_Message_0x9206;

    @Override
    public JT1078MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 服务器FTP地址长度
     */
    private Integer serverIPAddressLength;
    /**
     * 服务器FTP地址
     */
    private String serverIPAddress;
    /**
     * 服务器FTP端口
     */
    private Integer serverPort;
    /**
     * FTP用户名长度
     */
    private Integer usernameLength;
    /**
     * FTP用户名
     */
    private String username;
    /**
     * FTP密码长度
     */
    private Integer passwordLength;
    /**
     * FTP密码
     */
    private String password;
    /**
     * 文件上传路径长度
     */
    private Integer fileUploadPathLength;
    /**
     * 文件上传路径
     */
    private String fileUploadPath;
    /**
     * 逻辑通道号
     * <p>
     * 按照JTT1076-2016中的表2：营运车辆车载视频终端音视频通道定义表；
     */
    private LogicalChannelNumber logicalChannelNumber;
    /**
     * 开始时间
     * <p>
     * BCD[6], YY-MM-DD-HH-MM-SS
     */
    private String beginTime;
    /**
     * 结束时间
     * <p>
     * BCD[6], YY-MM-DD-HH-MM-SS
     */
    private String endTime;
    /**
     * 报警标志
     * <p>
     * bit0~bit31见JT/T 808—2011表18报警 标志位定义;
     * bit32 ~ bit63 见表 13;
     * 全 0 表示无报警类型条件
     */
    private Long warningBits;
    /**
     * 音视频资源类型
     * <p>
     * 0:音视频，1:音频，2:视频，3:视频或音视频
     */
    private Integer mediaResourceType;
    /**
     * 码流类型
     * <p>
     * 0:所有码流，1:主码流，2:子码流
     */
    private Integer streamType;
    /**
     * 存储器类型
     * <p>
     * 0:所有存储器，1:主存储器，2:灾备存储器
     */
    private Integer storageType;
    /**
     * 任务执行条件
     * <p>
     * 用bit 位表示：
     * bit0：WIFI，为1 时表示WI-FI 下可下载；
     * bit1：LAN，为1 时表示LAN 连接时可下载；
     * bit2：3G/4G，为1 时表示3G/4G 连接时可下载；
     */
    private Integer taskExecuteCondition;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT1078_Message_Content_0x9206 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT1078_Message_Content_0x9206 content = new JT1078_Message_Content_0x9206();
        content.deserialize(ctx, reader);
        return content;
    }
}
