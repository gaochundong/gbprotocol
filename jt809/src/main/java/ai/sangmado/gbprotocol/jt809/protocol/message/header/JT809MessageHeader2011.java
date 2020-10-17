package ai.sangmado.gbprotocol.jt809.protocol.message.header;

import ai.sangmado.gbprotocol.jt809.protocol.serialization.IJT809MessageBufferWriter;
import ai.sangmado.gbprotocol.jt809.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt809.protocol.serialization.IJT809MessageBufferReader;
import ai.sangmado.gbprotocol.jt809.protocol.enums.JT809MessageContentEncryptionMode;
import ai.sangmado.gbprotocol.jt809.protocol.enums.JT809MessageId;
import ai.sangmado.gbprotocol.jt809.protocol.enums.JT809ProtocolVersion;
import ai.sangmado.gbprotocol.jt809.protocol.enums.JT809VersionFlag;
import ai.sangmado.gbprotocol.jt809.protocol.exceptions.UnsupportedJT809OperationException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static ai.sangmado.gbprotocol.jt809.protocol.enums.JT809ProtocolVersion.V2011;

@Getter
@Setter
@NoArgsConstructor
public class JT809MessageHeader2011 extends JT809MessageHeader {
    public static final JT809ProtocolVersion PROTOCOL_VERSION = V2011;
    public static final long MESSAGE_LENGTH_WITHOUT_CONTENT = 24;

    @Builder
    public JT809MessageHeader2011(
            Long messageLength,
            Long messageSequenceNumber,
            JT809MessageId messageId,
            Long gnssCenterId,
            JT809VersionFlag versionFlag,
            JT809MessageContentEncryptionMode encryptionMode,
            Long encryptionKey) {
        super(messageLength, messageSequenceNumber, messageId, gnssCenterId, versionFlag, encryptionMode, encryptionKey);
    }

    @Override
    public JT809ProtocolVersion getProtocolVersion() {
        return PROTOCOL_VERSION;
    }

    @Override
    public long getMessageLengthWithoutContent() {
        return MESSAGE_LENGTH_WITHOUT_CONTENT;
    }

    @Override
    public JT809MessageHeader clone() {
        try {
            return JT809MessageHeader2011.builder()
                    .messageLength(this.getMessageLength())
                    .messageSequenceNumber(this.getMessageSequenceNumber())
                    .messageId(this.getMessageId())
                    .gnssCenterId(this.getGnssCenterId())
                    .versionFlag(this.getVersionFlag())
                    .encryptionMode(this.getEncryptionMode())
                    .encryptionKey(this.getEncryptionKey())
                    .build();
        } catch (Exception ex) {
            throw new UnsupportedJT809OperationException("克隆对象失败", ex);
        }
    }

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT809MessageBufferWriter writer) {
        writer.writeUInt32(getMessageLength());
        writer.writeUInt32(getMessageSequenceNumber());
        writer.writeUInt16(getMessageId().getValue());
        writer.writeUInt32(getGnssCenterId());
        writer.writeBytes(getVersionFlag().toArray());
        writer.writeByte(getEncryptionMode().getValue());
        writer.writeUInt32(getEncryptionKey());
    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT809MessageBufferReader reader) {
        setMessageLength(reader.readUInt32());
        setMessageSequenceNumber(reader.readUInt32());
        setMessageId(JT809MessageId.cast(reader.readUInt16()));
        setGnssCenterId(reader.readUInt32());
        setVersionFlag(new JT809VersionFlag(reader.readBytes(3)));
        setEncryptionMode(JT809MessageContentEncryptionMode.cast(reader.readByte()));
        setEncryptionKey(reader.readUInt32());
    }

    public static JT809MessageHeader2011 decode(IVersionedSpecificationContext ctx, IJT809MessageBufferReader reader) {
        JT809MessageHeader2011 header = new JT809MessageHeader2011();
        header.deserialize(ctx, reader);
        return header;
    }
}
