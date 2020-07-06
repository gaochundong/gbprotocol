package ai.sangmado.gbprotocol.gbcommon.serializer;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializerBase;

/**
 * 整数转16进制字符串，宽度为8
 */
public class LongToHex8StringSerializer extends ToStringSerializerBase {
    public final static ToStringSerializer instance = new ToStringSerializer();

    public LongToHex8StringSerializer() {
        super(Object.class);
    }

    public LongToHex8StringSerializer(Class<?> handledType) {
        super(handledType);
    }

    @Override
    @SuppressWarnings("RedundantCast")
    public String valueToString(Object value) {
        return "0x" + String.format("%08X", (Long) value).toUpperCase();
    }
}