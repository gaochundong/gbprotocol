package ai.sangmado.gbprotocol.gbcommon.serializer;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializerBase;

/**
 * 整数转16进制字符串，宽度为2
 */
public class IntegerToHex2StringSerializer extends ToStringSerializerBase {
    public final static ToStringSerializer instance = new ToStringSerializer();

    public IntegerToHex2StringSerializer() {
        super(Object.class);
    }

    public IntegerToHex2StringSerializer(Class<?> handledType) {
        super(handledType);
    }

    @Override
    @SuppressWarnings("RedundantCast")
    public String valueToString(Object value) {
        return "0x" + String.format("%02X", (Integer) value).toUpperCase();
    }
}