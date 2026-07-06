package com.book.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 图书实体类
 */
@Data
public class Book {
    private Long id;
    private String bookName;    // 图书名称
    private String author;      // 作者
    private String isbn;        // 图书编号
    private Integer stock;      // 库存数量
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}