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
    public ResponseBean userPage(@RequestParam String username, HttpServletRequest request){
        System.out.println(username);
        String token=request.getHeader("Authorization");
        System.out.println("token:"+token);
        List<Article> list = articleService.selectArticleByUserName(username);
        if (list== null){
            return new ResponseBean(200,"success",list);
        }else
            return new ResponseBean(400,"failure",null);

    }
    @PostMapping("/updateByIduUrl")
    public String updateByIduUrl(Integer userId,String base64Date)  {
        String avatar=null;
        try{
            avatar=  qiniu.getPublicUrl( qiniuService.put64image(base64Date));
            System.out.printf(avatar);
            userService.updateByIduUrl(userId,avatar);

        }catch (Exception e){
            System.out.println(e);
        }


        return avatar;
    }

    @RequiresAuthentication
    @PostMapping("/api/ChangePassword")
    public ResponseBean changePW(@RequestParam String nPassword, @RequestParam String oPassword, HttpServletRequest request){
        String token=request.getHeader("Authorization");
        System.out.println("token:"+token);
        LUser lUserBean = userService.selectlUserByName(JWTUtil.getUsername(token));
        if (lUserBean.getPassword().equals(DigestUtils.sha256Hex(oPassword))) {
            lUserBean.setPassword(DigestUtils.sha256Hex(nPassword));
            userService.changePassword(lUserBean);
            return new ResponseBean(200,"成功修改密码",JWTUtil.sign(lUserBean.getName(), DigestUtils.sha256Hex(nPassword)));
        }else {
            return new ResponseBean(401,"旧密码不匹配",null);
        }
    }

    @RequiresAuthentication
    @PostMapping("/api/ChangeUserInfo")
    public ResponseBean changeUI(@RequestBody User userBean,HttpServletRequest request){
    return null;

    }

}
