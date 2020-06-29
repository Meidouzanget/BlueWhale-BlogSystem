package com.melcoc.bluewhale.service;

import com.melcoc.bluewhale.domain.Great;

import java.util.List;
import java.util.concurrent.Future;

public interface GreatService {
    /**
     * 查询是否有该用户对该文章的点赞记录
     * @return
     */
    Future<List<Great>> findByAidAndUid(int aId, int uId);
    /**
     * 删除记录
     * @return
     */
    Future<Integer> delete(int id);
    /**
     * 添加记录
     * @return
     */
    Future<Integer> saveAndFlush(Great great);
}
