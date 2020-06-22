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
    int deletedComment(Integer commentId);

    /**
     * 带用户表的全查
     * @param answerId
     * @return
     */
    List<Comment> userCommentList(int answerId);
}
