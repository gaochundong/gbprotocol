package ai.sangmado.jt808.protocol.message.header;

/**
 * 消息头工厂
 */
public final class JT808MessageHeaderFactory {

    public JT808MessageHeader2011.JT808MessageHeader2011Builder complianceWith2011Builder() {
        return JT808MessageHeader2011.builder();
    }

    public JT808MessageHeader2013.JT808MessageHeader2013Builder complianceWith2013Builder() {
        return JT808MessageHeader2013.builder();
    }

    public JT808MessageHeader2019.JT808MessageHeader2019Builder complianceWith2019Builder() {
        return JT808MessageHeader2019.builder();
    }
}
