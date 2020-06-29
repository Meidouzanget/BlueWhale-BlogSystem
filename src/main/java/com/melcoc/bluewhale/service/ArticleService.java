package com.melcoc.bluewhale.service;


import com.melcoc.bluewhale.domain.Article;
import org.springframework.scheduling.annotation.Async;

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

    int deletedArticle(Integer aId,Integer userId);

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
    @Async
    int saveAndFlush(Article article);

    /**
     * 单用户文章的全查询
     * @return
     */
    @Async
    List<Article> selectArticleByUserName(String name);

    @Async
    List<Article> articleUserList();

    @Async
    List<Article> articleUser();
}
