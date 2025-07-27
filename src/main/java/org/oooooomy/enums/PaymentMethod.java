package org.oooooomy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 支付方式枚举
 * </p>
 *
 * @author Gao YuanMing
 * @since 2025-07-27
 */
@Getter
@AllArgsConstructor
public enum PaymentMethod {
    WECHAT("wechat", "微信支付"),
    ALIPAY("alipay", "支付宝"),
    CAMPUS_CARD("campus_card", "校园卡支付");

    private final String value;
    private final String description;
}
