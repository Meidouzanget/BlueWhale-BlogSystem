package com.melcoc.bluewhale;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.melcoc.bluewhale.dao")
public class BluewhaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BluewhaleApplication.class, args);
    }

}
