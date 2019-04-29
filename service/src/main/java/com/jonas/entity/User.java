package com.jonas.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.annotation.*;
import com.jonas.enums.AgeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

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
@Accessors(chain = true)
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
    @JSONField(serialzeFeatures = SerializerFeature.WriteEnumUsingToString)
    private AgeEnum age;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 余额
     */
    private Long balance;

    /**
     * 是否审核
     */
    @TableField("is_audit")
    private Boolean isAudit;

    /**
     * 是否删除
     */
    @TableLogic
    @TableField("deleted")
    private Boolean deleted;

    /**
     * 创建时间
     */
    @TableField(value = "ctime", fill = FieldFill.INSERT)
    private Long ctime;

    /**
     * 更新时间
     */
    @TableField(value = "utime", fill = FieldFill.INSERT_UPDATE)
    private Long utime;
}
