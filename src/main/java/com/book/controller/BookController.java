package com.book.controller;

import com.book.dto.PageDTO;
import com.book.entity.Book;
import com.book.service.BookService;
import com.book.util.ResultUtil;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import java.util.Map;

/**
 * 图书管理接口
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Resource
    private BookService bookService;

    /**
     * 分页模糊查询图书
     */
    @GetMapping("/page")
    public ResultUtil<Map<String, Object>> page(PageDTO dto) {
        Map<String, Object> pageData = bookService.getBookPage(dto);
        return ResultUtil.success(pageData);
    }

    /**
     * 根据id查询单本图书
     */
    @GetMapping("/{id}")
    public ResultUtil<Book> getById(@PathVariable Long id) {
        Book book = bookService.getById(id);
        return ResultUtil.success(book);
    }

    /**
     * 新增图书
     */
    @PostMapping("/add")
    public ResultUtil<?> add(@RequestBody Book book) {
        bookService.addBook(book);
        return ResultUtil.success();
    }

    /**
     * 修改图书
     */
    @PutMapping("/edit")
    public ResultUtil<?> edit(@RequestBody Book book) {
        bookService.editBook(book);
        return ResultUtil.success();
    }

    /**
     * 删除图书
     */
    @DeleteMapping("/{id}")
    public ResultUtil<?> delete(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResultUtil.success();
    }
}