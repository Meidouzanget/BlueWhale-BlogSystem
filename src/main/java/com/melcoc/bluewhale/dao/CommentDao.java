package com.melcoc.bluewhale.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.melcoc.bluewhale.domain.Comment;
import com.melcoc.bluewhale.domain.CommentReply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CommentDao extends BaseMapper<Comment> {

    /**
     * 逻辑删除
     */
    @Update("UPDATE comment SET deleted=0 where comment_id=#{commentId};")
    int deletedComment(Integer commentId);

    @Select("select t1.*,t2.name,t2.nick_name from comment t1 LEFT JOIN  user t2   ON t1.user_id =t2.user_id WHERE t1.answer_id=#{answerId} and t1.deleted=0  order by t1.comment_id desc")
    List<Comment> userCommentList(int answerId);

}
