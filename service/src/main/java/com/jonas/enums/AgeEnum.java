package com.jonas.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * 【 enter the class description 】
 *
 * @author shenjy 2019/04/29
 */
public enum AgeEnum implements IEnum<Integer> {
    ONE(1, "一岁"),
    TWO(2, "二岁"),
    THREE(3, "三岁");

    private int code;
    private String message;

    AgeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public Integer getValue() {
        return code;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
