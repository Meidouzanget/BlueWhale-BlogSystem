package com.melcoc.bluewhale.service;


import com.melcoc.bluewhale.domain.Article;

import java.util.List;
import java.util.concurrent.Future;

public interface ArticleService {
    /**
     * 全查
     * @return
     */

    Future<List<Article>> selectArticleAll();
    /**
     * 添加
     */

    Future<Integer> insertArticle(Article article);
    /**
     * 逻辑删除
     */

    Future<Integer> deletedArticle(Integer aId,Integer userId);

    /**
     * 修改点赞数
     * @return
     */

    Future<Article> findByIdForUpdate(int aid);

    /**
     * 添加点赞数
     * @param article
     * @return
     */

    Future<Integer> saveAndFlush(Article article);

    /**
     * 单用户文章的全查询
     * @return
     */

    Future<List> selectArticleByUserName(String name);


    Future<List> articleUserList();


    Future<List> articleUser();
}
