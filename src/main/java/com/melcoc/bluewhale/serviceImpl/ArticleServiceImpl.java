package com.melcoc.bluewhale.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.melcoc.bluewhale.dao.ArticleDao;
import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;


    @Async
    @Override
    public List<Article> selectArticleAll() {
      QueryWrapper wrapper = new QueryWrapper<Article>();
        wrapper.eq("deleted",0);
        wrapper.orderByDesc("a_id");
        return articleDao.selectList(wrapper);
    }

    @Async
    @Override
    public int insertArticle(Article article) {
        return articleDao.insertArticle(article);
    }



    @Async
    @Override
    public int deletedArticle(Integer aId,Integer userId) {

        return articleDao.deletedArticle(aId,userId);
    }



    @Async
    @Override
    public Article findByIdForUpdate(int aid) {

        return articleDao.findByIdForUpdate(aid);
    }

    @Async
    @Override
    public int saveAndFlush(Article article) {
        return articleDao.saveAndFlush(article);
    }

    @Async
    @Override
    public List<Article> selectArticleByUserName(String name) {
        return articleDao.selectArticleByUserName(name);
    }

    @Async
    @Override
    public List<Article> articleUserList() {
        return articleDao.articleUserList();
    }

    @Async
    @Override
    public List<Article> articleUser() {
        return articleDao.articleUser();
    }


}
