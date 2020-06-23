package com.melcoc.bluewhale.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.melcoc.bluewhale.dao.ArticleDao;
import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;


    @Override
    public List<Article> selectArticleAll() {
      QueryWrapper wrapper = new QueryWrapper<Article>();
        wrapper.eq("deleted",0);
        wrapper.orderByDesc("a_id");
        return articleDao.selectList(wrapper);
    }

    @Override
    public int insertArticle(Article article) {
        return articleDao.insertArticle(article);
    }



    @Override
    public int deletedArticle(Integer aId,Integer userId) {

        return articleDao.deletedArticle(aId,userId);
    }



    @Override
    public Article findByIdForUpdate(int aid) {

        return articleDao.findByIdForUpdate(aid);
    }

    @Override
    public int saveAndFlush(Article article) {
        return articleDao.saveAndFlush(article);
    }

    @Override
    public List<Article> selectUserAll(Integer userId) {
        return articleDao.selectUserAll(userId);
    }

    @Override
    public List<Article> articleUserList() {
        return articleDao.articleUserList();
    }

    @Override
    public List<Article> articleUser() {
        return articleDao.articleUser();
    }


}
