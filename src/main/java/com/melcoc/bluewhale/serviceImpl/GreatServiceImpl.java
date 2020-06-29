package com.melcoc.bluewhale.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.melcoc.bluewhale.dao.GreatDao;
import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.domain.Great;
import com.melcoc.bluewhale.service.GreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

@Async("taskExecutor")
@Service
public class GreatServiceImpl implements GreatService {

    @Autowired
    GreatDao greatDao;
    /**
     * 查询是否有该用户对该文章的点赞记录
     * @return
     */


    @Override
    public Future<List<Great>> findByAidAndUid(int aId, int uId) {
        QueryWrapper wrapper = new QueryWrapper<Article>();
        wrapper.eq("a_id",aId);
        wrapper.eq("u_id",uId);
        return new AsyncResult<>(greatDao.selectList(wrapper));
    }
    /**
     * 删除记录
     * @return
     */

    @Override
    public Future<Integer> delete(int id) {
        return new AsyncResult<>( greatDao.deleteById(id));
    }

    /**
     * 添加记录
     * @param great
     * @return
     */

    @Override
    public Future<Integer> saveAndFlush(Great great) {
        return new AsyncResult<>(greatDao.insert(great));
    }
}
