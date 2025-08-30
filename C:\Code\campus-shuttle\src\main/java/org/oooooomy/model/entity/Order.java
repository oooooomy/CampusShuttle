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
 * 预约订单表
 * </p>
 *
 * @author Gao YuanMing
 * @since 2025-08-06
 */
@Getter
@Setter
@ToString
@TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 预约订单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 班次ID
     */
    @TableField("schedule_id")
    private Long scheduleId;

    /**
     * 库存ID
     */
    @TableField("inventory_id")
    private Long inventoryId;

    /**
     * 预约日期
     */
    @TableField("reservation_date")
    private LocalDate reservationDate;

    /**
     * 预约状态
     */
    @TableField("status")
    private String status;

    /**
     * 取消原因
     */
    @TableField("cancel_reason")
    private String cancelReason;

    /**
     * 乘车二维码
     */
    @TableField("qr_code")
    private String qrCode;

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
