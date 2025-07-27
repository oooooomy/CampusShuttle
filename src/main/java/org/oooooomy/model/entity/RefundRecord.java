package org.oooooomy.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 退款记录表
 * </p>
 *
 * @author Gao YuanMing
 * @since 2025-07-27
 */
@Getter
@Setter
@ToString
@TableName("t_refund_record")
public class RefundRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 退款ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 退款单号
     */
    @TableField("refund_no")
    private String refundNo;

    /**
     * 原支付记录ID
     */
    @TableField("payment_id")
    private Long paymentId;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 关联预约订单ID
     */
    @TableField("order_id")
    private Long orderId;

    /**
     * 退款金额
     */
    @TableField("amount")
    private BigDecimal amount;

    /**
     * 退款方式
     */
    @TableField("refund_method")
    private String refundMethod;

    /**
     * 退款状态
     */
    @TableField("status")
    private String status;

    /**
     * 退款原因
     */
    @TableField("reason")
    private String reason;

    /**
     * 第三方退款单号
     */
    @TableField("transaction_id")
    private String transactionId;

    /**
     * 完成时间
     */
    @TableField("complete_time")
    private LocalDateTime completeTime;

    /**
     * 操作人ID(人工退款时)
     */
    @TableField("operator_id")
    private Long operatorId;

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
