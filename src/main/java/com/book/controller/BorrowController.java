package com.book.controller;

import com.book.dto.BorrowDTO;
import com.book.entity.BorrowRecord;
import com.book.service.BorrowService;
import com.book.util.ResultUtil;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import java.util.List;

/**
 * 图书借阅接口
 */
@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @Resource
    private BorrowService borrowService;

    /**
     * 借阅图书
     */
    @PostMapping("/add")
    public ResultUtil<?> borrow(@RequestBody BorrowDTO dto) {
        borrowService.borrowBook(dto);
        return ResultUtil.success();
    }

    /**
     * 归还图书
     */
    @PutMapping("/return/{bookId}")
    public ResultUtil<?> returnBook(@PathVariable Long bookId) {
        borrowService.returnBook(bookId);
        return ResultUtil.success();
    }

    /**
     * 查询全部借阅记录
     */
    @GetMapping("/record")
    public ResultUtil<List<BorrowRecord>> recordList() {
        List<BorrowRecord> list = borrowService.getAllRecord();
        return ResultUtil.success(list);
    }
}