package org.oooooomy.service.impl;

import org.oooooomy.model.entity.Order;
import org.oooooomy.mapper.OrderMapper;
import org.oooooomy.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 预约订单表 服务实现类
 * </p>
 *
 * @author Gao YuanMing
 * @since 2025-07-27
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
