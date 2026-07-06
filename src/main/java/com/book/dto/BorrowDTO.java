package com.book.dto;

import lombok.Data;

/**
 * 借阅图书接收参数
 */
@Data
public class BorrowDTO {
    private Long bookId;
    private String readerName;
}