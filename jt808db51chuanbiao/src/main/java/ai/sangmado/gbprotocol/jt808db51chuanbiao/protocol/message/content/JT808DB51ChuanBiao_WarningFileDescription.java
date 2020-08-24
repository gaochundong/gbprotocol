package ai.sangmado.gbprotocol.jt808db51chuanbiao.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageFormatter;
import lombok.*;

/**
 * 报警附件文件描述
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808DB51ChuanBiao_WarningFileDescription implements IJT808MessageFormatter {

    /**
     * 文件名称长度
     */
    private Integer fileNameLength;
    /**
     * 文件名称
     * <p>
     * 文件名称命名规则为: 文件类型_通道号_报警类型_序号_报警编号_后缀名
     */
    private String fileName;
    /**
     * 文件大小
     */
    private Long fileSize;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT808DB51ChuanBiao_WarningFileDescription decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808DB51ChuanBiao_WarningFileDescription content = new JT808DB51ChuanBiao_WarningFileDescription();
        content.deserialize(ctx, reader);
        return content;
    }
}
