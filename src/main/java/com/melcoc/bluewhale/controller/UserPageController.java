package com.melcoc.bluewhale.controller;

import com.melcoc.bluewhale.domain.ResponseBean;
import com.melcoc.bluewhale.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class UserPageController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/u/{id}")
    public ResponseBean userPage(@PathVariable String id, HttpServletRequest request){
        System.out.println(id);
        String token=request.getHeader("Authorization");
        System.out.println("token:"+token);
        return new ResponseBean(200,"success",null);
        /*if (token.equals("")){
            JWTUtil.getUsername(token);
            User user= userService.selectUserByName(JWTUtil.getUsername(token));
            return new ResponseBean(200,JWTUtil.getUsername(token),user);
        }else {
        }
        */
    }

    @PostMapping("/api/ChangePassword")
    public ResponseBean changePW(@PathVariable String id, HttpServletRequest request){
        return null;
    }

}
