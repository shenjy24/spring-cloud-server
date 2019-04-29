package com.jonas.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jonas.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 【 enter the class description 】
 *
 * @author shenjy 2018/10/25
 */
@Component
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询用户列表
     *
     * @param startTime
     * @return
     */
    List<User> listUser(@Param("startTime") Long startTime);
}
