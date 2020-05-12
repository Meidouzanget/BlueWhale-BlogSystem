package com.melcoc.bluewhale.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.domain.Img;
import com.melcoc.bluewhale.serviceImpl.ArticleServiceImpl;
import com.melcoc.bluewhale.serviceImpl.ImgServiceImpl;
import com.melcoc.bluewhale.serviceImpl.Qiniu;
import com.melcoc.bluewhale.serviceImpl.QiniuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleServiceImpl articleService;

    @Autowired
    ImgServiceImpl imgService;


    @Autowired
    QiniuServiceImpl qiniuService;

    @Autowired
    Qiniu qiniu;




    /**
     * 发布微博
     * @@return
     */
    @RequestMapping("/addArticle")
    public String addArticle(Article article,Img img) throws IOException {

//        article.setAId(article.getAId());//信息编号
        article.setUserId(1);//获取用户编号
        article.setCreateTime(LocalDateTime.now());//获取当前发布时间
        article.setContent(article.getContent());//获取内容
        article.setDeleted(1);//逻辑删除 0不显示，1显示
        articleService.insertArticle(article);//发布微博

        System.out.println("url:"+img.getUrl());


        if (img.getUrl()!=""){//判断用户是否发布图文微博
           System.out.println("图片加文字");
//            img.setUrl(qiniuService.getUrl(img.getUrl(),UUID.randomUUID()));//把图片地址返回到数据库
           img.setImgId(img.getImgId());//图片ID
            img.setAId(article.getAId());//图片对应哪一个信息的编号
            img.setUId(1);//获取用户ID
            img.setCreateTime(LocalDateTime.now());//图片当前发布时间
            System.out.println(img);
            imgService.insertImg(img);//获取图片地址

        }
        System.out.println(article);

        return "03-Newsfeed";
    }

    /**
     * 查询所有微博
     */
    @RequestMapping("/allArticle")
    public @ResponseBody List<Article> allArticle(){
        List list=new ArrayList();
        List<Article> listArticle=articleService.selectArticleAll();
        List<Img> listImg=imgService.selectImgAll();


        list.add(listArticle);
        list.add(listImg);
        System.out.println(list);
        return list;
    }
}
