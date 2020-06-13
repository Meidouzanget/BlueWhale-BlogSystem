package com.melcoc.bluewhale.controller;

import com.melcoc.bluewhale.domain.LUser;
import com.melcoc.bluewhale.domain.ResponseBean;
import com.melcoc.bluewhale.jwt.JWTUtil;
import com.melcoc.bluewhale.serviceImpl.UserService;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public ResponseBean login(@RequestParam("username") String username,
                              @RequestParam("password") String password) {
        LUser userBean = service.getUserWithPermission(username);
        if (userBean.getPassword().equals(password)) {
            return new ResponseBean(200, "Login successfully", JWTUtil.sign(username, password));
        } else {
            throw new UnauthorizedException();
        }
    }
}
