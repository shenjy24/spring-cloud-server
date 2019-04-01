package com.jonas.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jonas.entity.User;
import com.jonas.mapper.UserMapper;
import com.jonas.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 【 enter the class description 】
 *
 * @author shenjy 2018/10/25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User getUser(Long uid) {
        return baseMapper.selectById(uid);
    }

}
