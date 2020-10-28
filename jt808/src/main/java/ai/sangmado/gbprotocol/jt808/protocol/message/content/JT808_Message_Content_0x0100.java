package ai.sangmado.gbprotocol.jt808.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808ProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808VehiclePlateColor;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808ProtocolVersionException;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808.protocol.utils.BytesPadder;
import ai.sangmado.gbprotocol.jt808.protocol.utils.StringsConverter;
import com.google.common.base.CharMatcher;
import lombok.*;

import static com.google.common.base.Strings.nullToEmpty;
import static com.google.common.base.Strings.padEnd;

/**
 * 终端注册
 *
 * @since V2011 长度至少25字节
 * @since V2013 长度至少37字节
 * @since V2019 长度至少76字节
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808_Message_Content_0x0100 extends JT808MessageContent {
    public static final JT808MessageId MESSAGE_ID = JT808MessageId.JT808_Message_0x0100;
    private String padSpace;

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
    private JT808VehiclePlateColor plateColor;
    /**
     * 车牌号
     * 车牌颜色为 0 时，表示车辆 VIN；否则，表示公安交通管理部门颁发的机动车号牌。
     */
    private String plateNumber;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {
        writer.writeWord(getProvinceId());
        writer.writeWord(getCityId());

        final char padSpace = ' '; // 补空格
        final byte padChar = (byte) 0x00;  // 补0x00
        if (ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2011)) {
            writer.writeString(padEnd(nullToEmpty(getManufacturerId()), 5, padSpace));
            writer.writeString(padEnd(nullToEmpty(getDeviceModel()), 8, padSpace));
            writer.writeString(padEnd(nullToEmpty(getDeviceId()), 7, padSpace));
        } else if (ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2013)) {
            writer.writeBytes(BytesPadder.padRight(StringsConverter.toBytes(ctx, getManufacturerId()), 5, padChar));
            writer.writeBytes(BytesPadder.padRight(StringsConverter.toBytes(ctx, getDeviceModel()), 20, padChar));
            writer.writeBytes(BytesPadder.padRight(StringsConverter.toBytes(ctx, getDeviceId()), 7, padChar));
        } else if (ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2019)) {
            writer.writeBytes(BytesPadder.padLeft(StringsConverter.toBytes(ctx, getManufacturerId()), 11, padChar));
            writer.writeBytes(BytesPadder.padLeft(StringsConverter.toBytes(ctx, getDeviceModel()), 30, padChar));
            writer.writeBytes(BytesPadder.padLeft(StringsConverter.toBytes(ctx, getDeviceId()), 30, padChar));
        } else {
            throw new UnsupportedJT808ProtocolVersionException(ctx.getProtocolVersion());
        }

        writer.writeByte(getPlateColor().getValue());
        writer.writeString(getPlateNumber());
    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        setProvinceId(reader.readWord());
        setCityId(reader.readWord());

        final String padSpace = " "; // 补空格
        final byte padChar = (byte) 0x00;  // 补0x00
        if (ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2011)) {
            setManufacturerId(CharMatcher.anyOf(padSpace).trimTrailingFrom(reader.readString(5)));
            setDeviceModel(CharMatcher.anyOf(padSpace).trimTrailingFrom(reader.readString(8)));
            setDeviceId(CharMatcher.anyOf(padSpace).trimTrailingFrom(reader.readString(7)));
        } else if (ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2013)) {
            setManufacturerId(StringsConverter.toString(ctx, BytesPadder.trimRight(reader.readBytes(5), padChar)));
            setDeviceModel(StringsConverter.toString(ctx, BytesPadder.trimRight(reader.readBytes(20), padChar)));
            setDeviceId(StringsConverter.toString(ctx, BytesPadder.trimRight(reader.readBytes(7), padChar)));
        } else if (ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2019)) {
            setManufacturerId(StringsConverter.toString(ctx, BytesPadder.trimLeft(reader.readBytes(11), padChar)));
            setDeviceModel(StringsConverter.toString(ctx, BytesPadder.trimLeft(reader.readBytes(30), padChar)));
            setDeviceId(StringsConverter.toString(ctx, BytesPadder.trimLeft(reader.readBytes(30), padChar)));
        } else {
            throw new UnsupportedJT808ProtocolVersionException(ctx.getProtocolVersion());
        }

        setPlateColor(JT808VehiclePlateColor.cast(reader.readByte() & 0xFF));
        setPlateNumber(reader.readStringRemaining());
    }

    public static JT808_Message_Content_0x0100 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x0100 content = new JT808_Message_Content_0x0100();
        content.deserialize(ctx, reader);
        return content;
    }
}
