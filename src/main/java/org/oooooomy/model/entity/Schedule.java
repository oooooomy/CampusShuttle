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
import java.time.LocalTime;

/**
 * <p>
 * 班次信息表
 * </p>
 *
 * @author Gao YuanMing
 * @since 2025-07-27
 */
@Getter
@Setter
@ToString
@TableName("t_schedule")
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 班次ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 车牌号
     */
    @TableField("bus_number")
    private String busNumber;

    /**
     * 出发站点ID
     */
    @TableField("departure_site_id")
    private String departureSiteId;

    /**
     * 到达站点ID
     */
    @TableField("arrival_site_id")
    private String arrivalSiteId;

    /**
     * 发车时间
     */
    @TableField("departure_time")
    private LocalTime departureTime;

    /**
     * 总座位数
     */
    @TableField("total_seats")
    private Integer totalSeats;

    /**
     * 司机姓名
     */
    @TableField("driver_name")
    private String driverName;

    /**
     * 司机联系方式
     */
    @TableField("driver_contact")
    private String driverContact;

    /**
     * 是否启用(1-启用,0-停用)
     */
    @TableField("is_active")
    private Boolean isActive;

    /**
     * 班次类型
     */
    @TableField("schedule_type")
    private String scheduleType;

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
