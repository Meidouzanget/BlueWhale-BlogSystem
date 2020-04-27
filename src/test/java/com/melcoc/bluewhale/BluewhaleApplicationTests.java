package com.melcoc.bluewhale;

import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.service.ArticleService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;


@Ignore
@SpringBootTest
class BluewhaleApplicationTests {
    @Autowired
    ArticleService articleService;

    @Test
    void Testinsert() {
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
