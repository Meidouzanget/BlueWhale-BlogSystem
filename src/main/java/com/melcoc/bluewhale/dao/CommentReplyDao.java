package com.melcoc.bluewhale.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.melcoc.bluewhale.domain.CommentReply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CommentReplyDao extends BaseMapper<CommentReply> {
    /**
     * 逻辑删除
     */
    @Update("UPDATE comment SET deleted=0 where user_id=#{userId} and comment_id=#{commentId};")
    int deletedCommentReply(int commentId,int userId);
}
