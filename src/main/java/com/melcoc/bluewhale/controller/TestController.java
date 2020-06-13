package com.melcoc.bluewhale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    /**
     * 首页
     */
    @RequestMapping("/index")
    public  String index(){
        return "test";
    }
    @GetMapping("Landing")
    public  String landing(){
        return "LandingPage";
    }
}
