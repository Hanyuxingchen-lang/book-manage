package com.book.service.impl;

import com.book.dto.PageDTO;
import com.book.entity.Book;
import com.book.exception.BusinessException;
import com.book.mapper.BookMapper;
import com.book.service.BookService;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookMapper bookMapper;

    @Override
    public Map<String, Object> getBookPage(PageDTO dto) {
        // 分页偏移量计算
        dto.setPageNum((dto.getPageNum() - 1) * dto.getPageSize());
        List<Book> list = bookMapper.selectBookByPage(dto);
        Long total = bookMapper.countBook(dto.getKeyword());
        Map<String, Object> map = new HashMap<>();
        map.put("records", list);
        map.put("total", total);
        map.put("pageNum", dto.getPageNum() / dto.getPageSize() + 1);
        map.put("pageSize", dto.getPageSize());
        return map;
    }

    @Override
    public Book getById(Long id) {
        Book book = bookMapper.selectById(id);
        if(book == null){
            throw new BusinessException("图书不存在");
        }
        return book;
    }

    @Override
    public void addBook(Book book) {
        bookMapper.insert(book);
    }

    @Override
    public void editBook(Book book) {
        Book exist = bookMapper.selectById(book.getId());
        if(exist == null){
            throw new BusinessException("图书不存在，无法修改");
        }
        bookMapper.update(book);
    }

    @Override
    public void deleteBook(Long id) {
        Book exist = bookMapper.selectById(id);
        if(exist == null){
            throw new BusinessException("图书不存在");
        }
        bookMapper.deleteById(id);
    }
}