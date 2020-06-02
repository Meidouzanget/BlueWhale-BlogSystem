package com.melcoc.bluewhale.service;


import com.melcoc.bluewhale.domain.Comment;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CommentService {
    /**
     * 全查
     * @return
     */
    List<Comment> selectCommentAll(int answerId);
    /**
     * 添加
     */
    int insertComment(Comment comment);
    /**
     * 逻辑删除
     */
    @Update("UPDATE comment SET deleted=0 where comment_id=#{commentId};")
    int deletedComment(Integer commentId);
}
