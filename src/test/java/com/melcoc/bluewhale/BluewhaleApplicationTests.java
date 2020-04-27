package com.melcoc.bluewhale;

import com.melcoc.bluewhale.domain.Article;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;

@SpringBootTest
class BluewhaleApplicationTests {

    @Test
    void Testinsert() {
        Article article=new Article();
        article.setA_id(1);
        article.setUser_id(1001);
        article.setCreate_time(LocalDateTime.now());
    }

}
