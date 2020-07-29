package ai.sangmado.gbprotocol.jt808.protocol.message;

import ai.sangmado.gbprotocol.gbcommon.memory.IBufferPool;
import ai.sangmado.gbprotocol.gbcommon.memory.PooledByteArrayFactory;
import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.JT808ProtocolSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808ProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808VehicleState;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808WarningType;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x0200;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JT808_Message_0x0200_Test {

    private IBufferPool bufferPool = new PooledByteArrayFactory(512, 10);
    private ISpecificationContext ctx = new JT808ProtocolSpecificationContext()
            .withProtocolVersion(JT808ProtocolVersion.V2019)
            .withBufferPool(bufferPool);

    private static final String TIMESTAMP_PATTERN = "yyMMddHHmmss";
    private static final DateTimeFormatter TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern(TIMESTAMP_PATTERN);

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void when_JT808_Message_0x0200_thenShouldPassSerializationAndDeserialization() {
        JT808MessageId messageId = JT808MessageId.JT808_Message_0x0200;
        String phoneNumber = "123456789";
        int serialNumber = 123;

        JT808WarningType warningType = JT808WarningType.JT808_Warning_1;
        JT808VehicleState state = JT808VehicleState.JT808_Vehicle_State_0;
        Long latitude = 30L;
        Long longitude = 20L;
        Integer altitude = 666;
        Integer speed = 50;
        Integer direction = 44;
        LocalDateTime timestamp = LocalDateTime.parse("200210112233", TIMESTAMP_FORMATTER);

        JT808MessageHeader header = JT808MessageHeaderFactory
                .buildWith(ctx)
                .withMessageId(messageId)
                .withPhoneNumber(phoneNumber)
                .withSerialNumber(serialNumber);
        JT808MessageContent content = JT808_Message_Content_0x0200.builder()
                .warningType(warningType)
                .state(state)
                .latitude(latitude)
                .longitude(longitude)
                .altitude(altitude)
                .speed(speed)
                .direction(direction)
                .timestamp(timestamp)
                .build();

        List<JT808Message> message = JT808MessageAssembler.assemble(ctx, header, content);
        assertEquals(1, message.size());

        byte[] bufArray = new byte[512];
        ByteBuffer buf = ByteBuffer.wrap(bufArray);
        IJT808MessageBufferWriter writer = new JT808MessageByteBufferWriter(ctx, buf);
        JT808Message srcMessage = message.get(0);
        srcMessage.serialize(ctx, writer);
        buf.flip();
        assertEquals(48, buf.limit());

        IJT808MessageBufferReader reader = new JT808MessageByteBufferReader(ctx, buf);
        JT808Message dstMessage = new JT808Message();
        dstMessage.deserialize(ctx, reader);
        assertEquals(messageId, dstMessage.getHeader().getMessageId());
        assertEquals(phoneNumber, dstMessage.getHeader().getPhoneNumber());
        assertEquals(serialNumber, dstMessage.getHeader().getSerialNumber());
        assertEquals(warningType, ((JT808_Message_Content_0x0200) (dstMessage.getContent())).getWarningType());
        assertEquals(state, ((JT808_Message_Content_0x0200) (dstMessage.getContent())).getState());
        assertEquals(latitude, ((JT808_Message_Content_0x0200) (dstMessage.getContent())).getLatitude());
        assertEquals(longitude, ((JT808_Message_Content_0x0200) (dstMessage.getContent())).getLongitude());
        assertEquals(latitude, ((JT808_Message_Content_0x0200) (dstMessage.getContent())).getLatitude());
        assertEquals(altitude, ((JT808_Message_Content_0x0200) (dstMessage.getContent())).getAltitude());
        assertEquals(speed, ((JT808_Message_Content_0x0200) (dstMessage.getContent())).getSpeed());
        assertEquals(direction, ((JT808_Message_Content_0x0200) (dstMessage.getContent())).getDirection());
        assertEquals(timestamp, ((JT808_Message_Content_0x0200) (dstMessage.getContent())).getTimestamp());
    }
}
