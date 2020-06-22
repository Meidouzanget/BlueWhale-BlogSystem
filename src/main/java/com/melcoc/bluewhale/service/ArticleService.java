package com.melcoc.bluewhale.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.melcoc.bluewhale.domain.Article;

import java.util.List;
import java.util.Map;

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
     * 修改点赞数
     * @return
     */
    Article findByIdForUpdate(int aid);

    /**
     * 添加点赞数
     * @param article
     * @return
     */
    int saveAndFlush(Article article);

    /**
     * 单用户文章的全查询
     * @return
     */
    List<Article> selectUserAll(Integer userId);

    List<Article> articleUserList();

    List<Article> articleUser();
}
