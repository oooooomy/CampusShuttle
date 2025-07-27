package org.oooooomy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 退款状态枚举
 * </p>
 *
 * @author Gao YuanMing
 * @since 2025-07-27
 */
@Getter
@AllArgsConstructor
public enum RefundStatus {
    PROCESSING("processing", "处理中"),
    SUCCESS("success", "退款成功"),
    FAILED("failed", "退款失败");

    private final String value;
    private final String description;
}
