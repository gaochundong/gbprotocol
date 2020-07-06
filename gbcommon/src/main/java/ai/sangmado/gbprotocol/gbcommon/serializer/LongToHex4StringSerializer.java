package ai.sangmado.gbprotocol.gbcommon.serializer;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializerBase;

/**
 * 整数转16进制字符串，宽度为4
 */
public class LongToHex4StringSerializer extends ToStringSerializerBase {
    public final static ToStringSerializer instance = new ToStringSerializer();

    public LongToHex4StringSerializer() {
        super(Object.class);
    }

    public LongToHex4StringSerializer(Class<?> handledType) {
        super(handledType);
    }

    @Override
    @SuppressWarnings("RedundantCast")
    public String valueToString(Object value) {
        return "0x" + String.format("%04X", (Long) value).toUpperCase();
    }
}