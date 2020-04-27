package com.melcoc.bluewhale.service;


import com.melcoc.bluewhale.domain.Article;

import java.util.List;

public interface ArticleService {
    /**
     * 全查
     * @return
     */
    List<Article> selectall();
    /**
     * 添加
     */
    int insert(Article article);
    /**
     * 修改
     */
    int update(Article article);
    /**
     * 删除
     */
    int delete(Integer id);
}
