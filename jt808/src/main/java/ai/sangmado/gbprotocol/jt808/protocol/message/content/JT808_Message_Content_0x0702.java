package ai.sangmado.gbprotocol.jt808.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 终端驾驶员身份信息采集上报
 *
 * @since V2011
 * @since V2013 终端从业资格证IC卡插入或拔出后，自动触发本指令。收到0x8702指令后，使用本指令应答。
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808_Message_Content_0x0702 extends JT808MessageContent {
    public static final JT808MessageId MESSAGE_ID = JT808MessageId.JT808_Message_0x0702;

    @Override
    public JT808MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 状态
     *
     * @since V2013
     * 0x01：从业资格证IC 卡插入（驾驶员上班）；
     * 0x02：从业资格证IC 卡拔出（驾驶员下班）。
     */
    private Integer state;
    /**
     * 时间
     *
     * @since V2013 插卡/拔卡时间，YY-MM-DD-hh-mm-ss；
     */
    private LocalDateTime stateTime;
    /**
     * IC卡读取结果
     *
     * @since V2013
     * 0x00：IC 卡读卡成功；
     * 0x01：读卡失败，原因为卡片密钥认证未通过；
     * 0x02：读卡失败，原因为卡片已被锁定；
     * 0x03：读卡失败，原因为卡片被拔出；
     * 0x04：读卡失败，原因为数据校验错误。
     */
    private Integer icCardReadResult;
    /**
     * 驾驶员姓名长度
     *
     * @since V2011
     */
    private Integer driverNameLength;
    /**
     * 驾驶员姓名
     *
     * @since V2011
     */
    private String driverName;
    /**
     * 驾驶员身份证号
     *
     * @since V2011 长度20位,不足补0x00
     * @since V2013 这个版本居然删除了这个字段
     * @since V2019 这个版本居然又加回来了这个字段，还移动了位置，f..k
     */
    private String nationalIdentity;
    /**
     * 从业资格证编号
     *
     * @since V2011 长度40位
     */
    private String licenseNumber;
    /**
     * 从业资格证发证机构名称长度
     *
     * @since V2011
     */
    private Integer licenseIssuedByNameLength;
    /**
     * 从业资格证发证机构名称
     *
     * @since V2011
     */
    private String licenseIssuedByName;
    /**
     * 从业资格证证件有效期
     *
     * @since V2013 YYYYMMDD
     */
    private String licenseExpiredAt;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808_Message_Content_0x0702 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x0702 content = new JT808_Message_Content_0x0702();
        content.deserialize(ctx, reader);
        return content;
    }
}
