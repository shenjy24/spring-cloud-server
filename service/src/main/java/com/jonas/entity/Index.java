package com.jonas.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 【 enter the class description 】
 *
 * @author shenjy 2019/04/21
 */
@Data
@TableName("t_index")
public class Index {
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    @TableField
    private Long a;

    @TableField
    private Long b;

    @TableField
    private Long c;

    @TableField
    private Long d;

    @TableField
    private Long e;
}
