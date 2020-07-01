package com.melcoc.bluewhale.controller;

import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.domain.LUser;
import com.melcoc.bluewhale.domain.ResponseBean;
import com.melcoc.bluewhale.domain.User;
import com.melcoc.bluewhale.jwt.JWTUtil;
import com.melcoc.bluewhale.service.ArticleService;
import com.melcoc.bluewhale.serviceImpl.Qiniu;
import com.melcoc.bluewhale.serviceImpl.QiniuServiceImpl;
import com.melcoc.bluewhale.serviceImpl.UserServiceImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.ExecutionException;


@RestController
public class UserPageController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private Qiniu qiniu;

    @Autowired
    private QiniuServiceImpl qiniuService;

    @PostMapping("/api/ArticleOfUser")
    public ResponseBean userPage(@RequestParam String username, HttpServletRequest request) throws ExecutionException, InterruptedException {
        System.out.println(username);
        String token=request.getHeader("Authorization");
        System.out.println("token:"+token);
        List<Article> list = articleService.selectArticleByUserName(username).get();
        if (list== null){
            return new ResponseBean(200,"success",list);
        }else
            return new ResponseBean(400,"failure",null);

    }
    @RequiresAuthentication
    @PostMapping("/api/updateByIduUrl")
    public ResponseBean updateByIduUrl(@RequestParam String base64Data,HttpServletRequest request) {
        String avatar = null;
        try {
            avatar = qiniu.getPublicUrl(qiniuService.put64image(base64Data));
            System.out.printf(avatar);
            String token = request.getHeader("Authorization");
            System.out.println(JWTUtil.getUsername(token));
            userService.updateByIduUrl(JWTUtil.getUsername(token), avatar).get();

        } catch (Exception e) {
            System.out.println(e);
        }


        return new ResponseBean(200, "头像上传成功", avatar);
    }

    @RequiresAuthentication
    @PostMapping("/api/ChangePassword")
    public ResponseBean changePW(@RequestParam String nPassword, @RequestParam String oPassword, HttpServletRequest request) throws ExecutionException, InterruptedException {
        String token=request.getHeader("Authorization");
        System.out.println("token:"+token);
        LUser lUserBean = userService.selectlUserByName(JWTUtil.getUsername(token)).get();
        if (lUserBean.getPassword().equals(DigestUtils.sha256Hex(oPassword))) {
            lUserBean.setPassword(DigestUtils.sha256Hex(nPassword));
            userService.changePassword(lUserBean).get();
            return new ResponseBean(200,"成功修改密码",JWTUtil.sign(lUserBean.getName(), DigestUtils.sha256Hex(nPassword)));
        }else {
            return new ResponseBean(401,"旧密码不匹配",null);
        }
    }

    @RequiresAuthentication
    @PostMapping("/api/ChangeUserInfo")
    public ResponseBean changeUI(@RequestBody User userBean,HttpServletRequest request) throws ExecutionException, InterruptedException {
        String token=request.getHeader("Authorization");
        boolean flag=false;

        if (userBean.getName().equals(JWTUtil.getUsername(token))){
            System.out.println(userBean);
            flag = userService.updateById(userBean).get();
        }
        if (flag) {
            return new ResponseBean(200,"修改成功",null);
        } else {
            return new ResponseBean(401,"用户名错误 修改失败",null);
        }

    }
    @RequiresAuthentication
    @PostMapping("/api/QueryUserInfo")
    public ResponseBean selectUI(HttpServletRequest request) throws ExecutionException, InterruptedException {
        String token=request.getHeader("Authorization");
        User user = null;
        user = userService.selectUserByName(JWTUtil.getUsername(token)).get();
        if (user!=null){
            return new ResponseBean(200,"查询成功",user);
        }else {
            return new ResponseBean(404,"查询失败",null);
        }

    }

}
