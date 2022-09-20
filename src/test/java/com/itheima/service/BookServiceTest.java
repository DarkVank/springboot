package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;
    @Test
    void saveTest(){
        Book book = new Book();
        book.setType("计算机测试");
        book.setName("spring11");
        book.setDescription("show show");

        System.out.println(bookService.save(book));
    }
    @Test
    void updateTest(){
        Book book = new Book();
        book.setId(7);
        book.setType("计算机测试");
        book.setName("spring22");
        book.setDescription("show show");

        System.out.println(bookService.update(book));
    }

    @Test
    void deleteTest(){

        System.out.println(bookService.delete(7));
    }

    @Test
    void getAllTest(){
        System.out.println(bookService.getAll());
    }

    @Test
    void pageTest(){
        IPage<Book> page = bookService.getPage(0, 5);
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
    }
}

