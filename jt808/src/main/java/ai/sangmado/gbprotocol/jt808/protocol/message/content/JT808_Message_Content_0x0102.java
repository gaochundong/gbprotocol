package ai.sangmado.gbprotocol.jt808.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808ProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808ProtocolVersionException;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808.protocol.utils.BytesPadder;
import ai.sangmado.gbprotocol.jt808.protocol.utils.StringsConverter;
import lombok.*;

/**
 * 终端鉴权
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808_Message_Content_0x0102 extends JT808MessageContent {
    public static final JT808MessageId MESSAGE_ID = JT808MessageId.JT808_Message_0x0102;

    @Override
    public JT808MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 鉴权码长度
     *
     * @since V2019 新增字段
     */
    private Integer authCodeLength;
    /**
     * 鉴权码内容
     * <p>
     * 终端重连后上报鉴权码
     *
     * @since V2011 仅有此一个字段
     * @since V2013 仅有此一个字段
     * @since V2019 增加长度
     */
    private String authCode;
    /**
     * 终端IMEI
     *
     * @since V2019 新增字段 byte[15]
     */
    private String deviceImei;
    /**
     * 软件版本号
     *
     * @since V2019 新增字段 byte[20] 厂家自定义版本号，位数不足时，后补0x00
     */
    private String softwareVersion;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {
        final byte padChar = (byte) 0x00;  // 补0x00
        if (ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2011) || ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2013)) {
            writer.writeString(getAuthCode()); // V2011和V2013,仅有此一个字段
        } else if (ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2019)) {
            writer.writeByte(getAuthCodeLength());
            writer.writeString(getAuthCode());
            writer.writeBytes(BytesPadder.padRight(StringsConverter.toBytes(ctx, getDeviceImei()), 15, padChar));
            writer.writeBytes(BytesPadder.padRight(StringsConverter.toBytes(ctx, getSoftwareVersion()), 20, padChar));
        } else {
            throw new UnsupportedJT808ProtocolVersionException(ctx.getProtocolVersion());
        }
    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        final byte padChar = (byte) 0x00;  // 补0x00
        if (ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2011) || ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2013)) {
            setAuthCode(reader.readStringRemaining()); // V2011和V2013,仅有此一个字段
        } else if (ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2019)) {
            setAuthCodeLength(reader.readByte() & 0xFF);
            setAuthCode(reader.readString(getAuthCodeLength()));
            setDeviceImei(StringsConverter.toString(ctx, BytesPadder.trimRight(reader.readBytes(15), padChar)));
            setSoftwareVersion(StringsConverter.toString(ctx, BytesPadder.trimRight(reader.readBytes(20), padChar)));
        } else {
            throw new UnsupportedJT808ProtocolVersionException(ctx.getProtocolVersion());
        }
    }

    public static JT808_Message_Content_0x0102 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x0102 content = new JT808_Message_Content_0x0102();
        content.deserialize(ctx, reader);
        return content;
    }
}
