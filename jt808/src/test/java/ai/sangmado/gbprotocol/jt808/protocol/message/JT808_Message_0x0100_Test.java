package ai.sangmado.gbprotocol.jt808.protocol.message;

import ai.sangmado.gbprotocol.gbcommon.memory.IBufferPool;
import ai.sangmado.gbprotocol.gbcommon.memory.PooledByteArrayFactory;
import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.JT808ProtocolVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808ProtocolVersion;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808VehiclePlateColor;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x0100;
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

public class JT808_Message_0x0100_Test {

    private final IBufferPool bufferPool = new PooledByteArrayFactory(512, 10);
    private final IVersionedSpecificationContext ctx = new JT808ProtocolVersionedSpecificationContext()
            .withProtocolVersion(JT808ProtocolVersion.V2019)
            .withBufferPool(bufferPool);

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void when_JT808_Message_0x0100_thenShouldPassSerializationAndDeserialization() {
        JT808MessageId messageId = JT808MessageId.JT808_Message_0x0100;
        String phoneNumber = "123456";
        int serialNumber = 123;

        int provinceId = 19;
        int cityId = 18;
        String manufacturerId = "777";
        String deviceId = "111";
        String deviceModel = "Made in China";
        String plateNumber = "AAA-BBB-CCC";
        JT808VehiclePlateColor plateColor = JT808VehiclePlateColor.JT808_Vehicle_Color_Blue;

        JT808MessageHeader header = JT808MessageHeaderFactory
                .buildWith(ctx)
                .withMessageId(messageId)
                .withPhoneNumber(phoneNumber)
                .withSerialNumber(serialNumber);
        JT808MessageContent content = JT808_Message_Content_0x0100.builder()
                .provinceId(provinceId)
                .cityId(cityId)
                .manufacturerId(manufacturerId)
                .deviceId(deviceId)
                .deviceModel(deviceModel)
                .plateNumber(plateNumber)
                .plateColor(plateColor)
                .build();

        List<JT808Message> messages = JT808MessageAssembler.assemble(ctx, header, content);
        assertEquals(1, messages.size());

        byte[] bufArray = new byte[512];
        ByteBuffer buf = ByteBuffer.wrap(bufArray);
        IJT808MessageBufferWriter writer = new JT808MessageByteBufferWriter(ctx, buf);
        JT808Message srcMessage = messages.get(0);
        srcMessage.serialize(ctx, writer);
        buf.flip();
        assertEquals(107, buf.limit());

        IJT808MessageBufferReader reader = new JT808MessageByteBufferReader(ctx, buf);
        JT808Message dstMessage = new JT808Message();
        dstMessage.deserialize(ctx, reader);
        assertEquals(messageId, dstMessage.getHeader().getMessageId());
        assertEquals(phoneNumber, dstMessage.getHeader().getPhoneNumber());
        assertEquals(serialNumber, dstMessage.getHeader().getSerialNumber());
        assertEquals(provinceId, ((JT808_Message_Content_0x0100) (dstMessage.getContent())).getProvinceId());
        assertEquals(cityId, ((JT808_Message_Content_0x0100) (dstMessage.getContent())).getCityId());
        assertEquals(manufacturerId, ((JT808_Message_Content_0x0100) (dstMessage.getContent())).getManufacturerId());
        assertEquals(deviceId, ((JT808_Message_Content_0x0100) (dstMessage.getContent())).getDeviceId());
        assertEquals(deviceModel, ((JT808_Message_Content_0x0100) (dstMessage.getContent())).getDeviceModel());
        assertEquals(plateNumber, ((JT808_Message_Content_0x0100) (dstMessage.getContent())).getPlateNumber());
        assertEquals(plateColor, ((JT808_Message_Content_0x0100) (dstMessage.getContent())).getPlateColor());
    }
}
