package com.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.BookMapper;
import com.itheima.domain.Book;
import lombok.Builder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTest {
    @Autowired
    private BookMapper bookMapper;

    @Test
    void pageTest(){
        IPage page = new Page(0,4);
        bookMapper.selectPage(page,null);
    }

    @Test
    void conditionTest(){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","Spring");
        bookMapper.selectList(queryWrapper);
    }

}
