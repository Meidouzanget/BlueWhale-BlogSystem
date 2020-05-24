package com.melcoc.bluewhale.service;

import com.melcoc.bluewhale.domain.Great;

import java.util.List;

public interface GreatService {
    /**
     * 查询是否有该用户对该文章的点赞记录
     */
    List<Great> findByAidAndUid(int aId,int uId);
    /**
     * 删除记录
     */
    int delete(int id);
    /**
     * 添加记录
     */
    int saveAndFlush(Great great);
}
