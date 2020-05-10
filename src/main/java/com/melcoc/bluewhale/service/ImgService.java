package com.melcoc.bluewhale.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.domain.Img;

import java.util.List;


public interface ImgService {
    /**
     * 全查
     * @return
     */
    List<Img> selectImgAll();
    /**
     * 添加
     */
    int insertImg(Img img);
    /**
     * 修改
     */
    int updateImg(Img img);
    /**
     * 删除
     */
    int deleteImg(Integer id);
}
