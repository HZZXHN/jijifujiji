package com.atguigu.test;


import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

@ContextConfiguration(locations = {"classpath:springMVC.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void test(){
       /* List<Book> list = bookDao.queryBookAll();
        list.forEach(book -> {
            System.err.println(book);
        });*/
        /*Book book = bookDao.queryBookById(1);
        System.err.println(book);*/
        //(Integer id, String name, String author, BigDecimal price, Integer sales, Integer stock)
        //bookDao.updateBookById(new Book(1,"射雕英雄传","hehe",new BigDecimal("100.00"),100,10));
        //bookDao.deleteBookById(1);
        bookDao.insertBook(new Book(null,"非常好的书","呵呵",new BigDecimal("10.00"),100,1));
    }
}
