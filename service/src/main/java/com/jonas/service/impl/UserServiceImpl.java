package com.jonas.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jonas.entity.User;
import com.jonas.mapper.UserMapper;
import com.jonas.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<User> listUser(Long uid, Long startTime) {
        LambdaQueryWrapper<User> wrapper = new QueryWrapper<User>().lambda();
        if (null != uid) {
            wrapper.eq(User::getId, uid);
        }
        if (null != startTime) {
            wrapper.ge(User::getCtime, startTime);
        }
        return baseMapper.selectList(wrapper);
    }
}
