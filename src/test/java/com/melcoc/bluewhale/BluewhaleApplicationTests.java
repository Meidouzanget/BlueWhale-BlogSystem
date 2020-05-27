package com.melcoc.bluewhale;

import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.service.ArticleService;
import com.melcoc.bluewhale.serviceImpl.GreatServiceImpl;
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
    void testQiniu() {




    }
}
