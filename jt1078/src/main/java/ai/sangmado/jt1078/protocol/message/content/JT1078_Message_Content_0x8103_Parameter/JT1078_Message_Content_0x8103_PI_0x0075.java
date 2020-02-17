package ai.sangmado.jt1078.protocol.message.content.JT1078_Message_Content_0x8103_Parameter;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.encoding.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItem;
import ai.sangmado.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItemId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 平台设置终端参数 - 参数项 - 音视频参数设置
 */
@NoArgsConstructor
public class JT1078_Message_Content_0x8103_PI_0x0075 extends JT808_Message_Content_0x8103_ParameterItem {
    public static final JT808_Message_Content_0x8103_ParameterItemId PARAMETER_ITEM_ID =
            JT1078_Message_Content_0x8103_ParameterItemId.JT1078_0x8103_0x0075;

    @Override
    public JT808_Message_Content_0x8103_ParameterItemId getParameterItemId() {
        return PARAMETER_ITEM_ID;
    }

    @Override
    public Integer getParameterItemLength() {
        return 4;
    }

    /**
     * 实时流编码模式
     * <p>
     * 0：CBR(固定码率)；
     * 1：VBR(可变码率)；
     * 2：ABR(平均码率)；
     * 100 ～127：自定义
     */
    @Getter
    @Setter
    private Integer realtimeStreamEncoding;

    /**
     * 实时流分辨率
     * <p>
     * 0：QCIF；
     * 1：CIF；
     * 2：WCIF；
     * 3：D1；
     * 4：WD1；
     * 5：720P；
     * 6：1 080P；
     * 100 ～127：自定义
     */
    @Getter
    @Setter
    private Integer realtimeStreamResolution;

    /**
     * 实时流关键帧间隔
     * <p>
     * 范围(1 ～1 000)帧
     */
    @Getter
    @Setter
    private Integer realtimeStreamKeyFrameInterval;

    /**
     * 实时流目标帧率
     * <p>
     * 范围(1～120)帧/s
     */
    @Getter
    @Setter
    private Integer realtimeStreamTargetFps;

    /**
     * 实时流目标码率
     * <p>
     * 单位为千位每秒(kbps)
     */
    @Getter
    @Setter
    private Long realtimeStreamTargetBitRate;

    /**
     * 存储流编码模式
     * <p>
     * 0：CBR(固定码率)；
     * 1：VBR(可变码率)；
     * 2：ABR(平均码率)；
     * 100 ～127：自定义
     */
    @Getter
    @Setter
    private Integer storageStreamEncoding;

    /**
     * 存储流分辨率
     * <p>
     * 0：QCIF；
     * 1：CIF；
     * 2：WCIF；
     * 3：D1；
     * 4：WD1；
     * 5：720P；
     * 6：1 080P；
     * 100 ～127：自定义
     */
    @Getter
    @Setter
    private Integer storageStreamResolution;

    /**
     * 存储流关键帧间隔
     * <p>
     * 范围(1 ～1 000)帧
     */
    @Getter
    @Setter
    private Integer storageStreamKeyFrameInterval;

    /**
     * 存储流目标帧率
     * <p>
     * 范围(1～120)帧/s
     */
    @Getter
    @Setter
    private Integer storageStreamTargetFps;

    /**
     * 存储流目标码率
     * <p>
     * 单位为千位每秒(kbps)
     */
    @Getter
    @Setter
    private Long storageStreamTargetBitRate;

    /**
     * OSD字幕叠加设置
     * <p>
     * 按位设置：0 表示不叠加，1 表示叠加；
     * bit0：日期和时间；
     * bit1：车牌号码；
     * bit2：逻辑通道号；
     * bit3：经纬度；
     * bit4：行驶记录速度；
     * bit5：卫星定位速度；
     * bit6：连续驾驶时间；
     * bit7 ～ bit10：保留；
     * bit11 ～ bit15：自定义
     */
    @Getter
    @Setter
    private Integer osdOverlaySetting;

    /**
     * 是否启用音频输出
     * <p>
     * 0：不启用；1：启用
     */
    @Getter
    @Setter
    private Integer audioOutputEnabled;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {
        writer.writeDWord(getParameterItemId().getValue());
        writer.writeByte(getParameterItemLength());

        writer.writeByte(getRealtimeStreamEncoding());
        writer.writeByte(getRealtimeStreamResolution());
        writer.writeWord(getRealtimeStreamKeyFrameInterval());
        writer.writeByte(getRealtimeStreamTargetFps());
        writer.writeDWord(getRealtimeStreamTargetBitRate());

        writer.writeByte(getStorageStreamEncoding());
        writer.writeByte(getStorageStreamResolution());
        writer.writeWord(getStorageStreamKeyFrameInterval());
        writer.writeByte(getStorageStreamTargetFps());
        writer.writeDWord(getStorageStreamTargetBitRate());

        writer.writeWord(getOsdOverlaySetting());
        writer.writeByte(getAudioOutputEnabled());
    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        reader.readDWord();
        reader.readByte();

        setRealtimeStreamEncoding(reader.readByte() & 0xFF);
        setRealtimeStreamResolution(reader.readByte() & 0xFF);
        setRealtimeStreamKeyFrameInterval(reader.readWord());
        setRealtimeStreamTargetFps(reader.readByte() & 0xFF);
        setRealtimeStreamTargetBitRate(reader.readDWord());

        setStorageStreamEncoding(reader.readByte() & 0xFF);
        setStorageStreamResolution(reader.readByte() & 0xFF);
        setStorageStreamKeyFrameInterval(reader.readWord());
        setStorageStreamTargetFps(reader.readByte() & 0xFF);
        setStorageStreamTargetBitRate(reader.readDWord());

        setOsdOverlaySetting(reader.readWord());
        setAudioOutputEnabled(reader.readByte() & 0xFF);
    }

    public static JT1078_Message_Content_0x8103_PI_0x0075 decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT1078_Message_Content_0x8103_PI_0x0075 content = new JT1078_Message_Content_0x8103_PI_0x0075();
        content.deserialize(ctx, reader);
        return content;
    }
}
