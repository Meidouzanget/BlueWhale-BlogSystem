package com.melcoc.bluewhale.serviceImpl;

import com.melcoc.bluewhale.dao.ArticleDao;
import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;


    @Override
    public List<Article> selectArticleAll() {
        return articleDao.selectList(null);
    }

    @Override
    public int insertArticle(Article article) {
        return articleDao.insert(article);
    }

    @Override
    public int updateArticle(Article article) {
        return articleDao.updateById(article);
    }

    @Override
    public int deleteArticle(Integer id) {
        return articleDao.deleteById(id);
    }
}
