package ai.sangmado.gbstandard.jt1078.protocol.message;

import ai.sangmado.gbstandard.gbcommon.memory.IByteArrayPool;
import ai.sangmado.gbstandard.gbcommon.memory.PooledByteArrayFactory;
import ai.sangmado.jt1078.protocol.message.content.JT1078_Message_Content_0x8103_Parameter.JT1078_Message_Content_0x8103_PI_0x0075;
import ai.sangmado.jt1078.protocol.message.extension.JT1078MessageExtension;
import ai.sangmado.gbstandard.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbstandard.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.gbstandard.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.gbstandard.jt808.protocol.encoding.impl.JT808MessageByteBufferReader;
import ai.sangmado.gbstandard.jt808.protocol.encoding.impl.JT808MessageByteBufferWriter;
import ai.sangmado.gbstandard.jt808.protocol.enums.JT808MessageContentEncryptionMode;
import ai.sangmado.gbstandard.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbstandard.jt808.protocol.enums.JT808ProtocolVersion;
import ai.sangmado.gbstandard.jt808.protocol.message.JT808MessagePacket;
import ai.sangmado.gbstandard.jt808.protocol.message.JT808MessagePacketBuilder;
import ai.sangmado.gbstandard.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbstandard.jt808.protocol.message.content.JT808_Message_Content_0x8103;
import ai.sangmado.gbstandard.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_PI_0x0001;
import ai.sangmado.gbstandard.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_PI_0x0002;
import ai.sangmado.gbstandard.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItem;
import ai.sangmado.gbstandard.jt808.protocol.message.header.JT808MessageHeader;
import ai.sangmado.gbstandard.jt808.protocol.message.header.JT808MessageHeaderFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class JT1078_Message_0x8103_Test {

    @Mock
    private ISpecificationContext ctx;

    private IByteArrayPool byteArrayPool = new PooledByteArrayFactory(512, 10);

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        when(ctx.getProtocolVersion()).thenReturn(JT808ProtocolVersion.V2011);
        when(ctx.getByteOrder()).thenReturn(ByteOrder.BIG_ENDIAN);
        when(ctx.getCharset()).thenReturn(Charset.forName("GBK"));
        when(ctx.getMessageContentEncryptionMode()).thenReturn(JT808MessageContentEncryptionMode.None);
        when(ctx.getByteArrayPool()).thenReturn(byteArrayPool);
        assertEquals("GBK", ctx.getCharset().name());

        JT1078MessageExtension.extend();
    }

    @Test
    public void when_JT1078_Message_0x8103_thenShouldPassSerializationAndDeserialization() {
        JT808MessageId messageId = JT808MessageId.JT808_Message_0x8103;
        String phoneNumber = "123456789";
        int serialNumber = 123;

        JT808_Message_Content_0x8103_PI_0x0001 pi1 = new JT808_Message_Content_0x8103_PI_0x0001();
        pi1.setHeartbeatInterval(12345L);
        JT808_Message_Content_0x8103_PI_0x0002 pi2 = new JT808_Message_Content_0x8103_PI_0x0002();
        pi2.setTcpReplyTimeout(23456L);
        JT1078_Message_Content_0x8103_PI_0x0075 pi3 = new JT1078_Message_Content_0x8103_PI_0x0075();
        pi3.setRealtimeStreamEncoding(0);
        pi3.setRealtimeStreamResolution(3);
        pi3.setRealtimeStreamKeyFrameInterval(10);
        pi3.setRealtimeStreamTargetFps(25);
        pi3.setRealtimeStreamTargetBitRate(1024L);
        pi3.setStorageStreamEncoding(0);
        pi3.setStorageStreamResolution(3);
        pi3.setStorageStreamKeyFrameInterval(10);
        pi3.setStorageStreamTargetFps(25);
        pi3.setStorageStreamTargetBitRate(1024L);
        pi3.setOsdOverlaySetting(1);
        pi3.setAudioOutputEnabled(1);

        List<JT808_Message_Content_0x8103_ParameterItem> itemList = new ArrayList<>();
        itemList.add(pi1);
        itemList.add(pi2);
        itemList.add(pi3);

        JT808MessageHeader header = JT808MessageHeaderFactory
                .buildWith(ctx)
                .withMessageId(messageId)
                .withPhoneNumber(phoneNumber)
                .withSerialNumber(serialNumber);
        JT808MessageContent content = JT808_Message_Content_0x8103.builder()
                .itemCount(itemList.size())
                .itemList(itemList)
                .build();

        List<JT808MessagePacket> packets = JT808MessagePacketBuilder.buildPackets(ctx, header, content);
        assertEquals(1, packets.size());

        byte[] bufArray = new byte[512];
        ByteBuffer buf = ByteBuffer.wrap(bufArray);
        IJT808MessageBufferWriter writer = new JT808MessageByteBufferWriter(ctx, buf);
        JT808MessagePacket sePacket = packets.get(0);
        sePacket.serialize(ctx, writer);
        buf.flip();
        assertEquals(60, buf.limit());

        IJT808MessageBufferReader reader = new JT808MessageByteBufferReader(ctx, buf);
        JT808MessagePacket dePacket = new JT808MessagePacket();
        dePacket.deserialize(ctx, reader);
        assertEquals(messageId, dePacket.getHeader().getMessageId());
        assertEquals(phoneNumber, dePacket.getHeader().getPhoneNumber());
        assertEquals(serialNumber, dePacket.getHeader().getSerialNumber());
        assertEquals(itemList.size(), ((JT808_Message_Content_0x8103) (dePacket.getContent())).getItemCount());
        assertEquals(JT808_Message_Content_0x8103_PI_0x0001.PARAMETER_ITEM_ID, ((JT808_Message_Content_0x8103) (dePacket.getContent())).getItemList().get(0).getParameterItemId());
        assertEquals(JT808_Message_Content_0x8103_PI_0x0002.PARAMETER_ITEM_ID, ((JT808_Message_Content_0x8103) (dePacket.getContent())).getItemList().get(1).getParameterItemId());
        assertEquals(JT1078_Message_Content_0x8103_PI_0x0075.PARAMETER_ITEM_ID, ((JT808_Message_Content_0x8103) (dePacket.getContent())).getItemList().get(2).getParameterItemId());
        assertEquals(pi3.getRealtimeStreamTargetBitRate(), ((JT1078_Message_Content_0x8103_PI_0x0075) (((JT808_Message_Content_0x8103) (dePacket.getContent())).getItemList().get(2))).getRealtimeStreamTargetBitRate());
    }
}
