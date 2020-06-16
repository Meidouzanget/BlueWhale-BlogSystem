package com.melcoc.bluewhale.controller;

import com.melcoc.bluewhale.domain.LUser;
import com.melcoc.bluewhale.domain.ResponseBean;
import com.melcoc.bluewhale.jwt.JWTUtil;
import com.melcoc.bluewhale.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService service;

    @PostMapping("/api/Login")
    public ResponseBean login(@RequestParam("username")String username,@RequestParam("password")String password) {
        System.out.println(username+password);
        String passwordHex = DigestUtils.sha256Hex(password);
        LUser userBean = null;
        if (service.getUserWithPermission(username) == null){
            return new ResponseBean(401, "登录失败", null);
        }else {
            userBean = service.getUserWithPermission(username);
        }

        if (userBean.getPassword().equals(passwordHex)) {
            return new ResponseBean(200, "登录成功", JWTUtil.sign(username, passwordHex));
        } else {
            throw new UnauthorizedException();
        }
    }
}
