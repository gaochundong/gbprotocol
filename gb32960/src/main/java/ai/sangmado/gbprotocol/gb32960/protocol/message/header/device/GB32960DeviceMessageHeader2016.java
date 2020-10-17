package ai.sangmado.gbprotocol.gb32960.protocol.message.header.device;

import ai.sangmado.gbprotocol.gb32960.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960DeviceCommandId;
import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960MessageContentEncryptionMode;
import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960ProtocolVersion;
import ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960ReplyId;
import ai.sangmado.gbprotocol.gb32960.protocol.exceptions.UnsupportedGB32960OperationException;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.IGB32960MessageBufferReader;
import ai.sangmado.gbprotocol.gb32960.protocol.serialization.IGB32960MessageBufferWriter;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static ai.sangmado.gbprotocol.gb32960.protocol.enums.GB32960ProtocolVersion.V2016;

@Getter
@Setter
@NoArgsConstructor
public class GB32960DeviceMessageHeader2016 extends GB32960DeviceMessageHeader {
    public static final GB32960ProtocolVersion PROTOCOL_VERSION = V2016;

    @Builder
    public GB32960DeviceMessageHeader2016(
            GB32960DeviceCommandId commandId,
            GB32960ReplyId replyId,
            String vin,
            GB32960MessageContentEncryptionMode encryptionMode,
            Integer contentLength) {
        super(commandId, replyId, vin, encryptionMode, contentLength);
    }

    @Override
    public GB32960ProtocolVersion getProtocolVersion() {
        return PROTOCOL_VERSION;
    }

    @Override
    public GB32960DeviceMessageHeader clone() {
        try {
            return GB32960DeviceMessageHeader2016.builder()
                    .commandId(this.getCommandId())
                    .replyId(this.getReplyId())
                    .vin(this.getVin())
                    .encryptionMode(this.getEncryptionMode())
                    .contentLength(this.getContentLength())
                    .build();
        } catch (Exception ex) {
            throw new UnsupportedGB32960OperationException("克隆对象失败", ex);
        }
    }

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IGB32960MessageBufferWriter writer) {
        writer.writeByte(getCommandId().getValue());
        writer.writeByte(getReplyId().getValue());
        writer.writeString(getVin());
        writer.writeByte(getEncryptionMode().getValue());
        writer.writeWord(getContentLength());
    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IGB32960MessageBufferReader reader) {
        setCommandId(GB32960DeviceCommandId.cast(reader.readByte()));
        setReplyId(GB32960ReplyId.cast(reader.readByte()));
        setVin(reader.readString(100));
        setEncryptionMode(GB32960MessageContentEncryptionMode.cast(reader.readByte()));
        setContentLength(reader.readWord());
    }

    public static GB32960DeviceMessageHeader2016 decode(IVersionedSpecificationContext ctx, IGB32960MessageBufferReader reader) {
        GB32960DeviceMessageHeader2016 header = new GB32960DeviceMessageHeader2016();
        header.deserialize(ctx, reader);
        return header;
    }
}
