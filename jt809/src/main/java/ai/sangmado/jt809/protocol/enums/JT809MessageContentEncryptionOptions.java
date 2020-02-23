package ai.sangmado.jt809.protocol.enums;

import lombok.*;

/**
 * 消息体加密参数
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT809MessageContentEncryptionOptions {

    private Long IA1;

    private Long IC1;

    private Long M1;
}
