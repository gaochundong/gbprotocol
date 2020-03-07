package ai.sangmado.gbprotocol.jt809.protocol.message;

import ai.sangmado.gbprotocol.gbcommon.memory.IBufferPool;
import ai.sangmado.gbprotocol.gbcommon.memory.PooledByteArrayFactory;
import ai.sangmado.gbprotocol.jt809.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt809.protocol.serialization.IJT809MessageBufferWriter;
import ai.sangmado.gbprotocol.jt809.protocol.enums.*;
import ai.sangmado.gbprotocol.jt809.protocol.message.content.JT809MessageContent;
import ai.sangmado.gbprotocol.jt809.protocol.message.content.JT809_Message_Content_0x1400;
import ai.sangmado.gbprotocol.jt809.protocol.message.content.JT809_Message_Content_0x1400_Sub.JT809_Message_Content_0x1400_Sub_0x1402;
import ai.sangmado.gbprotocol.jt809.protocol.message.header.JT809MessageHeader;
import ai.sangmado.gbprotocol.jt809.protocol.message.header.JT809MessageHeader2011;
import ai.sangmado.gbprotocol.jt809.protocol.serialization.IJT809MessageBufferReader;
import ai.sangmado.gbprotocol.jt809.protocol.serialization.impl.JT809MessageByteBufferReader;
import ai.sangmado.gbprotocol.jt809.protocol.serialization.impl.JT809MessageByteBufferWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class JT809_Message_0x1400_Test {

    @Mock
    private ISpecificationContext ctx;

    private IBufferPool bufferPool = new PooledByteArrayFactory(512, 10);

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        JT809MessageContentEncryptionOptions encryptionOptions = new JT809MessageContentEncryptionOptions();
        encryptionOptions.setIA1(11111L);
        encryptionOptions.setIC1(22222L);
        encryptionOptions.setM1(33333L);

        when(ctx.getProtocolVersion()).thenReturn(JT809ProtocolVersion.V2011);
        when(ctx.getByteOrder()).thenReturn(ByteOrder.BIG_ENDIAN);
        when(ctx.getCharset()).thenReturn(Charset.forName("GBK"));
        when(ctx.getMessageContentEncryptionMode()).thenReturn(JT809MessageContentEncryptionMode.Encrypted);
        when(ctx.getMessageContentEncryptionOptions()).thenReturn(encryptionOptions);
        when(ctx.getBufferPool()).thenReturn(bufferPool);
        assertEquals("GBK", ctx.getCharset().name());
    }

    @Test
    public void when_JT809_Message_0x1400_thenShouldPassSerializationAndDeserialization() {
        JT809MessageId messageId = JT809MessageId.JT809_Message_0x1400;
        long messageSequenceNumber = 888999L;
        Long gnssCenterId = 33L;
        Long encryptionKey = 7777777L;
        Long timestamp = 0x000000004B49286AL;

        JT809_Message_Content_0x1400_Sub_0x1402 subMessage = new JT809_Message_Content_0x1400_Sub_0x1402();
        subMessage.setWarningType(JT809WarningType.JT809_Warning_0x000B);
        subMessage.setWarningSource(JT809WarningSource.VehicleBox);
        subMessage.setWarningTime(timestamp);
        subMessage.setBeginTime(timestamp);
        subMessage.setEndTime(timestamp);
        subMessage.setWarningInfoId(789L);
        subMessage.setWarningInfoLength(44L);
        subMessage.setWarningInfoContent("Warning! Here is a warning.");
        subMessage.setDrivingLineId(444L);
        subMessage.setPlateNumber("京A88888");
        subMessage.setPlateColor(1);
        subMessage.setFromPlatformId("99999");
        subMessage.setToPlatformId("88888");

        JT809MessageContent content = JT809_Message_Content_0x1400.builder()
                .subMessage(subMessage)
                .build();

        JT809MessageHeader header = JT809MessageHeader2011.builder()
                .messageId(messageId)
                .messageSequenceNumber(messageSequenceNumber)
                .gnssCenterId(gnssCenterId)
                .versionFlag(new JT809VersionFlag(1, 2, 4))
                .encryptionMode(JT809MessageContentEncryptionMode.Encrypted)
                .encryptionKey(encryptionKey)
                .build();

        List<JT809MessagePacket> packets = JT809MessagePacketBuilder.buildPackets(ctx, header, content);
        assertEquals(1, packets.size());

        byte[] bufArray = new byte[512];
        ByteBuffer buf = ByteBuffer.wrap(bufArray);
        IJT809MessageBufferWriter writer = new JT809MessageByteBufferWriter(ctx, buf);
        JT809MessagePacket sePacket = packets.get(0);
        sePacket.serialize(ctx, writer);
        buf.flip();
        assertEquals(76, buf.limit());

        IJT809MessageBufferReader reader = new JT809MessageByteBufferReader(ctx, buf);
        JT809MessagePacket dePacket = new JT809MessagePacket();
        dePacket.deserialize(ctx, reader);

        Assertions.assertEquals(messageId, dePacket.getHeader().getMessageId());
        Assertions.assertEquals(messageSequenceNumber, dePacket.getHeader().getMessageSequenceNumber());
        Assertions.assertEquals(gnssCenterId, dePacket.getHeader().getGnssCenterId());

        JT809_Message_Content_0x1400_Sub_0x1402 deSubMessage = (JT809_Message_Content_0x1400_Sub_0x1402) ((JT809_Message_Content_0x1400) (dePacket.getContent())).getSubMessage();
        Assertions.assertEquals(subMessage.getWarningType(), deSubMessage.getWarningType());
    }
}
