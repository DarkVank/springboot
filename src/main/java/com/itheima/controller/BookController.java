package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.utils.R;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {

        if(book.getName().equals("111")) throw new IOException() ;
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

//    @GetMapping("/{currentPage}/{pageSize}")
//    public R getPage(@PathVariable Integer currentPage , @PathVariable Integer pageSize ){
//        IPage<Book> page = bookService.getPage(currentPage, pageSize);
////        如果当前页码值大于最大页码值，则使用最大页码值作为当前页
//        if(currentPage > page.getPages()){
//           page = bookService.getPage((int) page.getPages(),pageSize);
//        }
//
//        return new R(null != page,page);
//    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage , @PathVariable Integer pageSize ,Book book){
        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        System.out.println(book);
//        如果当前页码值大于最大页码值，则使用最大页码值作为当前页
        if(currentPage > page.getPages()){
            page = bookService.getPage((int) page.getPages(),pageSize,book);
        }

        return new R(null != page,page);
    }

}
