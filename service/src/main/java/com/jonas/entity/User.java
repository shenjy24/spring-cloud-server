package com.jonas.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 用户基础信息表
 * </p>
 *
 * @author yangjh
 * @since 2018-08-24
 */
@Data
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(type = IdType.ID_WORKER)
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

    /**
     * 创建时间
     */
    @TableField(value = "ctime", fill = FieldFill.INSERT)
    private Long ctime;

    /**
     * 更新时间
     */
    @TableField(value = "utime", fill = FieldFill.INSERT)
    private Long utime;
}
