package com.melcoc.bluewhale;

import com.melcoc.bluewhale.domain.LUserrole;
import com.melcoc.bluewhale.service.ArticleService;
import com.melcoc.bluewhale.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BluewhaleApplicationTests {
    @Autowired
    ArticleService articleService;
    @Autowired
    UserService userService;



    @Test
    void testQiniu() {




    }

    @Test
    void login(){
        //LUser lUser = userDao.getUserWithPermission("clarence");
        System.out.println();
    }
    @Test
    void register(){
        LUserrole lUserrole = new LUserrole();

        lUserrole.setRid(1);
        lUserrole.setUrid(1);

        userService.insertUserrole(lUserrole);
        System.out.println(lUserrole);

    }
}
