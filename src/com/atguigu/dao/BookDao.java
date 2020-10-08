package com.atguigu.dao;

import com.atguigu.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据id查一个
     * 查全部
     * 删除一个
     * 添加一个
     * 更新一个
     */

    public Book queryBookById(Integer id) {
        return jdbcTemplate.queryForObject("select id,name,author,price,sales,stock from t_book where id = ?", new BeanPropertyRowMapper<Book>(Book.class), id);
    }

    public List<Book> queryBookAll() {
        return jdbcTemplate.query("select id,name,author,price,sales,stock from t_book", new BeanPropertyRowMapper<Book>(Book.class));
    }

    public int deleteBookById(Integer id) {
        return jdbcTemplate.update("delete from t_book where id = ?", id);
    }

    public int insertBook(Book book) {
        return jdbcTemplate.update("INSERT INTO t_book (name,author,price,sales,stock) VALUES(?,?,?,?,?)",
                book.getName(),
                book.getAuthor(),
                book.getPrice(),
                book.getSales(),
                book.getStock());
    }

    public int updateBookById(Book book) {
        return jdbcTemplate.update("update t_book SET name = ?,price = ?,author=?,sales=?,stock=? where id = ?",
                book.getName(),
                book.getPrice(),
                book.getAuthor(),
                book.getSales(),
                book.getStock(),
                book.getId());
    }


}
