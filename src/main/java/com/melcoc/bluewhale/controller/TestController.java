package com.melcoc.bluewhale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/hello")
    public String hello(){
        return "login";
    }
    @RequestMapping("/reg")
    public String reg(){
        return "reg";
    }
}
