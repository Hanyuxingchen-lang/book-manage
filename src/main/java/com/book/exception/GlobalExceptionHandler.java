package com.book.exception;

import com.book.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局统一异常处理器
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResultUtil<?> businessException(BusinessException e) {
        return ResultUtil.fail(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultUtil<?> allException(Exception e) {
        e.printStackTrace();
        return ResultUtil.fail("系统异常，请联系管理员");
    }
}