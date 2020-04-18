package ai.sangmado.gbprotocol.jt1078.protocol.message.content.JT1078_Message_Content_0x8103_Parameter;

import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItem;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItemId;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageFormatter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 平台设置终端参数 - 参数项 - 音视频通道列表设置
 */
@NoArgsConstructor
public class JT1078_Message_Content_0x8103_PI_0x0076 extends JT808_Message_Content_0x8103_ParameterItem {
    public static final JT808_Message_Content_0x8103_ParameterItemId PARAMETER_ITEM_ID =
            JT1078_Message_Content_0x8103_ParameterItemId.JT1078_0x8103_0x0076;

    @Override
    public JT808_Message_Content_0x8103_ParameterItemId getParameterItemId() {
        return PARAMETER_ITEM_ID;
    }

    @Override
    public Integer getParameterItemLength() {
        return 4;
    }

    /**
     * 音视频通道总数
     */
    @Getter
    @Setter
    private Integer mediaChannelCount;
    /**
     * 音频通道总数
     */
    @Getter
    @Setter
    private Integer audioChannelCount;
    /**
     * 视频通道总数
     */
    @Getter
    @Setter
    private Integer videoChannelCount;
    /**
     * 音视频通道对照表
     */
    @Getter
    @Setter
    private List<MediaChannel> mediaChannelMappingTable;

    /**
     * 音视频通道
     */
    @Getter
    @Setter
    @NoArgsConstructor
    public static class MediaChannel implements IJT808MessageFormatter {
        /**
         * 物理通道号
         */
        private Integer physicalChannelNumber;
        /**
         * 逻辑通道号
         */
        private Integer logicalChannelNumber;
        /**
         * 通道类型
         * <p>
         * 0：音视频；
         * 1：音频；
         * 2：视频
         */
        private Integer channelType;
        /**
         * 是否连接云台
         * <p>
         * 通道类型为0和2时，此字段有效；
         * 0：未连接；1：连接
         */
        private Integer ptzConnected;

        @Override
        public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

        }

        @Override
        public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

        }
    }

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT1078_Message_Content_0x8103_PI_0x0076 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT1078_Message_Content_0x8103_PI_0x0076 content = new JT1078_Message_Content_0x8103_PI_0x0076();
        content.deserialize(ctx, reader);
        return content;
    }
}
