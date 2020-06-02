package com.melcoc.bluewhale.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.melcoc.bluewhale.domain.CommentReply;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentReplyDao extends BaseMapper<CommentReply> {
}
