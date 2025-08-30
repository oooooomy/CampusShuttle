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
 * 支付记录表
 * </p>
 *
 * @author Gao YuanMing
 * @since 2025-08-06
 */
@Getter
@Setter
@ToString
@TableName("t_payment_record")
public class PaymentRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 支付ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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
     * 支付订单号
     */
    @TableField("order_no")
    private String orderNo;

    /**
     * 支付金额(固定5元)
     */
    @TableField("amount")
    private BigDecimal amount;

    /**
     * 支付方式
     */
    @TableField("payment_method")
    private String paymentMethod;

    /**
     * 支付状态
     */
    @TableField("status")
    private String status;

    /**
     * 第三方交易号
     */
    @TableField("transaction_id")
    private String transactionId;

    /**
     * 支付时间
     */
    @TableField("payment_time")
    private LocalDateTime paymentTime;

    /**
     * 回调时间
     */
    @TableField("callback_time")
    private LocalDateTime callbackTime;

    /**
     * 回调内容
     */
    @TableField("callback_content")
    private String callbackContent;

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
