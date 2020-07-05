package com.melcoc.bluewhale.controller;

import com.melcoc.bluewhale.domain.LUser;
import com.melcoc.bluewhale.domain.ResponseBean;
import com.melcoc.bluewhale.domain.User;
import com.melcoc.bluewhale.jwt.JWTUtil;
import com.melcoc.bluewhale.service.UserService;
import io.swagger.annotations.Api;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ExecutionException;

@Api("登录验证Controller")
@RestController
public class LoginController {

    @Autowired
    private UserService service;
    /**
    *   登录流程
    */
    @PostMapping("/api/Login")
    public ResponseBean login(@RequestParam("username")String username,@RequestParam("password")String password) throws ExecutionException, InterruptedException {
        System.out.println(username+":"+password);
        String passwordHex = DigestUtils.sha256Hex(password);
        LUser lUserBean;
        User UserBean;
        if (service.getUserWithPermission(username).get() == null){
            return new ResponseBean(401, "用户不存在", null);
        }else {
            lUserBean = service.getUserWithPermission(username).get();
        }

        if (lUserBean.getPassword().equals(passwordHex)) {
            if (service.selectUserByName(username).get().getStatus()== 0) {
                return new ResponseBean(200, "登录成功", JWTUtil.sign(lUserBean.getName(), passwordHex));
            }else {
                return new ResponseBean(401, "用户被封禁", null);
            }
        } else {
            return new ResponseBean(401,"用户密码错误",null);
        }
    }

    @RequiresAuthentication
    @PostMapping("/api/pTest")
    public ResponseBean pTest(HttpServletRequest request) throws ExecutionException, InterruptedException {
        String token=request.getHeader("Authorization");
        System.out.println("token:"+token);
        JWTUtil.getUsername(token);
        User user= service.selectUserByName(JWTUtil.getUsername(token)).get();
        return new ResponseBean(200,JWTUtil.getUsername(token),user);
    }

}
