package org.oooooomy.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SiteVo {

    /**
     * 站点ID
     */
    private Long id;

    private String siteCode;

    /**
     * 站点名称(如咸阳国际机场)
     */
    private String siteName;

    /**
     * 详细地址
     */
    private String location;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 纬度
     */
    private BigDecimal latitude;

    /**
     * 排序权重
     */
    private Integer sortOrder;

}
