package com.jonas.api.dto;

import lombok.Data;

/**
 * <p>
 * 用户基础信息表
 * </p>
 *
 * @author yangjh
 * @since 2018-08-24
 */
@Data
public class User {

    private Long id;

    /**
     * 用户昵称
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

    private Long ctime;

    private Long utime;
}
