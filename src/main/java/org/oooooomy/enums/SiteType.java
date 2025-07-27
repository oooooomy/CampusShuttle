package org.oooooomy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 站点类型枚举
 * </p>
 *
 * @author Gao YuanMing
 * @since 2025-07-27
 */
@Getter
@AllArgsConstructor
public enum SiteType {
    CAMPUS("campus", "校园站点"),
    TRANSPORT_HUB("transport_hub", "交通枢纽站点");

    private final String value;
    private final String description;
}
