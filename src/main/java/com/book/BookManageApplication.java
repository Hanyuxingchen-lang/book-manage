package com.book;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 图书借阅管理系统启动类
 * @author 你的名字
 */
@SpringBootApplication
@MapperScan("com.book.mapper") // 扫描mapper接口
public class BookManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookManageApplication.class, args);
    }
}