package ai.sangmado.gbprotocol.jt808.protocol.message;

import ai.sangmado.gbprotocol.gbcommon.memory.IBufferPool;
import ai.sangmado.gbprotocol.gbcommon.memory.PooledByteArrayFactory;
import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.JT808ProtocolVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808DeviceRegistrationResult;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808ProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8100;
import ai.sangmado.gbprotocol.jt808.protocol.message.header.JT808MessageHeader;
import ai.sangmado.gbprotocol.jt808.protocol.message.header.JT808MessageHeaderFactory;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.impl.JT808MessageByteBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.impl.JT808MessageByteBufferWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.nio.ByteBuffer;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JT808_Message_0x8100_Test {

    private final IBufferPool bufferPool = new PooledByteArrayFactory(512, 10);
    private final IVersionedSpecificationContext ctx = new JT808ProtocolVersionedSpecificationContext()
            .withProtocolVersion(JT808ProtocolVersion.V2019)
            .withBufferPool(bufferPool);

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void when_JT808_Message_0x8100_thenShouldPassSerializationAndDeserialization() {
        JT808MessageId messageId = JT808MessageId.JT808_Message_0x8100;
        String phoneNumber = "123456";
        int serialNumber = 123;

        JT808DeviceRegistrationResult registrationResult = JT808DeviceRegistrationResult.Success;
        String authCode = "1234-5678";
        int ackSerialNumber = 123;

        JT808MessageHeader header = JT808MessageHeaderFactory
                .buildWith(ctx)
                .withMessageId(messageId)
                .withPhoneNumber(phoneNumber)
                .withSerialNumber(serialNumber);
        JT808MessageContent content = JT808_Message_Content_0x8100.builder()
                .registrationResult(registrationResult)
                .authCode(authCode)
                .ackSerialNumber(ackSerialNumber)
                .build();

        List<JT808Message> messages = JT808MessageAssembler.assemble(ctx, header, content);
        assertEquals(1, messages.size());

        byte[] bufArray = new byte[512];
        ByteBuffer buf = ByteBuffer.wrap(bufArray);
        IJT808MessageBufferWriter writer = new JT808MessageByteBufferWriter(ctx, buf);
        JT808Message srcMessage = messages.get(0);
        srcMessage.serialize(ctx, writer);
        buf.flip();
        assertEquals(32, buf.limit());

        IJT808MessageBufferReader reader = new JT808MessageByteBufferReader(ctx, buf);
        JT808Message dstMessage = new JT808Message();
        dstMessage.deserialize(ctx, reader);
        assertEquals(messageId, dstMessage.getHeader().getMessageId());
        assertEquals(phoneNumber, dstMessage.getHeader().getPhoneNumber());
        assertEquals(serialNumber, dstMessage.getHeader().getSerialNumber());
        assertEquals(registrationResult, ((JT808_Message_Content_0x8100) (dstMessage.getContent())).getRegistrationResult());
        assertEquals(authCode, ((JT808_Message_Content_0x8100) (dstMessage.getContent())).getAuthCode());
        assertEquals(ackSerialNumber, ((JT808_Message_Content_0x8100) (dstMessage.getContent())).getAckSerialNumber());
    }
}
