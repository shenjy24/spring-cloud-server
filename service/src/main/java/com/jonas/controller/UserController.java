package com.jonas.controller;

import com.jonas.constant.BizException;
import com.jonas.constant.SystemCode;
import com.jonas.entity.User;
import com.jonas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 【 enter the class description 】
 *
 * @author shenjy 2018/10/24
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private UserService userService;


    /**
     * 获取单个用户
     * @param uid
     * @return
     */
    @RequestMapping("/getUser")
    public User getUser(Long uid) {
        User user = userService.getUser(uid);
        if (null == user) {
            throw new BizException(SystemCode.NEED_AUTH);
        }

        return user;
    }

    @PostMapping("/test")
    public Integer test() {
        return port;
    }

    @PostMapping("/getUserObject")
    public User getUserObject(@RequestBody User user) {
        throw new RuntimeException();
    }
}
