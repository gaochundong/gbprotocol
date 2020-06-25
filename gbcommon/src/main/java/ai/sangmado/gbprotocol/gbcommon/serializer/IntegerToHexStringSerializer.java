package ai.sangmado.gbprotocol.gbcommon.serializer;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializerBase;

/**
 * 整数转16进制字符串
 */
public class IntegerToHexStringSerializer extends ToStringSerializerBase {
    public final static ToStringSerializer instance = new ToStringSerializer();

    public IntegerToHexStringSerializer() {
        super(Object.class);
    }

    public IntegerToHexStringSerializer(Class<?> handledType) {
        super(handledType);
    }

    @Override
    @SuppressWarnings("RedundantCast")
    public String valueToString(Object value) {
        return "0x" + String.format("%X", (Integer) value).toUpperCase();
    }
}