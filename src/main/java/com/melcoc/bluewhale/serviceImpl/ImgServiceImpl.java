package com.melcoc.bluewhale.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.melcoc.bluewhale.dao.ImgDao;
import com.melcoc.bluewhale.domain.Img;
import com.melcoc.bluewhale.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImgServiceImpl implements ImgService {

    @Autowired
    ImgDao imgDao;


    @Override
    public List<Img> selectImgAll() {
        return imgDao.selectList(null);
    }

    @Override
    public int insertImg(Img img) {
        return imgDao.insert(img);
    }

    @Override
    public int updateImg(Img img) {
        return imgDao.updateById(img);
    }

    @Override
    public int deleteImg(Integer id) {
        return imgDao.deleteById(id);
    }
}
