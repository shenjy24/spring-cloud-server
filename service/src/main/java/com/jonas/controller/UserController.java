package com.jonas.controller;

import com.jonas.entity.User;
import com.jonas.mapper.UserMapper;
import com.jonas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 【 enter the class description 】
 *
 * @author shenjy 2018/10/24
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/listUser")
    public List<User> listUser(Long startTime) {
        return userMapper.listUser(startTime);
    }
}
