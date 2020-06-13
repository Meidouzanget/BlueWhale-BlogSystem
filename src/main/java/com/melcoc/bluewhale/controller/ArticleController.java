package com.melcoc.bluewhale.controller;

import com.google.gson.Gson;
import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.domain.Great;
import com.melcoc.bluewhale.domain.Img;
import com.melcoc.bluewhale.serviceImpl.*;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.UrlSafeBase64;
import io.lettuce.core.dynamic.annotation.Param;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Decoder;
import com.qiniu.storage.Region;
import com.qiniu.storage.Configuration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

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
    public String index() {
        return "03-Newsfeed";
    }

    /**
     * 发布微博
     *
     * @@return
     */
    @RequestMapping("/addArticle")
    public String addArticle(Article article, String base64Date, Model model) throws Exception {
//       article.setAId(article.getAId());//信息编号
        article.setUserId(1);//获取用户编号
        article.setCreateTime(LocalDateTime.now());//获取当前发布时间
        article.setContent(article.getContent());//获取内容
        article.setDeleted(1);//逻辑删除 0不显示，1显示
        article.setGreatNum(0);
        System.out.println(base64Date);


        if (base64Date != null) {//判断用户是否发布图文微博
            System.out.println("图片加文字");
            article.setUrl(qiniu.getUrl(0, qiniuService.put64image(base64Date)));


        }
        articleService.insertArticle(article);//发布微博

        List<Article> list = articleService.selectArticleAll();
        System.out.println(list);
        model.addAttribute("articlelist", list);
        return "MainPage";
    }

    /**
     * 查询所有微博
     */
    @RequestMapping("/allArticle")
    public String allArticle(Model model) {

        List<Article> list = articleService.selectArticleAll();
        System.out.println(list);
        model.addAttribute("articlelist", list);
        return "MainPage";
    }

    /**
     * 点赞
     */
//    @Transactional
    @RequestMapping("/great")
    public String great(@Param("aId") int aId, @Param("uId") int uId, Model model) {
        //查询是否有该用户对该文章的点赞记录
        List<Great> list = greatService.findByAidAndUid(aId, uId);
        if (list != null && list.size() > 0) {
            //如果找到了这条记录，则删除该记录，同时文章的点赞数减1
            Great great = list.get(0);
            //删除记录
            greatService.delete(great.getId());
            //文章点赞数减1，查询时使用Mysql行级锁解决并发覆盖问题
            Article article = articleService.findByIdForUpdate(aId);
            article.setGreatNum(article.getGreatNum() - 1);
            articleService.saveAndFlush(article);
        } else {
            //如果没有找到这条记录，则添加这条记录，同时文章点赞数加1
            Great great = new Great();
            great.setaId(aId);
            great.setuId(uId);
            //添加记录
            greatService.saveAndFlush(great);
            //文章点赞数加1，查询时使用Mysql行级锁解决并发覆盖问题
            Article article = articleService.findByIdForUpdate(aId);
            article.setGreatNum(article.getGreatNum() + 1);
            articleService.saveAndFlush(article);

        }
        List<Article> list2 = articleService.selectArticleAll();
        model.addAttribute("articlelist", list2);
        return "MainPage";
    }

    /**
     * 逻辑删除
     */
    public String deldeArticle(@Param("aId") int aId) {
        articleService.deletedArticle(aId);
        return "删除成功";
    }

    /**
     * base64图片上传测试
     */
    @RequestMapping("/upload")
    public @ResponseBody
    String base64Upload(@RequestParam String base64Date, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = UUID.randomUUID().toString();
        BASE64Decoder decoder = null;
        decoder = new BASE64Decoder();
        String str = base64Date.split("base64,")[1];//去掉“data:image/jpeg”
        //解码。将base64的字符串转化二进制流
        byte[] imageByte = decoder.decodeBuffer(str);
        StringBuffer buf = new StringBuffer();
        byte[] uploadBytes = imageByte;
        String file64 = com.qiniu.util.Base64.encodeToString(uploadBytes, 0);
        Integer l = uploadBytes.length;
        String url = "http://upload-z2.qiniup.com/putb64/" + l + "/key/" + UrlSafeBase64.encodeToString(key);
        //非华东空间需要根据注意事项 1 修改上传域名
        RequestBody rb = RequestBody.create(null, file64);
        Request request1 = new Request.Builder().
                url(url).
                addHeader("Content-Type", "application/octet-stream")
                .addHeader("Authorization", "UpToken " + qiniuService.getUpToken())
                .post(rb).build();
        //System.out.println(request.headers());
        OkHttpClient client = new OkHttpClient();
        okhttp3.Response response1 = client.newCall(request1).execute();
        System.out.println(response1);
        // 如果不需要添加图片样式，使用以下方式
        System.out.println(key);
        return key;

    }
}


