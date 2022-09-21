package com.itheima.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExAdvice {

    @ExceptionHandler(Exception.class)
    public R dealException(Exception ex){
        //记录日志
        //发送消息
        //打印异常
        ex.printStackTrace();

        return new R("服务器异常");
    }

}
