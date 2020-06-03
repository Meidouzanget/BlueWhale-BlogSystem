package com.melcoc.bluewhale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class BluewhaleApplication {
    public static void main(String[] args) {
        SpringApplication.run(BluewhaleApplication.class, args);
    }
}
