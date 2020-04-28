package com.melcoc.bluewhale;

import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDateTime;


@SpringBootTest
class BluewhaleApplicationTests {
    @Autowired
    ArticleService articleService;

    @Test
    void testInsert() {
        Article article=new Article();
        article.setA_id(1);
        article.setUser_id(1001);
        article.setCreate_time(LocalDateTime.now());
        article.setContent("你们在干嘛？");
        article.setDeleted(1);
       int i=  articleService.insert(article);
        System.out.println(i);
    }

}
