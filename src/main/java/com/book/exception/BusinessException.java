package com.book.exception;

/**
 * 自定义业务异常：图书不存在、库存不足等场景抛出
 */
public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}