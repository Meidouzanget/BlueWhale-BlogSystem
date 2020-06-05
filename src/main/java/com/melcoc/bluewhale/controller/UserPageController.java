package com.melcoc.bluewhale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserPageController {

    @GetMapping("Landing")
    public  String landing(){
        return "LandingPage";
    }
}
