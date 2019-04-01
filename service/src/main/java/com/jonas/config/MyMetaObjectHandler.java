package com.jonas.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.toolkit.SystemClock;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * 【功能描述】
 *
 * @author yangjh  16/08/2018.
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {

        Long now = SystemClock.now();

        Object ctime = getFieldValByName("ctime", metaObject);
        if (null == ctime) {
            setFieldValByName("ctime", now, metaObject);
        }

        Object utime = getFieldValByName("utime", metaObject);
        if (null == utime) {
            setFieldValByName("utime", now, metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Long now = SystemClock.now();

        Object utime = getFieldValByName("utime", metaObject);
        if (null == utime) {
            setFieldValByName("utime", now, metaObject);
        }
    }
}
