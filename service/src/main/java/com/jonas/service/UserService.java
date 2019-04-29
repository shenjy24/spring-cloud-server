package com.jonas.service;

import com.jonas.entity.User;

import java.util.List;

/**
 * 【 enter the class description 】
 *
 * @author shenjy 2018/10/25
 */
public interface UserService {

    /**
     * 获取单个用户
     *
     * @param uid
     * @return
     */
    User getUser(Long uid);

    /**
     * 查询用户列表
     *
     * @param uid
     * @param startTime
     * @return
     */
    List<User> listUser(Long uid, Long startTime);
}
