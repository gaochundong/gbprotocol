package ai.sangmado.gbprotocol.jt808.protocol.message.content;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808ProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.exceptions.UnsupportedJT808ProtocolVersionException;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import com.google.common.base.CharMatcher;
import lombok.*;

import static com.google.common.base.Strings.*;

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
     * @since V2019
     */
    private Integer authCodeLength;
    /**
     * 鉴权码内容
     * <p>
     * 终端重连后上报鉴权码
     *
     * @since V2011
     */
    private String authCode;
    /**
     * 终端IMEI
     *
     * @since V2019
     */
    private String deviceImei;
    /**
     * 软件版本号
     * <p>
     * 厂家自定义版本号，位数不足时，后补0x00
     *
     * @since V2019
     */
    private String softwareVersion;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {
        final char padChar = '0';
        if (ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2011) || ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2013)) {
            writer.writeString(getAuthCode());
        } else if (ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2019)) {
            writer.writeByte(getAuthCodeLength());
            writer.writeString(getAuthCode());
            writer.writeString(padStart(nullToEmpty(getDeviceImei()), 15, padChar));
            writer.writeString(padEnd(nullToEmpty(getDeviceImei()), 20, padChar));
        } else {
            throw new UnsupportedJT808ProtocolVersionException(ctx.getProtocolVersion());
        }
    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        final String padChar = "0";
        if (ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2011) || ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2013)) {
            setAuthCode(reader.readStringRemaining());
        } else if (ctx.getProtocolVersion().equals(JT808ProtocolVersion.V2019)) {
            setAuthCodeLength(reader.readByte() & 0xFF);
            setAuthCode(reader.readString(getAuthCodeLength()));
            setDeviceImei(CharMatcher.anyOf(padChar).trimLeadingFrom(reader.readString(15)));
            setSoftwareVersion(reader.readStringRemaining());
        } else {
            throw new UnsupportedJT808ProtocolVersionException(ctx.getProtocolVersion());
        }
    }

    public static JT808_Message_Content_0x0102 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x0102 content = new JT808_Message_Content_0x0102();
        content.deserialize(ctx, reader);
        return content;
    }
}
