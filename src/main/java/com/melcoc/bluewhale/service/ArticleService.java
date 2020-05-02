package com.melcoc.bluewhale.service;


import com.melcoc.bluewhale.domain.Article;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ArticleService {
    /**
     * 全查
     * @return
     */
    List<Article> selectArticleAll();
    /**
     * 添加
     */
    int insertArticle(Article article);
    /**
     * 修改
     */
    int updateArticle(Article article);
    /**
     * 删除
     */
    int deleteArticle(Integer id);
}
