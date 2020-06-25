package com.melcoc.bluewhale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping("/u/{id}")
    public String profilePage(@PathVariable String id) {
        return "ProfilePage";
    }
    /**
     * 修改密码页
     */
    @RequestMapping("/changePassword")
    public String changePassword() {
        return "ChangePassword";
    }
    /**
     * 个人信息页
     */
    @RequestMapping("/personalInformation")
    public String personalInformation() {
        return "personalInformation";
    }



}
