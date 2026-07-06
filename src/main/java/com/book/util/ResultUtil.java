package com.book.util;

import lombok.Data;

/**
 * 全局统一接口返回封装工具
 */
@Data
public class ResultUtil<T> {
    private Integer code; // 响应码 200成功 500失败
    private String msg;
    private T data;

    // 成功无数据
    public static <T> ResultUtil<T> success() {
        ResultUtil<T> r = new ResultUtil<>();
        r.setCode(200);
        r.setMsg("操作成功");
        return r;
    }
    // 成功带数据
    public static <T> ResultUtil<T> success(T data) {
        ResultUtil<T> r = new ResultUtil<>();
        r.setCode(200);
        r.setMsg("操作成功");
        r.setData(data);
        return r;
    }
    // 失败
    public static <T> ResultUtil<T> fail(String msg) {
        ResultUtil<T> r = new ResultUtil<>();
        r.setCode(500);
        r.setMsg(msg);
        return r;
    }
}