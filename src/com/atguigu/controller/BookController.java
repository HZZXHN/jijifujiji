package com.atguigu.controller;

import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    // 查全部 , 不用传入id,所以去掉依然识别
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String queryBookAll(Map<String, Object> map) {
        List<Book> list = bookService.queryBookAll();
        map.put("books",list);
        return "bookList";
    }

    //通过id在网页上呈现一本书
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String findBookById(@PathVariable("id") Integer id,Map<String,Object>map){
        Book book = bookService.queryBookById(id);
        map.put("book",book);
        return "bookEdit";
    }

    //更新
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public String updateBookById(Book book){
        bookService.updateBookById(book);
        return "redirect:/book";
    }

    //删除
    @RequestMapping(value = "/deleteBookById/{id}",method = RequestMethod.DELETE)
    public String deleteBookById(@PathVariable("id") Integer id) {
        bookService.deleteBookById(id);
        return "redirect:/book";
    }

    // 插入一个Book
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String insertBook(Book book){
        bookService.insertBook(book);
        //走 get 方式
        // 乱码, SpringMVC 为 get方式作出乱码,post没处理
        return "redirect:/book";
    }





}
