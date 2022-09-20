package com.itheima.controller;

import com.itheima.controller.utils.R;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public R save(@RequestBody Book book){
        return new R(true,bookService.save(book));
    }
    @GetMapping
    public R getAll(){
        return new R(true,bookService.getAll());
    }

    @PutMapping
    public R update(@RequestBody Book book){

        return new R(bookService.update(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(bookService.delete(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,bookService.getById(id));
    }

}
