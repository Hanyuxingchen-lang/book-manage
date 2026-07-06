package com.book.dto;

import lombok.Data;

/**
 * 分页查询通用参数
 */
@Data
public class PageDTO {
    private Integer pageNum = 1;  // 当前页
    private Integer pageSize = 5; // 每页条数
    private String keyword;       // 图书名称模糊查询关键字
}