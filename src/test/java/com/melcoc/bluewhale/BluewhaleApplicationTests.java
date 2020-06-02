package com.melcoc.bluewhale;

import com.melcoc.bluewhale.dao.UserDao;
import com.melcoc.bluewhale.domain.LUser;
import com.melcoc.bluewhale.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BluewhaleApplicationTests {
    @Autowired
    ArticleService articleService;
    UserDao userDao;



    @Test
    void testQiniu() {




    }

    @Test
    void login(){
        LUser lUser = userDao.getUserWithPermission("clarence");
        System.out.println(lUser);
    }
}
