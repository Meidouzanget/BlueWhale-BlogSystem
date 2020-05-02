package com.melcoc.bluewhale.controller;

import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.domain.Img;
import com.melcoc.bluewhale.serviceImpl.ArticleServiceImpl;
import com.melcoc.bluewhale.serviceImpl.ImgServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    ArticleServiceImpl articleService;

    @Autowired
    ImgServiceImpl imgService;

    @RequestMapping("/index")
    public String hello(){
        return "03-Newsfeed";
    }


    /**
     * 发布微博
     * @@return
     */
    @RequestMapping("/addArticle")
    public String addArticle(){
        Article article=new Article();
        article.setA_id(article.getA_id());//信息编号
        article.setUser_id(1);//获取用户编号
        article.setCreate_time(LocalDateTime.now());//获取当前发布时间
        article.setContent(article.getContent());//获取内容
        article.setDeleted(0);//判断是否修改

        Img img=new Img();
        img.setImg_id(img.getImg_id());//图片ID
        img.setUrl(img.getUrl());//获取图片地址
        img.setA_id(article.getA_id());//图片对应哪一个信息的编号
        img.setU_id(1);//获取用户ID
        img.setCreate_time(LocalDateTime.now());//图片当前发布时间


        System.out.println(article);
        System.out.println(img);
        articleService.insertArticle(article);//发布微博
        imgService.insertImg(img);//获取图片地址
        return "03-Newsfeed";
    }

    /**
     * 查询所有微博
     */
    @RequestMapping("/allArticle")
    public @ResponseBody List<Article> allArticle(){
        List<Article> list=articleService.selectArticleAll();
        System.out.println(list);
        return list;
    }
}
