package org.oooooomy.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 站点信息表
 * </p>
 *
 * @author Gao YuanMing
 * @since 2025-08-06
 */
@Getter
@Setter
@ToString
@TableName("t_site")
public class Site implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 站点ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 站点编码(如XY_AIRPORT)
     */
    @TableField("site_code")
    private String siteCode;

    /**
     * 站点名称(如咸阳国际机场)
     */
    @TableField("site_name")
    private String siteName;

    /**
     * 描述信息(在哪个位置上车)
     */
    @TableField("description")
    private String description;

    /**
     * 是否启用(1-启用,0-停用)
     */
    @TableField("is_active")
    private Boolean isActive;

    /**
     * 站点类型(校区/交通枢纽)
     */
    @TableField("site_type")
    private String siteType;

    /**
     * 排序权重
     */
    @TableField("sort_order")
    private Integer sortOrder;

    /**
     * 创建时间
     */
    @TableField("created_at")
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    @TableField("updated_at")
    private LocalDateTime updatedAt;
}
