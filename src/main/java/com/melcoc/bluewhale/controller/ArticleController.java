package com.melcoc.bluewhale.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.domain.Great;
import com.melcoc.bluewhale.domain.Img;
import com.melcoc.bluewhale.serviceImpl.*;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileReader;
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
    GreatServiceImpl greatService;

    @Autowired
    QiniuServiceImpl qiniuService;

    @Autowired
    Qiniu qiniu;


    /**
     * 首页
     */
    @RequestMapping("/index")
    public String index(){
        return "03-Newsfeed";
    }

    /**
     * 发布微博
     * @@return
     */
    @RequestMapping("/addArticle")
    public String addArticle(Article article,Img img) throws IOException {
//       article.setAId(article.getAId());//信息编号
        article.setUserId(1);//获取用户编号
        article.setCreateTime(LocalDateTime.now());//获取当前发布时间
        article.setContent(article.getContent());//获取内容
        article.setDeleted(1);//逻辑删除 0不显示，1显示
        article.setGreatNum(0);
        articleService.insertArticle(article);//发布微博

        System.out.println("url:"+img.getUrl());

        if (img.getUrl()!=""){//判断用户是否发布图文微博
           System.out.println("图片加文字");
//            FileReader fileReader=new FileReader(img.getUrl());
//            System.out.println("fileReader:"+fileReader);
            //img.setUrl(qiniuService.uploadImgImputStream(,UUID.randomUUID().toString()));//把图片地址返回到数据库
           img.setImgId(img.getImgId());//图片ID
            img.setAId(article.getaId());//图片对应哪一个信息的编号
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

        List<Article> list=articleService.selectAll();

        return list;
    }
    /**
     * 点赞
     */
    @Transactional
    @RequestMapping("/great")
    public String great(@Param("aid") int aid, @Param("uid") int uid, Model model){
        //查询是否有该用户对该文章的点赞记录
        List<Great> list=greatService.findByAidAndUid(aid,uid);
        if (list!=null && list.size()>0){
            //如果找到了这条记录，则删除该记录，同时文章的点赞数减1
            Great great=list.get(0);
            //删除记录
            greatService.delete(great.getId());
            //文章点赞数减1，查询时使用Mysql行级锁解决并发覆盖问题
            Article article=articleService.findByIdForUpdate(aid);
            article.setGreatNum(article.getGreatNum()-1);
            //articleService.saveAndFlush(article);
        }else {
            //如果没有找到这条记录，则添加这条记录，同时文章点赞数加1
            Great great=new Great();
            great.setaId(aid);
            great.setuId(uid);
            //添加记录
            greatService.saveAndFlush(great);
            //文章点赞数加1，查询时使用Mysql行级锁解决并发覆盖问题
            Article article=articleService.findByIdForUpdate(aid);
            article.setGreatNum(article.getGreatNum()+1);
            //articleService.saveAndFlush(article);
        }
        model.addAttribute("details",articleService.selectAll());
        return "detail";
    }

}



