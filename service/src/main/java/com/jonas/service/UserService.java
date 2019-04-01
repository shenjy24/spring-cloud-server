package com.jonas.service;

import com.jonas.entity.User;

/**
 * 【 enter the class description 】
 *
 * @author shenjy 2018/10/25
 */
public interface UserService {

    /**
     * 获取单个用户
     * @param uid
     * @return
     */
    User getUser(Long uid);
}
