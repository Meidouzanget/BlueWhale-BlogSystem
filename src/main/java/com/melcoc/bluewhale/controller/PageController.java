package com.melcoc.bluewhale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    /**
     * 登录页
     * @return
     */
    @GetMapping("Login")
    public  String landing(){
        return "LandingPage";
    }
    /**
     * 首页
     */
    @RequestMapping("/")
    public String index() {
        return "MainPage";
    }
    /**
     * 个人页
     */
    @RequestMapping("/profilePage")
    public String profilePage() {
        return "ProfilePage";
    }

}
