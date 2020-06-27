package com.melcoc.bluewhale.controller;

import com.melcoc.bluewhale.domain.LUser;
import com.melcoc.bluewhale.domain.LUserrole;
import com.melcoc.bluewhale.domain.ResponseBean;
import com.melcoc.bluewhale.domain.User;
import com.melcoc.bluewhale.jwt.JWTUtil;
import com.melcoc.bluewhale.serviceImpl.UserServiceImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RegController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/api/Reg")
    public ResponseBean reg(@RequestParam("nickname") String nickName,
                      @RequestParam("username") String username,
                      @RequestParam("email") String email,
                      @RequestParam("password") String password,
                      @RequestParam("birth") String birth,
                      @RequestParam("sex") Integer sex,
                            HttpServletRequest request
                      ){
        System.out.println(nickName+":"+username+":"+email+":"+password+birth+sex);
        LUser lUserBean = new LUser();
        User userBean = new User();
        String xRealIP = request.getHeader("X-Real-IP");
        String remote = request.getRemoteAddr();
        System.out.println("X-Real-IP:"+xRealIP+"RemoteAddr："+remote);


        if (userService.getUserNameNoRepeat(username)){//检测用户名重复
            if (userService.getUserEmailNoRepeat(email)){//检测邮件地址是否重复
                //写入
                userBean.setNickName(nickName);
                userBean.setName(username);
                userBean.setEmail(email);
                userBean.setBirth(birth);
                userBean.setSex(sex);

                lUserBean.setAccount(email);
                lUserBean.setName(username);
                lUserBean.setPassword(DigestUtils.sha256Hex(password));

                if (userService.register(userBean,lUserBean)){

                    LUser lUserBean2= userService.selectlUserByName(username);
                    User userBean2 =userService.selectUserByName(username);
                    System.out.println(lUserBean2.getUid()+" "+userBean.getUserId());

                    if (lUserBean2.getUid()==userBean2.getUserId()) {

                        userService.insertUserrole(new LUserrole(userBean2.getUserId(),1));
                        return new ResponseBean(200, "注册成功", JWTUtil.sign(userBean.getName(), DigestUtils.sha256Hex(password)));
                    }else {
                        return new ResponseBean(500,"发生未知错误", null);
                    }
                }else {
                    return new ResponseBean(500,"发生未知错误", null);
                }
            }else {
                return new ResponseBean(403,"邮箱地址重复", null);
            }
        }else {
            return new ResponseBean(403,"用户名重复", null);
        }

    }
}
