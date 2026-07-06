package com.book.service;

import com.book.dto.PageDTO;
import com.book.entity.Book;
import java.util.Map;

public interface BookService {
    // 分页查询图书
    Map<String, Object> getBookPage(PageDTO dto);
    // 根据id获取图书
    Book getById(Long id);
    // 新增图书
    void addBook(Book book);
    // 修改图书
    void editBook(Book book);
    // 删除图书
    void deleteBook(Long id);
}