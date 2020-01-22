package ai.sangmado.jt808.protocol.message;

import ai.sangmado.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.jt808.protocol.message.header.JT808MessageHeader;

import java.util.List;

/**
 * JT808 消息包构造器
 */
public class JT808MessagePackageBuilder {

    public List<JT808MessagePackage> buildPackages(JT808MessageHeader header, JT808MessageContent content) {
        if (content.canSplitAccordingly()) {
            //content.getSplitByLength();


            // 此处需要获取到消息体的总长度，然后通过分包长度判断是否满足分包条件，进而进行分包操作
        }
        return null;
    }
}
