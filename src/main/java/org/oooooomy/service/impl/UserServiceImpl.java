package org.oooooomy.service.impl;

import org.oooooomy.model.entity.User;
import org.oooooomy.mapper.UserMapper;
import org.oooooomy.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author Gao YuanMing
 * @since 2025-07-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
