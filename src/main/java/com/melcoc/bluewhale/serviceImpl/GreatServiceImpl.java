package com.melcoc.bluewhale.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.melcoc.bluewhale.dao.GreatDao;
import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.domain.Great;
import com.melcoc.bluewhale.service.GreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GreatServiceImpl implements GreatService {

    @Autowired
    GreatDao greatDao;
    /**
     * 查询是否有该用户对该文章的点赞记录
     */

    @Override
    public List<Great> findByAidAndUid(int aId, int uId) {
        QueryWrapper wrapper = new QueryWrapper<Article>();
        wrapper.eq("a_id",aId);
        wrapper.eq("u_id",uId);
        return greatDao.selectList(wrapper);
    }
    /**
     * 删除记录
     */
    @Override
    public int delete(int id) {
        return greatDao.deleteById(id);
    }

    /**
     * 添加记录
     * @param great
     * @return
     */
    @Override
    public int saveAndFlush(Great great) {
        return greatDao.insert(great);
    }
}
