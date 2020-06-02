package com.melcoc.bluewhale.service;


import com.melcoc.bluewhale.domain.Article;

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
     * 逻辑删除
     */
    int deletedArticle(Integer aId);
    /**
     * 查询文章
     */
    List<Article> selectAll();
    /**
     * 修改点赞数
     * @return
     */
    Article findByIdForUpdate(int aid);

    /**
     * 添加点赞数
     * @param article
     * @return
     */
    Article saveAndFlush(Article article);
}
