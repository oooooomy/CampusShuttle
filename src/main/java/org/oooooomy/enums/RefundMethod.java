package org.oooooomy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 退款方式枚举
 * </p>
 *
 * @author Gao YuanMing
 * @since 2025-07-27
 */
@Getter
@AllArgsConstructor
public enum RefundMethod {
    ORIGINAL("original", "原路退回"),
    MANUAL("manual", "人工退款");

    private final String value;
    private final String description;
}
