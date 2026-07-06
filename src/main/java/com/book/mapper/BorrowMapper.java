package com.book.mapper;

import com.book.entity.BorrowRecord;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface BorrowMapper {
    // 新增借阅记录
    int insert(BorrowRecord record);
    // 根据图书id查未归还记录
    BorrowRecord selectUnReturnByBookId(Long bookId);
    // 归还图书，更新归还时间
    int updateReturnTime(@Param("id") Long recordId);
    // 查询全部借阅记录
    List<BorrowRecord> selectAll();
}