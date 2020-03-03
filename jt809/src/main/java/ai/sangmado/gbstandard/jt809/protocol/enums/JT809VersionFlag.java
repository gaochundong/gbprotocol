package ai.sangmado.gbstandard.jt809.protocol.enums;

import lombok.*;

/**
 * 协议版本号标识
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT809VersionFlag {
    public static final int MajorIndex = 0;
    public static final int MinorIndex = 1;
    public static final int BuildIndex = 2;
    public static final int FixedByteLength = 3;

    private byte majorVersion;

    private byte minorVersion;

    private byte buildVersion;

    public JT809VersionFlag(int majorVersion, int minorVersion, int buildVersion) {
        this.majorVersion = (byte) majorVersion;
        this.minorVersion = (byte) minorVersion;
        this.buildVersion = (byte) buildVersion;
    }

    public JT809VersionFlag(byte[] array) {
        this.majorVersion = array[MajorIndex];
        this.minorVersion = array[MinorIndex];
        this.buildVersion = array[BuildIndex];
    }

    public byte[] toArray() {
        byte[] array = new byte[FixedByteLength];
        array[MajorIndex] = getMajorVersion();
        array[MinorIndex] = getMinorVersion();
        array[BuildIndex] = getBuildVersion();
        return array;
    }

    @Override
    public String toString() {
        return String.format("%s.%s.%s",
                getMajorVersion(), getMinorVersion(), getBuildVersion());
    }
}
