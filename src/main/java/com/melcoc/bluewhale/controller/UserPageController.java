package com.melcoc.bluewhale.controller;

import com.melcoc.bluewhale.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserPageController {
    @Autowired
    private UserServiceImpl userService;

}
