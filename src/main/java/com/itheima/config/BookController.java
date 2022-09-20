package com.itheima.config;

import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Boolean save(@RequestBody Book book){
        return bookService.save(book);
    }
    @GetMapping
    public List<Book> getAll(){
        return bookService.getAll();
    }

    @PutMapping
    public Boolean update(@RequestBody Book book){
        return bookService.update(book);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id){
        return bookService.delete(id);
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id){
        return bookService.getById(id);
    }

}
