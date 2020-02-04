package ai.sangmado.jt808.protocol.message;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.enums.JT808MessageContentEncryptionMode;
import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.jt808.protocol.enums.JT808ProtocolVersion;
import ai.sangmado.jt808.protocol.memory.IByteArrayPool;
import ai.sangmado.jt808.protocol.memory.PooledByteArrayFactory;
import ai.sangmado.jt808.protocol.message.codec.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.message.codec.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.message.codec.impl.JT808MessageByteBufferReader;
import ai.sangmado.jt808.protocol.message.codec.impl.JT808MessageByteBufferWriter;
import ai.sangmado.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x0100;
import ai.sangmado.jt808.protocol.message.header.JT808MessageHeader;
import ai.sangmado.jt808.protocol.message.header.JT808MessageHeaderFactory;
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

public class JT808_Message_0x0100_Test {

    @Mock
    private ISpecificationContext ctx;

    private IByteArrayPool byteArrayPool = new PooledByteArrayFactory(512, 10);

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        when(ctx.getJT808ProtocolVersion()).thenReturn(JT808ProtocolVersion.V2019);
        when(ctx.getByteOrder()).thenReturn(ByteOrder.BIG_ENDIAN);
        when(ctx.getCharset()).thenReturn(Charset.forName("GBK"));
        when(ctx.getMessageContentEncryptionMode()).thenReturn(JT808MessageContentEncryptionMode.None);
        when(ctx.getByteArrayPool()).thenReturn(byteArrayPool);
        assertEquals("GBK", ctx.getCharset().name());
    }

    @Test
    public void when_JT808_Message_0x0100_thenShouldPassSerializationAndDeserialization() {
        JT808MessageId messageId = JT808MessageId.JT808_Message_0x0100;
        String phoneNumber = "123456789";

        int provinceId = 19;
        int cityId = 18;
        String manufacturerId = "777";
        String deviceId = "111";
        String deviceModel = "Made in China";
        String plateNumber = "AAA-BBB-CCC";
        byte plateColor = (byte) 8;
        int serialNumber = 123;

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

        List<JT808MessagePacket> packets = JT808MessagePacketBuilder.buildPackets(ctx, header, content);
        assertEquals(1, packets.size());

        byte[] bufArray = new byte[512];
        ByteBuffer buf = ByteBuffer.wrap(bufArray);
        IJT808MessageBufferWriter writer = new JT808MessageByteBufferWriter(ctx, buf);
        JT808MessagePacket packet = packets.get(0);
        packet.serialize(ctx, writer);
        buf.flip();
        assertEquals(102, buf.limit());

        IJT808MessageBufferReader reader = new JT808MessageByteBufferReader(ctx, buf);
        JT808MessagePacket dePacket = new JT808MessagePacket();
        dePacket.deserialize(ctx, reader);
        assertEquals(messageId, dePacket.getHeader().getMessageId());
        assertEquals(phoneNumber, dePacket.getHeader().getPhoneNumber());
        assertEquals(serialNumber, dePacket.getHeader().getSerialNumber());
        assertEquals(provinceId, ((JT808_Message_Content_0x0100) (dePacket.getContent())).getProvinceId());
        assertEquals(cityId, ((JT808_Message_Content_0x0100) (dePacket.getContent())).getCityId());
        assertEquals(manufacturerId, ((JT808_Message_Content_0x0100) (dePacket.getContent())).getManufacturerId());
        assertEquals(deviceId, ((JT808_Message_Content_0x0100) (dePacket.getContent())).getDeviceId());
        assertEquals(deviceModel, ((JT808_Message_Content_0x0100) (dePacket.getContent())).getDeviceModel());
        assertEquals(plateNumber, ((JT808_Message_Content_0x0100) (dePacket.getContent())).getPlateNumber());
        assertEquals(plateColor, ((JT808_Message_Content_0x0100) (dePacket.getContent())).getPlateColor());
    }
}
