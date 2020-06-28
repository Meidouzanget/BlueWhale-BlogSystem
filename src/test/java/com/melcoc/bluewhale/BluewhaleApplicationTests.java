package com.melcoc.bluewhale;

import com.melcoc.bluewhale.service.UserService;
import com.melcoc.bluewhale.serviceImpl.MailServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BluewhaleApplicationTests {

    @Autowired
    MailServiceImpl mailService;
    @Autowired
    UserService userService;

    @Test
    void mailTest(){
        //mailService.sendSimpleMailMessge("983978565@qq.com","敏感操作测试","您的验证码是"+9357);
    }
    @Test
    void userTest(){
        if (userService.selectUserByName("burst")==null){
            System.out.println("ok");
        }else {
            System.out.println("no");
        }
    }
}
