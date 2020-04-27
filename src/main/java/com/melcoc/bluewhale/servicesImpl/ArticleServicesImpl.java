package com.melcoc.bluewhale.servicesImpl;

import com.melcoc.bluewhale.dao.ArticleDao;
import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ArticleServicesImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    @Override
    public List<Article> selectall() {
        return articleDao.selectList(null);
    }

    @Override
    public int insert(Article article) {
        return articleDao.insert(article);
    }

    @Override
    public int update(Article article) {
        return articleDao.updateById(article);
    }

    @Override
    public int delete(Integer id) {
        return articleDao.deleteById(id);
    }
}
