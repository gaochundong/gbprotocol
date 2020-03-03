package ai.sangmado.gbstandard.jt808.protocol.message.content;

import ai.sangmado.gbstandard.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbstandard.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.gbstandard.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.gbstandard.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbstandard.jt808.protocol.enums.JT808ProtocolVersion;
import ai.sangmado.gbstandard.jt808.protocol.exceptions.UnsupportedJT808ProtocolVersionException;
import com.google.common.base.CharMatcher;
import lombok.*;

import static com.google.common.base.Strings.*;

/**
 * 终端注册
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808_Message_Content_0x0100 extends JT808MessageContent {
    public static final JT808MessageId MESSAGE_ID = JT808MessageId.JT808_Message_0x0100;

    @Override
    public JT808MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 省域ID
     * 标示终端安装车辆所在的省域，0 保留，由平台取默认值。省域 ID 采用 GB/T 2260 中规定的行政区划代码六位中前两位。
     */
    private Integer provinceId;
    /**
     * 市县域ID
     * 标示终端安装车辆所在的市域和县域，0 保留，由平台取默认值。市县域 ID 采用 GB/T 2260 中规定的行政区划代码六位中后四位。
     */
    private Integer cityId;
    /**
     * 制造商ID
     * 由车载终端厂商所在地行政区划代码和制造商ID组成
     * 2011版本 5 个字节，终端制造商编码
     * 2013版本 5 个字节，终端制造商编码
     * 2019版本 11 个字节，终端制造商编码
     */
    private String manufacturerId;
    /**
     * 终端型号
     * 2011版本 8 个字节，此终端型号由制造商自行定义，位数不足时，补空格。
     * 2013版本 20 个字节，此终端型号由制造商自行定义，位数不足时，后补“0x00”。
     * 2019版本 30 个字节，此终端型号由制造商自行定义，位数不足时，前补“0x00”。
     */
    private String deviceModel;
    /**
     * 终端ID
     * 2011版本 7 个字节，由大写字母和数字组成，此终端 ID 由制造商自行定义，位数不足时，补空格。
     * 2013版本 7 个字节，由大写字母和数字组成，此终端 ID 由制造商自行定义，位数不足时，后补“0x00”。
     * 2019版本 30 个字节，由大写字母和数字组成，此终端 ID 由制造商自行定义，位数不足时，前补“0x00”。
     */
    private String deviceId;
    /**
     * 车牌颜色
     * 2011版本 按照 JT/T415-2006 的 5.4.12。未上牌时，取值为 0。
     * 2013版本 按照 JT/T415-2006 的 5.4.12。未上牌时，取值为 0。
     * 2019版本 按照 JT/T697.7-2014 中的规定。未上牌时，取值为 0。
     */
    private Integer plateColor;
    /**
     * 车牌号
     * 车牌颜色为 0 时，表示车辆 VIN；否则，表示公安交通管理部门颁发的机动车号牌。
     */
    private String plateNumber;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {
        writer.writeWord(getProvinceId());
        writer.writeWord(getCityId());

        final char padChar = '0';
        if (ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2011) || ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2013)) {
            writer.writeString(padEnd(nullToEmpty(getManufacturerId()), 5, padChar));
            writer.writeString(padEnd(nullToEmpty(getDeviceModel()), 20, padChar));
            writer.writeString(padEnd(nullToEmpty(getDeviceId()), 7, padChar));
        } else if (ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2019)) {
            writer.writeString(padStart(nullToEmpty(getManufacturerId()), 11, padChar));
            writer.writeString(padStart(nullToEmpty(getDeviceModel()), 30, padChar));
            writer.writeString(padStart(nullToEmpty(getDeviceId()), 30, padChar));
        } else {
            throw new UnsupportedJT808ProtocolVersionException(ctx.getProtocolVersion());
        }

        writer.writeByte(getPlateColor());
        writer.writeString(getPlateNumber());
    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        setProvinceId(reader.readWord());
        setCityId(reader.readWord());

        final String padChar = "0";
        if (ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2011) || ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2013)) {
            setManufacturerId(CharMatcher.anyOf(padChar).trimTrailingFrom(reader.readString(5)));
            setDeviceModel(CharMatcher.anyOf(padChar).trimTrailingFrom(reader.readString(20)));
            setDeviceId(CharMatcher.anyOf(padChar).trimTrailingFrom(reader.readString(7)));
        } else if (ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2019)) {
            setManufacturerId(CharMatcher.anyOf(padChar).trimLeadingFrom(reader.readString(11)));
            setDeviceModel(CharMatcher.anyOf(padChar).trimLeadingFrom(reader.readString(30)));
            setDeviceId(CharMatcher.anyOf(padChar).trimLeadingFrom(reader.readString(30)));
        } else {
            throw new UnsupportedJT808ProtocolVersionException(ctx.getProtocolVersion());
        }

        setPlateColor(reader.readByte() & 0xFF);
        setPlateNumber(reader.readStringRemaining());
    }

    public static JT808_Message_Content_0x0100 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x0100 content = new JT808_Message_Content_0x0100();
        content.deserialize(ctx, reader);
        return content;
    }
}
