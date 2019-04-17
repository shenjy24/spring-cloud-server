package com.jonas.config;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.jonas.constant.BizException;
import com.jonas.constant.JsonResult;
import com.jonas.constant.SystemCode;
import com.jonas.util.logging.SystemLogger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 【 enter the class description 】
 *
 * @author shenjy 2018/11/01
 */
@ControllerAdvice
@Configuration
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public void handleException(Exception ex, HttpServletResponse response) {
        if (ex instanceof BizException) {
            try {
                response.setContentType("text/json; charset=UTF-8");
                response.getWriter().write(ex.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                SystemLogger.getLogger().error("server error: ", ex);
                response.setContentType("text/json; charset=UTF-8");
                response.getWriter().write(new BizException(SystemCode.SERVER_ERROR).getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
