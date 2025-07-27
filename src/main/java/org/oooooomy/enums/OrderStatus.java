package org.oooooomy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 订单状态枚举
 * </p>
 *
 * @author Gao YuanMing
 * @since 2025-07-27
 */
@Getter
@AllArgsConstructor
public enum OrderStatus {
    PENDING("pending", "待处理"),
    CONFIRMED("confirmed", "已确认"),
    CANCELLED("cancelled", "已取消"),
    COMPLETED("completed", "已完成"),
    EXPIRED("expired", "已过期");

    private final String value;
    private final String description;

}
