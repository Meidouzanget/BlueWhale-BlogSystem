package com.melcoc.bluewhale.controller;

import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.domain.Great;
import com.melcoc.bluewhale.serviceImpl.ArticleServiceImpl;
import com.melcoc.bluewhale.serviceImpl.GreatServiceImpl;
import com.melcoc.bluewhale.serviceImpl.Qiniu;
import com.melcoc.bluewhale.serviceImpl.QiniuServiceImpl;
import com.qiniu.util.UrlSafeBase64;
import io.lettuce.core.dynamic.annotation.Param;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Api("微博Controller")
@RestController
public class ArticleController {

    @Autowired
    ArticleServiceImpl articleService;

    @Autowired
    GreatServiceImpl greatService;

    @Autowired
    QiniuServiceImpl qiniuService;

    @Autowired
    Qiniu qiniu;




    /**
     * 发布微博
     *
     * @return
     */
    @ApiOperation("发布微博")
    @PostMapping("/api/addArticle")
    public Article addArticle(Integer userId,String content, String base64Date) {

        Article article=new Article();
        article.setUserId(userId);
        article.setCreateTime(LocalDateTime.now());
        article.setContent(content);

        try {
            System.out.println("base64Date:"+base64Date);
            if (!base64Date.equals("")) {//判断用户是否发布图文微博
                System.out.println("图片加文字");
                article.setUrl(qiniu.getPublicUrl( qiniuService.put64image(base64Date)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("上传图片失败"+e);
        }


        articleService.insertArticle(article);//发布微博
        List<Article> list = articleService.selectArticleAll();
        System.out.println(list);

        return article;
    }



    /**
     * 点赞
     */
    @ApiOperation("点赞")
    @PostMapping("/api/great")
    public String great(@Param("aId") int aId, @Param("uId") int uId) {
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
        return "点赞成功";
    }

    /**
     * 逻辑删除
     */
    @ApiOperation("逻辑删除")
    @PostMapping("/api/deldeArticle")
    public int deldeArticle(@Param("aId") int aId ,Integer userId) {
       int i= articleService.deletedArticle(aId,userId);
        return i;
    }

    /**
     * base64图片上传测试
     */
    @ApiOperation("base64图片上传测试")
    @PostMapping("/upload")
    public String base64Upload(@RequestParam String base64Date, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = UUID.randomUUID().toString();
        String str = base64Date.split("base64,")[1];//去掉“data:image/jpeg”
        //解码。将base64的字符串转化二进制流
        byte[] imageByte = Base64.decodeBase64(str);
        StringBuilder buf = new StringBuilder();
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



    /**
     * 单用户文章的全查询
     * @return
     */
    @ApiOperation("单用户文章的全查询")
    @PostMapping("/api/selectUserAll")
    public List<Article> selectUserAll(Integer userId){
        List<Article> list = articleService.selectUserAll(userId);
        System.out.println(list);
        return list;
    }

    /**
     * 用户表 文章表
     */
    @ApiOperation("用户表 文章表查询")
    @PostMapping("/api/articleUserList")
    public List<Article> articleUserList(){
        List<Article> list=articleService.articleUserList();
        System.out.println(list);
        return list;
    }

    /**
     *最新一条文章
     */
    @ApiOperation("最新一条文章")
    @PostMapping("/api/articleUser")
    public List<Article> articleUser(){
        List<Article> list=articleService.articleUser();
        System.out.println(list);
        return list;
    }
}



