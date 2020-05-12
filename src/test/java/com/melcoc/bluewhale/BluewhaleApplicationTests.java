package com.melcoc.bluewhale;

import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.service.ArticleService;
import com.qiniu.util.Auth;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest
class BluewhaleApplicationTests {
    @Autowired
    ArticleService articleService;

    @Test
    void testInsert() {
        Article article=new Article();

//        article.setUser_id(1001);
//        article.setCreate_time(LocalDateTime.now());
//        article.setContent("你们在干嘛？");
//        article.setDeleted(1);
//        int i=  articleService.insertArticle(article);
//        System.out.println(i);
    }
    @Test
    void testAll() {
       List<Article> list= articleService.selectArticleAll();
       list.stream().forEach(article -> System.out.println(article));

    }

    @Test
    void testQiniu() {




    }
}
