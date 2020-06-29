package com.melcoc.bluewhale.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.melcoc.bluewhale.dao.ArticleDao;
import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

@Service
@Async("taskExecutor")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;



    @Override
    public Future<List> selectArticleAll() {
      QueryWrapper wrapper = new QueryWrapper<Article>();
        wrapper.eq("deleted",0);
        wrapper.orderByDesc("a_id");
        List<Article> list = articleDao.selectList(wrapper);
        return new AsyncResult<>(list);
    }


    @Override
    public Future<Integer> insertArticle(Article article) {
        return new AsyncResult<>(articleDao.insertArticle(article));
    }




    @Override
    public Future<Integer> deletedArticle(Integer aId, Integer userId) {
        return new AsyncResult<>(articleDao.deletedArticle(aId,userId));
    }




    @Override
    public Future<Article> findByIdForUpdate(int aid) {
        Article article =articleDao.findByIdForUpdate(aid);
        return new AsyncResult<>(article);
    }


    @Override
    public Future<Integer> saveAndFlush(Article article) {

        return new AsyncResult<>(articleDao.saveAndFlush(article));
    }


    @Override
    public Future<List> selectArticleByUserName(String name) {
        List<Article> list =articleDao.selectArticleByUserName(name);
        return new AsyncResult<>(list);
    }


    @Override
    public Future<List> articleUserList() {
        List<Article> list = articleDao.articleUserList();
        return new AsyncResult<>(list);
    }


    @Override
    public Future<List> articleUser() {
        List<Article> list =articleDao.articleUser();
        return new AsyncResult<>(list);
    }


}
