package com.melcoc.bluewhale.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegController {

    @GetMapping("/api/Reg")
    public String reg(){

        return "LandingPage";
    }

    @PostMapping("/api/Reg")
    public String reg(Model model){

        return "LandingPage";
    }
}
