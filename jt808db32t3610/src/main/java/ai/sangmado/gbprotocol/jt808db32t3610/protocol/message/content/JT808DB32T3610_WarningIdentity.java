package ai.sangmado.gbprotocol.jt808db32t3610.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageFormatter;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 报警标识号
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808DB32T3610_WarningIdentity implements IJT808MessageFormatter {

    /**
     * 终端ID
     * <p>
     * 7个字节，由大写字母和数字组成，此终端ID由制造商自行定义，位数不足时，后补0x00
     */
    private String deviceId;
    /**
     * 时间
     * <p>
     * YY-MM-DD-hh-mm-ss (GMT+8 时间)
     * BCD[6]
     */
    private LocalDateTime timestamp;
    /**
     * 序号
     * <p>
     * 同一时间点报警的序号，从0循环累加
     */
    private Integer serialNumber;
    /**
     * 附件数量
     * <p>
     * 表示该报警对应的附件数量
     */
    private Integer fileCount;
    /**
     * 预留
     */
    private Integer reserved = 0;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB32T3610_WarningIdentity decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB32T3610_WarningIdentity content = new JT808DB32T3610_WarningIdentity();
        content.deserialize(ctx, reader);
        return content;
    }
}
