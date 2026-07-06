package com.book.mapper;

import com.book.dto.PageDTO;
import com.book.entity.Book;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface BookMapper {
    // 分页模糊查询图书
    List<Book> selectBookByPage(@Param("dto") PageDTO dto);
    // 查询总条数
    Long countBook(@Param("keyword") String keyword);
    // 根据id查询
    Book selectById(Long id);
    // 新增图书
    int insert(Book book);
    // 修改图书
    int update(Book book);
    // 删除图书
    int deleteById(Long id);
    // 修改库存
    int updateStock(@Param("id") Long id, @Param("num") Integer num);
}