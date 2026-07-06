package com.book.service.impl;

import com.book.dto.BorrowDTO;
import com.book.entity.Book;
import com.book.entity.BorrowRecord;
import com.book.exception.BusinessException;
import com.book.mapper.BookMapper;
import com.book.mapper.BorrowMapper;
import com.book.service.BorrowService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.annotation.Resource;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Resource
    private BookMapper bookMapper;
    @Resource
    private BorrowMapper borrowMapper;

    /**
     * 借阅图书：加事务，库存减少+新增记录必须同时成功
     */
    @Override
    @Transactional
    public void borrowBook(BorrowDTO dto) {
        Long bookId = dto.getBookId();
        // 1. 判断图书是否存在
        Book book = bookMapper.selectById(bookId);
        if(book == null){
            throw new BusinessException("图书不存在");
        }
        // 2. 判断库存
        if(book.getStock() <= 0){
            throw new BusinessException("图书库存不足，无法借阅");
        }
        // 3. 判断是否未归还
        BorrowRecord unReturn = borrowMapper.selectUnReturnByBookId(bookId);
        if(unReturn != null){
            throw new BusinessException("该图书还有未归还记录，不可重复借阅");
        }
        // 4. 新增借阅记录
        BorrowRecord record = new BorrowRecord();
        record.setBookId(bookId);
        record.setReaderName(dto.getReaderName());
        borrowMapper.insert(record);
        // 5. 库存-1
        bookMapper.updateStock(bookId, -1);
    }

    /**
     * 归还图书：事务，库存+1，更新归还时间
     */
    @Override
    @Transactional
    public void returnBook(Long bookId) {
        BorrowRecord record = borrowMapper.selectUnReturnByBookId(bookId);
        if(record == null){
            throw new BusinessException("无未归还借阅记录");
        }
        // 更新归还时间
        borrowMapper.updateReturnTime(record.getId());
        // 库存+1
        bookMapper.updateStock(bookId, 1);
    }

    @Override
    public List<BorrowRecord> getAllRecord() {
        return borrowMapper.selectAll();
    }
}