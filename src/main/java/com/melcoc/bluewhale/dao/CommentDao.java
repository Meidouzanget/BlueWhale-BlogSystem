package com.melcoc.bluewhale.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.melcoc.bluewhale.domain.Comment;
import com.melcoc.bluewhale.domain.CommentReply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
@Mapper
public interface CommentDao extends BaseMapper<Comment> {

    /**
     * 逻辑删除
     */
    @Update("UPDATE comment SET deleted=0 where comment_id=#{commentId};")
    int deletedComment(Integer commentId);
}
