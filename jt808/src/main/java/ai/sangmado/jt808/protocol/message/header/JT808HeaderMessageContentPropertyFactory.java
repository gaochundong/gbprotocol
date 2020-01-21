package ai.sangmado.jt808.protocol.message.header;

/**
 * 消息头中消息体属性工厂
 */
public final class JT808HeaderMessageContentPropertyFactory {

    public JT808HeaderMessageContentProperty2011.JT808HeaderMessageContentProperty2011Builder complianceWith2011Builder() {
        return JT808HeaderMessageContentProperty2011.builder();
    }

    public JT808HeaderMessageContentProperty2013.JT808HeaderMessageContentProperty2013Builder complianceWith2013Builder() {
        return JT808HeaderMessageContentProperty2013.builder();
    }

    public JT808HeaderMessageContentProperty2019.JT808HeaderMessageContentProperty2019Builder complianceWith2019Builder() {
        return JT808HeaderMessageContentProperty2019.builder();
    }
}
