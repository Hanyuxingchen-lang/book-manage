package com.book.service;

import com.book.dto.BorrowDTO;
import com.book.entity.BorrowRecord;
import java.util.List;

public interface BorrowService {
    // 借阅图书
    void borrowBook(BorrowDTO dto);
    // 归还图书
    void returnBook(Long bookId);
    // 查询全部借阅记录
    List<BorrowRecord> getAllRecord();
}