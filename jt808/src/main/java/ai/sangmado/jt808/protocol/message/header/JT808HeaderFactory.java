package ai.sangmado.jt808.protocol.message.header;

/**
 * 消息头工厂
 */
public final class JT808HeaderFactory {

    public JT808Header2011.JT808Header2011Builder complianceWith2011Builder() {
        return JT808Header2011.builder();
    }

    public JT808Header2013.JT808Header2013Builder complianceWith2013Builder() {
        return JT808Header2013.builder();
    }

    public JT808Header2019.JT808Header2019Builder complianceWith2019Builder() {
        return JT808Header2019.builder();
    }
}
