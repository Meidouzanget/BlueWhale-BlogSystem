package com.melcoc.bluewhale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/test")
    public ModelAndView logina(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        return modelAndView;
    }

}
