package org.oooooomy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 支付状态枚举
 * </p>
 *
 * @author Gao YuanMing
 * @since 2025-07-27
 */
@Getter
@AllArgsConstructor
public enum PaymentStatus {
    PENDING("pending", "待支付"),
    PAID("paid", "已支付"),
    REFUNDED("refunded", "已退款"),
    FAILED("failed", "支付失败");

    private final String value;
    private final String description;
}
