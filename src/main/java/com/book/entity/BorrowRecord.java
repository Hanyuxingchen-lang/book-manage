package com.book.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 图书借阅记录实体
 */
@Data
public class BorrowRecord {
    private Long id;
    private Long bookId;        // 图书id
    private String readerName;  // 借阅人姓名
    private LocalDateTime borrowTime; // 借阅时间
    private LocalDateTime returnTime; // 归还时间
}