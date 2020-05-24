package com.melcoc.bluewhale.service;


import com.melcoc.bluewhale.domain.Article;
import org.apache.ibatis.annotations.Insert;
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
     * 删除
     */
    int deleteArticle(Integer id);
    /**
     * 查询文章
     */
    List<Article> selectAll();
    /**
     * 修改点赞数
     */
    Article findByIdForUpdate(int aid);

}
