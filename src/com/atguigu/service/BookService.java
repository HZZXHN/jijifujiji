package com.atguigu.service;

import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    public List<Book> queryBookAll() {
        return bookDao.queryBookAll();
    }

    public int deleteBookById(Integer id) {
        return bookDao.deleteBookById(id);
    }

    public int insertBook(Book book) {
        return bookDao.insertBook(book);
    }

    public int updateBookById(Book book) {
        return bookDao.updateBookById(book);
    }

}
