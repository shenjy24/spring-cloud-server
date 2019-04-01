package com.jonas.api.service;

import com.jonas.api.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 【 enter the class description 】
 *
 * @author shenjy 2018/10/25
 */
@FeignClient(value = "spring-cloud-server", path = "/user")
public interface UserApiService {

    /**
     * 获取单个用户
     * @param uid
     * @return
     */
    @RequestMapping("/getUser")
    User getUser(@RequestParam("uid") Long uid) ;

    @PostMapping("/test")
    Integer test();
}
