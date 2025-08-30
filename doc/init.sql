CREATE TABLE `t_user`
(
    `id`         bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `username`   varchar(20)  NOT NULL COMMENT '用户名/学工号',
    `password`   varchar(100) NOT NULL COMMENT '加密后的密码',
    `salt`       varchar(50)  NOT NULL COMMENT '加密盐值',
    `real_name`  varchar(20)  NOT NULL COMMENT '真实姓名',
    `role`       varchar(20)  NOT NULL COMMENT '用户角色',
    `department` varchar(50)           DEFAULT NULL COMMENT '院系/部门',
    `phone`      varchar(20)           DEFAULT NULL COMMENT '手机号',
    `email`      varchar(50)           DEFAULT NULL COMMENT '邮箱',
    `status`     tinyint(1)   NOT NULL DEFAULT '1' COMMENT '状态(1-正常,0-禁用)',
    `created_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_username` (`username`),
    KEY `idx_phone` (`phone`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户信息表';

CREATE TABLE `t_site`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '站点ID',
    `site_name`   varchar(50)  NOT NULL COMMENT '站点名称(如咸阳国际机场)',
    `description` varchar(100) NOT NULL COMMENT '描述信息(在哪个位置上车)',
    `is_active`   tinyint(1)   NOT NULL DEFAULT '1' COMMENT '是否启用(1-启用,0-停用)',
    `site_type`   varchar(20)  NOT NULL COMMENT '站点类型(校区/交通枢纽)',
    `sort_order`  int(11)               DEFAULT '0' COMMENT '排序权重',
    `created_at`  datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`  datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `idx_site_type` (`site_type`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='站点信息表';

CREATE TABLE `t_schedule`
(
    `id`             bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '班次ID',
    `departure_site` varchar(50) NOT NULL COMMENT '出发站名称(如"长安校区")',
    `arrival_site`   varchar(50) NOT NULL COMMENT '到达站名称(如"友谊校区")',
    `departure_time` time        NOT NULL COMMENT '发车时间',
    `total_seats`    int(3)      NOT NULL COMMENT '总座位数',
    `is_active`      tinyint(1)  NOT NULL DEFAULT '1' COMMENT '是否启用(1-启用,0-停用)',
    `schedule_type`  varchar(20) NOT NULL DEFAULT 'regular' COMMENT '班次类型',
    `created_at`     datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`     datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `idx_departure_time` (`departure_time`),
    KEY `idx_site_pair` (`departure_site`, `arrival_site`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='班次信息表';

CREATE TABLE `t_schedule_inventory`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT '库存ID',
    `schedule_id`     bigint(20) NOT NULL COMMENT '班次ID',
    `inventory_date`  date       NOT NULL COMMENT '库存日期',
    `total_seats`     int(11)    NOT NULL COMMENT '总座位数',
    `available_seats` int(11)    NOT NULL COMMENT '可用座位数',
    `version`         int(11)    NOT NULL DEFAULT '0' COMMENT '乐观锁版本号',
    `created_at`      datetime   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`      datetime   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_schedule_date` (`schedule_id`, `inventory_date`),
    KEY `idx_inventory_date` (`inventory_date`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='班次每日库存表';

CREATE TABLE `t_order`
(
    `id`               bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '预约订单ID',
    `user_id`          bigint(20)  NOT NULL COMMENT '用户ID',
    `schedule_id`      bigint(20)  NOT NULL COMMENT '班次ID',
    `inventory_id`     bigint(20)  NOT NULL COMMENT '库存ID',
    `reservation_date` date        NOT NULL COMMENT '预约日期',
    `status`           varchar(20) NOT NULL COMMENT '预约状态',
    `cancel_reason`    varchar(255)         DEFAULT NULL COMMENT '取消原因',
    `qr_code`          varchar(100)         DEFAULT NULL COMMENT '乘车二维码',
    `created_at`       datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`       datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_user_schedule_date` (`user_id`, `schedule_id`, `reservation_date`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_schedule_date` (`schedule_id`, `reservation_date`),
    KEY `idx_status` (`status`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='预约订单表';

CREATE TABLE `t_payment_record`
(
    `id`               bigint(20)     NOT NULL AUTO_INCREMENT COMMENT '支付ID',
    `user_id`          bigint(20)     NOT NULL COMMENT '用户ID',
    `order_id`         bigint(20)     NOT NULL COMMENT '关联预约订单ID',
    `order_no`         varchar(32)    NOT NULL COMMENT '支付订单号',
    `amount`           decimal(10, 2) NOT NULL DEFAULT '5.00' COMMENT '支付金额(固定5元)',
    `payment_method`   varchar(20)    NOT NULL COMMENT '支付方式',
    `status`           varchar(20)    NOT NULL COMMENT '支付状态',
    `transaction_id`   varchar(64)             DEFAULT NULL COMMENT '第三方交易号',
    `payment_time`     datetime                DEFAULT NULL COMMENT '支付时间',
    `callback_time`    datetime                DEFAULT NULL COMMENT '回调时间',
    `callback_content` text                    DEFAULT NULL COMMENT '回调内容',
    `created_at`       datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`       datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_order_no` (`order_no`),
    UNIQUE KEY `uk_order_id` (`order_id`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_payment_time` (`payment_time`),
    KEY `idx_status` (`status`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='支付记录表';

CREATE TABLE `t_refund_record`
(
    `id`             bigint(20)     NOT NULL AUTO_INCREMENT COMMENT '退款ID',
    `refund_no`      varchar(32)    NOT NULL COMMENT '退款单号',
    `payment_id`     bigint(20)     NOT NULL COMMENT '原支付记录ID',
    `user_id`        bigint(20)     NOT NULL COMMENT '用户ID',
    `order_id`       bigint(20)     NOT NULL COMMENT '关联预约订单ID',
    `amount`         decimal(10, 2) NOT NULL DEFAULT '5.00' COMMENT '退款金额',
    `refund_method`  varchar(20)    NOT NULL COMMENT '退款方式',
    `status`         varchar(20)    NOT NULL COMMENT '退款状态',
    `reason`         varchar(255)            DEFAULT NULL COMMENT '退款原因',
    `transaction_id` varchar(64)             DEFAULT NULL COMMENT '第三方退款单号',
    `complete_time`  datetime                DEFAULT NULL COMMENT '完成时间',
    `operator_id`    bigint(20)              DEFAULT NULL COMMENT '操作人ID(人工退款时)',
    `created_at`     datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`     datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_refund_no` (`refund_no`),
    KEY `idx_payment_id` (`payment_id`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_order_id` (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='退款记录表';