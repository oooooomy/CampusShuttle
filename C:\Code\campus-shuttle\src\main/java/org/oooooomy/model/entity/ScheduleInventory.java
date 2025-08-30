package org.oooooomy.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 班次每日库存表
 * </p>
 *
 * @author Gao YuanMing
 * @since 2025-08-06
 */
@Getter
@Setter
@ToString
@TableName("t_schedule_inventory")
public class ScheduleInventory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 库存ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 班次ID
     */
    @TableField("schedule_id")
    private Long scheduleId;

    /**
     * 库存日期
     */
    @TableField("inventory_date")
    private LocalDate inventoryDate;

    /**
     * 总座位数
     */
    @TableField("total_seats")
    private Integer totalSeats;

    /**
     * 可用座位数
     */
    @TableField("available_seats")
    private Integer availableSeats;

    /**
     * 乐观锁版本号
     */
    @TableField("version")
    private Integer version;

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
